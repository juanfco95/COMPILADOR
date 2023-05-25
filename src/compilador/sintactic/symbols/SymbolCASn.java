/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

public class SymbolCASn extends ComplexSymbolFactory.ComplexSymbol {

    int v1;

    public SymbolCASn(String name, int id) {
        super(name, id);
    }

    public SymbolCASn(SymbolELp v1) {
        super("CASn", 0);
        this.v1 = v1.r;
        System.out.println("He detectat case valor= " + v1);
    }
}
