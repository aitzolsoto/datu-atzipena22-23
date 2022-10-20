package dambi.mainklaseak;

import java.io.IOException;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendiak;

public class XmltikCsvra {
    public static void main(String[] args) throws IOException {
        Xmla xmla = new Xmla("Mendiak.xml");
        Csva csva = new Csva("","Arabakoak.csv");
        Mendiak mendiak = xmla.irakurri();
        Mendiak arabakoak = new Mendiak();
        for(int i = 0; i < mendiak.getMendiak().size();i++){
            if(mendiak.getMendiak().get(i).getProbintzia().equals("Araba")){
                arabakoak.add(mendiak.getMendiak().get(i));
            }
        }

        csva.idatzi(arabakoak);
    }
}
