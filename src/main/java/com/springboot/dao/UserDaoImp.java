package dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImp() {
    }


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        logger.info("User successfully saved, user details: " + user);
    }

    @Override
    public void removeUser(Long id) {
        User user = (User) entityManager.find(User.class, new Long(id));
        if (user != null) {
            entityManager.remove(user);
        }
        logger.info("User successfully removed, user details: " + user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        logger.info("User successfully update, user details: " + user);
    }

    @Override
    public User getUser(Long id) {
        User user = (User) entityManager.find(User.class, new Long(id));
        logger.info("User successfully loaded, user details: " + user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = entityManager.createQuery("from User",User.class).getResultList();
        for(User user: users){
            logger.info("User list: " + user);
        }
        return users;
    }
}
