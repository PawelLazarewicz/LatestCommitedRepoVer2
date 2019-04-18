package pl.allegro.latest_commited_repo_ver2.shas;

import java.util.List;
import java.util.Map;

public class ShasDate {

    private Map<String, List<String>> repoNameWithLatestShasDateFromEachBranch;

    public ShasDate() {
    }

    public Map<String, List<String>> getRepoNameWithLatestShasDateFromEachBranch() {
        return repoNameWithLatestShasDateFromEachBranch;
    }

    public void setRepoNameWithLatestShasDateFromEachBranch(Map<String, List<String>> repoNameWithLatestShasDateFromEachBranch) {
        this.repoNameWithLatestShasDateFromEachBranch = repoNameWithLatestShasDateFromEachBranch;
    }

    @Override
    public String toString() {
        return repoNameWithLatestShasDateFromEachBranch.toString();
    }
}
