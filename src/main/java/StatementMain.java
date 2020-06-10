import lombok.SneakyThrows;

import java.sql.*;

public class StatementMain {
    @SneakyThrows
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:8030/postgres","postgres","admin")) {
            System.out.println("Connected");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM musicband WHERE id=?");
            preparedStatement.setInt(1,0);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("numberofparticipants"));
                System.out.println(resultSet.getInt("singlescount"));
                System.out.println(resultSet.getString("musicgenre"));
                System.out.println(resultSet.getString("bestalbum_name"));
            }
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
