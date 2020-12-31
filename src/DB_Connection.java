import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {

    private String url = "jdbc:sqlite:battleship.db";
    private Connection conn = null;

    public DB_Connection(){
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to the database");
        } catch (SQLException e){
            System.out.println("Problem with DB connection: " + e.getMessage());
        }
    }

    // Creates a new row when a new player signs-up
    public void CreateNewPlayer() {
        String query = "INSERT INTO players (userName, password, score) VALUES('Ali', 134, 12)";
        try{
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            int rv = stmt.executeUpdate(query);
            System.out.println("Execute" + rv);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
