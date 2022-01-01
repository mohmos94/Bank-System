import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {
        try{
            System.out.println("Database connection established");
            final String DB_URL = "jdbc:mysql://localhost:3306/bank_system";
            final String USER = "root";
            final String PASS = "Nettavisen123+";
            Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_system","root", "Nettavisen123+");
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE if not exists PDF(FAKTURANUMMER int ,KJØPER varchar(150), KIDDNUMMER varchar(20), KONTONUMMER varchar(11) )");
            statement.execute(" insert into PDF values (1 ,'oslo garasje as', '1256445221', '1234687912' ) ");
            statement.close();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();

        }

    }
}
