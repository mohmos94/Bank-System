package Database.Classes;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
       /*

        DbKunde arany = new DbKunde();

        arany.insert(2,
                "Ketheeswaran",
                "Arany",
                "95242854",
                "mosti94@hotmail.com");


        arany.update(2,
                "Ali",
                "Asie",
                "920414",
                "asie94@hotmail.com");

        //arany.delete(2);
        arany.read(2);

        */

        DBBank_Konto konto = new DBBank_Konto();
        //konto.insert(2, "brukskonto", "123456789", 0, 1);
        //konto.update(1, "sparekonto", "11111111", 10000, 1);
        //konto.read(1);
        //konto.delete(2);

        DbBruker bruker = new DbBruker();
       // bruker.insert(3, "sparekonto", "nettavisen123", 1);
        /*
        bruker.update(
                2,
                "arany98",
                "Nettavisen123",
                1
        );

         */
        //bruker.delete(3);
        bruker.read(2);
    }


}
