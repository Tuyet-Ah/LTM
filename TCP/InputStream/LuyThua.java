package TCP.InputStream;
import java.util.*;
import java.io.*;
import java.net.*;

public class LuyThua
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket ("172.188.19.218", 1604);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        String ma = "B23DCCN056;nxMRj8z";
        out.write(ma.getBytes());
        out.flush();

        byte buffer[] = new byte[256];
        int len = in.read(buffer);
        String s = new String(buffer, 0, len);
        String mang[] = s.split("\\|");
        int a = Integer.parseInt(mang[0]);
        int b = Integer.parseInt(mang[1]);

        long kq = (long) Math.pow(a, b);
        System.out.println(kq);
        String res = "" + kq;
        out.write(res.getBytes());
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
