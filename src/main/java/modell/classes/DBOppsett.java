package modell.classes;

import java.sql.*;
import java.util.Scanner;

abstract class DBOppsett {
    public static final String Connection_String ="jdbc:mysql://localhost:3306/banksystem";
    public static final String user = "root";
    public static final String password  = "Nettavisen123+";
    public static Connection con = null;
    public static Statement stat;
    public static PreparedStatement ps = null;
    public static ResultSet rs;
    public static DatabaseMetaData metaData;
    public static Scanner scanner;

    public static final String SQL_CREATE_Kunde = "CREATE TABLE if not exists Kunde (Fødselsnummer  varchar(150) not null, Fornavn varchar(150),  Etternavn varchar(150), Telefon varchar(8), Email varchar(150), PRIMARY KEY (Fødselsnummer))";
    public static final String SQL_CREATE_BankSystem = "CREATE TABLE if not exists Banksystem (SystemID int NOT NULL AUTO_INCREMENT, Brukernavn varchar(150), Passord varchar(150), Fødselsnummer varchar(150) NOT NULL, PRIMARY KEY (SystemID),FOREIGN key (Fødselsnummer) references Kunde(Fødselsnummer))";
    public static final String SQL_CREATE_BankKonto = "CREATE TABLE if not exists Bankkonto (Kontonummer varchar(150) NOT NULL, Kontonavn varchar(150), Balansen long, SystemID int not null , PRIMARY KEY (Kontonummer),FOREIGN KEY (SystemID) REFERENCES Banksystem(SystemID))";
    public static final String SQL_CREATE_Transaksjoner = "CREATE TABLE if not exists Transaksjoner(Referansenummer int NOT NULL AUTO_INCREMENT, Kontonummer varchar(150) not null, Sum int, PRIMARY KEY (Referansenummer), FOREIGN KEY (Kontonummer) REFERENCES Bankkonto(Kontonummer))";

}