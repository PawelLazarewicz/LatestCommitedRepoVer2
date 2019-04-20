package pl.allegro.latest_commited_repo_ver2.repos;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import pl.allegro.latest_commited_repo_ver2.Methods;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class RepoFacade extends Methods {

    private URL urlRepos;
    private ReposNames reposNames = new ReposNames();
//    private List<String> names = new ArrayList<>();

    public RepoFacade(URL urlRepos) {
        this.urlRepos = urlRepos;
    }

    public void readReposNamesFromJsonToArrayString() {

        try {
            StringBuilder inline = urlToString(urlRepos);

            JSONArray jsonArray = stringToJsonArray(inline);

            List<String> namesList = getValueFromKeyForEachJsonArrayObject(jsonArray);
            reposNames.setRepoNameList(namesList);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    //get as string value from key "name" for each jsonArray object
    //and return list of names
    private List<String> getValueFromKeyForEachJsonArrayObject(JSONArray reposJsonArray) {
        List<String> names = new ArrayList<>();

        for (Object repoJsonArray : reposJsonArray) {

            JSONObject repoObject = (JSONObject) repoJsonArray;
            String stringRepoName = String.valueOf(repoObject.get("name"));

            names.add(stringRepoName);
        }
        return names;
    }

    public List<String> getReposNames() {
        return reposNames.getRepoNameList();
    }
}

