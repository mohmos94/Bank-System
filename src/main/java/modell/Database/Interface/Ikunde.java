package modell.Database.Interface;

import java.sql.SQLException;

public interface Ikunde {
    void insert(String etternavnet, String fornavn, String telefon, String mail) throws SQLException;
    void update(int id, String etternavnet, String fornavn, String telefon, String mail) throws SQLException;
    void delete(int id) throws SQLException;
    void read(int id) throws SQLException;

}
