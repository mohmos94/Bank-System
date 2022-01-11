package modell;


import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {

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
        transaksjoner.søke_Transaksjoner();





    }

}
