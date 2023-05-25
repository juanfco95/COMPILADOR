/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

public class SymbolP extends SymbolBase {
    
    public String id;
    public int valor;

    public SymbolP(String name, Integer id) {
        super(name, id);
    }

    public SymbolP(SymbolP p1, SymbolCND s1) {
        super("P", 0);
    }

    public SymbolP(SymbolCND s1) {
        super("P", 0);
    }

    public SymbolP() {
        super("P", 0);
    }

    public SymbolP(Symbolinstr s1) {
        super("P", 0);
        this.id = s1.id;
        this.valor = s1.valor;
    }

}
