package pl.allegro.latest_commited_repo_ver2.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepoController {

    private RepoFacade repoFacade;

    @Autowired
    public void setRepoFacade(RepoFacade repoFacade) {
        this.repoFacade = repoFacade;
    }

    @RequestMapping("/repos")
    public ResponseEntity getRepos(){
        repoFacade.readReposNamesFromJsonToArrayString();

        return new ResponseEntity(HttpStatus.OK);
    }
}
