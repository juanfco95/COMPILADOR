/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

import compilador.sintactic.tipoSub;
import java_cup.runtime.ComplexSymbolFactory;

public class SymbolRetInstr extends ComplexSymbolFactory.ComplexSymbol {

    public tipoSub tSub;
    public boolean esBool;

    public SymbolRetInstr(String name, int id) {
        super(name, id);
    }

    public SymbolRetInstr() {
        super("RetInstr", 0);
    }

    public SymbolRetInstr(boolean b) {
        super("RetInstr", 0);
        this.esBool = b;
    }

    public SymbolRetInstr(tipoSub t) {
        super("RetInstr", 0);
        this.tSub = t;
    }

}
