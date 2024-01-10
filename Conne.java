import java.sql.Connection;
import java.sql.DriverManager;

public class Conne {
    Connection c;
    java.sql.Statement s;

    public Conne() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/BANKMANAGEMENTSYSTEM", "root", "MayaDev@12345");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
