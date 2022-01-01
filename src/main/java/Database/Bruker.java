package Database;

import java.util.Scanner;

public class Bruker {
    private void insert(){
        Scanner bruker = new Scanner(System.in);
        int BrukerId = bruker.nextInt();
        String brukernavn = bruker.next();
        String passord = bruker.next();
        int PersonId =  bruker.nextInt();

        String sql = "INSERT INTO bruker VALUES " + "(" + BrukerId + "" + brukernavn + " " + passord + " " + PersonId + ");";
    }
}
