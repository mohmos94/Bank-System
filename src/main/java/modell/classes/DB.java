package modell.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class DB {
    public static final String Connection_String ="jdbc:mysql://localhost:3306/banksystem";
    public static final String user = "root";
    public static final String password  = "Nettavisen123+";
    public static Connection con = null;
    public static Statement stat;
    public static PreparedStatement ps = null;
    Scanner scanner;

    String sql = "CREATE DATABASE BankSystem";
    public static final String SQL_CREATE_Kunde = "CREATE TABLE if not exists Kunde(Fødelsnummer  varchar(150) not null, Fornavn varchar(150),  Etternavn varchar(150), Telefon varchar(8), Email varchar(150), PRIMARY KEY (Fødelsnummer))";
    public static final String SQL_CREATE_BankSystem = "CREATE TABLE if not exists Banksystem(SystemID int NOT NULL AUTO_INCREMENT, Brukernavn varchar(150), Passord varchar(150), Fødeslsnummer int NOT NULL, PRIMARY KEY (SystemID),FOREIGN key (Fødeslsnummer) references Kunde(Fødeslsnummer))";
    public static final String SQL_CREATE_BankKonto = "CREATE TABLE if not exists Bankkonto(Kontonummer int NOT NULL, Kontonavn varchar(150), Balansen long, SystemID int , PRIMARY KEY (Kontonummer),FOREIGN KEY (SystemID) REFERENCES Banksystem(SystemID))";
    public static final String SQL_CREATE_Transaksjoner = "CREATE TABLE if not exists Transaksjoner(Referansenummer int NOT NULL AUTO_INCREMENT, Kontonummer int, Sum int, PRIMARY KEY (Referansenummer), FOREIGN KEY (Kontonummer) REFERENCES Bankkonto(Kontonummer))";

}