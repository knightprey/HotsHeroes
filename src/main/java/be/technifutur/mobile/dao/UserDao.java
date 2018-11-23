package be.technifutur.mobile.dao;

import be.technifutur.mobile.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao {

    public User insert(User user) {

        String baseQuery = "INSERT INTO public.user (username, password) VALUES ('%s', '%s')";
        String query = String.format(baseQuery, user.getUsername(), user.getPassword());
        int id = executeInsert(query);

        if (id > 0) {
            return new User(id, user.getUsername(), user.getPassword());
        } else {
            return null;
        }
    }

    public User findByUsername(String username) {

        String baseQuery = "SELECT id, username, password FROM public.user WHERE username = '%s'";
        String query = String.format(baseQuery, username);
        return executeQuery(query, new ResultSetConverter<User>() {
            @Override
            public User convert(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }
                return null;
            }
        });
    }

    public List<User> findAll() {
        String baseQuery = "SELECT id, username, password FROM public.user";
        return executeQuery(baseQuery, new ResultSetConverter<List<User>>() {
            @Override
            public List<User> convert(ResultSet rs) throws SQLException {

                List<User> users = new ArrayList<>();

                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                   users.add(user);
                }

                return users;
            }
        });
    }
}
