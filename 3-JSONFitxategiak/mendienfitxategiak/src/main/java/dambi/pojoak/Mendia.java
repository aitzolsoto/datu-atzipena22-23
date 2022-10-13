package dambi.pojoak;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;




@XmlType( propOrder = { "id","mendia", "altuera", "probintzia"} )
@XmlRootElement( name = "Mendia" )

public class Mendia {
    int id = 0;
    String mendia = "";
    int altuera = 0;
    String probintzia = "";

    public int getId(){
        return id;
    }

    @XmlElement(name = "Id")
    public void setId(int id){
        this.id = id;
    }

    public String  getMendia(){

        return mendia;
    }

    @XmlElement( name = "Mendia" )
    public void setMendia(String mendia){

        this.mendia = mendia;
    }

    public int getAltuera(){

        return altuera;
    }

    @XmlElement( name = "Altuera" )
    public void setAltuera(int altuera){

        this.altuera = altuera;
    }

    public String getProbintzia(){

        return probintzia;
    }

    @XmlElement( name = "Probintzia" )
    public void setProbintzia(String probintzia){

        this.probintzia = probintzia;
    }

    public String toString(){
        return "Id: " + id + ", Mendia: " + mendia + ",Altuera: " + altuera + ",Probintzia: " + probintzia;
    }

}
