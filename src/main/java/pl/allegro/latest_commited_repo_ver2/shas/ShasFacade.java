package pl.allegro.latest_commited_repo_ver2.shas;

import pl.allegro.latest_commited_repo_ver2.branches.BranchesFacade;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ShasFacade {

    private BranchesFacade branchesFacade;

    private ShasDate shasDate;

    public ShasFacade(BranchesFacade branchesFacade) {
        this.branchesFacade = branchesFacade;
    }

    public Map<String, List<LocalDateTime>> readShasDateFromJsonToMap() {


        return null;
    }
}
