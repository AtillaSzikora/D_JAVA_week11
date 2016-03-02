package transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

    final String folderPath= "c:\\music\\";

    public FileServer() {
        try {
            ServerSocket ss = new ServerSocket(6789);
            Socket s = ss.accept();
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            File f = (File) ois.readObject();
            File destination = new File(folderPath + f.getName());
            save(destination, s.getInputStream(), f.length());
            ois.close();
            s.close();
            ss.close(); }
        catch (Exception e) {e.printStackTrace();} }

    private void save(File f, InputStream is, long fileSize) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            int i;
            byte[] buffer = new byte[4096];
            while ((i = is.read(buffer)) > -1) {fos.write(buffer);}
        fos.close(); }
        catch (Exception e) {e.printStackTrace();} }

    public static void main(String[] args) {
        new FileServer();
    }
}
