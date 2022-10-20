package dambi.mainklaseak;

import java.io.FileNotFoundException;
import java.io.IOException;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.pojoak.Mendiak;

public class JsonetikCsvara {
    public static void main(String[] args) throws IOException {
        Jsona jsona = new Jsona("data/Mendiak.json");
        Csva csva = new Csva("","Nafarroakoak.csv");
        Mendiak mendiak = jsona.irakurri();
        Mendiak nafarroakoak = new Mendiak();
        for(int i = 0; i < mendiak.getMendiak().size();i++){
            if(mendiak.getMendiak().get(i).getProbintzia().equals("Nafarroa")){
                nafarroakoak.add(mendiak.getMendiak().get(i));
            }
        }

        csva.idatzi(nafarroakoak);
    }
}
