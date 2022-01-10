package modell.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Transaksjoner extends DBOppsett {

    private int referansenummer;
    private String kontonummer;
    private int Sum;


    public Transaksjoner(int referansenummer, String kontonummer, int sum) {
        this.referansenummer = referansenummer;
        this.kontonummer = kontonummer;
        Sum = sum;
    }


    public int banksystem() throws SQLException {
        String insert = "insert into transaksjoner(Referansenummer, Kontonummer, Sum) values(?,?,?)";
        con = DriverManager.getConnection(Connection_String, user, password);
        ps = con.prepareStatement(insert);
        System.out.println("running SQL code...");
        ps.setInt(1, getReferansenummer());
        ps.setInt(2, getReferansenummer());
        ps.setString(3, getKontonummer());
        System.out.println("SQL code is finished successfully");
        return ps.executeUpdate();
    }

    /**
     * søke opp banksystem
     * @throws SQLException får en sql feilmelding dersom man skriver feil verdi
     */

    public void søke_Brukere() throws SQLException {
        String enkel_Søk = "select * from transaksjoner where Kontonummer = ? ";
        con = DriverManager.getConnection(Connection_String, user, password);
        scanner = new Scanner(System.in);
        if(scanner != null){
            ps = con.prepareStatement(enkel_Søk);
            System.out.println("skriv inn kontonummer");
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

    /**
     *endrer transaksjoner i databasen
     * @throws SQLException sende ut en sql feilmelding
     */



    private void update() throws SQLException {
        System.out.println("running SQL code...");
        String update = "update transaskjoner set Kontonummer = ?, Sum = ? where Referansenummer = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);
        try (PreparedStatement pre = connection.prepareStatement(update)) {
            pre.setString(1, getKontonummer());
            pre.setInt(2, getSum());
            pre.setInt(3, getReferansenummer());
            pre.executeUpdate();
            System.out.println("SQL code is finished successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * metode for å slette banksystem bilde
     * @throws SQLException kaster ut en sql feilspørring
     */

    public void slette_transaksjoner() throws SQLException {
        String enkel_Søk = "select * from transaksjoner where Kontonummer = ? ";

        String delete = "delete from transaksjoner where Referansenummer = ?";
        con = DriverManager.getConnection(Connection_String, user, password);
        ps = con.prepareStatement(enkel_Søk);

        ps.setString(1, getKontonummer());
        rs = ps.executeQuery();
        while(rs.next()){
            int sjekk =  rs.getInt(1);
            if(sjekk  ==  getReferansenummer()){
                ps = con.prepareStatement(delete);
                ps.setInt(1, getReferansenummer());
                ps.executeUpdate();
            }
        }
    }


    public int getReferansenummer() {
        return referansenummer;
    }

    public void setReferansenummer(int referansenummer) {
        this.referansenummer = referansenummer;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public int getSum() {
        return Sum;
    }

    public void setSum(int sum) {
        Sum = sum;
    }
}
