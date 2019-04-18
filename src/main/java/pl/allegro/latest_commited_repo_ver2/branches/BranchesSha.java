package pl.allegro.latest_commited_repo_ver2.branches;

import java.util.List;
import java.util.Map;

public class BranchesSha {

    private Map<String, List<String>> repoNameWithLatestShasFromEachBranch;

    public BranchesSha() {
    }

    public Map<String, List<String>> getRepoNameWithLatestShasFromEachBranch() {
        return repoNameWithLatestShasFromEachBranch;
    }

    public void setRepoNameWithLatestShasFromEachBranch(Map<String, List<String>> repoNameWithLatestShasFromEachBranch) {
        this.repoNameWithLatestShasFromEachBranch = repoNameWithLatestShasFromEachBranch;
    }

    @Override
    public String toString() {
        return repoNameWithLatestShasFromEachBranch.toString();
    }
}
