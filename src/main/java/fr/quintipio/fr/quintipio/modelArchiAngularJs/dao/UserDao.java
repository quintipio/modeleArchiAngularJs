package fr.quintipio.fr.quintipio.modelArchiAngularJs.dao;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {

    public User findByEmail(String email);

    public User findBySsoIdAndPassword(String ssoId, String password);

    public User findBySsoId(String ssoId);
}
