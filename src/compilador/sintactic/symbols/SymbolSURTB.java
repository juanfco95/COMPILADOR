/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

public class SymbolSURTB extends ComplexSymbolFactory.ComplexSymbol {

    public SymbolSURTB(String name, int id) {
        super(name, id);
    }

    public SymbolSURTB() {
        super("SURTB", 0);
    }

}
