package controller.classes;


public class Bank_Konto   {
    private String kontonavn;
    private String konto_Type;
    private String konto_Nummer;
    private long balansen;


    public Bank_Konto(String kontonavn, String konto_Type, String konto_Nummer, long balansen) {
        this.kontonavn = kontonavn;
        this.konto_Type = konto_Type;
        this.konto_Nummer = konto_Nummer;
        this.balansen = balansen;
    }


    public String getKontonavn() {
        return kontonavn;
    }

    /**
     * metode for å endre kontonavnet
     * @param kontonavn tar et kontonavn som parameter
     */

    public void setKontonavn(String kontonavn) {
        String drift = "driftskonto";
        String bruks = "brukskonto";
        String spare = "sparekonto";
        String pensjon = "penssjonskonto";

        if (kontonavn.equals(drift) || kontonavn.equals(bruks) || kontonavn.equals(spare) || kontonavn.equals(pensjon)) {
            this.kontonavn = kontonavn;
        }

        else {
            System.out.println("kan ikke lage kontoen");
        }

    }

    public String getKonto_Type() {
        return konto_Type;
    }

    public void setKonto_Type(String konto_Type) {
        this.konto_Type = konto_Type;
    }


    public String getKonto_Nummer() {
        return konto_Nummer;
    }

    /**
     * sjekker om kontonummeret stemmer
     *
     * @param konto_Nummer det skal være 11 siffer og det skal kun innholde tallverdier
     */

    public void setKonto_Nummer(String konto_Nummer) {
        if (konto_Nummer.length() == 11 && konto_Nummer.matches("[0-9]*")) {
            System.out.println("kontonummeret må være 11 verdier");
        } else {
            System.out.println("feil kan ikke bruke kontonummeret");
        }
    }


    public long getBalansen() {
        return balansen;
    }

    /**
     * brukes for å sette penger inn i bankontoen
     *
     * @param balansen sjekker tilgjengelig penger inn i kontoen
     * @param penger   penger som skal settes inn i kontoen
     */

    public void setBalansen(long balansen, int penger) {
        if (penger < 0) {
            System.out.println("kan ikke legge inn mindre enn 0 kroner ");
        } else {

            this.balansen = balansen + penger;
        }
    }

    /**
     * metode for å lage et konto
     * @param kontonavn String verdi for  kontonavnet
     * @param konto_Nummer String verdi for konto nummer
     */


    public void lage_Conto(String kontonavn, String konto_Nummer) {
        lage_Konto(kontonavn, konto_Nummer);
    }

    private String lage_Konto(String kontonavn, String konto_Nummer){
        String drift = "driftskonto";
        String bruks = "brukskonto";
        String spare = "sparekonto";
        String pensjon = "penssjonskonto";

        if (kontonavn.equals(drift) || kontonavn.equals(bruks) || kontonavn.equals(spare) || kontonavn.equals(pensjon)) {
            if(konto_Nummer.length() == 11 && konto_Nummer.matches("[0-9]*")){

                return konto_Nummer;
            }
        }

        return "error could not create account";
    }


    public void slette_konto(String kontonavn, String konto_Nummer) {

        System.out.println(kontonavn + " med kontonummer" + konto_Nummer + " har blitt slettet");

    }
}