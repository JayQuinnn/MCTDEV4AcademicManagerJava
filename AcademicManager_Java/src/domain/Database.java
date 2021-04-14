package domain;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {



    public static Connection connect() {

        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("Mitch");
            dataSource.setPassword("mitch123456789");
            dataSource.setServerName("94.224.211.168");
            dataSource.setPort(25568);
            dataSource.setDatabaseName("academic04");

            return dataSource.getConnection();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
