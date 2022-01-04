package Database.Interface;

public interface Ikunde {
    public void insert(int PersonID, String LastName, String FirstName, int Telefon, String Email);
    public void update(int PersonID, String LastName, String FirstName, int Telefon, String Email);
    public void delete(int PersonID, String LastName, String FirstName, int Telefon, String Email);
    public void read(int PersonID, String LastName, String FirstName, int Telefon, String Email);

}
