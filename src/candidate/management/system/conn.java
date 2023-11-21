package candidate .management.system;


import java.sql.*;

public class conn {
    
    Connection c;
    Statement s;

    public conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///candidatemanagemnetsystem", "root", "@chandini06");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}