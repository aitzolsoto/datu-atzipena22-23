package dambi.atzipenekoak;

import java.io.File;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla {
    String strFileIn;
    String strFileOut;

    public Xmla(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Xmla(String strFileIn,String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Mendiak irakurri(){
         /* init jaxb marshaler */
         Mendiak mendiak = null;
         try{
            File file = new File( "hirumendi.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );

            /**
             * the only difference with the marshaling operation is here
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            mendiak = (Mendiak)jaxbUnmarshaller.unmarshal(file);
        
         }catch(JAXBException e){
            e.printStackTrace();
         }
        return mendiak;
    }

    public int idatzi(Mendiak mendiak){
        int guztira = 0;
        try{
            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( mendiak, new File( strFileOut ) );
            jaxbMarshaller.marshal( mendiak, System.out );
        }catch(JAXBException e){
            e.printStackTrace();
        }
        return mendiak.getMendiak().size();
    }
}
