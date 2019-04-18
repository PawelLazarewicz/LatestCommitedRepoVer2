package pl.allegro.latest_commited_repo_ver2.branches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BranchesController {

    private BranchesFacade branchesFacade;

    @Autowired
    public void setBranchesFacade(BranchesFacade branchesFacade) {
        this.branchesFacade = branchesFacade;
    }

    @RequestMapping("/branches")
    public ResponseEntity getRepos(){
        Map<String, List<String>> stringListMap = branchesFacade.readBranchesShasFromJsonToMap();

        return new ResponseEntity(stringListMap, HttpStatus.OK);
    }
}
