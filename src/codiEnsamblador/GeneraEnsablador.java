/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package codiEnsamblador;

import compilador.sintactic.Codi3A;
import compilador.sintactic.EscritorFichero;
import compilador.sintactic.InstrCodi3A;
import compilador.sintactic.TablaProcedimientos;
import compilador.sintactic.TablaVariables;
import compilador.sintactic.TiposOperandoC3A;
import compilador.sintactic.tipoSub;
import compilador.sintactic.Error;
import java.util.ArrayList;

public class GeneraEnsablador {

    EscritorFichero f;
    ArrayList<String> parametros;

    public GeneraEnsablador() {
        f = new EscritorFichero("CodiEnsamblador.X68");
        parametros = new ArrayList<>();
    }

    public void generaError68k() {
        f.escribirFichero("\tORG    $600");
        f.escribirFichero("error DC.B '" + Error.causaError + "',0");
        f.escribirFichero("SL\tDS.W 1 *Variable auxiliar para los saltos de linea de la consola");
        f.escribirFichero("\tORG    $1000");
        f.escribirFichero("\nSTART:");
        f.escribirFichero("\tMOVEM.L D0-D1/A1,-(A7)");
        f.escribirFichero("\tMOVE.W (SL),D1\n\tMOVE.B #11,D0\n\tTRAP #15");
        f.escribirFichero("\tMOVE.W 16(A7),D1");
        f.escribirFichero("\tLEA error,A1");
        f.escribirFichero("\tMOVE.B #14,D0");
        f.escribirFichero("\tTRAP #15");
        f.escribirFichero("\tMOVEM.L (A7)+,D0-D1/A1");
        f.escribirFichero("\tEND START");
        f.cierraFichero();
    }

    public void generaCodi68k() {
        f.escribirFichero("\tORG    $600");
        for (int i = 0; i < TablaVariables.tVar.size(); i++) {
            if (TablaVariables.tVar.get(i).constante) {
                generaVariableGlobal68k(TablaVariables.tVar.get(i).idVariable, true, TablaVariables.tVar.get(i).valor); //Es una constante
            } else {
                generaVariableGlobal68k(TablaVariables.tVar.get(i).idVariable, false, -1); //No es una constante
            }
        }
        f.escribirFichero("SL\tDS.L 1 *Variable auxiliar para los saltos de linea de la consola");
        f.escribirFichero("\n\tORG    $1000");
        f.escribirFichero("\nSTART:");
        f.escribirFichero("\tMOVE.L #0,SL");
        //Ahora cogemos las instrucciones del codigo 3A
        for (int i = 0; i < Codi3A.C3A.size(); i++) {
            generaInstruccion68k(Codi3A.C3A.get(i));
        }
        f.escribirFichero("\tJMP FIN$68K");
        imprimir();
        imprimirBooleano();
        escribir();
        neg();
        f.escribirFichero("FIN$68K");
        f.escribirFichero("\tEND START");
        f.cierraFichero();
    }

    public void generaVariableGlobal68k(String nombre, boolean constante, int valor) {
        if (constante) {
            nombre += "\tEQU\t" + valor;
        } else {
            nombre += "\tDS.L 1";
        }
        f.escribirFichero(nombre);
    }

    public void generaInstruccion68k(InstrCodi3A inst) {
        switch (inst.instruccion) {
            case SKIP:
                f.escribirFichero(inst.destino.toString() + ":");
                break;
            case COPY:
                if (inst.param2.type == TiposOperandoC3A.procedure) {
                    f.escribirFichero("\tMOVE.L (A0)," + inst.destino);
                    f.escribirFichero("\tMOVE.L (A7)+,A0");
                    for (int i = parametros.size() - 1; i >= 0; i--) {
                        f.escribirFichero("\tMOVE.L (A7)+," + parametros.get(i));
                    }
                    parametros.clear();
                } else {
                    if (inst.param2.type == TiposOperandoC3A.variable) {
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + ")," + inst.destino);
                    } else {
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + "," + inst.destino);
                    }

                }

