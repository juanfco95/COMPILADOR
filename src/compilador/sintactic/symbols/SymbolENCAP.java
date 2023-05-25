/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

public class SymbolENCAP extends ComplexSymbolFactory.ComplexSymbol {

    public boolean teArgs;
    public String id;

    public SymbolENCAP(String name, int id) {
        super(name, id);
    }

    public SymbolENCAP(boolean b, String s) {
        super("ENCAP", 0);
        this.teArgs = b;
        this.id = s;
    }

    public SymbolENCAP(boolean b) {
        super("ENCAP", 0);
        this.teArgs = b;
    }
}
