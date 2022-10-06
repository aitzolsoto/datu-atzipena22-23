package dambi;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class MendiakCX {
    private static String[] zutabeak;
    private static Mendiak mendiak = new Mendiak();
    private static int mendiZenb = 0;
    public static void main(String[] args) throws IOException{
        try (BufferedReader inputStream = new BufferedReader(new FileReader("mendienxmlak/Mendiak.csv"))){
            String banatzailea = ";";
            String l;
            while ((l = inputStream.readLine()) != null) {
                zutabeak = l.split(banatzailea);
                if(mendiZenb != 0){
                    Mendia mendia = new Mendia();
                    mendia.setMendia(zutabeak[0]);
                    mendia.setAltuera(Integer.parseInt(zutabeak[1]));
                    mendia.setProbintzia(zutabeak[2]);
                    mendiak.add(mendia);
                }
                mendiZenb++;
            }
            System.out.println(mendiak.getMendiak());
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }

      
        try{

                /* init jaxb marshaler */
                JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    
                /* set this flag to true to format the output */
                jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
    
                /* marshaling of java objects in xml (output to file and standard output) */
                jaxbMarshaller.marshal( mendiak, new File( "mendiguztiak.xml" ) );
                jaxbMarshaller.marshal( mendiak, System.out );
    
        }
        catch( JAXBException e ){
                e.printStackTrace();
        }
    
        
        
    }
}
