package domain;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // SINGLETON
    private static Connection instantie = null;

    public static Connection connect() {

        if (instantie != null){
            try{
                return instantie; //https://www.baeldung.com/java-singleton
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }

        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("Mitch");
            dataSource.setPassword("mitch123456789");
            dataSource.setServerName("94.224.211.168");
            dataSource.setPort(25568);
            dataSource.setDatabaseName("academic04");
            Connection connection = dataSource.getConnection();
            instantie = connection;
            return connection;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
