package modell.classes;


import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {

        Kunder kunder = new Kunder("mostafa", "mohammedi", "95242854", "mosti94@hotmail.com");
        //kunder.kunde();

        //kunder.søke_kundebilde(1);

        kunder.slette_Kundebilde("12345678912");


    }

}
