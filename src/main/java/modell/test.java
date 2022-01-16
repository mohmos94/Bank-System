package modell;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import modell.Classes.*;


import java.io.IOException;
import java.sql.SQLException;


public class test {
    public static void main(String[] args) throws SQLException, IOException {

        Kunder kunder = new Kunder("mostafa", "mohammedi", "95242854", "mosti94@hotmail.com");
        //kunder.kunde();

        //kunder.søke_kundebilde(1);

        //kunder.slette_Kundebilde("12345678912");

        BankSystem system = new BankSystem("mosti94", "Mohammedi123", "09099428705");
       // system.banksystem();
        //system.søke_Brukere();
        //system.slette_Kundebilde("12345678912");

        Bank_kontoer konto =  new Bank_kontoer("09099428705", "spareKonto", 0, 6);
        //konto.Konto();

       // Transaksjoner transaksjoner = new Transaksjoner(3, "123456789", "spar",1200);

        //transaksjoner.insert("123456789");
        //transaksjoner.søke_Transaksjoner();

        //Creating PDF document object
        /*
        PDDocument document = new PDDocument();
        PDPage new_Page = new PDPage();
        document.addPage(new_Page);
        System.out.println("PDF created");

        PDDocumentInformation pdd = document.getDocumentInformation();

        pdd.setAuthor("Learning");
        pdd.setTitle("Eksempel Oppgave");
        pdd.setCreator("Mostafa Mohammedi");
        pdd.setSubject("Emsepler på hvordan vi lager egenskaper på pdf filen");
        document.save("C:/PdfBox_Examples/mosti.pdf");
        document.close();
                contentStream.endText();


         */

        /*
        String testing  = "dette er en test for å sjekk om dette fungerer";
        String dest = "C:/PdfBox_Examples/sample.pdf";
        Paragraph par = new Paragraph(testing);


        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument
        PdfDocument pdfDoc = new PdfDocument(writer);

        // Adding a new page
        pdfDoc.addNewPage();

        // Creating a Document
        Document document = new Document(pdfDoc);
        float [] pointColumnWidths = {150F, 150F, 150F};

        Table table = new Table(pointColumnWidths);
        table.addCell(new Cell().add("Name"));
        table.addCell(new Cell().add("Name"));
        table.addCell(new Cell().add("Name"));
        document.add(table);



        document.add(table);

        // Closing the document
        document.close();
        System.out.println("PDF Created");


         */

        PDF pdf = new PDF();
        pdf.skriv_Ut_Transaksjoner();













    }

}
