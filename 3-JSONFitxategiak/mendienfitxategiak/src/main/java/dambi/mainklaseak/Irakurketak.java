package dambi.mainklaseak;

import java.io.IOException;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendiak;

public class Irakurketak {
    static Csva csva = new Csva("Mendiak.csv","IdatzitakoMendiak.csv");
    static Xmla xmla = new Xmla("hirumendi.xml","IdaztekoMendiak.xml");
    public static void main(String[] args) throws IOException {
        //Mendiak irakurritakoMendiak = csva.irakurri();
        //System.out.println(csva.idatzi(irakurritakoMendiak) + " mendi idatzi dira");

        Mendiak mendiakXml = xmla.irakurri();
        System.out.println(xmla.idatzi(mendiakXml) + " mendi idatzi dira");
    }
}
