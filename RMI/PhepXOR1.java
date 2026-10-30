package RMI;
import java.io.*;
import java.util.*;
import java.rmi.*;
import java.net.*;
import java.rmi.registry.*;

public class PhepXOR1
{
    public static void main(String []args) throws Exception
    {
        Registry registry = LocateRegistry.getRegistry("36.50.135.242", 1099);

        CharacterService service = (CharacterService) registry.lookup("RMICharacterService");

        String s = service.requestCharacter("B23DCCN056", "Xidb0Thk");

        String[] tmp = s.split(";");

        String xorKey = tmp[0], inp = tmp[1], res = "";
        for(int i = 0; i < inp.length(); ++i)
            res += (char) (inp.charAt(i) ^ xorKey.charAt(i % xorKey.length()));

        service.submitCharacter("B23DCCN056", "Xidb0Thk", res);
    }
}
