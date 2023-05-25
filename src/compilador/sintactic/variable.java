/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic;

public class variable {

    static int nvar = 0;
    /*Atributos de una variable*/
    public int idV;
    public String idVariable;
    public tipoSub tSub;
    public int procedure;
    public boolean constante = false;
    public int valor;

    public variable(String s, tipoSub t, int p) {
        this.idV = nvar;
        nvar++;
        this.idVariable = s;
        this.tSub = t;
        this.procedure = p;
    }

    variable(tipoSub t, int p) {
        this.tSub = t;
        this.procedure = p;
    }

}
