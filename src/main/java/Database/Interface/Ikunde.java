package Database.Interface;

import java.sql.SQLException;

public interface Ikunde {
    public void createConnection() throws SQLException;
    public void insert(int PersonID, String LastName, String FirstName, int Telefon, String Email);
    public void update(int PersonID, String LastName, String FirstName, int Telefon, String Email);
    public void delete(int PersonID, String LastName, String FirstName, int Telefon, String Email);
    public void read(int PersonID, String LastName, String FirstName, int Telefon, String Email);

}
