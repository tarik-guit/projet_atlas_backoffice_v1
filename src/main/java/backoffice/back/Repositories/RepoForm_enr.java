package backoffice.back.Repositories;

import backoffice.back.Entities.Admin;
import backoffice.back.Entities.Form_enr_ag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoForm_enr extends JpaRepository<Form_enr_ag,Long> {

    @Query("SELECT n FROM Form_enr_ag  n WHERE n.processed=:tr")
    List<Form_enr_ag> getallnontraite(@Param("tr") int tr );
}
