package modell.Interface;

import java.sql.SQLException;

public interface IBanksystem {
    public int banksystem() throws SQLException;
    public void søke_Brukere() throws SQLException;
    public void update() throws SQLException;

    public void slette_Kundebilde(String Fødelsnummer) throws SQLException;




}
