/*
AUTORES: 
        JUAN FRANCISCO HERNANDEZ FERNANDEZ
        MACIÀ SALVÀ SALVÀ
        ALEJANDRO MUÑOZ NAVARRO
 */
package compiladorprueba;

import compilador.sintactic.symbols.SymbolI;
import java.io.Reader;
import java.io.FileReader;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import compilador.lexic.Scanner;
import compilador.sintactic.Parser;
import javax.swing.JFileChooser;

public class CompiladorJMA {

    public static void main(String[] args) {
        Reader input;
        try {
            input = new FileReader("CodigoJMA.txt");
            SymbolFactory sf = new ComplexSymbolFactory();
            Scanner scanner = new Scanner(input);
            Parser parser = new Parser(scanner, sf);
            Symbol simbolResultat = parser.parse();
            SymbolI resultat = (SymbolI) simbolResultat.value;
        } catch (Exception e) {
            System.err.println("error: " + e);
            e.printStackTrace(System.err);
        }
    }

}
