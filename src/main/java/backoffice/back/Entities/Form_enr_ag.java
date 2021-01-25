package backoffice.back.Entities;


import backoffice.back.jpa_auditing.auditingclasse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Form_enr_ag extends auditingclasse<String> implements Serializable {
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
    @Column
    private int processed;

}
