package modell.Classes;

import modell.Classes.DBOppsett;
import modell.Interface.ITransaksjoner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

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
    private int Sum;


    public Transaksjoner(int referansenummer, String kontonummer, int sum) {
        this.referansenummer = referansenummer;
        this.kontonummer = kontonummer;
        Sum = sum;
    }

    /**
     *
     * @param kontonummer
     * @return
     * @throws SQLException
     */


    @Override
    public int insert(String kontonummer ) throws SQLException {


        if(getKontonummer().compareToIgnoreCase(kontonummer) == 0){
            String insert = "insert into transaksjoner(Referansenummer, Kontonummer, Sum) values(?,?,?)";
            con = DriverManager.getConnection(Connection_String, user, password);
            ps = con.prepareStatement(insert);
            System.out.println("running SQL code...");
            ps.setInt(1, getReferansenummer());
            ps.setString(2, getKontonummer());
            ps.setInt(3, getSum());
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
            file = new File("C:/PdfBox_Examples/kontoutskrift.pdf");
            pdf = PDDocument.load(file);
            page = pdf.getPage(0);
            contentStream = new PDPageContentStream(pdf, page);



            while(rs.next()){
                String referanse = rs.getString(1);
                String kontonmummer = rs.getString(2);
                String sum = rs.getString(3);

                contentStream.beginText();
                contentStream.newLineAtOffset(1,1);
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.showText("kontonummer " + kontonmummer + " kiddnummer " + referanse + " kostnader " + sum + " kr");
                contentStream.endText();
                contentStream.close();
                pdf.save("C:/PdfBox_Examples/kontoutskrift.pdf");
                pdf.close();
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
}
