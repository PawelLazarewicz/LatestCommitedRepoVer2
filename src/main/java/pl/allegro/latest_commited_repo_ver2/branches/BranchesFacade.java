package pl.allegro.latest_commited_repo_ver2.branches;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.allegro.latest_commited_repo_ver2.repos.RepoFacade;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class BranchesFacade {

    private RepoFacade repoFacade;

    private Map<String, List<String>> repoNameWithLatestShasFromEachBranch = new HashMap<>();

    public BranchesFacade(RepoFacade repoFacade) {
        this.repoFacade = repoFacade;
    }

    public Map<String, List<String>> readBranchesShasFromJsonToMap() {

        for (String repoName : repoFacade.getReposNames()) {
            StringBuilder inline = new StringBuilder();
            try {
                URL url = new URL("https://api.github.com/repos/Lazar18/" + repoName + "/branches");

                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline.append(sc.nextLine());
                }
                sc.close();

                JSONParser jsonParser = new JSONParser();
                JSONArray jsonArray = (JSONArray) jsonParser.parse(inline.toString());

                List<String> branchesShas = new ArrayList<>();
                String stringShaName;
                for (Object aJsonArray : jsonArray) {

                    JSONObject branchObjects = (JSONObject) aJsonArray;
                    JSONObject commitObjects = (JSONObject) branchObjects.get("commit");
                    stringShaName = String.valueOf(commitObjects.get("sha"));

                    branchesShas.add(stringShaName);
                }
                repoNameWithLatestShasFromEachBranch.put(repoName, branchesShas);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println(repoNameWithLatestShasFromEachBranch);

        return repoNameWithLatestShasFromEachBranch;
    }
}
