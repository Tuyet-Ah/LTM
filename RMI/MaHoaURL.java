package RMI;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.rmi.*;
import java.util.*;
import java.rmi.registry.*;

public class MaHoaURL
{
    public static void main (String[] args)throws Exception
    {
        Registry registry = LocateRegistry.getRegistry("36.50.135.242",1099);
        CharacterService service = (CharacterService) registry.lookup("RMICharacterService");
        String studentCode = "B23DCCN056";
        String qCode = "NhZnoTX3";

        String s = service.requestCharacter(studentCode, qCode);

        String encode = new URI(null, null, s, null).toASCIIString();

        service.submitCharacter(studentCode, qCode, encode);

    }


}
