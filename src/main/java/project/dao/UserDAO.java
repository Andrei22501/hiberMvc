package project.dao;

import project.models.User;
import java.util.List;
public interface UserDAO {

    @SuppressWarnings("unchecked")
    List<User> listUsers();

    User show(int id);
    void delete(int id);
    void save(User user);
}
