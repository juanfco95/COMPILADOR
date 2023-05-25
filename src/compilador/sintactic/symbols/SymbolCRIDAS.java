/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

public class SymbolCRIDAS extends SymbolBase {

    public String id;

    public SymbolCRIDAS(String name, Integer id) {
        super(name, id);
    }

    public SymbolCRIDAS() {
        super("CRIDAS", 0);
    }

    public SymbolCRIDAS(String s) {
        super("CRIDAS", 0);
        this.id = s;
    }

}
