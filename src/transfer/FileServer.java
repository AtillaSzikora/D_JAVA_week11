package transfer;

import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

    final String folderPath= "c:\\gdrive\\";

    public FileServer() {
        try {
            ServerSocket ss = new ServerSocket(6789);
            Socket s = ss.accept();
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            File f = (File) ois.readObject();
            File destination = new File(folderPath + f.getName());
            save(destination, s.getInputStream(), f.length());
            s.close();
            ss.close(); }
        catch (Exception e) {e.printStackTrace();} }

    private void save(File f, InputStream is, long fileSize) {}

    public static void main(String[] args) {
        new FileServer();
    }
}
