package backoffice.back.Controllers;

import backoffice.back.Entities.Agent;
import backoffice.back.Entities.FileInformation;
import backoffice.back.Entities.Form_enr_ag;
import backoffice.back.Exceptions.UploadFileException;
import backoffice.back.Repositories.RepoForm_enr;
import backoffice.back.Repositories.Repoagent;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
@CrossOrigin()
@RestController
public class Controform_enr {


    @Autowired
    private RepoForm_enr rep;

    @GetMapping("/form_enrs")
    public List<Form_enr_ag> getallformsnontraite() {
        return rep.getallnontraite(0);
    }

    @DeleteMapping("/form_enrs")
    public String deleteall() {
        rep.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/form_enr/{id}")
    public String deletbyid(@PathVariable Long id) {
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/form_enr")
    public Form_enr_ag creerformenr(@RequestBody Form_enr_ag form) {

        return  rep.save(form);
    }

    @PutMapping("/trait_form_enr/{id}")
    public Form_enr_ag traite(@PathVariable Long id) {
        Form_enr_ag form= rep.findById(id).get();

            form.setProcessed(1);

        return rep.save(form);
    }



}
