package RMI;
import java.util.*;
import java.util.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
public class ChuyenDoiBatPhan
{
    public static void main(String[] args) throws Exception
    {
        Registry registry = LocateRegistry.getRegistry("36.50.135.242", 1099);
        ByteService service = (ByteService) registry.lookup("RMIByteService");
        byte[] a = service.requestData("B23DCCN056", "HhPAxeDw");

        String res = "";
        for(byte x : a)
        {
            res += String.format("%03o", x & 0xFF);
        }
        byte[] ans = res.toString().getBytes();
        service.submitData("B23DCCN056", "HhPAxeDw", ans);


    }
}
