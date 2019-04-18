package pl.allegro.latest_commited_repo_ver2.repos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReposNames {

    private RepoName[] repoNameList;

    public ReposNames() {
    }

    public RepoName[] getRepoNameList() {
        return repoNameList;
    }

    public void setRepoNameList(RepoName[] repoNameList) {
        this.repoNameList = repoNameList;
    }

    @Override
    public String toString() {
        return "repoNameList: " + repoNameList;
    }
}
