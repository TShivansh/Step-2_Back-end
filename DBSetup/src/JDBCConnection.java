import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver loaded");
        DriverManager.getConnection("jdbc:mysql://localhost:3306/Simpli", "root", "#Mechanical@100");
        System.out.println("Connection established");
    }
}

