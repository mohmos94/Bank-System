package modell.Interface;

public interface IBank_System{
    public int loggin(String brukernavn, String passord);

    public String verifisert_Bruker(int value);

    public void betale_Faktura(String kontonummer, String kiddnummer, int penger);

    public void hvis_Transaksjoner();



}
