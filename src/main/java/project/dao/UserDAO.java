package project.dao;

import project.models.User;

import java.util.List;

public interface UserDAO {

    @SuppressWarnings("unchecked")
    List<User> listUsers();

    void update(int id, User user);

    User show(int id);

    void delete(int id);

    void save(User user);
}
