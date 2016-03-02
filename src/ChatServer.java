import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public ChatServer() {
        try {
            ServerSocket ss = new ServerSocket(6789);
            Socket s = ss.accept();
            OutputStream os = s.getOutputStream();
            InputStream is = s.getInputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            ObjectInputStream ois = new ObjectInputStream(is);

            oos.writeObject("message");
            oos.writeObject("Hi client. Your IP is: " + s.getInetAddress());

            is.close(); os.close();
            s.close();
            ss.close();
        }
        catch (Exception e) {e.printStackTrace();} }

    public static void main(String[] args) {
        new ChatServer();
    }
}
