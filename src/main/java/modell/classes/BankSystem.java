package modell.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BankSystem extends DBOppsett {
    private int SystemID;
    private String Brukernavn;
    private String Passord;
    private String Fødselsnummer;

    public BankSystem(String brukernavn, String passord, String fødselsnummer) {
        Brukernavn = brukernavn;
        Passord = passord;
        Fødselsnummer = fødselsnummer;
    }


    public int banksystem() throws SQLException {
        String insert = "insert into banksystem(brukernavn, Passord, Fødselsnummer) values(?,?,?)";
        String enkel_Søk = "select * from kunde where Fødselsnummer = ? ";
        con = DriverManager.getConnection(Connection_String, user, password);
                ps = con.prepareStatement(insert);
                System.out.println("running SQL code...");
                ps.setString(1, getBrukernavn());
                ps.setString(2, getPassord());
                ps.setString(3, getFødselsnummer());
                System.out.println("SQL code is finished successfully");
                return ps.executeUpdate();
    }

    /**
     * søke opp banksystem
     * @throws SQLException får en sql feilmelding dersom man skriver feil verdi
     */

    public void søke_Brukere() throws SQLException {
        String enkel_Søk = "select * from banksystem where Fødselsnummer = ? ";
        con = DriverManager.getConnection(Connection_String, user, password);
        scanner = new Scanner(System.in);
        if(scanner != null){
                ps = con.prepareStatement(enkel_Søk);
                System.out.println("skriv inn fødelsnummer");
                String søkevalg = scanner.nextLine();
                ps.setString(1, søkevalg);

                rs = ps.executeQuery();

                while(rs.next()){
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                }

            }
            else {
                System.out.println("inkorrekt valg start på nytt");
            }

        }

    public void update() throws SQLException {
        System.out.println("running SQL code...");
        String update = "update bruker set Brukernavn = ?, Passord = ? where Fødselsnummer = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(update)) {
            pre.setString(3, getFødselsnummer());
            pre.setString(1, getBrukernavn());
            pre.setString(2, getPassord());
            pre.executeUpdate();
            System.out.println("SQL code is finished successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * metode for å slette banksystem bilde
     * @param Fødelsnummer tekstlig verdi for å ordet man ønsker å slette
     * @throws SQLException kaster ut en sql feilspørring
     */

    public void slette_Kundebilde(String Fødelsnummer) throws SQLException {
        String enkel_Søk = "select * from banksystem where Fødselsnummer = ? ";

        String delete = "delete from banksystem where Fødselsnummer = ?";
        con = DriverManager.getConnection(Connection_String, user, password);
        ps = con.prepareStatement(enkel_Søk);

        ps.setString(1, Fødelsnummer);
        rs = ps.executeQuery();
        while(rs.next()){
            String sjekk =  rs.getString(4);
            if(sjekk.compareToIgnoreCase(Fødelsnummer) == 0){
                ps = con.prepareStatement(delete);
                ps.setString(1, Fødelsnummer);
                ps.executeUpdate();
            }
        }
    }

    public int getSystemID() {
        return SystemID;
    }

    public void setSystemID(int systemID) {
        SystemID = systemID;
    }

    public String getBrukernavn() {
        return Brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        Brukernavn = brukernavn;
    }

    public String getPassord() {
        return Passord;
    }

    public void setPassord(String passord) {
        Passord = passord;
    }

    public String getFødselsnummer() {
        return Fødselsnummer;
    }

    public void setFødselsnummer(String fødselsnummer) {
        Fødselsnummer = fødselsnummer;
    }
}
