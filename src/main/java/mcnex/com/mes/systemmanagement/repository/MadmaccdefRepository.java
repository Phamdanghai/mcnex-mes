package mcnex.com.mes.systemmanagement.repository;

import mcnex.com.mes.systemmanagement.doman.Madmaccdef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MadmaccdefRepository extends JpaRepository<Madmaccdef,String> {
    @Query(value = "Select * from madmusrdef adm WHERE adm.user_id = :user_id",nativeQuery = true)
    Madmaccdef findByUserId(@Param("user_id") String user_id);
}
