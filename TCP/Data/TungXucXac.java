package TCP.Data;
import java.io.*;
import java.util.*;
import java.net.*;
public class TungXucXac
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("36.50.135.242", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String ma = "B23DCCN056;2oIIJbJr";
        out.writeUTF(ma);
        out.flush();

        int n = in.readInt();
        System.out.println(n);

        int cnt[] = new int[7];
        for(int i = 0 ; i < n ;++i)
        {
            int roll = in.readInt();
            if(roll >= 1 && roll <= 6)
                cnt[roll]++;
        }
        for(int i = 1; i <= 6; ++i)
        {
            float res = (float) cnt[i] / n;
            System.out.println(cnt[i] + ":" + res);
            out.writeFloat(res);
        }

        out.flush();

        in.close();
        out.close();
        socket.close();

    }
}
