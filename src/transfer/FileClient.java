package transfer;

import java.io.*;
import java.net.Socket;

public class FileClient {

    File f;

    public FileClient(File f) {
        this.f = f;
        try {
            Socket s = new Socket("localhost", 6789);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(f);
            loadAndSend(s.getOutputStream());
            oos.close();
            s.close(); }
        catch (Exception e) {e.printStackTrace();} }

    public void loadAndSend(OutputStream os) {
        try {
            FileInputStream fis = new FileInputStream(f);
            int i;
            while ((i = fis.read()) > -1) {os.write(i);}
        fis.close(); }
        catch (Exception e) {e.printStackTrace();} }

    public static void main(String[] args) {
        File f = new File("c:\\gdrive\\rhcp.mp3");
        new FileClient(f);
    }
}
