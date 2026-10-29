package RMI;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.rmi.*;
import java.util.*;
import java.rmi.registry.*;
import java.io.*;
import java.net.*;

public class LanXuatHienItNhat
{
    public static void main (String[] args)throws Exception
    {
        Registry registry = LocateRegistry.getRegistry("36.50.135.242",1099);
        ByteService service = (ByteService) registry.lookup("RMIByteService");

        String studentCode = "B23DCCN056";
        String qCode = "u38ujUFH";

        byte[] data = service.requestData(studentCode, qCode);

        Map<Byte, Integer> count = new LinkedHashMap<>();

        for(byte x : data)
        {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int min = Integer.MAX_VALUE;

        for(int value: count.values())
        {
            if(value < min)
                min = value;
        }

        byte[] result = new byte[2];

        for(Map.Entry<Byte, Integer> entry : count.entrySet())
        {
            if(entry.getValue() == min)
            {
                result[0] = entry.getKey();
                result[1] = (byte) (int) entry.getValue();
                break;
            }
        }

        service.submitData(studentCode, qCode, result);
    }


}
