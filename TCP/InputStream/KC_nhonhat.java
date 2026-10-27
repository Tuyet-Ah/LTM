package TCP.InputStream;
import java.util.*;
import java.io.*;
import java.net.*;

public class KC_nhonhat
{
    public static void main(String[]args) throws Exception
    {
        Socket socket = new Socket("36.50.135.242", 2206);
        InputStream in = new DataInputStream(socket.getInputStream());
        OutputStream out= new DataOutputStream(socket.getOutputStream());

        String ma = "B23DCCN056;GglBrUQB";
        out.write(ma.getBytes());
        out.flush();

        byte buffer[] = new byte[1024];
        int len = in.read(buffer);
        String s = new String(buffer, 0, len);
        System.out.println(s);

        String a[] = s.split(",");
        ArrayList<Long>list = new ArrayList<>();
        for(String x : a)
        {
            list.add(Long.parseLong(x));
        }
        long max1 = 0;
        long max2 = 0;
        long kc = Long.MAX_VALUE;
        Collections.sort(list);
        for(int i = 1; i < a.length; ++i)
        {
            long hieu = list.get(i) - list.get(i - 1);
            if(hieu < kc)
            {
                kc = hieu;
                max1 = list.get(i);
                max2 = list.get(i - 1);
            }
        }
        String res = kc + "," + max2 + "," + max1;
        System.out.println(res);

        out.write(res.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }

}
