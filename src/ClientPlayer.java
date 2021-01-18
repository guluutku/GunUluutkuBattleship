import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientPlayer extends LogIn {

    PrintWriter out = null;

    public void run() throws IOException{

        Socket socket = new Socket ("127.0.0.1", 4444);

        BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream ()));

        out = new PrintWriter(socket.getOutputStream (), true);

        String inputLine;

        out.close();

        in.close();

        socket.close();

    }

    public ClientPlayer(String title) {
        super(title);
    }

    public static void main(String[] args) throws IOException {

       LogIn ln = new LogIn("Client Player");

    }

}
