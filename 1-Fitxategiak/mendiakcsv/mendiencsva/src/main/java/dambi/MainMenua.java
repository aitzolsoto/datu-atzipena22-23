package dambi;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class MainMenua {

    private static String[] zutabeak;
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1.- Mendien zerrenda ikusi");
            System.out.println("2.- Mendirik altuena bistaratu");
            System.out.println("3.- Mendiak esportatu");
            System.out.println("4.- Mendirik txikiena bistaratu");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    mendienZerrendaIkusi();
                    break;
                case 2:
                    mendirikAltuenaBistaratu();
                    break;
                case 3:
                    mendiakEsportatu();
                    break;
                case 4:
                    mendirikTxikienaBistaratu();
                    break;
                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
    }

    private static void mendienZerrendaIkusi() throws IOException{
        try (BufferedReader inputStream = new BufferedReader(new FileReader("Mendiak.csv"))){
            String banatzailea = ";";
            String l;
            while ((l = inputStream.readLine()) != null) {
                zutabeak = l.split(banatzailea);
                System.out.printf("%10s | %8s | %10s",zutabeak[0],zutabeak[1],zutabeak[2]);
                System.out.println();
            }
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
    }

    private static void mendirikAltuenaBistaratu() throws IOException{
        try (BufferedReader inputStream = new BufferedReader(new FileReader("Mendiak.csv"))){
            int lerroZenbakia = 0;
            String banatzailea = ";";
            String[] mendirikAltuena = null;
            String l;
            while ((l = inputStream.readLine()) != null) {
                zutabeak = l.split(banatzailea);
                if(lerroZenbakia != 0 && (mendirikAltuena == null || Integer.parseInt(mendirikAltuena[1]) < Integer.parseInt(zutabeak[1]))){
                    mendirikAltuena = zutabeak;
                }
                lerroZenbakia++;
            }

            System.out.println("Mendirik altuena: ");
            System.out.printf("%10s | %8s | %10s",mendirikAltuena[0],mendirikAltuena[1],mendirikAltuena[2]);
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
    }

    private static void mendirikTxikienaBistaratu() throws IOException{
        try (BufferedReader inputStream = new BufferedReader(new FileReader("Mendiak.csv"))){
            int lerroZenbakia = 0;
            String banatzailea = ";";
            String[] mendirikAltuena = null;
            String l;
            while ((l = inputStream.readLine()) != null) {
                zutabeak = l.split(banatzailea);
                if(lerroZenbakia != 0 && (mendirikAltuena == null || Integer.parseInt(mendirikAltuena[1]) > Integer.parseInt(zutabeak[1]))){
                    mendirikAltuena = zutabeak;
                }
                lerroZenbakia++;
            }

            System.out.println("Mendirik txikiena: ");
            System.out.printf("%10s | %8s | %10s",mendirikAltuena[0],mendirikAltuena[1],mendirikAltuena[2]);
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
    }

    private static void mendiakEsportatu() throws IOException{
        System.out.println("Aukeratu probintzia");
        System.out.println("1.Araba");
        System.out.println("2.Bizkaia");
        System.out.println("3.Gipuzkoa");
        System.out.println("4.Nafarroa");
        System.out.print("Sartu zenbaki bat: ");
        int probintzia = in.nextInt();
        String aukeratutakoProbintzia = "";

        
        try (BufferedReader inputStream = new BufferedReader(new FileReader("Mendiak.csv"))){
            PrintWriter outputStream = new PrintWriter(new FileWriter("MendiGuztiak.csv"));
            switch(probintzia){
                case 1:
                    aukeratutakoProbintzia = "Araba";
                    outputStream = new PrintWriter(new FileWriter("Araba.csv"));
                    break;
                case 2:
                    aukeratutakoProbintzia = "Bizkaia";
                    outputStream = new PrintWriter(new FileWriter("Bizkaia.csv"));
                    break;
                case 3:
                    aukeratutakoProbintzia = "Gipuzkoa";
                    outputStream = new PrintWriter(new FileWriter("Gipuzkoa.csv"));
                    break;
                case 4:
                    aukeratutakoProbintzia = "Nafarroa";
                    outputStream = new PrintWriter(new FileWriter("Nafarroa.csv"));
                    break;
                default:
                    mendiakEsportatu();
                    break;
            }
            String banatzailea = ";";
            String l;
            while ((l = inputStream.readLine()) != null) {
                zutabeak = l.split(banatzailea);
                if(aukeratutakoProbintzia.equals(zutabeak[2])){
                    outputStream.println(l);
                }
            }
            inputStream.close();
            outputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
    }
}
