package pl.allegro.latest_commited_repo_ver2.shas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.allegro.latest_commited_repo_ver2.branches.BranchesFacade;

@Configuration
public class ShasConfig {

    @Bean
    public ShasDate shasDate(){
        return new ShasDate();
    }

    @Bean
    public ShasFacade shasFacade(BranchesFacade branchesFacade, ShasDate shasDate){
        return new ShasFacade(branchesFacade, shasDate);
    }
}
