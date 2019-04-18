package pl.allegro.latest_commited_repo_ver2.repos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
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
