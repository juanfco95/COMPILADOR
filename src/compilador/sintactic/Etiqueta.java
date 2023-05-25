/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic;

import java.util.ArrayList;

public class Etiqueta {

    ArrayList<Etiqueta> tET = new ArrayList<>();
    String etiqueta;
    int numET;

    public Etiqueta() {

    }

    public Etiqueta(String s) {
        this.etiqueta = s;
    }

    public void addEtiqueta(String s) {
        tET.add(new Etiqueta(s));
    }

    public String novaET() {
        String et = "";
        if (tET.isEmpty()) {
            et += "E_0";
            tET.add(new Etiqueta(et));
            numET++;
        } else {
            Integer i = tET.size();
            et += "E_" + Integer.toString(i);
            tET.add(new Etiqueta(et));
            numET++;
        }
        return et;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public Etiqueta getLastEtiqueta() {
        return tET.get(tET.size() - 1);
    }
}
