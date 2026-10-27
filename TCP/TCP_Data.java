import java.util.*;
import java.io.*;
import java.net.*;


public class TCP_Data
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("36.50.135.242", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String ma = "B23DCCN056;9wmKqPY6";
        out.writeUTF(ma);
        out.flush();

        String s = in.readUTF();
        int d = in.readInt();

        System.out.println(s + " " + d);
        String res = "";
        for(char x : s.toCharArray())
        {
            if(Character.isLetter(x))
            {
                char base = Character.isUpperCase(x) ?'A' : 'a';
                char tmp = (char) (((x - base - d) % 26 + 26) % 26 + base);
                res += tmp;
            }
            else res += x;
        }
        System.out.println(res);

        out.writeUTF(res);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
