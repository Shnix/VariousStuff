import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ScrollableMain {

    @SneakyThrows
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:8030/postgres","postgres","admin")) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select * from musicband");

            if(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
            if(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
            if(resultSet.previous()){
                System.out.println(resultSet.getString("name"));
            }
            if(resultSet.relative(1)){
                System.out.println(resultSet.getString("name"));
            }
            if(resultSet.absolute(1)){
                System.out.println(resultSet.getString("name"));
            }
            if(resultSet.first()){
                System.out.println(resultSet.getString("name"));
            }
            if(resultSet.last()){
                System.out.println(resultSet.getString("name"));
            }
//            resultSet.beforeFirst(); resultSet.afterLast();
            int[] array = {1,2};
            "kek".substring(3,1);
        }
    }
}
