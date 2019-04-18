package pl.allegro.latest_commited_repo_ver2.repos;

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
