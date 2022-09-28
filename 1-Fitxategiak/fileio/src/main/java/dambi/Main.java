package dambi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static int aukera = 0;
    public static void main(String[] args) throws IOException {
        while(aukera != 4){
            System.out.println("MENUA");
            System.out.println("----------------------");
            System.out.println("1.Fitxategia edo karpeta existitzen dela egiaztatu");
            System.out.println("2.Karpeta baten edukia bistaratu");
            System.out.println("3.Fitxategia sortu");
            System.out.println("4.Irten");
            System.out.print("Sartu zenbaki bat: ");
            aukera = in.nextInt();

            switch(aukera){
                case 1:
                    fitxategiaExistitzenDa();
                    break;
                case 2:
                    edukiaBistaratu();
                    break;
                case 3:
                    fitxategiaSortu();
                    break;
            }
        }
    }

    private static void fitxategiaExistitzenDa(){
        System.out.println("Sartu karpeta edo fitxategiaren path-a: ");
        in.nextLine();
        String pathIzena = in.nextLine();

        File f = new File(pathIzena);
        if(f.exists()){
            System.out.println(pathIzena + " existitzen da");
        }else{
            System.out.println(pathIzena + " ez da existitzen");
        }
    }

    private static void edukiaBistaratu(){
        System.out.print("Sartu karpeta edo fitxategiaren path-a: ");
        String pathIzena = in.next();

        File f = new File(pathIzena);
        if(f.exists()){
            File[] files = f.listFiles();
            for(int i = 0;i < files.length;i++){
                System.out.println(files[i].getName());
            }
        }else{
            System.out.println(pathIzena + " ez da existitzen");
        }
    }

    private static void fitxategiaSortu() throws IOException{
        System.out.print("Zer zoaz deskribatzera: ");
        String karpeta = in.next();
        System.out.print("Zein: ");
        String fitxategia = in.next();
        System.out.print("Nolakoa da: ");
        in.nextLine();
        String deskribapena = in.nextLine();

        System.out.println("Karpeta: " + karpeta);
        System.out.println("Fitxategia: " + fitxategia);
        System.out.println("Deskribapena: " + deskribapena);
        if(karpeta.equals("ugaztuna") || karpeta.equals("arraina")){
            File f = new File("C:\\Users\\soto.aitzol\\Desktop\\datu-atzipena22-23\\1-Fitxategiak\\fileio\\src\\karpeta berriak\\animaliak" + "\\" + karpeta + "k\\" + fitxategia + ".txt");
            if(f.createNewFile()){
                System.out.println("Fitxategia sortu da: " + f.getName());
                BufferedWriter out = new BufferedWriter(new FileWriter(f));
                out.write(deskribapena);
                out.close();
            }
        }else if(karpeta.equals("barazkia") || karpeta.equals("esnekia")){
            File f = new File("C:\\Users\\soto.aitzol\\Desktop\\datu-atzipena22-23\\1-Fitxategiak\\fileio\\src\\karpeta berriak\\elikagaiak" + "\\" + karpeta + "k\\" + fitxategia + ".txt");
            if(f.createNewFile()){
                System.out.println("Fitxategia sortu da: " + f.getName());
                PrintWriter out = new PrintWriter(f);
                out.write(deskribapena);
                out.close();
            }
        }else{
            System.out.println("Ez da sortu");
        }
    }

    
}
