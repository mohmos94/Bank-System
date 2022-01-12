package modell.Interface;

import java.sql.SQLException;

public interface ITransaksjoner {
    public int insert(String kontonummer ) throws SQLException;
    public void søke_Transaksjoner () throws SQLException;
    public void update() throws SQLException;
    public void slette_transaksjoner() throws SQLException;
}
