package backoffice.back.Entities;


import backoffice.back.jpa_auditing.auditingclasse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Agent extends auditingclasse<String> implements Serializable {


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
    @Column
    private String numcin;
    @Column
    private String urlcin;

    @ManyToOne(optional = true)
    private Admin admin;

}
