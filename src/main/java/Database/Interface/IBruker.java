package Database.Interface;

public interface IBruker {


    void insert(int brukerID, String brukernavn, String passord, int personId);

    void update(int brukerID, String brukernavn, String passord, int personId);

    void delete(int brukerID, String brukernavn, String passord, int personId);

    void read(int brukerID, String brukernavn, String passord, int personId);
}
