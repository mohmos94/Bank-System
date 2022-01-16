package modell.Classes;

import modell.Interface.IKunde;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Kunder extends DBOppsett implements IKunde {

    private String fornavn;
    private String etternavn;
    private String Telefon;
    private String Email;


    public Kunder(String fornavn, String etternavn, String telefon, String email) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        Telefon = telefon;
        Email = email;
    }


    /**
     * metode for å lage en kunde
     * @return int verdi for å legger inn kunde inn i databsen
     * @throws SQLException dersom man skrive noe feil
     */


    @Override
    public int kunde() throws SQLException {
        String insert = "insert into kunde(Fødselsnummer, Fornavn, Etternavn, Telefon, Email) values(?,?,?,?,?);";
        scanner = new Scanner(System.in);
        System.out.println("legg inn fødelselsnummer");
        String persnr = scanner.nextLine();
        if (persnr.length() == 11 && persnr.matches("[0-9]*")){
            //kobler til databasen
            con = DriverManager.getConnection(Connection_String, user, password);
            if (con != null) {
                ps = con.prepareStatement(insert);
                System.out.println("running SQL code...");

                ps.setString(1, persnr);
                ps.setString(2, getFornavn());
                ps.setString(3,getEtternavn());
                ps.setString(4, getTelefon());
                ps.setString(5, getEmail());

                System.out.println("SQL code is finished successfully");

                return ps.executeUpdate();

            }
            else{
                System.out.println("koblingen feilet sjekk DB klassen for koblingen eller brukernavn eller passord");

            }
        }
        else {
            System.out.println("lengden på brukernavnet er for liten vennligst skriv ");
            kunde();
        }
        return -1;
    }

    /**
     * søke opp kunde
     * @param valg_Til_Søke int verdi for å søke opp kunden
     * @throws SQLException får en sql feilmelding dersom man skriver feil verdi
     */

    @Override
    public void søke_kundebilde( int valg_Til_Søke) throws SQLException {
        String enkel_Søk = "select * from kunde where Fødselsnummer = ? ";
        String flere_kriterier = "select * from kunde where Fødselsnummer = ? and Telefon like ? ";
        con = DriverManager.getConnection(Connection_String, user, password);

        scanner = new Scanner(System.in);
        if(scanner != null){
            if(valg_Til_Søke == 1 ){
                ps = con.prepareStatement(enkel_Søk);
                System.out.println("skriv inn Fødselsnummer");
                String søkevalg = scanner.nextLine();
                ps.setString(1, søkevalg);

                rs = ps.executeQuery();



                while(rs.next()){
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                    System.out.println(rs.getString(5));
                }
            }
            else if(valg_Til_Søke == 2){
                ps = con.prepareStatement(flere_kriterier);
                System.out.println("skriv inn Fødselsnummer");
                String søkegrunnlag = scanner.nextLine();
                System.out.println("skriv inn søkefelt");
                String søkevalg = scanner.nextLine();
                ps.setString(1, søkegrunnlag);
                ps.setString(2, "%"+ søkevalg + "%");
                 rs = ps.executeQuery();

                while(rs.next()){
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                    System.out.println(rs.getString(5));
                }
            }
            else {
                System.out.println("inkorrekt valg start på nytt");
            }

        }
    }

    /**
     * metode for å slette kunde bilde
     * @param slettegrunnlag tekstlig verdi for å ordet man ønsker å slette
     * @throws SQLException kaster ut en sql feilspørring
     */

    @Override
    public void slette_Kundebilde(String slettegrunnlag) throws SQLException {
        String enkel_Søk = "select * from kunde where Fødselsnummer = ? ";

        String delete = "delete from kunde where Fødselsnummer = ?";
        con = DriverManager.getConnection(Connection_String, user, password);
        ps = con.prepareStatement(enkel_Søk);

        ps.setString(1, slettegrunnlag);
        rs = ps.executeQuery();
        while(rs.next()){
            String sjekk =  rs.getString(1);
            if(sjekk.compareToIgnoreCase(slettegrunnlag) == 0){
                ps = con.prepareStatement(delete);
                ps.setString(1, slettegrunnlag);
                ps.executeUpdate();

            }

        }

    }


    /**
     *
     * @param tilbakeMelding
     * @param brukernavnet
     * @param passord
     */

    @Override
    public void innlogging(String tilbakeMelding, String brukernavnet, String passord) {

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
     *
     * @param tilbakeMelding
     * @param konto_Nummer
     * @param balansen
     * @param penger
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




    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

