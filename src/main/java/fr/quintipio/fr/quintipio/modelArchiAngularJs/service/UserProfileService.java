package fr.quintipio.fr.quintipio.modelArchiAngularJs.service;


import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();
}
