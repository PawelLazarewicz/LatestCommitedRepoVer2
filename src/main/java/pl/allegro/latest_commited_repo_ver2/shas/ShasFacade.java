package pl.allegro.latest_commited_repo_ver2.shas;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.allegro.latest_commited_repo_ver2.branches.BranchesFacade;

import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ShasFacade {

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
            ZonedDateTime shaDate;
            ZonedDateTime latestShasDateForRepo = null;
            for (String shasName : repoName.getValue()) {

                StringBuilder inline = new StringBuilder();
                try {
                    URL url =
                            new URL("https://api.github.com/repos/Lazar18/" + repoName.getKey() + "/commits/" + shasName);
                    Scanner sc = new Scanner(url.openStream());
                    while (sc.hasNext()) {
                        inline.append(sc.nextLine());
                    }
                    sc.close();


                    JSONParser jsonParser = new JSONParser();
                    JSONObject jsonObject = (JSONObject) jsonParser.parse(inline.toString());
                    JSONObject commitObjects = (JSONObject) jsonObject.get("commit");
                    JSONObject authorObjects = (JSONObject) commitObjects.get("author");
                    String stringShasDate = (String) authorObjects.get("date");
                    shaDate = ZonedDateTime.parse(stringShasDate);
                    shasDates.add(shaDate);

                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            }
            if (!shasDates.isEmpty()) {
                latestShasDateForRepo = shasDates
                        .stream()
                        .sorted()
                        .collect(Collectors.toList())
                        .get(shasDates.size() - 1);
                repoNameWithLatestShasDateFromEachBranch.put(repoName.getKey(), latestShasDateForRepo);
            }
        }
        shasDate.setRepoNameWithLatestShasDate(repoNameWithLatestShasDateFromEachBranch);
//        System.out.println(shasDate.getRepoNameWithLatestShasDate());

//        return shasDate.getRepoNameWithLatestShasDate();
    }

    public Map<String, ZonedDateTime> getRepoNameWithLatestShasFromEachBranch() {
        return shasDate.getRepoNameWithLatestShasDate();
    }
}
