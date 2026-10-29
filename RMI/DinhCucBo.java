package RMI;
import java.io.*;
import java.util.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;


public class DinhCucBo
{
    public static void main(String[] args) throws Exception
    {
        Registry registry = LocateRegistry.getRegistry("36.50.135.242", 1099);

        DataService service = (DataService) registry.lookup("RMIDataService");

        String studentCode = "B23DCCN056";
        String qCode = "xGB8Es8L";

        Object obj = service.requestData(studentCode, qCode);

        int[] a = (int[]) obj;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < a.length; ++i)
        {
            if(i == 0)
            {
                if(a.length > 1 && a[i] > a[i + 1])
                    result.add(i + 1);
            }
            else if (i == a.length - 1)
            {
                if(a[i] > a[i - 1])
                    result.add(i + 1);
            }
            else
            {
                if(a[i] > a[i - 1] && a[i] > a[i + 1])
                    result.add(i + 1);
            }
        }
        service.submitData(studentCode, qCode, result);
    }
}
