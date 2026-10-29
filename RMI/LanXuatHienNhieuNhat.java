package RMI;
import java.io.*;
import java.util.*;
import java.rmi.*;
import java.net.*;
import java.rmi.registry.*;
public class LanXuatHienNhieuNhat
{
    public static void main(String[] args) throws Exception
    {
        Registry registry = LocateRegistry.getRegistry("36.50.135.242",1099);
        ByteService service = (ByteService) registry.lookup("RMIByteService");

        String studentCode = "B23DCCN056";
        String qCode = "9gKfsCKj";

        byte[] data = service.requestData(studentCode, qCode);

        Map<Byte, Integer> map = new LinkedHashMap<>();

        for(byte x : data)
        {
            map.put(x, map.getOrDefault(x, 0)+ 1);
        }
        int max = Integer.MIN_VALUE;

        for(int value : map.values())
        {
            if(value > max)
                max = value;
        }

        byte[] result = new byte[2];

        for(Map.Entry<Byte, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == max)
            {
                result[0] = entry.getKey();
                result[1] = (byte) (int) entry.getValue();
                break;
            }
        }

        service.submitData(studentCode, qCode, result);

    }
}
