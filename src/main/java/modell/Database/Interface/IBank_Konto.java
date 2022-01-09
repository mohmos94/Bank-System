package modell.Database.Interface;

import java.sql.SQLException;

public interface IBank_Konto {

    void insert(String kontonavn, String kontonummer, long balansen, int brukerID) throws SQLException;
    void update(int id, String kontonavn, String kontonummer, long balansen, int brukerID) throws SQLException;
    void delete(int id) throws SQLException;
    void read(int id) throws SQLException;
}
