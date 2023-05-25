/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

public class SymbolGEN3A extends ComplexSymbolFactory.ComplexSymbol {

    public SymbolGEN3A(String name, int id) {
        super(name, id);
    }

    public SymbolGEN3A() {
        super("GEN3A", 0);
    }
}
