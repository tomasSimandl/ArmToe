import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.stream.Stream;

public class SocketManager {

    private Socket socket;
    private PrintWriter out;
    private OutputStream stream;

    public SocketManager(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        stream = socket.getOutputStream();
        System.out.println("Socket opened successfully!");
    }

    public void sendCooridnates(int x, int y) throws IOException {
        System.out.println("Sending coordinates to Karel: " + String.valueOf(x) + y);
        System.out.println("Is socket connected: " + socket.isConnected());
        stream.write(x);
        stream.write(y);
        stream.flush();
    }

    public void stopConnection() throws IOException {
        out.close();
        socket.close();
    }

}