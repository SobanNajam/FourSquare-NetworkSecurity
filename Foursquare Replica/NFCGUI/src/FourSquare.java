
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;


public class FourSquare extends Thread{
    
    
    //<editor-fold defaultstate="collapsed" desc="Attributes">
    static PublicKey userPublic;
    KeyPair pair2;
    static PrivateKey fsPrivate;
    static PublicKey fsPublic; 
    private PrintWriter fspublickey;
    String re_enc_timeClear,re_enc_nonceClear,re_enc_uid,re_enc_nonce;
     private static final String Venue_PUBLIC_KEY_BASE64 =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKkC/b2fjIdS8atGeX/cOP8YWeEypeGnB1ICap\n" +
            "dWajoUGGXWbl3410gZopmcXbN9imMmNNs7I9KsOKJj6b7PzP4/p74da55kaht0l63603iKandHAw\n" +
            "7PeTWpHhJ3l12tAtvtiKppHqoY4IJDunOCHjB1fpmCkEX9JQ+a3vFl1/5wIDAQAB";
    private PrintWriter nfcFile;

     //</editor-fold>
    
    
    public FourSquare() {
        try {
            //<editor-fold defaultstate="collapsed" desc="Generate public and private Keys and Share Public Key ">
            KeyPairGenerator keyGen2 = KeyPairGenerator.getInstance("RSA");
            SecureRandom random2 = SecureRandom.getInstance("SHA1PRNG", "SUN");
            
            keyGen2.initialize(1024, random2);
            
            pair2 = keyGen2.generateKeyPair();
            fsPrivate = pair2.getPrivate();
            fsPublic =  pair2.getPublic();
            fspublickey = new PrintWriter("S:\\CN Common space\\file2","UTF-8");
            fspublickey.println(pair2.getPublic());
            fspublickey.close();
            //</editor-fold>
            
        } catch (Exception ex) {
            Logger.getLogger(FourSquare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Functions">
    
    @Override
    public void run() {
       while(true){ try {
            sleep(5000);
            checkForRequests();
        } catch (Exception ex) {
            Logger.getLogger(FourSquare.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       }
    }
    
    
    public byte[] DecryptUserPublic(byte[] encryptedMessage)
    {
        byte[] decryptedMessage = null;
        
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            //PrivateKey privateKey = getPrivateKey(privateKeyContentsAsByteArray);
            cipher.init(Cipher.DECRYPT_MODE, userPublic);
            decryptedMessage = cipher.doFinal(encryptedMessage);
        }
        catch (Throwable t) {System.out.println(t.getMessage());}
        
        return decryptedMessage;
    }
    
    public byte[] decryptFSPrivate(byte[] encryptedMessage)
    {
        byte[] decryptedMessage = null;
        
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            //PrivateKey privateKey = getPrivateKey(privateKeyContentsAsByteArray);
            cipher.init(Cipher.DECRYPT_MODE, fsPrivate);
            decryptedMessage = cipher.doFinal(encryptedMessage);
        }
        catch (Throwable t) {System.out.println(t.getMessage());}
        
        return decryptedMessage;
    }
    
     private static void regenerateKey() throws InvalidKeySpecException, NoSuchAlgorithmException, FileNotFoundException{
         Scanner in = new Scanner(new File("S:\\CN Common space\\file"));
         in.nextLine();
         in.next();
         
         String modulusString = in.nextLine();
         //String exponentString = "18bc01730656bde47476f7cfbd3d8f9e15ede9c389814672dc161e349b08627fc885fe9d2442ae92f0214c7e97cf0b9a9fc876df4f53517ab63d710f997b2779";
         
         in.next();
         in.next();         
         String publicExponentString = in.nextLine();

        // Load the key into BigIntegers
         BigInteger modulus = new BigInteger(modulusString.replace(" ", ""));
        //BigInteger exponent = new BigInteger(exponentString, 16);
         BigInteger pubExponent = new BigInteger(publicExponentString.replace(" ", ""));

        // Create private and public key specs
        //RSAPrivateKeySpec privateSpec = new RSAPrivateKeySpec(modulus, exponent);
         RSAPublicKeySpec publicSpec = new RSAPublicKeySpec(modulus, pubExponent);

        // Create a key factory
         KeyFactory factory = KeyFactory.getInstance("RSA");

        // Create the RSA private and public keys
         //PrivateKey priv = factory.generatePrivate(privateSpec);
         userPublic = factory.generatePublic(publicSpec);
 
    
 }

     
     private void checkForRequests() throws Exception {
        Scanner in = new Scanner(new File("S:\\CN Common space\\nfc"));
        int checksum = in.nextInt();
        in.close();

        if (checksum == 5) {
            System.out.println("Starting FS");
            startDecrypting();
        } else {
            System.out.println("Failing FS on "+checksum);
        }

    }

     
    private void startDecrypting() throws Exception {
        GetData();
        final RandomSymmetricCipher cipher2 = new RandomSymmetricCipher();
        final byte[] decTime = cipher2.decrypt(re_enc_timeClear, Venue_PUBLIC_KEY_BASE64);
        final byte[] decNonceClear = cipher2.decrypt(re_enc_nonceClear, Venue_PUBLIC_KEY_BASE64);
        System.out.println("\nnonce = ");
        for(byte x:decNonceClear){
          System.out.print(Character.valueOf((char)x));
        }
        System.out.println("\n");
        final byte[] de_re_Uid = cipher2.decrypt(re_enc_uid, Venue_PUBLIC_KEY_BASE64);
        
        final byte[] de_re_Nonce = cipher2.decrypt(re_enc_nonce, Venue_PUBLIC_KEY_BASE64);
        
        byte[] origUID = decryptFSPrivate(de_re_Uid);
        regenerateKey();
        
        
        byte[] origNonce = DecryptUserPublic(de_re_Nonce);
        
        
 
        System.out.println("\nThe Decrypted TEXT is : ");
 
        System.out.println("\nnonceOrg = ");
        for(byte x:origNonce){
          System.out.print(Character.valueOf((char)x));
        }
        System.out.println("\nUID = ");
        
        for(byte x:origUID){
          System.out.print(Character.valueOf((char)x));
        }
        nfcFile = new PrintWriter("S:\\CN Common space\\nfc", "UTF-8");
            nfcFile.print("0");
        nfcFile.close();
        System.out.println("");
    }

    private void GetData() {
        try {
            Scanner in = new Scanner(new File("S:\\CN Common space\\data"));
            
            re_enc_nonce =in.nextLine();
            re_enc_uid = in.nextLine();
            re_enc_nonceClear = in.nextLine();
            re_enc_timeClear = in.nextLine();
            
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FourSquare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     //</editor-fold>


    

}
