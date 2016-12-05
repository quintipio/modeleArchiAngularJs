package fr.quintipio.fr.quintipio.modelArchiAngularJs.service;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.dao.UserProfileDao;
import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    @Override
    public UserProfile findById(int id) {
        return userProfileDao.findOne(id);
    }

    @Override
    public UserProfile findByType(String type) {
        return userProfileDao.findByType(type);
    }

    @Override
    public List<UserProfile> findAll() {
        List<UserProfile> retour = new ArrayList<>();
        userProfileDao.findAll().forEach(x->retour.add(x));
        return retour;
    }
}
