package dambi;

import javax.json.Json;
import javax.json.JsonObject;

public class JsonExampleAriketa {
    public static void main(String[] args) {
        JsonObject model = Json.createObjectBuilder()
        .add("menu",Json.createObjectBuilder()
            .add("id", "file")
            .add("value", "file")
            .add("popup", Json.createObjectBuilder()
                .add("menuitem", Json.createArrayBuilder()
                .add(Json.createObjectBuilder()
                    .add("value", "new")
                    .add("onclick", "CreateNewDoc()"))
                .add(Json.createObjectBuilder()
                    .add("value", "open")
                    .add("onclick", "OpenDoc"))
                .add(Json.createObjectBuilder()
                    .add("value", "new")
                    .add("onclick", "CreateNewDoc()"))))) 
        .build();
        System.out.println(model);

    }
}
