package pl.allegro.latest_commited_repo_ver2.repos;

import java.util.List;

public class ReposNames {

    private List<RepoName> repoNameList;

    public ReposNames() {
    }

    public List<RepoName> getRepoNameList() {
        return repoNameList;
    }

    public void setRepoNameList(List<RepoName> repoNameList) {
        this.repoNameList = repoNameList;
    }

    @Override
    public String toString() {
        return "repoNameList: " + repoNameList;
    }
}
