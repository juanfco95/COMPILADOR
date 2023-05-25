/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import compilador.sintactic.variable;
import java.util.ArrayList;

public class SymbolTE_ARGS1 extends SymbolBase {

    public String id;
    public ArrayList<variable> tArg = new ArrayList(); //indices de el ambito actual

    public SymbolTE_ARGS1(String name, Integer id) {
        super(name, id);
    }

    public SymbolTE_ARGS1() {
        super("TE_ARGS", 0);
    }

    public SymbolTE_ARGS1(String s, variable i) {
        super("SymbolTE_ARGS1", 0);
        this.id = s;
        tArg.add(i);
    }

    public SymbolTE_ARGS1(String s, variable i, ArrayList a) {
        super("SymbolTE_ARGS1", 0);
        this.id = s;
        this.tArg = a;
        tArg.add(i);
    }
}
