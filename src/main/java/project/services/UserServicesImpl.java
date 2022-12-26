package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDAO;
import project.models.User;

import java.util.List;

@Component
public class UserServicesImpl implements UserServices {
    private final UserDAO userDAO;

    @Autowired
    public UserServicesImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    public User show(int id) {
        return userDAO.show(id);
    }
    @Transactional
    public void update(int id, User user) {
        userDAO.update(id, user);
    }
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }
}