package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*Programa honek xanadu.txt fitxategia karakterez karaktere irakurtzen du eta characteroutput.txt izeneko fitxategian idazten du baina kasu honetan maiuskulaz,*/

public class CopyCharactersMaiuskulaz {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("iostreams/xanadu.txt");
            outputStream = new FileWriter("iostreams/characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                c = Character.toUpperCase(c);
                outputStream.write(c);
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
