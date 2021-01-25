package backoffice.back.Entities;


import backoffice.back.jpa_auditing.auditingclasse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Admin extends auditingclasse<String> implements Serializable  {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private  String tel;
    @Column
    private  String email;
    @OneToMany(mappedBy = "admin")
    private Set<Agent> agents=new HashSet<Agent>(0);



}
