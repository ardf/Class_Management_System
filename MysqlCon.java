package StudentsDB;

import java.sql.*;

public class MysqlCon {
    public Connection con;

    public Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/students", "root", "");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
