/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic;

import java.util.ArrayList;

public class TablaVariables {

    public static ArrayList<variable> tVar = new ArrayList<variable>();

    public int nv = -1; //numero de variables que tenemos
    public int tempV = -1; // tine que empezar desde 1. Esta bien

    public TablaVariables() {

    }

    public int addVariable(variable var) {

        if (!existe(var)) {
            nv++;
            tVar.add(var); //mirar que no este duplicada esta variable
        }
        return nv;
    }

    public boolean existe(variable var) {

        if (tVar.isEmpty()) {
            if (var.idVariable == null) {
                tempV++;
                var.idVariable = "t" + tempV;

            }
        } else {
            if (var.idVariable == null) {
                tempV++;
                var.idVariable = "t" + tempV;

            }
        }
        for (int i = 0; i < tVar.size(); i++) {
            if (var.idVariable.equals(tVar.get(i).idVariable)) {
                return true;
            }
        }
        return false;
    }

    public variable obtenVariable(variable var) {
        int i = tVar.indexOf(var);
        if (i != -1) {
            variable v = tVar.get(i);
            return v;
        } else {
            return null;
        }
    }

    public variable get(int index) {
        if (index == -1) {
            return null;
        }
        variable v = tVar.get(index);
        return v;
    }

    public int getIdVariable(String nombre) {
        int id = -1;
        boolean trobat = false;
        for (int i = 0; i < tVar.size() && !trobat; i++) {
            if ((tVar.get(i).idVariable != null) && tVar.get(i).idVariable.equals(nombre)) {
                trobat = true;
                id = i;
            }
        }
        return id;
    }

    public variable obtenUltimaVariable() {
        return tVar.get(nv);
    }

}
