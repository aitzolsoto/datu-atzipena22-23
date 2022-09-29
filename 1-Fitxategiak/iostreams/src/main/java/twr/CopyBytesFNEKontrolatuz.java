package twr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*Programa honek xanadu.txt fitxategiko bytez byte irakurtzen du eta outagain.txt izeneko fitxategian idazten du, ez bada irakurri behar den fitxategia aurkitzen mezu bat erakusten du,
 * fitxategia ez dela aurkitu adieraziz.
*/

public class CopyBytesFNEKontrolatuz {
    public static void main(String[] args) throws IOException {



        try (FileInputStream in = new FileInputStream("iostreams/xanadu.txt"); FileOutputStream out = new FileOutputStream("iostreams/outagain.txt");){
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
    }
}