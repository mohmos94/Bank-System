package view.Interface;

import java.sql.SQLException;

public interface IBruker {
    void insert(int id, String brukernavn, String passord, int personligID) throws SQLException;
    void update(int id, String brukernavn, String passord, int personligID) throws SQLException;
    void delete(int id) throws SQLException;
    void read(int id) throws SQLException;
}
