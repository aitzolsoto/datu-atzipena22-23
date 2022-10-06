package dambi;


import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;



public class Mendiaxml {
    public static void main(String[] args) {
        try
        {

            /* init very simple data to marshal */
            Mendia urkiola = new Mendia();
            urkiola.setMendia("Urkiola");
            urkiola.setAltuera(1011);
            urkiola.setProbintzia("Bizkaia");


            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendia.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( urkiola, new File( "mendibat.xml" ) );
            jaxbMarshaller.marshal( urkiola, System.out );
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }
    }
}
