package modell.Database.Classes;

import modell.Database.Interface.IBruker;
import modell.classes.DB;

import java.sql.*;


public class DbBruker extends DB implements IBruker {


    @Override
    public void insert(String brukernavn, String passord, int personligID) throws SQLException {
        System.out.println("running SQL code...");
        String insert = "insert into bruker (Brukernavn, Passord, PersonID) values(?, ?,?);";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(insert)) {
            pre.setString(1, brukernavn);
            pre.setString(2, passord);
            pre.setLong(3, personligID);
            pre.executeUpdate();
            System.out.println("SQL code is finished successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(int id, String brukernavn, String passord, int personId) throws SQLException {
        System.out.println("running SQL code...");
        String update = "update bruker set Brukernavn = ?, Passord = ? where BrukerID = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(update)) {
            pre.setInt(3, id);
            pre.setString(1, brukernavn);
            pre.setString(2, passord);
            pre.executeUpdate();
            System.out.println("SQL code is finished successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        System.out.println("running SQL code...");
        String delete = "delete from bruker where BrukerID = ?";
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
        System.out.println("running SQL code...");

        String read = "select * from bruker where BrukerID = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(read)) {
            pre.setInt(1, id);

            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                System.out.println("Reading from table bruker index: "+  rs.getInt( 1) + " ");
                System.out.println("Brukernavnet: " + rs.getString( 2) + " ");
                System.out.println("passord: " + rs.getString(3) + " ");
                System.out.println();
                System.out.println("SQL code is finished successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
