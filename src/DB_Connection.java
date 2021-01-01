import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Connection to the database; reads, updates data
public class DB_Connection {

    //database url
    private String url = "jdbc:sqlite:battleship.db";
    private Connection conn = null;

    // Creates a new row when a new player signs-up
    public void CreateNewPlayer(String userName, char[] password) {
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
    public void LoginDB(String username, char[] password) {
        String query = "SELECT password FROM players " +
                "WHERE userName == '"+username+"' AND password == '"+password+"'  ";
        try{
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            new MainMenu();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
