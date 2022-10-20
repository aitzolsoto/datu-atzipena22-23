package dambi.mainklaseak;

import java.io.FileNotFoundException;

import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendiak;

public class JsonetikXmlra {
    public static void main(String[] args) throws FileNotFoundException  {
        Jsona jsona = new Jsona("data/Mendiak.json");
        Xmla xmla = new Xmla("","Nafarroakoak.xml");
        Mendiak mendiak = jsona.irakurri();
        Mendiak nafarroakoak = new Mendiak();
        for(int i = 0; i < mendiak.getMendiak().size();i++){
            if(mendiak.getMendiak().get(i).getProbintzia().equals("Nafarroa")){
                nafarroakoak.add(mendiak.getMendiak().get(i));
            }
        }

        xmla.idatzi(nafarroakoak);
    }
}
