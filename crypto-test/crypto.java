//Java imports
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Security;
 
//Javax imports
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

//FlexiCore import
import de.flexiprovider.core.FlexiCoreProvide;

public final class TestCrypt {
    public static void main (String[] args) throws Exception {
        Security.addProvider(new FlexiCoreProvider());
        
        Cipher cipher = Cipher.getInstance("AES128_CBC", "FlexiCore");
        KeyGenerator keyGen = KeyGenerator.getInstance("AES", "FlexiCore");
        
        print(keyGen);
    }
}