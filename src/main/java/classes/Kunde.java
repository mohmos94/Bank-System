package classes;

import Interface.Ikunde;

/**
 * classes.Kunde klassen representerer en kundeforhold i banksystemet. Man kan opprette så mange kunder man ønsker
 * @author mosti
 */

public class Kunde implements Ikunde {
    private String for_Navn;
    private String etter_Navn;
    private String fullname;
    private String telefon;
    private String mail;


    /**
     * konstruktor for å initialisere en kunde objekt
     * @param for_Navn tekst verdi for fornavnet til kunden
     * @param etter_Navn tekst verdi for etternavnet til kunden
     * @param telefon tekst verdi for telefonnummeret til kunden
     * @param mail tekst verdi for e-posten til kunden
     */

    public Kunde(String for_Navn, String etter_Navn, String telefon, String mail) {
        this.for_Navn = for_Navn;
        this.etter_Navn = etter_Navn;
        this.telefon = telefon;
        this.mail = mail;
        this.fullname = for_Navn + etter_Navn;
    }


    /**
     * @param tilbakeMelding en tekstlig tilbakemelding som kunden får ifra handlingen han ønsker å utføre i klassen
     * @param brukernavnet en tekstlig ord for å komme seg inn i systemet
     * @param passord er tekstlig ord for å sikre at ingen andre en brukeren kommer inn i systemet
     */

    @Override
    public void hvis_Info(String tilbakeMelding, String brukernavnet, String passord) {
        innlogging(tilbakeMelding, brukernavnet, passord);
    }

        private void innlogging(String tilbakeMelding, String brukernavnet, String passord) {

        switch (tilbakeMelding) {
            case "brukernavner feil":
                System.out.println("brukernavnet " + brukernavnet + " eksisterer ikke eller er skrevet feil");
                break;
            case "passord feil":
                System.out.println("Passordet " + passord + " er feil kan du vennligst angi passordet på nytt");
                break;
            case "vellyket innlogging":
                System.out.println("Vellykket innlogging");
                break;
            default:
                System.out.println("Det har oppstått en feil under innlogging");
                break;
        }
    }


    /**
     * @param tilbakeMelding en tekstlig tilbakemelding som kunden får ifra handlingen han ønsker å utføre i klassen
     * @param tilbakeMelding en tekslig tilbakemelding fra andre metoder for å vise hvilken informasjon som skal vises til kunden
     * @param konto_Nummer en tekstlig kontonummer som brukse til å vise hva man har i
     * @param penger en tallverdi  sum, som brukes til å beregne balansen etter utført transaksjon
     */


    @Override
    public void transaksjoner(String tilbakeMelding, String konto_Nummer, long balansen, int penger){
        transaksjon(tilbakeMelding, konto_Nummer, penger , balansen);

    }


    private void transaksjon(String tilbakeMelding, String konto_Nummer, int penger,long balansen) {

        switch (tilbakeMelding) {
            case "Mangler midler":
                System.out.println("penger " + penger + " er for mye for " + konto_Nummer + " du har " + balansen + " inn i kontoret ditt");
                break;
            case "Konto Finnes ikke":
                System.out.println("Kontonummer: " + konto_Nummer + " finnes ikke sjekk gjerne at du har riktig kontonummer");
                break;
            case "Overførte penger":
                System.out.println("du har overførte " + penger  + " til kontonummer " + konto_Nummer);
                break;
            case "laget nytt konto":
                System.out.println("kontonummeret " + konto_Nummer + " har blitt opprettet ");
            case "feil kontonummer":
                System.out.println("kontonummeret " + konto_Nummer + " kan ikke opprettes");
            case "kan ikke overføre mellom kontoer":
                System.out.println("kan ikke overføre mellom kontoene");
        }
    }



    public String getTelefon() {
        return telefon;
    }

    /**
     * brukes for å endre eksisterende telefonnummer
     * @param telefon tekstlig beskrivelse for å endre telefonnumer
     */
    public void setTelefon(String telefon) {
        if (telefon.length() == 9 && telefon.matches("[0-9]*")) {
            this.telefon = telefon;
        }
    }

    public String getFor_Navn() {
        return for_Navn;
    }

    public void setFor_Navn(String for_Navn) {
        this.for_Navn = for_Navn;
    }


    public String getEtter_Navn() {
        return etter_Navn;
    }

    public void setEtter_Navn(String etter_Navn) {
        this.etter_Navn = etter_Navn;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
