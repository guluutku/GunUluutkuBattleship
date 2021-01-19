import java.io.*;
import java.net.Socket;

public class ClientPlayer extends LogIn {

    public ClientPlayer(String title) {
        super(title);
    }

    public static void main(String[] args) throws IOException {

        // socket object
        Socket socket = new Socket("127.0.0.1", 7777);
        System.out.println("Connected!");

        // get the output stream from the socket.
        OutputStream outputStream = socket.getOutputStream();

        // create a data output stream from the output stream so we can send data through it
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        // goes log-in page when connect to the server
        new LogIn("Client Player");

    }

}
