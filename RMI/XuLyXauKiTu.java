package RMI;
import java.io.*;
import java.net.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
public class XuLyXauKiTu
{
    public static void main(String []args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("B23DCCN056", 1099);

        CharacterService service = (CharacterService) registry.lookup("RMICharacterService");

        String s = service.requestCharacter("B23DCCN056", "mabai").toString();

        if(s.startsWith("{")) s = s.substring(1);
        if(s.startsWith("}")) s = s.substring()


    }
}
