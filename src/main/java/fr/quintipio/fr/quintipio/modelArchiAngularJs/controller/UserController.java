package fr.quintipio.fr.quintipio.modelArchiAngularJs.controller;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.User;
import fr.quintipio.fr.quintipio.modelArchiAngularJs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
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

}
