package backoffice.back.jpa_auditing;

import backoffice.back.Repositories.Repoadmin;
import backoffice.back.securitycontroller.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class Auditor implements AuditorAware<String> {
  @Autowired
  public AuthController u;
 private String name;
 public String username(){

   if(u.getUsername()==null){return "tarik";}else{return u.getUsername();}
 }
    @Override
    public Optional<String> getCurrentAuditor(){
       // return Optional.of(u.getUsername());
      return Optional.of(this.username());
    }
}