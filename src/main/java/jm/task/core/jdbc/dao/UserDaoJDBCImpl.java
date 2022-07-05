package jm.task.core.jdbc.dao;

import com.mysql.cj.util.DnsSrv;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.archive.scan.spi.ScanOptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {


    }

    public void createUsersTable() throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXIST users (id BIGINT AUTO_INCREMENT, name VARCHAR(50)," + "last_name VARCHAR(50), age TINYINT, PRIMARY KEY (id));";
        Connection connection = null;
        try {
            connection = getConnection();
            connection.createStatement().execute(createTable);
            connection.commit();
            System.out.println("таблица создана");

        } catch (Exception ex) {
            if (connection != null) {
                connection.rollback();
            }
            System.out.println("табица не создана");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {
            }

        }
    }

    public void dropUsersTable() throws SQLException {
        String dropTable = "DELETE FROM users";
        Connection connection = null;
        try {
            connection = getConnection();
            connection.createStatement().execute(dropTable);
            connection.commit();
            System.out.println("таблица удалена");

        } catch (Exception ex) {
            if (connection != null) {
                connection.rollback();
            }
            System.out.println("таблица не удалена");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {

            }


        }
    }



    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String saveUser = "INSERT INFO users (name, lastName, age) VALUE (?, ?, ?);";
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(saveUser);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("клиент записан");
        } catch (Exception ex) {
            if (connection != null) {
                connection.rollback();
            }
            System.out.println("клиент не записан");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {

            }
        }


    }

    public void removeUserById(long id) throws SQLException {
        String removeUserById = "DELETE FROM users where id = ?";
        Connection connection = null;
        try {
            connection = getConnection();
            connection.createStatement().execute(removeUserById);
            connection.commit();
            System.out.println("клиент удален");
        } catch (Exception ex) {
            if (connection != null) {
                connection.rollback();
            }
            System.out.println("клиент не удален");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {

            }
        }

    }

    public List<User> getAllUsers() throws SQLException {
        String getAllUsers = "SELECT * FROM users";
        Connection connection = null;

        List<User> userList = new ArrayList<>();
        try {
            connection = Util.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getAllUsers);
                ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM users");
                while (resultSet.next()) ;
                User user = new User();
                resultSet.getInt("id");
                resultSet.getString("name");
                resultSet.getString("lastName");
                resultSet.getInt("age");
                userList.add(user);

            connection.commit();
        } catch (Exception ex) {
            if (connection != null) {
                connection.rollback();
            }
            System.out.println("пользователь не записан");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {

            }
        } return userList;
    }

    public void cleanUsersTable() throws SQLException {
        String cleanUsersTable = "DELETE FROM users";
        Connection connection = null;
        try {
            connection = Util.getConnection();
            connection.createStatement().execute(cleanUsersTable);
            connection.commit();
            System.out.println("таблица очищена");
        } catch (Exception ex) {
            if (connection != null) {
                connection.rollback();
            }

                System.out.println("таблица не очищена");
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception ignored) {

                }
            }

        }
    }
