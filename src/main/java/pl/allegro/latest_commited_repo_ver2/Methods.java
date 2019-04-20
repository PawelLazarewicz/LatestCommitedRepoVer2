package pl.allegro.latest_commited_repo_ver2;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Methods {

    //read JSON data from stream to String
    public StringBuilder urlToString(URL url) throws IOException {
        StringBuilder inline = new StringBuilder();

        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNext()) {
            inline.append(sc.nextLine());
        }
        sc.close();
        return inline;
    }

    //parse string to JSONArray into key value pairs
    public JSONArray stringToJsonArray(StringBuilder inline) throws ParseException {

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(inline.toString());

        return jsonArray;
    }
}
