package modell.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank_kontoer extends DBOppsett {
    private String kontonummer;
    private String kontonavn;
    private long Balansen;
    private int SystemID;

    public Bank_kontoer(String kontonummer, String kontonavn, long balansen, int systemID) {
        this.kontonummer = kontonummer;
        this.kontonavn = kontonavn;
        Balansen = balansen;
        SystemID = systemID;
    }

    public int Konto() throws SQLException {
        String insert = "insert into bankkonto(Kontonummer, Kontonavn, Balansen, SystemID) values(?,?,?,?)";
        String enkel_Søk = "select * from kunde where Fødselsnummer = ? ";
        con = DriverManager.getConnection(Connection_String, user, password);
        ps = con.prepareStatement(insert);
        System.out.println("running SQL code...");
        ps.setString(1, getKontonummer());
        ps.setString(2, getKontonavn());
        ps.setLong(3, getBalansen());
        ps.setLong(4, getSystemID());
        System.out.println("SQL code is finished successfully");
        return ps.executeUpdate();
    }

    public int slett_Konto() throws SQLException {
        String delete = "delete from banksystem where kontonummer = ?";

        con = DriverManager.getConnection(Connection_String, user, password);
        ps = con.prepareStatement(delete);
        ps.setString(1, getKontonummer());
        return ps.executeUpdate();

    }








    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public String getKontonavn() {
        return kontonavn;
    }

    public void setKontonavn(String kontonavn) {
        this.kontonavn = kontonavn;
    }

    public long getBalansen() {
        return Balansen;
    }

    public void setBalansen(long balansen) {
        Balansen = balansen;
    }

    public int getSystemID() {
        return SystemID;
    }

    public void setSystemID(int systemID) {
        SystemID = systemID;
    }
}
