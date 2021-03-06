package pl.allegro.latest_commited_repo_ver2.repos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

@Configuration
public class RepoConfig {

//    @Value("https://api.github.com/orgs/allegro/repos?per_page=100;sort=full_name")
    @Value("https://api.github.com/users/Lazar18/repos?per_page=100;sort=full_name")
    private URL urlRepos;

    @Bean
    public ReposNames reposNames(){
        return new ReposNames();
    }

    @Bean
    public RepoFacade repoFacade(ReposNames reposNames){
        return new RepoFacade(urlRepos, reposNames);
    }
}
