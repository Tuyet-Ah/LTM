package RMI;
import java.io.*;
import java.util.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;


public class TKSoThucNangCao
{
    public static void main(String []args) throws Exception
    {
        Registry registry = LocateRegistry.getRegistry("36.50.135.242", 1099);
        DataService service = (DataService) registry.lookup("RMIDataService");

        String studentCode = "B23DCCN056";
        String qCode = "cdkDeYYb";

        String s = (String) service.requestData(studentCode, qCode);

        String[] parts = s.split(",");
        int n = parts.length;
        double[] a = new double[n];

        for(int i = 0; i < n; ++i)
        {
            a[i] = Double.parseDouble(parts[i].trim());
        }

        double sum = 0;
        for(int i = 0; i < n; ++i)
        {
            sum += a[i];
        }

        double avg = sum / n;

        double variance = 0;
        for(int i = 0; i < n; ++i)
        {
            variance += Math.pow(a[i] - avg, 2);
        }

        double stddev = Math.sqrt(variance/n);

        Arrays.sort(a);

        int index = (int)Math.ceil(n * 0.95) - 1;
        double p95 = a[index];

        String result = String.format( Locale.US,
                "average=%.2f;stddev=%.2f;p95=%.2f",
                avg, stddev, p95);

        service.submitData(studentCode, qCode, result);

    }


}
