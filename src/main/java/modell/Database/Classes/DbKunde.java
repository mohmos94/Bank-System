package modell.Database.Classes;

import modell.Database.Interface.Ikunde;
import modell.classes.DB;

import java.sql.*;

public class DbKunde extends DB implements Ikunde{

    @Override
    public void insert(String etternavnet, String fornavn, String telefon, String mail) throws SQLException {
        System.out.println("running SQL code...");
        String insert = "insert into kunde(LastName, FirstName, Telefon, Email) values(?,?,?,?);";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(insert,PreparedStatement.RETURN_GENERATED_KEYS)) {
            pre.setString(1, etternavnet);
            pre.setString(2, fornavn);
            pre.setString(3, telefon);
            pre.setString(4, mail);
            pre.executeUpdate();



            System.out.println("SQL code is finished successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String etternavnet, String fornavn, String telefon, String mail) throws SQLException {
        System.out.println("running SQL code...");
        String update = "update kunde set lastName = ?, FirstName = ?, Telefon = ?, Email = ? where PersonID = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(update)) {
            pre.setInt(5, id);
            pre.setString(1, etternavnet);
            pre.setString(2, fornavn);
            pre.setString(3, telefon);
            pre.setString(4, mail);
            pre.executeUpdate();
            System.out.println("SQL code is finished successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        System.out.println("running SQL code...");

        String delete = "delete from kunde where PersonID = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(delete)) {
            pre.setInt(1, id);
            pre.executeUpdate();
            System.out.println("SQL code is finished successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read(int id) throws SQLException {
        String read = "select * from kunde where PersonID = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(read)) {
            pre.setInt(1, id);

            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                System.out.println("Reading from table kunde index: "+  rs.getInt( 1) + " ");
                System.out.print(rs.getString(2) + " ");
                System.out.print(rs.getString(3) + " ");
                System.out.print(rs.getString(4) + " ");
                System.out.println(rs.getString(5) + " ");
                System.out.println("database reading ended");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
