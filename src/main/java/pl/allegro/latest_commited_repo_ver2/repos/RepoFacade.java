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
    private ReposNames reposNames;
    private List<String> names = new ArrayList<>();

    public RepoFacade(URL urlRepos, ReposNames reposNames) {
        this.urlRepos = urlRepos;
        this.reposNames = reposNames;
    }

    public void readReposNamesFromJsonToArrayString() {

        try {
            StringBuilder inline = urlToString(urlRepos);

            JSONArray jsonArray = stringToJsonArray(inline);

            getValueFromKeyForEachJsonArrayObject(jsonArray);

            reposNames.setRepoNameList(names);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    //get as string value from key "name" for each jsonArray object
    //and return list of reposNames
    private void getValueFromKeyForEachJsonArrayObject(JSONArray reposJsonArray) {

        for (Object repoJsonArray : reposJsonArray) {

            JSONObject repoObject = (JSONObject) repoJsonArray;
            String stringRepoName = String.valueOf(repoObject.get("name"));

            names.add(stringRepoName);
        }
    }

    public List<String> getReposNames() {
        return reposNames.getRepoNameList();
    }
}

