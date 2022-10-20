package dambi.mainklaseak;

import java.io.IOException;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendiak;

public class CsvtikXmlra {
    public static void main(String[] args) throws IOException {
        Csva csva = new Csva("Mendiak.csv");
        Xmla Xmla = new dambi.atzipenekoak.Xmla("", "Mendiak.xml");
        Mendiak mendiak = csva.irakurri();
        Mendiak bizkaiakoak = new Mendiak();
        for(int i = 0; i < mendiak.getMendiak().size();i++){
            if(mendiak.getMendiak().get(i).getProbintzia().equals("Bizkaia")){
                bizkaiakoak.add(mendiak.getMendiak().get(i));
            }
        }
        Xmla.idatzi(bizkaiakoak);
    }
}
