
import java.sql.*;

// Connection to the database; reads, updates data
public class DB_Connection {

    //database url
    private String url = "jdbc:sqlite:battleship.db";
    private Connection conn = null;

    // Creates a new row when a new player signs-up
    public void CreateNewPlayer(String userName, String password) {
        String query = "INSERT INTO players (userName, password, score) VALUES('"+userName+"', '"+password+"', 0)";

        try{
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("New player added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* Already created usernames and passwords

    damina - damina1234
    geralt - geralt1234
    elvenmal - elvenmak1234

     */
    // Login players if username and password are correct
    public void LoginDB(String username, String password) {
        try{
            int ID = 0;
            int score;

            // database query to find user
            String query = "SELECT ID, userName, score FROM players " +
                    "WHERE userName = '"+username+"' AND password = '"+password+"'  ";

            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ID = rs.getInt("ID");
            score = rs.getInt("score");

            // if there is a account go to main menu with user's name and score
            if (ID != 0){
                new MainMenu(ID, username, score);
            }

            conn.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // updates player's score after the game
    public void updateScore(int ID, int score){
        try{
            int sc = score;

            String query = "UPDATE players SET score = '"+sc+"' WHERE ID = '"+ID+"' ";

            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);

            conn.close();

            System.out.println("Score Updated");
        } catch (SQLException e){
            System.out.println(e);
        }
    }

}
