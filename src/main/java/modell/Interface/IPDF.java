package modell.Interface;

import java.io.IOException;
import java.sql.SQLException;

public interface IPDF {
    public void skriv_Ut_Transaksjoner () throws SQLException, IOException;
}
