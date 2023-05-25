/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic;

public class OperandoC3A {

    public TiposOperandoC3A type;
    public String operando;

    public OperandoC3A(String s, TiposOperandoC3A tipo) {
        this.operando = s;
        this.type = tipo;
    }

    public OperandoC3A(String s, TiposOperandoC3A tipo, boolean temp) {
        this.operando = s;
        this.type = tipo;
    }

    @Override
    public String toString() {
//        String s = "OP{"+operando+" tipo: "+type.toString()+"}";
//        return s;
        return operando;
    }

}
