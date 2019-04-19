package pl.allegro.latest_commited_repo_ver2.shas;

import java.time.ZonedDateTime;
import java.util.Map;

public class ShasDate {

    private Map<String, ZonedDateTime> repoNameWithLatestShasDate;

    public ShasDate() {
    }

    public Map<String, ZonedDateTime> getRepoNameWithLatestShasDate() {
        return repoNameWithLatestShasDate;
    }

    public void setRepoNameWithLatestShasDate(Map<String, ZonedDateTime> repoNameWithLatestShasDate) {
        this.repoNameWithLatestShasDate = repoNameWithLatestShasDate;
    }

    @Override
    public String toString() {
        return "ShasDate{" +
                "repoNameWithLatestShasDate=" + repoNameWithLatestShasDate +
                '}';
    }
}
