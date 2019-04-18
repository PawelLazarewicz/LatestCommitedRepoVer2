package pl.allegro.latest_commited_repo_ver2.repos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepoName {

    String repoName;

    public RepoName() {
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    @Override
    public String toString() {
        return "reponame: " + repoName;
    }
}
