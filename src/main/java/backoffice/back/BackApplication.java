package backoffice.back;

import backoffice.back.handleimages.FileStorageProperties;
import backoffice.back.securitymodels.Rolerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})

public class BackApplication  implements CommandLineRunner {
  @Autowired
  private Rolerepo repo;


    public static void main(String[] args) {
        SpringApplication.run(BackApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }




    @Override
    public void run(String... arg) throws Exception {
       // storageService.deleteAll();
       // storageService.init();
    }


}
