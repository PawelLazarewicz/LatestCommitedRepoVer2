package pl.allegro.latest_commited_repo_ver2.shas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class ShasController {

    private ShasFacade shasFacade;

    @Autowired
    public void setShasFacade(ShasFacade shasFacade) {
        this.shasFacade = shasFacade;
    }

    @RequestMapping("/shas")
    public ResponseEntity getShasDate(){
        Map<String, ZonedDateTime> stringListMap = shasFacade.readLatestShaDateForRepoFromJsonToMap();

        return new ResponseEntity(stringListMap, HttpStatus.OK);
    }
}
