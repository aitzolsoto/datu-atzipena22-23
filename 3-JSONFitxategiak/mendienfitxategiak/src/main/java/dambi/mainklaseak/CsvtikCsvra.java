package dambi.mainklaseak;

import java.io.IOException;

import dambi.atzipenekoak.Csva;
import dambi.pojoak.Mendiak;

public class CsvtikCsvra {
    public static void main(String[] args) throws IOException {
        Csva csva  = new Csva("Mendiak.csv","Bizkaiakoak.csv");
        Mendiak mendiak = csva.irakurri();
        Mendiak bizkaiakoak = new Mendiak();

        for(int i = 0; i < mendiak.getMendiak().size();i++){
            if(mendiak.getMendiak().get(i).getProbintzia().equals("Bizkaia")){
                bizkaiakoak.add(mendiak.getMendiak().get(i));
            }
        }
        csva.idatzi(bizkaiakoak);
    }
}
