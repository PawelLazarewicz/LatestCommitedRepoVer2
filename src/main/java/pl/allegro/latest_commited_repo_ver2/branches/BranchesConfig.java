package pl.allegro.latest_commited_repo_ver2.branches;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.allegro.latest_commited_repo_ver2.repos.RepoFacade;

@Configuration
public class BranchesConfig {

    @Bean
    public BranchesSha branchesSha(){
        return new BranchesSha();
    }

    @Bean
    public BranchesFacade branchesFacade(RepoFacade repoFacade, BranchesSha branchesSha){
        return new BranchesFacade(repoFacade, branchesSha);
    }
}
