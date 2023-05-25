/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

public class SymbolSubP extends ComplexSymbolFactory.ComplexSymbol {

    public SymbolSubP(String name, int id) {
        super(name, id);
    }

    public SymbolSubP() {
        super("SubP", 0);
    }

}
