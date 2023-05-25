/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

public class SymbolENTRAB extends ComplexSymbolFactory.ComplexSymbol {

    public SymbolENTRAB(String name, int id) {
        super(name, id);
    }

    public SymbolENTRAB() {
        super("ENTRAB", 0);
    }

}
