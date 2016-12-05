package fr.quintipio.fr.quintipio.modelArchiAngularJs.service;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.dao.UserDao;
import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findAll() {
        List<User> retour = new ArrayList<>();
        userDao.findAll().forEach(x->retour.add(x));
        return retour;
    }

    @Override
    public User findByMail(String mail) {
        return userDao.findByEmail(mail);
    }

    @Override
    public User findBySsoIdAndPassword(String ssoId, String password) {
        return userDao.findBySsoIdAndPassword(ssoId,genererPassword(password));
    }

    @Override
    public User findById(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public boolean isUserSsoIdUnique(String ssoId) {
        return userDao.findBySsoId(ssoId) != null;
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {

        user.setPassword(genererPassword(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public void create(User user) {

        user.setPassword(genererPassword(user.getPassword()));
        userDao.save(user);
    }

    private String genererPassword(String password)
    {
        return password;
        /*BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        return bCryptPasswordEncoder.encode(password);*/
    }
}
