package Database.Classes;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        DbKunde arany = new DbKunde();

        arany.insert(2,
                "Ketheeswaran",
                "Arany",
                "95242854",
                "mosti94@hotmail.com");
    }

}
