/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic.symbols;

public class SymbolELp extends SymbolBase {

    public int r;
    public String identificador;
    public boolean esLiteral = false;

    public SymbolELp(String name, Integer id) {
        super(name, id);
    }

    public SymbolELp(Integer v, boolean b) {
        super("ELp", 0);
        this.r = v;
        this.esLiteral = b;
    }

    public SymbolELp(Integer v) {
        super("ELp", 0);
        this.r = v;
    }

    public SymbolELp(Integer v, String id) {
        super("ELp", 0);
        this.r = v;
        this.identificador = id;
    }

    public SymbolELp() {
        super("ELp", 0);
    }

    public SymbolELp(String s) {
        super("ELp", 0);
        this.identificador = s;
    }

}
