/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

public class SymbolAOp extends ComplexSymbolFactory.ComplexSymbol {

    public boolean and;

    public SymbolAOp(String name, int id) {
        super(name, id);
    }

    public SymbolAOp(boolean b) {
        super("AOp", 0);
        this.and = b;
    }

}
