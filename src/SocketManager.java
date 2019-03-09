import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketManager {

    private Socket socket;
    private PrintWriter out;

    public SocketManager(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Socket opened successfully!");
    }

    public void sendCooridnates(int x, int y) {
        System.out.println("Sending coordinates to Karel: [" + x + "," + y + "]");
        System.out.println("Is socket connected: " + socket.isConnected());
        out.println(x + " " + y + " ");
    }

    public void stopConnection() throws IOException {
        out.close();
        socket.close();
    }

}