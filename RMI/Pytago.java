package RMI;
import java.io.*;
import java.net.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
public class Pytago
{
    public static void main(String []args) throws Exception
    {
        Registry registry = LocateRegistry.getRegistry("26.50.135.242", 1099);

        DataService service = (DataService) registry.lookup("RMIDataService");

        Object s = service.requestData("B23DCCN056", "NMATI6Zw");
        int n = Integer.parseInt(s.toString());

        List <List<Integer>> pytago = new ArrayList<>();

        for(int x = 1; x <= n; ++x)
        {
            for(int y = 1; y < x; ++y)
            {
                for(int z = 1; z  <y; ++z)
                {
                    if(z * z + y * y == x * x)
                    {
                        List <Integer> trip = new ArrayList<>();
                        trip.add(z);
                        trip.add(y);
                        trip.add(x);
                        pytago.add(trip);
                    }
                }
            }
        }
        service.submitData("B23DCCN056", "NMATI6Zw", pytago);

    }
}
