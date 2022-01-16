package modell.Classes;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import modell.Interface.IPDF;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class PDF extends DBOppsett implements IPDF {

    String dest = "C:/PdfBox_Examples/sample.pdf";
    String information = "Konto utskrift ";
    /**
     * skriver ut PDf fil
     * @throws SQLException gir et sql feil dersom det er noe feil med databaser
     * @throws IOException gir ut io feil dersom det er noe feil med settingsene
     */


    @Override
    public void skriv_Ut_Transaksjoner () throws SQLException, IOException {

        String enkel_Søk = "select * from transaksjoner where Kontonummer = ? ";

        con = DriverManager.getConnection(Connection_String, user, password);
        scanner = new Scanner(System.in);
        if(scanner != null){
            ps = con.prepareStatement(enkel_Søk);
            System.out.println("skriv inn kontonummer");
            String søkevalg = scanner.nextLine();
            ps.setString(1, søkevalg);
            rs = ps.executeQuery();
            String destinaton  = "C:/PdfBox_Examples/kontouskrift.pdf";

            writer = new PdfWriter(destinaton);
            pdfDoc = new PdfDocument(writer);
            document = new Document(pdfDoc);
            float [] pointColumnWidth  = {100F, 100F, 100F, 100F};
            table = new Table(pointColumnWidth);
            table.addCell(new Cell().add("kontonummer"));
            table.addCell(new Cell().add("Kiddnummer"));
            table.addCell(new Cell().add("Beskrivelse"));
            table.addCell(new Cell().add("Penger"));

            while(rs.next()){
                String referanse = rs.getString(1);
                String kontonmummer = rs.getString(2);
                String sum = rs.getString(3);
                String beskrivelse = rs.getString(4);
                table.addCell(new Cell().add(kontonmummer));
                table.addCell(new Cell().add(referanse));
                table.addCell(new Cell().add(beskrivelse));
                table.addCell(new Cell().add(sum));

            }
            document.add(table);
            document.close();
            rs.close();
            con.close();
            System.out.println("table created ;)");

        }
        else {
            System.out.println("inkorrekt valg start på nytt");
        }

    }

}
