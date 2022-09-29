package twr;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

/*Programa honek xanadu.txt fitxategia lerroz lerro irakurtzen du eta characteroutputLines.txt izeneko fitxategian idazten du */

public class CopyLines {
    public static void main(String[] args) throws IOException {


        try (BufferedReader inputStream = new BufferedReader(new FileReader("iostreams/xanadu.txt"));PrintWriter outputStream = new PrintWriter(new FileWriter("iostreams/characteroutputLines.txt"));){
            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
            inputStream.close();
            outputStream.close();;
        }
    }
}