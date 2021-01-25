package backoffice.back.Repositories;

import backoffice.back.Entities.Admin;
import backoffice.back.Entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repoagent extends JpaRepository<Agent,Long> {
    @Query("SELECT n FROM Agent  n WHERE n.createdby=:username")
    List<Agent> getallforcurrentuser(@Param("username") String username );
}
