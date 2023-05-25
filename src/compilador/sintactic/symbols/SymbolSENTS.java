/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import compilador.sintactic.ParserSym;

public class SymbolSENTS extends SymbolBase {

    int resultado;
    String identificador;

    public SymbolSENTS(String name, Integer id) {
        super(name, id);
    }

    public SymbolSENTS(int operacion, SymbolELp e1, SymbolELp e2) {
        super("EL", 0);

        switch (operacion) {
            case ParserSym.ADD:
                resultado = e1.r + e2.r;
                break;
            case ParserSym.SUB:
                resultado = e1.r - e2.r;
                break;
        }
    }

    public SymbolSENTS(int operacion, SymbolELp e1, SymbolELp e2, String id) {
        super("EL", 0);
        this.identificador = id;
    }

    public SymbolSENTS(SymbolELp e1, SymbolSENTS e2) {
        super("SENTS", 0);
    }

}
