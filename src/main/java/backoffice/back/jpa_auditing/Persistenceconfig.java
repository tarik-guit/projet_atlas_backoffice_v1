package backoffice.back.jpa_auditing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="auditorProvider")
@Configuration
public class Persistenceconfig {

    //...

    @Bean
    AuditorAware<String> auditorProvider() {
        return new Auditor();
    }

    //...
}