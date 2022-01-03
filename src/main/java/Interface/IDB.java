package Interface;

public interface IDB {
    public void insert(int brukerID, String brukernavn, String passord, int personId);
    public void update(int brukerID, String brukernavn, String passord, int personId);
    public void delete(int brukerID, String brukernavn, String passord, int personId);
    public void read(int brukerID, String brukernavn, String passord, int personId);


}
