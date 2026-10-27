package TCP.Buffer;
import java.util.*;
import java.io.*;
import java.net.*;
public class SapXepChuoi
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("36.50.135.242", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String ma = "B23DCCN056;QojtngWH";
        out.write(ma);
        out.newLine();
        out.flush();

        
    }
}
