package modell.classes;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends DBOppsett {
    public static void main(String[] args) throws SQLException {
        con = DriverManager.getConnection(Connection_String, user, password);
        stat = con.createStatement();
        stat.addBatch(SQL_CREATE_Kunde);
        stat.addBatch(SQL_CREATE_BankSystem);
        stat.addBatch(SQL_CREATE_BankKonto);
        stat.addBatch(SQL_CREATE_Transaksjoner);
        stat.executeBatch();
    }
}
