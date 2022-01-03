package Database;

import Interface.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Bruker extends DB implements IDB {

    /**
     * insert into database
     */

    @Override
    public void insert(int brukerID, String brukernavn, String passord, int personId ){
        try{

            Connection connection  = DriverManager.getConnection(Connection_String,user, password);
            Statement statement = connection.createStatement();
            statement.execute("insert into bruker (BrukerID, Brukernavn, Passord, PersonID)values(brukerId, brukernavn, passord,personId)");
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void inserte(int brukerID, String brukernavn, String passord, int personId){

        try{

            Connection connection  = DriverManager.getConnection(Connection_String,user, password);
            Statement statement = connection.createStatement();
            statement.execute("insert into bruker (BrukerID, Brukernavn, Passord, PersonID)values(brukerId, brukernavn, passord,personId)");
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(int brukerID, String brukernavn, String passord, int personId) {
        update(brukerID, brukernavn, passord, personId);

    }
    private void updat(int brukerID, String brukernavn, String passord, int personId){

        try{

            Connection connection  = DriverManager.getConnection(Connection_String,user, password);
            Statement statement = connection.createStatement();
            statement.execute("update bruker set BrukerID = brukerId, Brukernavn = brukernavn, Passord = passord, Person = personId");
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int brukerID, String brukernavn, String passord, int personId) {
        delet(brukerID, brukernavn, passord, personId);

    }

    private void delet(int brukerID, String brukernavn, String passord, int personId){

        try{

            Connection connection  = DriverManager.getConnection(Connection_String,user, password);
            Statement statement = connection.createStatement();
            statement.execute("Delete from  bruker where BrukerID = brukerId and Brukernavn = brukernavn and Passord = passord and Person = personId");
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void read(int brukerID, String brukernavn, String passord, int personId) {
        reading(brukerID, brukernavn, passord, personId);

    }

    private void reading(int brukerID, String brukernavn, String passord, int personId){
        try{

            Connection connection  = DriverManager.getConnection(Connection_String,user, password);
            Statement statement = connection.createStatement();
            statement.execute("select * from bruker where BrukerID = brukerId");
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
