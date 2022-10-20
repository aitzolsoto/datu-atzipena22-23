package dambi.mainklaseak;

import java.io.IOException;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.pojoak.Mendiak;

public class CsvtikJsonera {
    public static void main(String[] args) throws IOException {
        Csva csva = new Csva("Mendiak.csv");
        Jsona jsona = new Jsona("", "data/Bizkaiakoak.json");
        Mendiak mendiak = csva.irakurri();
        Mendiak bizkaiakoak = new Mendiak();
        for(int i = 0; i < mendiak.getMendiak().size();i++){
            if(mendiak.getMendiak().get(i).getProbintzia().equals("Bizkaia")){
                bizkaiakoak.add(mendiak.getMendiak().get(i));
            }
        }
        jsona.idatzi(bizkaiakoak);
    }
}
