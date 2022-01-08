package controller.classes;

import controller.Interface.IBank_System;

import java.util.Scanner;

public class Bank_System implements IBank_System {

    private String brukernavn;
    private String passord;

    public Bank_System(String brukernavn, String passord) {
        this.brukernavn = brukernavn;
        this.passord = passord;
    }


    /**
     * metode for å verifisere bruker til innlogging
     * @param brukernavn tekst verdi som man skal legge inn
     * @param passord tekst verdi som man skal legge inn
     * @return skal retuerne 1 for riktig eller -1 for feil
     */
    @Override
    public int loggin(String brukernavn, String passord) {
       int value = logg(brukernavn, passord);
       return value;
    }


    private int logg(String brukernavn, String passord) {
        Scanner scanner = new Scanner(System.in);

        String bruker =scanner.next();
        String pass =scanner.next();

        if(brukernavn.equals(bruker) && passord.equals(pass)){
            return 1;
        }
        else{
            System.out.println("Brukernavnet eller passorder er feil");
            return -1;
        }
    }


    /**
     * metode for å verifisere brukeren
     * @param value tallverdi som viser til  om brukeren eksisterer eller ikke
     * @return teksverdi som viser til om brukeren er godkjent eller ikke
     */


    @Override
    public String verifisert_Bruker(int value) {
        final String godkjent = "Bruker er godkjent";
        final String feil = "passordet eller brukernavnet er feil";
        final String bruker_Finnes_Ikke= "Denne brukeren er ikke registrert";
        if (value == 1){
            return godkjent;
        }
        else if(value == -1){
            return feil;
        }
        else{
            return bruker_Finnes_Ikke;
        }

    }

    @Override
    public void betale_Faktura(String kontonummer, String kiddnummer, int penger) {

        String konto= "";



    }

    @Override
    public void hvis_Transaksjoner() {

    }
}
