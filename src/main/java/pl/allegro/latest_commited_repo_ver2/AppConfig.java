package pl.allegro.latest_commited_repo_ver2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.allegro.latest_commited_repo_ver2.branches.BranchesFacade;
import pl.allegro.latest_commited_repo_ver2.repos.RepoFacade;
import pl.allegro.latest_commited_repo_ver2.shas.ShasFacade;

@Configuration
public class AppConfig {

    @Bean
    public AppFacade appFacade(RepoFacade repoFacade, BranchesFacade branchesFacade, ShasFacade shasFacade){
        return new AppFacade(repoFacade, branchesFacade, shasFacade);
    }
}
