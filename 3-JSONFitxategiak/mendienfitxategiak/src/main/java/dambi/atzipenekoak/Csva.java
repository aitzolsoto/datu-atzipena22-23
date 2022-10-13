package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class Csva {
    String strFileIn;
    String strFileOut;

    public Csva(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Csva(String strFileIn,String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Mendiak irakurri() throws IOException{
        Mendiak mendiak = new Mendiak();
        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))){
            String banatzailea = ";";
            String l;
            int mendiZenb = 0;
            while ((l = inputStream.readLine()) != null) {
                String [] zutabeak = l.split(banatzailea);
                if(mendiZenb != 0){
                    Mendia mendia = new Mendia();
                    mendia.setId(mendiZenb);
                    mendia.setMendia(zutabeak[0]);
                    mendia.setAltuera(Integer.parseInt(zutabeak[1]));
                    mendia.setProbintzia(zutabeak[2]);
                    mendiak.add(mendia);
                }
                mendiZenb++;
            }
            //System.out.println(mendiak.getMendiak().toString());
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
        return mendiak;
    }

    public int idatzi(Mendiak mendiak) throws IOException{
        int guztira = 0;
        try {
            PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut));
            outputStream.printf("%s;%s;%s;%s;", "ID","MENDIA","ALTUERA","PROBINTZIA");
            
            for(int i = 0;i < mendiak.getMendiak().size();i++){
                //outputStream.println(mendiak.getMendiak().get(i));
                outputStream.printf("\n %d;%s;%d;%s;", mendiak.getMendiak().get(i).getId(),mendiak.getMendiak().get(i).getMendia(),mendiak.getMendiak().get(i).getAltuera(),mendiak.getMendiak().get(i).getProbintzia());
                guztira++;
            }
            outputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
        return guztira;
    }
}
