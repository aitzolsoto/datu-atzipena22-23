package dambi.mainklaseak;

import java.io.IOException;

import dambi.atzipenekoak.Csva;
import dambi.pojoak.Mendiak;

public class Irakurketak {
    static Csva csva = new Csva("Mendiak.csv","IdatzitakoMendiak.csv");
    public static void main(String[] args) throws IOException {
        Mendiak irakurritakoMendiak = csva.irakurri();
        System.out.println(csva.idatzi(irakurritakoMendiak) + " mendi idatzi dira");
    }
}
