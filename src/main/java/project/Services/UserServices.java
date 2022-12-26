package project.Services;

import project.models.User;

import java.util.List;

public interface UserServices {
    List<User> listUsers();
    User show(int id);
    void delete(int id);
    void save(User user);
}
