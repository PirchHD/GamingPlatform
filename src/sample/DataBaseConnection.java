package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection dataBaseLink;

    public Connection getConnection(){
        // try username = PirchHD, 123
        String nameDataBase = "login_db";
        String databaseUser = "root";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/" + nameDataBase + "?serverTimezone=UTC";

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
