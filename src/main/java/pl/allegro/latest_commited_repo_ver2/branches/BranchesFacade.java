package pl.allegro.latest_commited_repo_ver2.branches;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import pl.allegro.latest_commited_repo_ver2.Methods;
import pl.allegro.latest_commited_repo_ver2.repos.RepoFacade;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class BranchesFacade extends Methods {

    private RepoFacade repoFacade;

    private BranchesSha branchesSha;
    private Map<String, List<String>> repoNameWithLatestShasFromEachBranch = new HashMap<>();

    public BranchesFacade(RepoFacade repoFacade, BranchesSha branchesSha) {
        this.repoFacade = repoFacade;
        this.branchesSha = branchesSha;
    }

    public void readBranchesShasFromJsonToMap() {

        for (String repoName : repoFacade.getReposNames()) {
            try {
                URL url = new URL("https://api.github.com/repos/Lazar18/" + repoName + "/branches");
                StringBuilder inline = urlToString(url);

                JSONArray jsonArray = stringToJsonArray(inline);

                getValueFromKeyForEachJsonArrayObjectNested(repoName, jsonArray);

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        branchesSha.setRepoNameWithLatestShasFromEachBranch(repoNameWithLatestShasFromEachBranch);
    }

    //get as string value from key "commit":"sha" for each branchJsonArray object
    //and return map of repoNames with its list of shas
    private void getValueFromKeyForEachJsonArrayObjectNested(String repoName, JSONArray branchesJsonArray) {
        List<String> branchesShas = new ArrayList<>();
        String stringShaName;

        for (Object branchJsonArray : branchesJsonArray) {

            JSONObject branchObjects = (JSONObject) branchJsonArray;
            JSONObject commitObjects = (JSONObject) branchObjects.get("commit");
            stringShaName = String.valueOf(commitObjects.get("sha"));

            branchesShas.add(stringShaName);
        }
        repoNameWithLatestShasFromEachBranch.put(repoName, branchesShas);
    }

    public Map<String, List<String>> getRepoNameWithLatestShasFromEachBranch() {
        return branchesSha.getRepoNameWithLatestShasFromEachBranch();
    }
}