                break;
            case ADD:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# 
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tADD.L D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=#*v

                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tADD.L D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# 
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tADD.L D0,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=v*v

                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tADD.L D0, D1");
                        f.escribirFichero("\tMOVE.L D1, " + inst.destino);
                    }
                }
                break;

            case SUB:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# 
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tSUB.L D1, D0");
                        f.escribirFichero("\tMOVE.L D0, " + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tSUB.L D1, D0");
                        f.escribirFichero("\tMOVE.L D0, " + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# 
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tSUB.L D1, D0");
                        f.escribirFichero("\tMOVE.L D0, " + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tSUB.L D1, D0");
                        f.escribirFichero("\tMOVE.L D0, " + inst.destino);
                    }
                }
                break;

            case MUL:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# 
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + (inst.param2) + ",D1");
                        f.escribirFichero("\tSUB.L #1, D1");
                        f.escribirFichero("\tCLR.L D2");
                        f.escribirFichero("LOOP\n\tADD.L D0,D2\n");
                        f.escribirFichero("\tDBRA D1,LOOP");
                        f.escribirFichero("\tMOVE.L D2," + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tSUB.L #1, D1");
                        f.escribirFichero("\tCLR.L D2");
                        f.escribirFichero("LOOP\n\tADD.L D0,D2\n");
                        f.escribirFichero("\tDBRA D1,LOOP");
                        f.escribirFichero("\tMOVE.L D2," + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tSUB.L #1, D1");
                        f.escribirFichero("\tCLR.L D2");
                        f.escribirFichero("LOOP\n\tADD.L D0,D2\n");
                        f.escribirFichero("\tDBRA D1,LOOP");
                        f.escribirFichero("\tMOVE.L D2," + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tSUB.L #1, D1");
                        f.escribirFichero("\tCLR.L D2");
                        f.escribirFichero("LOOP\n\tADD.L D0,D2\n");
                        f.escribirFichero("\tDBRA D1,LOOP");
                        f.escribirFichero("\tMOVE.L D2," + inst.destino);
                    }
                }
                break;

            case DIV:
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be}
                     
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                       f.escribirFichero("\tCLR.L D2");
                        f.escribirFichero("LOOP\n\tCMP.L #0,D0\n\tBEQ ENDLOOP\n\tSUB.L D1,D0\n\tADD.L #1,D2\n");
                        f.escribirFichero("\tJMP LOOP");
                        f.escribirFichero("ENDLOOP\n\tMOVE.L D2," + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                       f.escribirFichero("\tCLR.L D2");
                        f.escribirFichero("LOOP\n\tCMP.L #0,D0\n\tBEQ ENDLOOP\n\tSUB.L D1,D0\n\tADD.L #1,D2\n");
                        f.escribirFichero("\tJMP LOOP");
                        f.escribirFichero("ENDLOOP\n\tMOVE.L D2," + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                       f.escribirFichero("\tCLR.L D2");
                        f.escribirFichero("LOOP\n\tCMP.L #0,D0\n\tBEQ ENDLOOP\n\tSUB.L D1,D0\n\tADD.L #1,D2\n");
                        f.escribirFichero("\tJMP LOOP");
                        f.escribirFichero("ENDLOOP\n\tMOVE.L D2," + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                       f.escribirFichero("\tCLR.L D2");
                        f.escribirFichero("LOOP\n\tCMP.L #0,D0\n\tBEQ ENDLOOP\n\tSUB.L D1,D0\n\tADD.L #1,D2\n");
                        f.escribirFichero("\tJMP LOOP");
                        f.escribirFichero("ENDLOOP\n\tMOVE.L D2," + inst.destino);
                    }
                }
                break;

            case MOD: // DIVU
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) {  //x=#*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= #*# //va be
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D1");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D0");
                        f.escribirFichero("\tDIVU D0,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=#*v
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D1");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D0");
                        f.escribirFichero("\tDIVU D0,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    }
                } else { //x = v*?
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { //x= v*# //va be
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D1");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D0");
                        f.escribirFichero("\tDIVU D0,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    } else { //x=v*v
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D1");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D0");
                        f.escribirFichero("\tDIVU D0,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tASR.L #4,D1");
                        f.escribirFichero("\tMOVE.L D1," + inst.destino);
                    }
                }
                break;

            case AND:
                
                f.escribirFichero("\tMOVE.L (" + inst.param1 + "), D0");
                f.escribirFichero("\tMOVE.L (" + TablaVariables.tVar.get(Integer.parseInt(inst.param2.operando)).idVariable + "), D1");
                f.escribirFichero("\tAND.L D0,D1");
                f.escribirFichero("\tMOVE.L D1," + inst.destino);
                break;

            case OR:
                f.escribirFichero("\tMOVE.L (" + inst.param1 + "), D0");
                f.escribirFichero("\tMOVE.L (" + TablaVariables.tVar.get(Integer.parseInt(inst.param2.operando)).idVariable + "), D1");
                f.escribirFichero("\tOR.L D0,D1");
                f.escribirFichero("\tMOVE.L D1," + inst.destino);
                break;

            case IFGT: //A>B. A > B tras CMP B, A
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBGT " + inst.destino);
                    } else { // (# > v)
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBGT " + inst.destino);
                    }

                } else { // (v > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.L  D1, D0");
                        f.escribirFichero("\tBGT " + inst.destino);
                    } else { // (v > v)
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBGT " + inst.destino);
                    }
                }
                break;

            case GE:
                f.escribirFichero("\t ;GE " + inst.param1 + "," + inst.param2 + "," + inst.destino);
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.L  D1, D0");
                        f.escribirFichero("\tBGE " + inst.destino);
                    } else { // (# > v)
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBGE " + inst.destino);
                    }

                } else { // (v > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.L  D1, D0");
                        f.escribirFichero("\tBGE " + inst.destino);
                    } else { // (v > v)
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBGE " + inst.destino);
                    }
                }
                break;

            case LE:
                f.escribirFichero("\t ;LE " + inst.param1 + "," + inst.param2 + "," + inst.destino);
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBLE " + inst.destino);
                    } else { // (# > v)
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBLE " + inst.destino);
                    }

                } else { // (v > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.L  D1, D0");
                        f.escribirFichero("\tBLE " + inst.destino);
                    } else { // (v > v)
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBLE " + inst.destino);
                    }
                }
                break;

            case LT:
                f.escribirFichero("\t ;LT " + inst.param1 + "," + inst.param2 + "," + inst.destino);
                if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBLT " + inst.destino);
                    } else { // (# > v)
                        f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                        f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBLT " + inst.destino);
                    }

                } else { // (v > ?)
                    if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
                        f.escribirFichero("\tMOVE.L (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                        f.escribirFichero("\tCMP.L  D1,D0");
                        f.escribirFichero("\tBLT " + inst.destino);
                    } else { // (v > v)
                        f.escribirFichero("\tMOVE.W (" + inst.param1 + "),D0");
                        f.escribirFichero("\tMOVE.W (" + inst.param2 + "),D1");
                        f.escribirFichero("\tCMP.W  D1,D0");
                        f.escribirFichero("\tBLT " + inst.destino);
                    }
                }
                break;

            case EQ:
                
                if (inst.temporal) {
                    
                    f.escribirFichero("\tMOVE.L (" + TablaVariables.tVar.get(Integer.parseInt(inst.param1.operando)).idVariable + "), D0");
                    f.escribirFichero("\tMOVE.L #" + inst.param2.operando + ", D1");
                    f.escribirFichero("\tCMP.L  D0,D1");
                    f.escribirFichero("\tBEQ " + inst.destino);
                } else {
                    if (inst.param1.type.equals(TiposOperandoC3A.enteroLit)) { // (# > ?)
                        if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (# > #)
                            f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                            f.escribirFichero("\tMOVE.L #" + inst.param2 + ",D1");
                            f.escribirFichero("\tCMP.L  D1,D0");
                            f.escribirFichero("\tBEQ " + inst.destino);
                        } else { // (# > v)
                            f.escribirFichero("\tMOVE.L #" + inst.param1 + ",D0");
                            f.escribirFichero("\tMOVE.L (" + inst.param2 + "),D1");
                            f.escribirFichero("\tCMP.L  D1,D0");
                            f.escribirFichero("\tBEQ " + inst.destino);
                        }

                    } else { // (v > ?)
                        if (inst.param2.type.equals(TiposOperandoC3A.enteroLit)) { // (v > #)
                            if (inst.param1.operando.equals("cert")) {
                                f.escribirFichero("\tMOVE.L #-1, D0");
                                f.escribirFichero("\tMOVE.L #" + inst.param2 + ", D1");
                                f.escribirFichero("\tCMP.L  D1, D0");
                                f.escribirFichero("\tBEQ " + inst.destino);
                            } else if (inst.param1.operando.equals("fals")) {
                                f.escribirFichero("\tMOVE.L #0, D0");
                                f.escribirFichero("\tMOVE.L #" + inst.param2 + ", D1");
                                f.escribirFichero("\tCMP.L  D1, D0");
                                f.escribirFichero("\tBEQ " + inst.destino);
                            } else {
                                f.escribirFichero("\tMOVE.L (" + inst.param1 + "), D0");
                            }
                            f.escribirFichero("\tMOVE.L #" + inst.param2 + ", D1");
                            f.escribirFichero("\tCMP.L  D1, D0");
                            f.escribirFichero("\tBEQ " + inst.destino);
                        } else { // (v > v)
                            f.escribirFichero("\tMOVE.L (" + inst.param1 + "), D0");
                            f.escribirFichero("\tMOVE.L (" + inst.param2 + "), D1");
                            f.escribirFichero("\tCMP.L  D1, D0");
                            f.escribirFichero("\tBEQ " + inst.destino);
                        }
                    }
                }
                break;

            case GOTO:
                f.escribirFichero("\tJMP " + inst.destino);
                break;

            case PARAM_S:
                parametros.add(inst.destino.toString());
                f.escribirFichero("\tMOVE.L (" + inst.destino + "),-(A7)");
                break;
            case CALL:
                if (inst.destino.toString().contains("imprimeix")) {
                    f.escribirFichero("\tJSR " + inst.destino);// CALL
                    f.escribirFichero("\tMOVE.L (A7)+,(" + parametros.get(0) + ")");//Recuperació de parámetros
                    f.escribirFichero("\tADD.L #1,SL"); //Aumentro SL
                    parametros.clear();
                    break;
                } else {
                    if ("escriure".equals(inst.destino.toString())) {
                        
                        f.escribirFichero("\tJSR " + inst.destino);// CALL
                        f.escribirFichero("\tMOVE.L D2,-(A7)");
                        f.escribirFichero("\tMOVE.L D2," + parametros.get(0));
                        f.escribirFichero("\tMOVE.L (A7)+,D2");
                        f.escribirFichero("\tMOVE.L (A7)+," + parametros.get(0));
                        f.escribirFichero("\tADD.L #1,SL");
                        parametros.clear();
                        break;
                    } else {
                        if("neg".equals(inst.destino.toString())){
                            f.escribirFichero("\tMOVE.L D1,-(A7)");
                            f.escribirFichero("\tJSR " + inst.destino);// CALL
                            f.escribirFichero("\tMOVE.L D1,"+inst.param2);
                            f.escribirFichero("    MOVE.L (A7)+,D1\n\tMOVE.L (A7)+,"+parametros.get(0));
                            parametros.clear();
                        }else{
                        f.escribirFichero("\tMOVE.L A0,-(A7)");// CALL
                        f.escribirFichero("\tJSR " + inst.destino);// CALL
                        if (TablaProcedimientos.getProcedimiento2(inst.destino.toString()).tipo == tipoSub.tipoSubVoid) {
                            f.escribirFichero("\tMOVE.L (A7)+,A0");
                            for (int i = parametros.size() - 1; i >= 0; i--) {
                                f.escribirFichero("\tMOVE.L (A7)+," + parametros.get(i));
                            }
                            parametros.clear();
                        }
                    }
                    }
                }
                break;
            case PMB:
                for (int i = TablaProcedimientos.tablaP.get(TablaProcedimientos.tablaP.size() - 1).Parametros.size() - 1; i >= 0; i--) {
                    int posicionPila = ((TablaProcedimientos.tablaP.get(TablaProcedimientos.tablaP.size() - 1).Parametros.size() - i) * 4) + 4;
                    f.escribirFichero("\tMOVE.L " + posicionPila + "(A7)," + TablaProcedimientos.tablaP.get(TablaProcedimientos.tablaP.size() - 1).Parametros.get(i).idVariable);
                }
                f.escribirFichero("\tMOVEM.L D0-D2,-(A7)");
                break;
            case RTN:
                if (inst.destino != null) {
                    f.escribirFichero("\tMOVE.L #" + inst.destino + ",A0");
                }
                f.escribirFichero("\tMOVEM.L (A7)+,D0-D2");
                f.escribirFichero("\tRTS");
                break;
        }
    }

    private void imprimir() {
        f.escribirFichero("imprimeix:");
        f.escribirFichero("\tMOVEM.L D0-D1,-(A7)");
        f.escribirFichero("\tMOVE.L (SL),D1\n\tMOVE.B #11,D0\n\tTRAP #15");
        f.escribirFichero("\tMOVE.L 12(A7),D1");
        f.escribirFichero("\tMOVE.B #3,D0");
        f.escribirFichero("\tTRAP #15");
        f.escribirFichero("\tMOVEM.L (A7)+,D0-D1");
        f.escribirFichero("\tRTS");
    }

    private void imprimirBooleano() {
        f.escribirFichero("imprimeixBooleano");
        f.escribirFichero("\tMOVEM.L D0-D1/A1,-(A7)");
        f.escribirFichero("\tMOVE.L (SL),D1\n\tMOVE.B #11,D0\n\tTRAP #15");
        f.escribirFichero("\tMOVE.L 16(A7),D1");
        f.escribirFichero("\tTST.L D1");
        f.escribirFichero("\tBEQ fals");
        f.escribirFichero("\tLEA true,A1");
        f.escribirFichero("\tJMP finb");
        f.escribirFichero("fals");
        f.escribirFichero("\tLEA false,A1");
        f.escribirFichero("finb");
        f.escribirFichero("\tMOVE.B #14,D0");
        f.escribirFichero("\tTRAP #15");
        f.escribirFichero("\tMOVEM.L (A7)+,D0-D1/A1");
        f.escribirFichero("\tRTS");
        f.escribirFichero("true DC.B 'cert',0");
        f.escribirFichero("false DC.B 'fals',0\n\tDS.W 0");
    }

    private void escribir() {
        f.escribirFichero("escriure");
        f.escribirFichero("\tMOVEM.L D0-D1/A1,-(A7)");
        f.escribirFichero("\tMOVE.L (SL),D1\n\tMOVE.B #11,D0\n\tTRAP #15");
        f.escribirFichero("\tLEA write,A1\n\tMOVE.B #14,D0\n\tTRAP #15");
        f.escribirFichero("\tMOVE.L  #(13)<<8,D1\n\tOR.W (SL),D1\n\tMOVE.B #11,D0\n\tTRAP #15");
        f.escribirFichero("\tMOVE.B #4,D0");
        f.escribirFichero("\tTRAP #15");
        f.escribirFichero("\tMOVE.L D1,D2");
        f.escribirFichero("\tMOVEM.L (A7)+,D0-D1/A1");
        f.escribirFichero("\tRTS");
        f.escribirFichero("write DC.B 'escriu aqui: ',0\n\tDS.W 0");
    }
    private void neg() {
        f.escribirFichero("neg:");
        f.escribirFichero("\tMOVEM.L D0,-(A7)");
        f.escribirFichero("\tMOVE.L 12(A7),D0");
        f.escribirFichero("\tCMP.L #0,D0");
        f.escribirFichero("\tBEQ CONVERTIR");
        f.escribirFichero("\tMOVE.L #0,D0");
        f.escribirFichero("\tJMP FINNEGARVALOR");
        f.escribirFichero("CONVERTIR\n\tMOVE.L #-1,D0");
        f.escribirFichero("FINNEGARVALOR\n\tMOVE.L  D0,D1\n\tMOVE.L (A7)+,D0\n\tRTS");
    }
}
