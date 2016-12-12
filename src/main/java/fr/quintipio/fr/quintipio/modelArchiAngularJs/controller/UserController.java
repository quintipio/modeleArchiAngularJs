package fr.quintipio.fr.quintipio.modelArchiAngularJs.controller;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.User;
import fr.quintipio.fr.quintipio.modelArchiAngularJs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("request")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> getAllUser() {
        List<User> liste = userService.findAll();
        return new ResponseEntity<>(liste,(liste.isEmpty())?HttpStatus.NO_CONTENT:HttpStatus.OK);
    }


    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        System.out.println("Suppression de l'utilisateur d'id : "+id);
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        if(userService.isUserSsoIdUnique(user.getSsoId())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        userService.create(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("user/create/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> updateUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {

        User userModif = userService.findById(user.getId());

        userModif.setVille(user.getVille());
        userModif.setUserProfiles(user.getUserProfiles());
        userModif.setBirthDate(user.getBirthDate());
        userModif.setEmail(user.getEmail());
        userModif.setFirstName(user.getFirstName());
        userModif.setLastName(user.getLastName());

        userService.update(userModif);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("user/update/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.ACCEPTED);
    }


}
