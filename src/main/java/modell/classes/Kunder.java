package modell.classes;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Kunder extends DB {

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
     * 
     * @return
     * @throws SQLException
     */

    public int kunde() throws SQLException {
        String insert = "insert into kunde(Fødelsnummer, Fornavn, Etternavn, Telefon, Email) values(?,?,?,?,?);";
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

    public void søke_kundebilde(int søke_Funksjon){
        String enkel_Søk = "select * from kunde where ? = ? ";
        String flere_kriterier = "select * from kunde where ? = ? and ? like '%?%' ";
        System.out.println("velg 1 for enkeltsøk eller 2 for flervalgsøk");
        scanner = new Scanner(System.in);
        if(scanner != null){
            int valg_Til_Søke= scanner.nextInt();
            søke_Funksjon = valg_Til_Søke;




        }








    }

    public void slette_Kundebilde(){


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

