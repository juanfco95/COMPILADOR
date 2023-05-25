/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import compilador.sintactic.descripcion;
import java_cup.runtime.ComplexSymbolFactory;

public class SymbolAO extends ComplexSymbolFactory.ComplexSymbol {

    public int r;
    public descripcion d;
    public int vBool;

    public SymbolAO(String name, int id) {
        super(name, id);
    }

    public SymbolAO() {
        super("AO", 0);
    }

    public SymbolAO(int i) {
        super("AO", 0);
        this.r = i;
    }

    public SymbolAO(int i, descripcion de) {
        super("AO", 0);
        this.vBool = i;
        this.d = de;
    }

    public SymbolAO(int i, descripcion de, int s) {
        super("AO", 0);
        this.vBool = i;
        this.d = de;
        this.r = s;
    }

    public SymbolAO(int i, int v) {
        super("AO", 0);
        this.vBool = v;
        this.r = i;
    }
}
