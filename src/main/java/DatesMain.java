import lombok.SneakyThrows;

import java.sql.*;


public class DatesMain {
    @SneakyThrows
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:8030/postgres","postgres","admin")) {
            Statement statement = connection.createStatement();
            statement.execute("ALTER TABLE musicband ADD dt date ");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE musicband SET dt = ? WHERE id=0");
            preparedStatement.setDate(1,new Date(System.currentTimeMillis()));
            preparedStatement.executeUpdate();
        }
        }
    }
