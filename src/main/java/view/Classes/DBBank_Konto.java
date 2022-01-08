package view.Classes;

import view.Interface.IBank_Konto;

import java.sql.*;

public class DBBank_Konto extends DB implements IBank_Konto {

    @Override
    public void insert(int id, String kontonavn, String kontonummer, long balansen, int brukerID) throws SQLException {
        String insert = "insert into bank_konto values(?, ?, ?,?,?);";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(insert)) {
            pre.setInt(1, id);
            pre.setString(2, kontonavn);
            pre.setString(3, kontonummer);
            pre.setLong(4, balansen);
            pre.setInt(5, brukerID);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(int id, String kontonavn, String kontonummer, long balansen, int brukerID) throws SQLException {
        String update = "update bank_konto set Kontonavn = ?, Kontonummer = ?, Balansen = ?, BrukerID = ? where KontoID = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(update)) {
            pre.setInt(5, id);
            pre.setString(1, kontonavn);
            pre.setString(2, kontonummer);
            pre.setLong(3, balansen);
            pre.setInt(4, brukerID);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        String delete = "delete from bank_konto where KontoID = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(delete)) {
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void read(int id) throws SQLException {
        String read = "select * from bank_konto where KontoID = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(read)) {
            pre.setInt(1, id);

            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                System.out.println("Reading from table bank konto index: "+  rs.getInt( 1) + " ");
                System.out.println("kontonavn " + rs.getString(2) + " ");
                System.out.println("kontonummer " + rs.getString(3) + " ");
                System.out.println("balansen " + rs.getLong(4) + " ");
                System.out.println("brukerID " + rs.getInt(5) + " ");
                System.out.println("database reading ended");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
