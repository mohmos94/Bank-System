package controller.classes;

import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException {

     //   Kunde most =  new Kunde("mm", "mm", "00", "00");
       // Kunde mosti =  new Kunde("mm", "mm", "00", "00");

        Kunde counter = new Kunde();

       int cin =  counter.counter();
        System.out.println(cin);






    }
}
