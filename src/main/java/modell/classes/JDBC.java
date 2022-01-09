package modell.classes;

import java.sql.*;

public class JDBC extends DB {

    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection(Connection_String, user, password);
            stat = con.createStatement();
            stat.addBatch(SQL_CREATE_Kunde);
            stat.addBatch(SQL_CREATE_BankSystem);
            stat.addBatch(SQL_CREATE_BankKonto);
            stat.addBatch(SQL_CREATE_Transaksjoner);
            stat.executeBatch();

        }
        catch (SQLException e){
            e.printStackTrace();

        }

    }
}
