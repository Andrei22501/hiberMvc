package project.services;

import project.models.User;

import java.util.List;

public interface UserServices {
    List<User> listUsers();

    User show(int id);

    void update(int id, User user);

    void delete(int id);

    void save(User user);
}
