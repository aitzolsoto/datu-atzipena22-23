package twr;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*Programa honek xanadu.txt fitxategia karakterez karaktere irakurtzen du eta characteroutput.txt izeneko fitxategian idazten du */

public class CopyCharacters {
    public static void main(String[] args) throws IOException {



        try(FileReader inputStream = new FileReader("iostreams/xanadu.txt");FileWriter outputStream = new FileWriter("iostreams/characteroutput.txt");) {
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
            inputStream.close();
            outputStream.close();
        } 
    }
}
