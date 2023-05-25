/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

public class SymbolSortTec extends ComplexSymbolFactory.ComplexSymbol {

    public SymbolSortTec(String name, int id) {
        super(name, id);
    }

    public SymbolSortTec() {
        super("SortTec", 0);
    }

}
