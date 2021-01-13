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
            String query = "SELECT ID FROM players " +
                    "WHERE userName = '"+username+"' AND password = '"+password+"'  ";
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println(password);
            new MainMenu("g",1);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
