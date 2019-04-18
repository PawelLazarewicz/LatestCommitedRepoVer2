package pl.allegro.latest_commited_repo_ver2.repos;

import java.util.List;

public class ReposNames {

    private List<String> repoNameList;

    public ReposNames() {
    }

    public List<String> getRepoNameList() {
        return repoNameList;
    }

    public void setRepoNameList(List<String> repoNameList) {
        this.repoNameList = repoNameList;
    }

    @Override
    public String toString() {
        return repoNameList.toString();
    }
}
