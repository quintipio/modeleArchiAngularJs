package fr.quintipio.fr.quintipio.modelArchiAngularJs.controller;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.User;
import fr.quintipio.fr.quintipio.modelArchiAngularJs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Scope("request")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser() {
        return userService.findAll();
    }


    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        System.out.println("Suppression de l'utilisateur d'id : "+id);
        userService.delete(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
