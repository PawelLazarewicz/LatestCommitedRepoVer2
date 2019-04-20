package pl.allegro.latest_commited_repo_ver2.shas;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.allegro.latest_commited_repo_ver2.Methods;
import pl.allegro.latest_commited_repo_ver2.branches.BranchesFacade;

import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ShasFacade extends Methods {

    private BranchesFacade branchesFacade;

    private ShasDate shasDate = new ShasDate();
    private Map<String, ZonedDateTime> repoNameWithLatestShasDateFromEachBranch = new HashMap<>();

    public ShasFacade(BranchesFacade branchesFacade) {
        this.branchesFacade = branchesFacade;
    }

    public void readLatestShaDateForRepoFromJsonToMap() {

        for (Map.Entry<String, List<String>> repoName :
                branchesFacade.getRepoNameWithLatestShasFromEachBranch().entrySet()) {

            List<ZonedDateTime> shasDates = new ArrayList<>();
            for (String shasName : repoName.getValue()) {
                try {
                    URL url = new URL("https://api.github.com/repos/Lazar18/" + repoName.getKey() + "/commits/" + shasName);
                    StringBuilder inline = urlToString(url);

                    getShasDatesListForRepo(shasDates, inline);

                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            }
            getMapRepoWithLatestShasDate(repoName, shasDates);
        }
        shasDate.setRepoNameWithLatestShasDate(repoNameWithLatestShasDateFromEachBranch);
    }

    // create Map <repoName, latestShasDate> - excluding repo without any shas
    private void getMapRepoWithLatestShasDate(Map.Entry<String, List<String>> repoName, List<ZonedDateTime> shasDates) {
        ZonedDateTime latestShasDateForRepo;

        if (!shasDates.isEmpty()) {
            latestShasDateForRepo = shasDates
                    .stream()
                    .sorted()
                    .collect(Collectors.toList())
                    .get(shasDates.size() - 1);
            repoNameWithLatestShasDateFromEachBranch.put(repoName.getKey(), latestShasDateForRepo);
        }
    }

    //get as ZonedDateTime value from key "commit":"author":"date" for each shaJsonObject
    // and return list of shasDates
    private void getShasDatesListForRepo(List<ZonedDateTime> shasDates, StringBuilder inline) throws ParseException {
        ZonedDateTime shasDate;

        JSONParser jsonParser = new JSONParser();
        JSONObject shaObject = (JSONObject) jsonParser.parse(inline.toString());
        JSONObject commitObjects = (JSONObject) shaObject.get("commit");
        JSONObject authorObjects = (JSONObject) commitObjects.get("author");
        String stringShasDate = (String) authorObjects.get("date");
        shasDate = ZonedDateTime.parse(stringShasDate);
        shasDates.add(shasDate);
    }

    public Map<String, ZonedDateTime> getRepoNameWithLatestShasFromEachBranch() {
        return shasDate.getRepoNameWithLatestShasDate();
    }
}
