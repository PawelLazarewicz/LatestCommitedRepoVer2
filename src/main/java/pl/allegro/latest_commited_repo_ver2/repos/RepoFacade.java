package pl.allegro.latest_commited_repo_ver2.repos;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class RepoFacade {

    private URL urlRepos;
    private ReposNames reposNames = new ReposNames();
    private List<String> names = new ArrayList<>();

    public RepoFacade(URL urlRepos) {
        this.urlRepos = urlRepos;
    }

    public List<String> readReposNamesFromJsonToArrayString() {

        StringBuilder inline = new StringBuilder();
        try {
            URL url = urlRepos;

            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext()) {
                inline.append(sc.nextLine());
            }
            sc.close();

            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(inline.toString());

            //Get data for Results array

            for (Object aJsonArray : jsonArray) {

//Store the JSON objects in an array
//Get the index of the JSON object and print the values as per the index
                JSONObject jsonObject1 = (JSONObject) aJsonArray;
                String stringRepoName = String.valueOf(jsonObject1.get("name"));
                names.add(stringRepoName);
            }
            reposNames.setRepoNameList(names);
            System.out.println(reposNames);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return reposNames.getRepoNameList();
    }

    public List<String> getReposNames(){
        return reposNames.getRepoNameList();
    }
}

