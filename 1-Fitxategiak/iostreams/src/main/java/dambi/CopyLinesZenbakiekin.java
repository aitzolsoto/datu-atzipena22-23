package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

/*Programa honek xanadu.txt fitxategia lerroz lerro irakurtzen du eta characteroutputLinesZenbakiekin.txt izeneko fitxategian idazten du, lerro bakoitzaren hasieran lerro zenbakia idazten du*/

public class CopyLinesZenbakiekin {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("iostreams/xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("iostreams/characteroutputLinesZenbakiekin.txt"));

            String l;
            int lerroZenbakia = 1;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(lerroZenbakia + ". " + l);
                lerroZenbakia ++;
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
