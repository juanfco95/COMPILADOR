/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import compilador.sintactic.Etiqueta;

public class SymbolCCND extends SymbolBase {

    public boolean booleano;
    int resultado;
    String identificador;
    Etiqueta e;

    public SymbolCCND(String name, Integer id) {
        super(name, id);
    }

    public SymbolCCND() {
        super("SymbolCCND", 0);
    }

    public SymbolCCND(Etiqueta et) {
        super("SymbolCCND", 0);
        this.e = et;
    }
    
    public Etiqueta getEtiqueta(){
        return e;
    }
}
