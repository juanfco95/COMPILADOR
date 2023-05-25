/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import compilador.sintactic.Etiqueta;

public class SymbolSCND extends SymbolBase {

    Etiqueta e;

    public SymbolSCND(String name, Integer id) {
        super(name, id);
    }

    public SymbolSCND() {
        super("SymbolSCND", 0);
    }

    public SymbolSCND(Etiqueta et) {
        super("SymbolSCND", 0);
        this.e = et;
    }

    public Etiqueta getEtiqueta() {
        return e;
    }
}
