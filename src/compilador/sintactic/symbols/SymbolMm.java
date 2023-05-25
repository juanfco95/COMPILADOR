/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import compilador.sintactic.Etiqueta;
import java_cup.runtime.ComplexSymbolFactory;

public class SymbolMm extends ComplexSymbolFactory.ComplexSymbol {

    public Etiqueta ei;

    public SymbolMm(String name, int id) {
        super(name, id);
    }

    public SymbolMm() {
        super("Mm", 0);
    }

    public SymbolMm(Etiqueta ei) {
        super("Mm", 0);
        this.ei = ei;
    }
}
