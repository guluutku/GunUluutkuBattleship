import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPlayer extends LogIn {

    PrintWriter out;

    public ServerPlayer(String title) {
        super(title);
    }

    public void run() throws IOException{

        ServerSocket serverSocket = new ServerSocket (4444);
        Socket clientSocket = serverSocket.accept ();

        out = new PrintWriter (clientSocket.getOutputStream (), true);

        BufferedReader in = new BufferedReader (new InputStreamReader(clientSocket.getInputStream ()));

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }

    public static void main(String[] args) throws IOException{
        LogIn ln = new LogIn("Server Player");
    }

}
