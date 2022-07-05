package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService UserService = new UserServiceImpl();

        UserService.createUsersTable();

        UserService.saveUser("Name1", "LastName1", (byte) 20);
        UserService.saveUser("Name2", "LastName2", (byte) 25);
        UserService.saveUser("Name3", "LastName3", (byte) 31);
        UserService.saveUser("Name4", "LastName4", (byte) 38);

        UserService.removeUserById(1);
        UserService.getAllUsers();
        UserService.cleanUsersTable();
        UserService.dropUsersTable();
    }
}
