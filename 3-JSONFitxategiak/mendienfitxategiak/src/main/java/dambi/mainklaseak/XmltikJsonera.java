package dambi.mainklaseak;

import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendiak;

public class XmltikJsonera {
    public static void main(String[] args) {
        Xmla xmla = new Xmla("Mendiak.xml");
        Jsona jsona = new Jsona("", "data/Arabakoak.json");
        Mendiak mendiak = xmla.irakurri();
        Mendiak arabakoak = new Mendiak();
        for(int i = 0; i < mendiak.getMendiak().size();i++){
            if(mendiak.getMendiak().get(i).getProbintzia().equals("Araba")){
                arabakoak.add(mendiak.getMendiak().get(i));
            }
        }

        jsona.idatzi(arabakoak);
    }
}
