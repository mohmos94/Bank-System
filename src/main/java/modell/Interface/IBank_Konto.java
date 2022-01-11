package modell.Interface;

import java.sql.SQLException;

public interface IBank_Konto {

    public int Konto() throws SQLException;
    public int slett_Konto() throws SQLException;
    public int oppdatere() throws SQLException;

}
