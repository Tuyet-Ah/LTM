package TCP.Data;
import java.util.*;
import java.io.*;
import java.net.*;
public class TongTich
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("36.50.135.242", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String ma = "B23DCCN056;2oIIJbJr";
        out.writeUTF(ma);
        out.flush();

        int a = in.readInt(), b = in.readInt();
        System.out.println(a);
        System.out.println(b);

        int tong = 0, tich = 1;
        tong = a + b;
        tich = a * b;
        System.out.println(tong + " " + tich);

        out.writeInt(tong);
        out.writeInt(tich);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }

}
