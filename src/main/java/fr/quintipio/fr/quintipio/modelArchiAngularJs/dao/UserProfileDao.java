package fr.quintipio.fr.quintipio.modelArchiAngularJs.dao;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.UserProfile;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Quentin on 05/12/2016.
 */
public interface UserProfileDao extends CrudRepository<UserProfile,Integer> {

    UserProfile findByType(String type);
}
