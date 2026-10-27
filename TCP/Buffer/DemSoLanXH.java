package TCP.Buffer;
import java.util.*;
import java.io.*;
import java.net.*;

public class DemSoLanXH
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

        String s = in.readLine().trim();
        System.out.println(s);

        int cnt[] = new int[256];
        for(char c : s.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
                cnt[c]++;
        }

        String res = "";
        for(char c : s.toCharArray())
        {
            if(Character.isLetterOrDigit(c) && cnt[c] > 1)
                res += c + ":" + cnt[c] + ",";
            cnt[c] = 0;
        }
        System.out.println(res);

        out.write(res);
        out.newLine();
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
