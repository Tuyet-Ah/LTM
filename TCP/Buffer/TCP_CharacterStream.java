import java.io.*;
import java.net.*;
import java.util.*;


public class TCP_CharacterStream
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("36.50.135.242", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String ma = "B23DCCN056;QhcWKEJs";
        out.write(ma);
        out.newLine();
        out.flush();

        String s = in.readLine().trim();
        System.out.println(s);

        String[] save = s.split(",");
        List<String> edu = new ArrayList<>();
        for(String x : save)
        {
            String tmp = x.trim();
            if(tmp.endsWith(".edu"))
                    edu.add(tmp);
        }

        String res = String.join(", ", edu);
        System.out.println(res);

        out.write(res);
        out.newLine();
        out.flush();

        in.close();
        out.close();
        socket.close();


    }

}
