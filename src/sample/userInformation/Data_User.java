package sample.userInformation;

import sample.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data_User {
    public static String username;
    public static String firstname;
    public static String lastname;
    public static String password;

    public Data_User(String username) {
        username = this.username;
    }

    public void getDataFromDatabase(){
        try {
            Connection con = new DataBaseConnection().getConnection();
            Statement myStmt = con.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from users_information WHERE username = '" + username + "';");
            while (myRs.next()) {
                this.username = myRs.getString("username");
                this.firstname = myRs.getString("firstname");
                this.lastname = myRs.getString("lastname");
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void changeDataToDatabase(){
        try {
            Connection con = new DataBaseConnection().getConnection();
            Statement myStmt = con.createStatement();
// UPDATE users_information SET firstname= 'Szymon', lastname = 'Prochal' WHERE username = 'PirchHD';
            ResultSet myRs = myStmt.executeQuery("UPDATE user_information SET firstname= " + "WHERE username = '" + username + "';");
            while (myRs.next()) {
                this.username = myRs.getString("username");
                this.firstname = myRs.getString("firstname");
                this.lastname = myRs.getString("lastname");
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}



