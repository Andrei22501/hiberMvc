package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        String e = "from User";
        TypedQuery<User> query = entityManager.createQuery(e, User.class);
        return query.getResultList();
    }

    public User show(int id) {
        String e = "from User where id =" + id;
        TypedQuery<User> query = entityManager.createQuery(e, User.class);
        return query.getSingleResult();
    }

    public void update(int id, User user) {
        User userUpdate = show(id);
        userUpdate.setName(user.getName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setMail(user.getMail());
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}

