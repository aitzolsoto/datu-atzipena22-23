package dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.json.Json;

import javax.json.JsonReader;
import javax.json.JsonStructure;

public class Jsona {
    String strFileIn;
    String strFileOut;

    public Jsona(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Jsona(String strFileIn, String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public void irakurri() throws FileNotFoundException{
        JsonReader reader = Json.createReader(new FileReader(strFileIn));
        JsonStructure jsonst = reader.read();
        System.out.println(jsonst);
    }
}
