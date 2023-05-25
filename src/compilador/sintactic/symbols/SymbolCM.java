/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import compilador.sintactic.Etiqueta;
import java_cup.runtime.ComplexSymbolFactory;

public class SymbolCM extends ComplexSymbolFactory.ComplexSymbol {

    public Etiqueta efi;
    public Etiqueta ei;

    public SymbolCM(String name, int id) {
        super(name, id);
    }

    public SymbolCM() {
        super("CM", 0);
    }

    public SymbolCM(Etiqueta efi, Etiqueta ei) {
        super("SymbolCM", 0);
        this.efi = efi;
        this.ei = ei;
    }

    public Etiqueta getEtiqueta(boolean esEfi) {
        if (esEfi) {
            return efi;
        } else {
            return ei;
        }
    }
}
