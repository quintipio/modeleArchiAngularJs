package fr.quintipio.fr.quintipio.modelArchiAngularJs.service;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findByMail(String mail);

    public User findBySsoIdAndPassword(String ssoId, String password);

    public User findById(Integer id);

    public User findBySSO(String ssoId);

    public boolean isUserSsoIdUnique(String ssoId);

    public void delete(Integer id);

    public void update(User user);

    public void create(User user);
}
