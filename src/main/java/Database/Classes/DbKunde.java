package Database.Classes;

import Database.Interface.Ikunde;

import java.sql.*;

public class DbKunde extends DB{

    public void insert(int id, String etternavnet, String fornavn, String telefon, String mail) throws SQLException{
        String insert = "insert into kunde values(?, ?, ?,?,?);";
        Connection connection = DriverManager.getConnection(Connection_String,user, password);
        try (PreparedStatement pre = connection.prepareStatement(insert)) {
            pre.setInt(1, id);
            pre.setString(2, etternavnet);
            pre.setString(3, fornavn);
            pre.setString(4, telefon);
            pre.setString(5, mail);
            pre.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        public void update (int id, String etternavnet, String fornavn, String telefon, String mail) throws SQLException{
            String insert = "insert into kunde values(?, ?, ?,?,?);";
            Connection connection = DriverManager.getConnection(Connection_String,user, password);
            try (PreparedStatement pre = connection.prepareStatement(insert)) {
                pre.setInt(1, id);
                pre.setString(2, etternavnet);
                pre.setString(3, fornavn);
                pre.setString(4, telefon);
                pre.setString(5, mail);
                pre.executeUpdate();
            }
            catch (SQLException e){
                e.printStackTrace();
            }



        }
}
