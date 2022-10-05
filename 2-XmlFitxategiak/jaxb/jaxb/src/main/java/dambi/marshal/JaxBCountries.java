package dambi.marshal;

import java.io.File;
import java.time.LocalDate;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import dambi.business.Countries;
import dambi.business.Country;

public class JaxBCountries {
    public static void main( String[] args )
    {
        try
        {

            /* init a list with a couple of countries to marshal */
            Country spain = new Country();
            spain.setName( "Spain" );
            spain.setCapital( "Madrid" );
            spain.setContinent( "Europe" );

            Country usa = new Country();
            usa.setName( "USA" );
            usa.setCapital( "Washington" );
            usa.setContinent( "America" );

            Country japan = new Country();
            japan.setName( "Japan" );
            japan.setCapital( "Tokyo" );
            japan.setContinent( "Asia" );


            Countries countries = new Countries();
            countries.add(spain);
            countries.add(usa);
            countries.add(japan);

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Countries.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( countries, new File( "countries.xml"));
            jaxbMarshaller.marshal( countries, System.out );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}
