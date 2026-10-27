package UDP;
import java.io.*;
import java.net.*;
import java.util.*;

public class DataType1
{
    public static void main (String[] args) throws Exception
    {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("36.50.135.242");
        int sP = 2207;

        String code = ";B23DCCN056;GPSpCUxg";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket (buffer, buffer.length);
        socket.receive(dpNhan);

        String received = new String(dpNhan.getData(), 0, dpNhan.getLength());
        String []part = received.split(";");
        String requestID = part[0];
        int n = Integer.parseInt(part[1]);
        String[] number = part[2].split(",");

        Set<Integer> set = new HashSet<>();
        for(String num : number)
        {
            if(!num.trim().isEmpty())
                set.add(Integer.parseInt(num.trim()));
        }

        List<String> miss = new ArrayList<>();
        for(int i = 1; i <=n ;++i)
        {
            if(!set.contains(i))
                miss.add(String.valueOf((i)));
        }

        String missing = String.join(",", miss);
        String response = requestID + ";" + missing;
        System.out.println(response);

        DatagramPacket dpGui2 = new DatagramPacket(response.getBytes(), response.length(), sA, sP);
        socket.send(dpGui2);

        socket.close();

    }
}
