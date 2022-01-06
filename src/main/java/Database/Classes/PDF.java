package Database.Classes;

import java.sql.*;

public class PDF extends DB {


    public void insert(int fakt, String kjoper, String kidd, String konto) throws SQLException{
        Connection connection  = DriverManager.getConnection(Connection_String,user, password);

        String query = "insert into pdf values(?,?,?,?)";

        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1,fakt);
        pstmt.setString(2, kjoper);
        pstmt.setString(3, kidd);
        pstmt.setString(4, konto);
    }

    public static void main(String[] args) throws SQLException {
        PDF pdf = new PDF();

        pdf.insert(5, "cutie as", "123456789", "12334567890");
    }

}
