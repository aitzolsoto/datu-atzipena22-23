package dambi.probak;

import java.io.File;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class MendienXmlaSortu {
    public static void main(String[] args) {
        try{
            Mendia urkiola = new Mendia();
            urkiola.setId(0);
            urkiola.setMendia("Urkiola");
            urkiola.setAltuera(1011);
            urkiola.setProbintzia("Bizkaia");
    
            Mendia aitzkorri = new Mendia();
            aitzkorri.setId(1);
            aitzkorri.setMendia("Aitzkorri");
            aitzkorri.setAltuera(1530);
            aitzkorri.setProbintzia("Guipuzkoa");
    
            Mendia saioa = new Mendia();
            saioa.setId(2);
            saioa.setMendia("Saioa");
            saioa.setAltuera(1418);
            saioa.setProbintzia("Nafarroa");
    
            Mendiak mendiak = new Mendiak();
            mendiak.add( urkiola );
            mendiak.add( aitzkorri );
            mendiak.add( saioa );
    
            
                /* init jaxb marshaler */
                JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    
                /* set this flag to true to format the output */
                jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
    
                /* marshaling of java objects in xml (output to file and standard output) */
                jaxbMarshaller.marshal( mendiak, new File( "hirumendi.xml" ) );
                jaxbMarshaller.marshal( mendiak, System.out );
    
        }
        catch( JAXBException e )
            {
                e.printStackTrace();
            }
    
        
    }
}
