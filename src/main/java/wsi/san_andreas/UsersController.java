package wsi.san_andreas;



import com.google.common.collect.Lists;
import javafx.print.Collation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wsi.model.Login;
import wsi.model.Users;
import wsi.repo.UsersRepo;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/biolodzy")
@Slf4j
public class UsersController {

    @Autowired
    UsersRepo usersRepo;

    @RequestMapping(value = "/status")
    public String showStatus() {
        return "App running OK";
    }


    @RequestMapping(value = "", method = GET)
    public Iterable<Users> getAllUsers() {
        return usersRepo.findAll();
    }

   @RequestMapping(value = "/bylogin", method = GET)
   public Iterable<Login> getLoginByText(String login) {
       return usersRepo.findByLog();
   }
}
