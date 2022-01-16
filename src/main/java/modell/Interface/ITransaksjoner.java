package modell.Interface;

import java.io.IOException;
import java.sql.SQLException;

public interface ITransaksjoner {
    public int insert(String kontonummer ) throws SQLException;
    public void søke_Transaksjoner () throws SQLException, IOException;
    public void update() throws SQLException;
    public void slette_transaksjoner() throws SQLException;
}
