package pl.allegro.latest_commited_repo_ver2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private AppFacade appFacade;

    @Autowired
    public void setAppFacade(AppFacade appFacade) {
        this.appFacade = appFacade;
    }

    @RequestMapping("/App")
    public ResponseEntity getLatestCommittedRepoName(){

        String latestCommittedRepoName = appFacade.App();

        return new ResponseEntity(latestCommittedRepoName, HttpStatus.OK);
    }
}
