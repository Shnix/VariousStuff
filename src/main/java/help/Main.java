package help;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    static Connection connection;
    static Statement statement;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "postgres";
        String password1 = "admin";
        String connectionUrl = "jdbc:postgresql://localhost:8030/postgres";
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(connectionUrl, userName, password1);
        statement = connection.createStatement();
        connection.setAutoCommit(false);
        System.out.println("Всё робит");
    }
}

