/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import compilador.sintactic.ParserSym;

public class SymbolEL extends SymbolBase {

    public boolean booleano;
    public int resultado = 0;
    public int r;
    public boolean isLiteral1;
    public boolean isLiteral2;

    public SymbolEL(String name, Integer id) {
        super(name, id);
    }

    public SymbolEL(int operacion, SymbolELp e1, SymbolELp e2) {
        super("EL", 0);

        switch (operacion) {
            case ParserSym.MENOR:
                booleano = e1.r < e2.r;
                break;
            case ParserSym.MAYOR:
                booleano = e1.r > e2.r;
                break;
            case ParserSym.IGUAL:
                booleano = e1.r == e2.r;
                break;
            case ParserSym.MAYIG:
                booleano = e1.r >= e2.r;
                break;
            case ParserSym.MENIG:
                booleano = e1.r <= e2.r;
                break;
        }
    }

    public void setR(int t) {
        this.r = t;
    }

}
