package modell.Interface;

public interface Ikunde {


    void transaksjoner(String tilbakeMelding, String konto_Nummer, long balansen, int penger);


    void hvis_Info(String tilbakeMelding, String brukernavnet, String passord);
}