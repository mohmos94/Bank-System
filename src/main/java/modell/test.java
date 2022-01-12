package modell;


import modell.Classes.BankSystem;
import modell.Classes.Bank_kontoer;
import modell.Classes.Kunder;
import modell.Classes.Transaksjoner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
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

        Transaksjoner transaksjoner = new Transaksjoner(1, "09099428705", 2000);

        //transaksjoner.insert("09099428705");
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

        File file = new File("C:/PdfBox_Examples/mosti.pdf");
       PDDocument dokument = PDDocument.load(file);

        PDPage page = dokument.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(dokument, page);
        contentStream.beginText();
        String text = "THIS IS A TEST";
        contentStream.setFont(PDType1Font.TIMES_ROMAN,12);
        contentStream.newLineAtOffset(25,700);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        //Saving the document
        dokument.save(new File("C:/PdfBox_Examples/new.pdf"));

        //Closing the document
        dokument.close();













    }

}
