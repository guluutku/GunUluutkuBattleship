
import javax.xml.transform.Result;
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

    // Login players if username and password are correct
    public void LoginDB(String username, String password) {
        try{
            int ID = 0;
            int score;
            String query = "SELECT ID, userName, score FROM players " +
                    "WHERE userName = '"+username+"' AND password = '"+password+"'  ";
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ID = rs.getInt("ID");
            score = rs.getInt("score");
            System.out.println(password);
            if (ID != 0){
                new MainMenu(username,score);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
