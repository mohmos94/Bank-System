package modell.Interface;

import java.sql.SQLException;

public interface IKunde {
    public int kunde() throws SQLException;
    public void søke_kundebilde( int valg_Til_Søke) throws SQLException;
    public void slette_Kundebilde(String slettegrunnlag) throws SQLException;
    public void innlogging(String tilbakeMelding, String brukernavnet, String passord);
    public void transaksjoner(String tilbakeMelding, String konto_Nummer, long balansen, int penger);


}
