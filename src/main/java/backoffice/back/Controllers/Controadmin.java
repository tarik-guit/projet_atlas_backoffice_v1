package backoffice.back.Controllers;


import backoffice.back.Entities.Admin;
import backoffice.back.Repositories.Repoadmin;
import backoffice.back.requestetresponse.MessageResponse;
import backoffice.back.requestetresponse.SignupRequest;
import backoffice.back.securitycontroller.AuthController;
import backoffice.back.services.genererpassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin()
public class Controadmin {
    @Autowired
    private Repoadmin repadmin;
    @Autowired
    public AuthController u;

    @GetMapping("/myagents")
    public List<Admin> getallagentsforcurrentadmin() {
        return repadmin.getall(u.getUsername());
    }

    @DeleteMapping("/admins")
    public String deleteall() {
        repadmin.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/admin/{id}")
    public String deletbyid(@PathVariable Long id) {
        repadmin.deleteById(id);
        return "supprimé";
    }
    @Autowired
    private AuthController auth;
    private genererpassword  gen;
    @PostMapping("/admin")
    public MessageResponse creeradmin(@RequestBody Admin admin) {
        Set<String> role= new HashSet<String>();
        role.add("user");
       SignupRequest req=new SignupRequest(admin.getTel(),admin.getEmail(),role,gen.generateCommonLangPassword());
      if( auth.registerUser(req).equals(ResponseEntity.ok(new MessageResponse("User registered successfully!")))){
          repadmin.save(admin);
          return new MessageResponse("Admin registered successfully!");
      }
        return   new MessageResponse("Admin not registred");
    }





}
