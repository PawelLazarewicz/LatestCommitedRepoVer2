package pl.allegro.latest_commited_repo_ver2;

import pl.allegro.latest_commited_repo_ver2.branches.BranchesFacade;
import pl.allegro.latest_commited_repo_ver2.repos.RepoFacade;
import pl.allegro.latest_commited_repo_ver2.shas.ShasFacade;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.stream.Collectors;

public class AppFacade {

    private RepoFacade repoFacade;
    private BranchesFacade branchesFacade;
    private ShasFacade shasFacade;
    private String latestCommittedRepoName;

    public AppFacade(RepoFacade repoFacade, BranchesFacade branchesFacade, ShasFacade shasFacade) {
        this.repoFacade = repoFacade;
        this.branchesFacade = branchesFacade;
        this.shasFacade = shasFacade;
    }

    public String App(){
        repoFacade.readReposNamesFromJsonToArrayString();
        branchesFacade.readBranchesShasFromJsonToMap();
        shasFacade.readLatestShaDateForRepoFromJsonToMap();

        return getLatestCommittedRepoName();
    }

    public String getLatestCommittedRepoName() {

        Map<String, ZonedDateTime> repoNameWithLatestShasFromEachBranch =
                shasFacade.getRepoNameWithLatestShasFromEachBranch();

        ZonedDateTime latestCommitDate = repoNameWithLatestShasFromEachBranch
                .values()
                .stream()
                .sorted()
                .collect(Collectors.toList())
                .get(repoNameWithLatestShasFromEachBranch.values().size() - 1);

        for (Map.Entry<String, ZonedDateTime> repoNameLatestCommitDateMap :
                repoNameWithLatestShasFromEachBranch.entrySet()) {

            if (latestCommitDate.equals(repoNameLatestCommitDateMap.getValue())) {
                latestCommittedRepoName = repoNameLatestCommitDateMap.getKey();
                System.out.println(latestCommittedRepoName);
                break;
            }
        }
        return latestCommittedRepoName;
    }
}
