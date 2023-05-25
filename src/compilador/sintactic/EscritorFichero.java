/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compilador.sintactic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscritorFichero {

    BufferedWriter bw;

    public EscritorFichero(String nomFicher) {
        try {
            bw = new BufferedWriter(new FileWriter(nomFicher));
        } catch (IOException ex) {
            Logger.getLogger(EscritorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribirFichero(String text) {
        try {
            bw.write(text);
            bw.newLine();
        } catch (IOException ex) {
            Logger.getLogger(EscritorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cierraFichero() {
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(EscritorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
