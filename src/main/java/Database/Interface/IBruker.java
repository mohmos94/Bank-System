package Database.Interface;

import java.sql.SQLException;

public interface IBruker {
    public void createConnection() throws SQLException;

    void insert(String brukernavn, String passord, int PersonID);

    void update(String brukernavn, String passord, int PersonID) throws SQLException;

    void delete(String brukernavn, String passord, int PersonID);

    void read(int brukerID);
}
