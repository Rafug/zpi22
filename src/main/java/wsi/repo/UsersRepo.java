package wsi.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wsi.model.Login;
import wsi.model.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface UsersRepo extends CrudRepository<Users,Integer> {


    List<Users> findByLogin(String login);

    ;

   @Query(nativeQuery = true, value = "select login from users " )
    List<Login> findByLog();
}
