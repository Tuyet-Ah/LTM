package UDP;
import java.util.*;
import java.io.*;
import java.net.*;
public class String2
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("36.50.135.242");
        int sP = 2208;

        String code = ";B23DCCN056;tOCgEHhp";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA,sP);
        socket.send(dpGui);

        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        String receivedMs = new String(dpNhan.getData(), 0, dpNhan.getLength());
        String []part = receivedMs.split(";");
        String requestID = part[0];
        String []mang = part[1].split("\\s+");
        String answer = "";
        for(String chuoi : mang)
        {
            chuoi = chuoi.toLowerCase();
            char dau = chuoi.charAt(0);
            String res = Character.toUpperCase(dau) + chuoi.substring(1);
            answer += res + " ";
        }

        String ans  = requestID + ";" + answer;

        DatagramPacket dpGui2 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui2);
        socket.close();
    }
}
