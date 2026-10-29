package RMI;
import java.io.*;
import java.util.*;
import java.rmi.registry.*;
import java.rmi.*;

public class SoLaMa
{
    public static String trans(int x)
    {
        int[] values = {1000, 900, 500, 400,100, 90, 50, 40, 10, 9 ,5 ,4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String ans = "";
        for(int i = 0; i< values.length; ++i)
        {
            while(x >= values[i])
            {
                ans += symbols[i];
                x -= values[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception
    {
        Registry registry = LocateRegistry.getRegistry("36.50.135.242", 1099);

        CharacterService service = (CharacterService) registry.lookup("RMICharacterService");
        String studentCode = "B23DCCN056";
        String qCode = "EKV9TH6P";

        String s = service.requestCharacter(studentCode, qCode);

        int n = Integer.parseInt(s.trim().split("\\s+")[0]);

        String roman = trans(n);
        System.out.println(roman);
        service.submitCharacter(studentCode, qCode, roman);
    }
}