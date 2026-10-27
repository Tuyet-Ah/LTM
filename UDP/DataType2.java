package UDP;
import java.io.*;
import java.net.*;
import java.util.*;

public class DataType2
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("36.50.135.242");
        int sP = 2207;

        String code = ";B23DCCN056;ewpE0p8B";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),sA, sP);
        socket.send(dpGui);

        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        String receivedString = new String(dpNhan.getData(), 0, dpNhan.getLength());
        String []part = receivedString.split(";");
        String requestID = part[0];
        String[] mang = part[1].split(",");
        List<Integer> list = new ArrayList<>();

        for(String num : mang)
        {
            list.add(Integer.parseInt(num));
        }
        Collections.sort(list);

        int mi = list.get(0);
        int ma = list.get(list.size() - 1);

        String send = requestID + ";" + ma + "," + mi;
        DatagramPacket dpGui2 = new DatagramPacket(send.getBytes(), send.length(), sA, sP);
        socket.send(dpGui2);
        socket.close();
    }
}
