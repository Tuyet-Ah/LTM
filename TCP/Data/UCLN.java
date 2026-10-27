package TCP.Data;
import java.io.*;
import java.util.*;
import java.net.*;

public class UCLN
{
    static int ucln(int a, int b)
    {
        if(b == 0) return a;
        return ucln(b, a %b);
    }
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

        int uc = ucln(a, b);
        int bc = a * b / uc;
        System.out.println(uc + " " + bc + " " + tong + " " + tich);
        out.write(uc);
        out.write(bc);
        out.write(tong);
        out.write(tich);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
