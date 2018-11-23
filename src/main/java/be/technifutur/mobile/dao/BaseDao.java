package be.technifutur.mobile.dao;

import java.sql.*;

public abstract class BaseDao {

    protected int executeInsert(String query) {

        try (Connection connection = DriverManager.getConnection(DaoConfig.CONNECTION_STRING, DaoConfig.USER, DaoConfig.PASSWORD);
             Statement statement = connection.createStatement();
        ) {
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return -2;
        }
    }

    protected int executeUpdate(String query) {

        try (Connection connection = DriverManager.getConnection(DaoConfig.CONNECTION_STRING, DaoConfig.USER, DaoConfig.PASSWORD);
             Statement statement = connection.createStatement();
        ) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    protected <T> T executeQuery(String query, ResultSetConverter<T> converter) {

        try (Connection connection = DriverManager.getConnection(DaoConfig.CONNECTION_STRING, DaoConfig.USER, DaoConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return converter.convert(rs);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public interface ResultSetConverter<T> {

        T convert(ResultSet rs) throws SQLException;
    }
}
