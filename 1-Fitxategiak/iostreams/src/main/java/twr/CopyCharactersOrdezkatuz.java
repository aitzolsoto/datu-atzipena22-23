package twr;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*Programa honek xanadu.txt fitxategia karakterez karaktere irakurtzen du eta characteroutput.txt izeneko fitxategian idazten du, a karaktere guztiak o karaktereagatik ordezkatzen ditu */

public class CopyCharactersOrdezkatuz {
    public static void main(String[] args) throws IOException {

     

        try (FileReader inputStream = new FileReader("iostreams/xanadu.txt");FileWriter outputStream = new FileWriter("iostreams/characteroutput.txt");){
            int c;
            while ((c = inputStream.read()) != -1) {
                if(c == 'a'){
                    outputStream.write('o');
                }else{
                    outputStream.write(c);
                }
                
            }

            inputStream.close();
            outputStream.close();
        } 
    }
}
