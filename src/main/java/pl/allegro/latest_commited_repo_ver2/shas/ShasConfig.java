package pl.allegro.latest_commited_repo_ver2.shas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.allegro.latest_commited_repo_ver2.branches.BranchesFacade;

@Configuration
public class ShasConfig {

    @Bean
    public ShasFacade shasFacade(BranchesFacade branchesFacade){
        return new ShasFacade(branchesFacade);
    }
}
