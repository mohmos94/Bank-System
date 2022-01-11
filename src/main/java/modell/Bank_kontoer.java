package modell;

import modell.Interface.IBank_Konto;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Bank_kontoer extends DBOppsett implements IBank_Konto {
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

    @Override
    public int Konto() throws SQLException {
        String insert = "insert into bankkonto(Kontonummer, Kontonavn, Balansen, SystemID) values(?,?,?,?)";
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

    public void Søke_Konto() throws SQLException{
        String select = "select * from  bankkonto where SystemID = ?";
        con =DriverManager.getConnection(Connection_String, user, password);
        ps = con.prepareStatement(select);
        ps.setInt(1, getSystemID());



    }

    @Override
    public int oppdatere() throws SQLException {

        String oppdate = "Update bankkonto set Kontonummer = ?, Kontonavn = ?, Balansen = ? where SystemID = ?";
        String select = "select * from  bankkonto where SystemID = ?";

        con = DriverManager.getConnection(Connection_String, user, password);
        ps = con.prepareStatement(select);
        ps.setInt(1, getSystemID());
        rs = ps.executeQuery();

        while (rs.next()) {
            int check  = rs.getInt(getSystemID());

            if (getSystemID() == check)
                ps = con.prepareStatement(oppdate);
                ps.setString(1, getKontonummer());
                ps.setString(2, getKontonavn());
                ps.setLong(3, getBalansen());
                ps.setInt(4, getSystemID());
                return ps.executeUpdate();

        }
        return -1;
    }



    @Override
    public int slett_Konto() throws SQLException {
        String søke_Konto = "select * from banksystem where kontonummer = ?";
        String delete = "delete from banksystem where kontonummer = ?";
        con = DriverManager.getConnection(Connection_String, user, password);

        ps = con.prepareStatement(søke_Konto);
        ps.setString(1, getKontonummer());
        rs = ps.executeQuery();

        while(rs.next()){

            if (rs.getString(1).compareToIgnoreCase(getKontonummer()) == 0){
                ps = con.prepareStatement(delete);
                ps.setString(1,getKontonummer());
            }
        }


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
