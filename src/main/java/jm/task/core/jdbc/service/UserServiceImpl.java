package jm.task.core.jdbc.service;

import java.util.List;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;;
import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class UserServiceImpl implements UserService {
    //private final UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    private final UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    public UserServiceImpl() {
    }

    public void createUsersTable() {
        this.userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        this.userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        this.userDaoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        this.userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return this.userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        this.userDaoHibernate.cleanUsersTable();
    }
}
