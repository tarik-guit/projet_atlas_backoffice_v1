package backoffice.back.Controllers;

import backoffice.back.Entities.Admin;
import backoffice.back.Entities.Agent;
import backoffice.back.Repositories.Repoadmin;
import backoffice.back.Repositories.Repoagent;
import backoffice.back.requestetresponse.MessageResponse;
import backoffice.back.requestetresponse.SignupRequest;
import backoffice.back.securitycontroller.AuthController;
import backoffice.back.services.Createagent;
import backoffice.back.services.genererpassword;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin()
public class Controagent {

    @Autowired
    private Repoagent repagent;
    @Autowired
    private Createagent create;
    @Autowired
    private genererpassword gen;
    @Autowired
    public AuthController u;

    @GetMapping("/agents")
    public List<Agent> getallagents() {
        return repagent.findAll();
    }

    @GetMapping("/agents_currentadmin")
    public List<Agent> getallagentsforcurrentuser() {
        return repagent.getallforcurrentuser(u.getUsername());
    }

    @DeleteMapping("/agents")
    public String deleteall() {
        repagent.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/agent/{id}")
    public String deletbyid(@PathVariable Long id) {
        repagent.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/agent")
    public MessageResponse creereagent(@RequestBody Agent agent) {
        Set<String> role= new HashSet<String>();
        role.add("user");
        String password=gen.generateCommonLangPassword();
        JSONObject json = create.createagentcompte(new SignupRequest(agent.getTel(),agent.getEmail(),role,password));
        if(json.get("message").toString().equals("User registered successfully!")){repagent.save(agent);
        return new MessageResponse("Agent registered successfully!"); }
        return new MessageResponse("Agent not registred");
    }

    @PutMapping("/Agent/{id}")
    public Agent updateecole(@PathVariable Long id, @RequestBody Agent cla) {
        Agent agent= repagent.findById(id).get();
        if (cla.getNom() != null) {
            agent.setNom(cla.getNom());
        }
        if (cla.getPrenom() != null) {
            agent.setPrenom(cla.getPrenom());
        }

        if (cla.getTel() != null) {
            agent.setTel(cla.getTel());
        }
        if (cla.getEmail()!= null) {
            agent.setEmail(cla.getEmail());
        }
        if (cla.getNumcin() != null) {
            agent.setNumcin(cla.getNumcin());
        }

        return repagent.save(agent);
    }

}
