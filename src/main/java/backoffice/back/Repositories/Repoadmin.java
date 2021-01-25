package backoffice.back.Repositories;

import backoffice.back.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repoadmin extends JpaRepository<Admin,Long> {

    @Query("SELECT n FROM Admin  n WHERE n.createdby=:username")
    List<Admin> getall(@Param("username") String username );


}
