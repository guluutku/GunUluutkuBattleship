import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Connection to the database; reads, updates data
public class DB_Connection {

    //database url
    private String url = "jdbc:sqlite:battleship.db";
    private Connection conn = null;

    // Start of the system checks database connection
    public DB_Connection(){
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to the database");
        } catch (SQLException e){
            System.out.println("Problem with DB connection: " + e.getMessage());
        }
    }

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

}
