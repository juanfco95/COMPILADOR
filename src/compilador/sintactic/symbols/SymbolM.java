/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

public class SymbolM extends ComplexSymbolFactory.ComplexSymbol {

    public SymbolM(String name, int id) {
        super(name, id);
    }

    public SymbolM() {
        super("M", 0);
    }
}
