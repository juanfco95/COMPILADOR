/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import compilador.sintactic.variable;
import java.util.ArrayList;

public class SymbolPARAM extends SymbolBase {

    public int nParamInt;
    public int nParamBool;
    public ArrayList<variable> tPar = new ArrayList();

    public SymbolPARAM(String name, Integer id) {
        super(name, id);
    }

    public SymbolPARAM() {
        super("PARAM", 0);
    }

    public SymbolPARAM(boolean b) {
        super("PARAM", 0);
        if (b) {
            nParamInt = nParamInt + 1;
        } else {
            nParamBool = nParamBool + 1;
        }
    }

    public SymbolPARAM(boolean b, int i) {
        super("PARAM", 0);
        if (b) {
            nParamInt = i + 1;
        } else {
            nParamBool = i + 1;
        }
    }

    public SymbolPARAM(variable i) {
        super("PARAM", 0);
        tPar.add(i);
    }

    public SymbolPARAM(variable i, ArrayList a) {
        super("PARAM", 0);
        this.tPar = a;
        tPar.add(i);
    }
}
