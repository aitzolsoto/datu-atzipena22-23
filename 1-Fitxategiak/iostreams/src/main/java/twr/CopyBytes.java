package twr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*Programa honek xanadu.txt fitxategiko bytez byte irakurtzen du eta outagain.txt izeneko fitxategian idazten du */

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        

        try(FileInputStream in = new FileInputStream("iostreams/xanadu.txt");FileOutputStream out = new FileOutputStream("iostreams/outagain.txt");) {
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.close();
        } 
    }
}