package modell.classes;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BankSystem extends DB {
    private int SystemID;
    private String Brukernavn;
    private String Passord;
    private String Fødselsnummer;


    public int banksystem() throws SQLException {
        String insert = "insert into banksystem(brukernavn, Passord, Fødselsnummer) values(?,?,?)";


            //kobler til databasen
            con = DriverManager.getConnection(Connection_String, user, password);
            if (con != null) {
                ps = con.prepareStatement(insert);
                System.out.println("running SQL code...");
                ps.setString(1, getBrukernavn());
                ps.setString(2,getPassord());
                ps.setString(3,getFødselsnummer());

                System.out.println("SQL code is finished successfully");

                return ps.executeUpdate();

            }
            else{
                System.out.println("koblingen feilet sjekk DB klassen for koblingen eller brukernavn eller passord");

            }
        return -1;
    }

    /**
     * søke opp banksystem
     * @param valg_Til_Søke int verdi for å søke opp banksystemn
     * @throws SQLException får en sql feilmelding dersom man skriver feil verdi
     */

    public void søke_kundebilde( int valg_Til_Søke) throws SQLException {
        String enkel_Søk = "select * from banksystem where Fødselsnummer = ? ";
        String flere_kriterier = "select * from banksystem where Fødselsnummer = ? and Telefon like ? ";
        con = DriverManager.getConnection(Connection_String, user, password);

        scanner = new Scanner(System.in);
        if(scanner != null){
            if(valg_Til_Søke == 1 ){
                ps = con.prepareStatement(enkel_Søk);
                System.out.println("skriv inn fødelsnummer");
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
                System.out.println("skriv inn fødelsnummer");
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
     * metode for å slette banksystem bilde
     * @param slettegrunnlag tekstlig verdi for å ordet man ønsker å slette
     * @throws SQLException kaster ut en sql feilspørring
     */

    public void slette_Kundebilde(String slettegrunnlag) throws SQLException {
        String enkel_Søk = "select * from banksystem where Fødelsnummer = ? ";

        String delete = "delete from banksystem where Fødelsnummer = ?";
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

    public int getSystemID() {
        return SystemID;
    }

    public void setSystemID(int systemID) {
        SystemID = systemID;
    }

    public String getBrukernavn() {
        return Brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        Brukernavn = brukernavn;
    }

    public String getPassord() {
        return Passord;
    }

    public void setPassord(String passord) {
        Passord = passord;
    }

    public String getFødselsnummer() {
        return Fødselsnummer;
    }

    public void setFødselsnummer(String fødselsnummer) {
        Fødselsnummer = fødselsnummer;
    }
}
