/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public class SymbolBase extends ComplexSymbol {

    public SymbolBase(String name, Integer id) {
        super(name, id);
    }

}
