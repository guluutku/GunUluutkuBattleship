import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPlayer extends LogIn {

    public ServerPlayer(String title) {
        super(title);
    }

    public static void main(String[] args) throws IOException{

        ServerSocket ss = new ServerSocket(7777);
        System.out.println("ServerSocket awaiting connections...");
        Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Connection from " + socket + "!");

        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();

        // create a DataInputStream so we can read data from it.
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        System.out.println(dataInputStream.readUTF());

    }

}
