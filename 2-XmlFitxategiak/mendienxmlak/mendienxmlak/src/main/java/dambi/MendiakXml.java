package dambi;


import java.io.File;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import dambi.Mendia;
import dambi.Mendiak;

public class MendiakXml {
    
    public static void main(String[] args) {
        try{
        Mendia urkiola = new Mendia();
        urkiola.setMendia("Urkiola");
        urkiola.setAltuera(1011);
        urkiola.setProbintzia("Bizkaia");

        Mendia aitzkorri = new Mendia();
        aitzkorri.setMendia("Aitzkorri");
        aitzkorri.setAltuera(1530);
        aitzkorri.setProbintzia("Guipuzkoa");

        Mendia saioa = new Mendia();
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
