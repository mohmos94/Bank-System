package modell.Classes;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import modell.Interface.ITransaksjoner;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Transaksjoner extends DBOppsett implements ITransaksjoner {

    private int referansenummer;
    private String kontonummer;
    private String beskrivelse;
    private int Sum;

    public Transaksjoner(int referansenummer, String kontonummer, String beskrivelse, int sum) {
        this.referansenummer = referansenummer;
        this.kontonummer = kontonummer;
        this.beskrivelse = beskrivelse;
        Sum = sum;
    }

    /**
     * @param kontonummer
     * @return
     * @throws SQLException
     */


    @Override
    public int insert(String kontonummer ) throws SQLException {


        if(getKontonummer().compareToIgnoreCase(kontonummer) == 0){
            String insert = "insert into transaksjoner(Referansenummer, Kontonummer, Sum, beskrivelse) values(?,?,?,?)";
            con = DriverManager.getConnection(Connection_String, user, password);
            ps = con.prepareStatement(insert);
            System.out.println("running SQL code...");
            ps.setInt(1, getReferansenummer());
            ps.setString(2, getKontonummer());
            ps.setInt(3, getSum());
            ps.setString(4,getBeskrivelse());
            System.out.println("SQL code is finished successfully");
            return ps.executeUpdate();
        }
        return -1;

    }

    /**
     * søke opp banksystem
     * @throws SQLException får en sql feilmelding dersom man skriver feil verdi
     */

    @Override
    public void søke_Transaksjoner () throws SQLException, IOException {

        String enkel_Søk = "select * from transaksjoner where Kontonummer = ? ";

        con = DriverManager.getConnection(Connection_String, user, password);
        scanner = new Scanner(System.in);
        if(scanner != null){
            ps = con.prepareStatement(enkel_Søk);
            System.out.println("skriv inn kontonummer");
            String søkevalg = scanner.nextLine();
            ps.setString(1, søkevalg);
            rs = ps.executeQuery();

            String destination = "C:/PdfBox_Examples/kontoutskrift.pdf";
            writer = new PdfWriter(destination);
            pdfDoc = new PdfDocument(writer);
            float [] pointColumnWidths = {150F, 150F, 150F};
            table = new Table(pointColumnWidths);

            table.addCell(new Cell().add("Kontonummer"));
            table.addCell(new Cell().add("Beskrivelse"));
            table.addCell(new Cell().add("Kiddnummer"));






            while(rs.next()){
                String referanse = rs.getString(1);
                String kontonmummer = rs.getString(2);
                String sum = rs.getString(3);

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



    @Override
    public void update() throws SQLException {
        System.out.println("running SQL code...");
        String update = "update transaksjoner set Kontonummer = ?, Sum = ? where Referansenummer = ?";
        Connection connection = DriverManager.getConnection(Connection_String, user, password);

        PreparedStatement pre = connection.prepareStatement(update);
        pre.setString(1, getKontonummer());
        pre.setInt(2, getSum());
        pre.setInt(3, getReferansenummer());
        pre.executeUpdate();
        System.out.println("SQL code is finished successfully");

    }

    /**
     * metode for å slette banksystem bilde
     * @throws SQLException kaster ut en sql feilspørring
     */

    @Override
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

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
