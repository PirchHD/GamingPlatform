package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection dataBaseLink;

    public Connection getConnection(){
        String nameDataBase = "gaming_db";
        String databaseUser = "pirch_root";
        String databasePassword = "f185dbb0";
        String url = "jdbc:mysql://db4free.net:3306/gaming_db?server=1&db=gaming_db";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            dataBaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return dataBaseLink;
    }

}
