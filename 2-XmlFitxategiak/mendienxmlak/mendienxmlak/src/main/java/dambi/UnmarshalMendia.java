package dambi;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.Marshaller;

public class UnmarshalMendia {
    public static void main( String[] args )
    {
        try
        {
            File file = new File( "hirumendi.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );

            /**
             * the only difference with the marshaling operation is here
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Mendiak mendiak = (Mendiak)jaxbUnmarshaller.unmarshal(file);
            for(int i = 0;i < mendiak.getMendiak().size();i++){
                float altueraOinetan =  mendiak.getMendiak().get(i).getAltuera() * 3.28f;
                mendiak.getMendiak().get(i).setAltuera((int)altueraOinetan);
            }

            /* init jaxb marshaler */
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( mendiak, new File( "mendiakaltueraoinatan.xml" ) );
            jaxbMarshaller.marshal( mendiak, System.out );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}
