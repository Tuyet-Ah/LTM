import java.io.*;
import java.net.*;
import java.util.*;

public class LonThuHai
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("36.50.135.242", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        String ma = "B23DCCN056; GglBrUQB";
        out.write(ma.getBytes());
        out.flush();

        byte buffer[] = new byte[1024];
        int len = in.read(buffer);

        String s = new String(buffer, 0, len).trim();
        System.out.println(s);
        s = s.replace(",", " ").trim();
        String a[] = s.split("\\s+");
        ArrayList<Long> list = new ArrayList<>();
        for(String x : a)
        {
            list.add(Long.parseLong(x));
        }

        long res = Long.MAX_VALUE;
        Long a1 = 1L * (-1);
        Long a2 = 1L * (-1);
        Collections.sort(list);
        for(int i = 1; i < list.size(); ++i)
        {
            Long tmp = list.get(i) - list.get(i - 1);
            if(tmp <= res)
            {
                res = tmp;
                a1 = list.get(i - 1);
                a2 = list.get(i);
            }
        }
        String kq = res + "," + a1 + "," + a2;
        System.out.println(kq);

        out.write(kq.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
