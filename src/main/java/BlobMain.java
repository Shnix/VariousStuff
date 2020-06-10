import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class BlobMain {
    @SneakyThrows
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:8030/postgres","postgres","admin")) {
            FileInputStream image = new FileInputStream(new File("D:/flowers.jpg"));
            PreparedStatement statement = connection.prepareStatement("UPDATE musicband SET image = ? WHERE id=0");
            statement.setBinaryStream(1,image);
            statement.executeUpdate();
        }
        }
    }

