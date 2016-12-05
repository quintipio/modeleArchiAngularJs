package fr.quintipio.fr.quintipio.modelArchiAngularJs.controller;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.Commune;
import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.UserProfile;
import fr.quintipio.fr.quintipio.modelArchiAngularJs.service.CommuneService;
import fr.quintipio.fr.quintipio.modelArchiAngularJs.service.UserProfileService;
import fr.quintipio.fr.quintipio.modelArchiAngularJs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("request")
@RequestMapping("/ref")
public class ReferentielController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private CommuneService communeService;

    @RequestMapping(value = "/commune/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Commune> getAllCommune() {
        return communeService.findAllCommune();
    }

    @RequestMapping(value = "/userProfile/list",method = RequestMethod.GET)
    @ResponseBody
    public List<UserProfile> getAllUserProfile() {
        return userProfileService.findAll();
    }
}
