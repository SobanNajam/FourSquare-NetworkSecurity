
package classes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.swing.JOptionPane;

public class userThread  {
  
    //<editor-fold defaultstate="collapsed" desc="Attributes">
    private PrintWriter nfcFile;
    private  PrintWriter userpublickey;
    private String userId = "default";
    private PrintWriter dataFile;
    KeyPair pair1;
    static PrivateKey userPrivate;
    static PublicKey userPublic;
    static PublicKey FSPublic;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Socket Attributes 1">
    public Socket socket;
    public InputStream sin;
    public OutputStream sout;
    public DataInputStream in;
    public DataOutputStream out;
    public String line;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Socket Attributes 2">
    public Socket socket2;
    public InputStream sin2;
    public OutputStream sout2;
    public DataInputStream in2;
    public DataOutputStream out2;
    public String line2;
    //</editor-fold>
    private  static String modulusString;
    private static String publicExponentString;
        
    public userThread(PrivateKey pr,PublicKey pu,String user,Socket socketArg){
    
        userPrivate=pr;
        userPublic = pu;
        userId = user;
        
        try 
        {
       // socket = new Socket("127.0.0.1",6791);
        socket = socketArg;
        System.out.println("Connected to NFCDevice");
        sin = socket.getInputStream();
        sout = socket.getOutputStream();
        in = new DataInputStream(sin);
        out = new DataOutputStream(sout); 
        
        socket2 = new Socket("172.16.1.80", 6790);
        sin2 = socket2.getInputStream();
        sout2 = socket2.getOutputStream();
        in2 = new DataInputStream(sin2);
        out2 = new DataOutputStream(sout2);

        //read 2 things from FS
        
        readFSPublicKey();
        sendPublicKey();
        
          createSession();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
   

    private void createSession() 
    {
            try {
            //<editor-fold defaultstate="collapsed" desc="Request Nonce">
            
            //<editor-fold defaultstate="collapsed" desc="Redundant Code">
                nfcFile = new PrintWriter("S:\\CN Common space\\nfc", "UTF-8");
                nfcFile.print("1");
                nfcFile.close();
                //</editor-fold>
            out.writeUTF("1");
            System.out.println("\nJust sent 1 in stream\n");     
            //</editor-fold>
       
            //<editor-fold defaultstate="collapsed" desc="Step 1">
                
            //<editor-fold defaultstate="collapsed" desc="Redundant Code">
            /*
              Scanner in = new Scanner(new File("S:\\CN Common space\\nfc"));
              int checksum = in.nextInt();
              in.close();

                while (checksum != 2) {
                    sleep(1000);
                    //System.out.println("failing");
                    in = new Scanner(new File("S:\\CN Common space\\nfc"));
                    checksum = in.nextInt();
                    in.close();
                }
             */
            //</editor-fold>                
            
            line = in.readUTF(); //reads nonce into line string
            System.out.println("The nonce recieved is "+line);    
            
            //</editor-fold>
                               
            //<editor-fold defaultstate="collapsed" desc="Step 2">
                
            //<editor-fold defaultstate="collapsed" desc="Redundant Code">
            /*
            in = new Scanner(new File("S:\\CN Common space\\data"));
            String nonce = in.next();
            in.close();
            byte[] encryptedNonce = EncryptUserPrivate(nonce);  //Step 2
            
            getFSPublic();
            
            byte[] encryptedUID   = EncryptFSPublic(userId);    //Step 2
            
            dataFile = new PrintWriter("S:\\CN Common space\\data", "UTF-8");
            dataFile.println(encryptedNonce.length);
            dataFile.println(encryptedUID.length);
            dataFile.println(serializeData(encryptedNonce));
            dataFile.println(serializeData(encryptedUID));
            dataFile.close();
            
            nfcFile = new PrintWriter("S:\\CN Common space\\nfc", "UTF-8");
            nfcFile.print("3");
            nfcFile.close();
            */
            //</editor-fold>
            
            byte[] encryptedNonce = EncryptUserPrivate(line);
            getFSPublic();
            byte[] encryptedUID   = EncryptFSPublic(userId);  
            out.writeInt(encryptedNonce.length);
            out.writeInt(encryptedUID.length);
            serializeData(encryptedNonce);
            serializeData(encryptedUID);            
            System.out.println("Done with sending");
                
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Step 3">
            /*    
            in = new Scanner(new File("S:\\CN Common space\\nfc"));
                checksum = in.nextInt();
                in.close();
                
                while (checksum != 4) {
                    sleep(1000);
                    //System.out.println("failing");
                    in = new Scanner(new File("S:\\CN Common space\\nfc"));
                    checksum = in.nextInt();
                    
                    in.close();
                }
            
                nfcFile = new PrintWriter("S:\\CN Common space\\nfc", "UTF-8");
            nfcFile.print("5");
            nfcFile.close();
            */
            
                String re_enc_nonce = in.readUTF();
                String re_enc_uid = in.readUTF();
                String re_enc_nonceClear = in.readUTF();
                String re_enc_timeClear = in.readUTF();
           //-------------Connecting to FourSquare Start of Step 4 

                //un-comment or comment out next line 
                //Thread.sleep(7000);
                //^ yes this line
                
                out2.writeUTF(re_enc_nonce);
                out2.writeUTF(re_enc_uid);
                out2.writeUTF(re_enc_nonceClear);
                out2.writeUTF(re_enc_timeClear);


            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Check in Validation">
            
            /*  
             * //<editor-fold defaultstate="collapsed" desc="Redundant Code">
             * in = new Scanner(new File("S:\\CN Common space\\nfc"));
             * checksum = in.nextInt();
             * in.close();
             * 
             * while (checksum != 0) {
             * switch(checksum){
             * case -5:
             * JOptionPane.showMessageDialog(null, "False Check in Detected!", "Error!", JOptionPane.ERROR_MESSAGE);
             * nfcFile = new PrintWriter("S:\\CN Common space\\nfc", "UTF-8");
             * nfcFile.print("0");
             * nfcFile.close();
             * }
             * sleep(1000);
             * //System.out.println("failing");
             * in = new Scanner(new File("S:\\CN Common space\\nfc"));
             * checksum = in.nextInt();
             * in.close();
             * }
             */
        //</editor-fold>
       
            int checksum = in2.readInt();
            System.out.println("Valuevalue == "+checksum);
            
            if (checksum == 0)
            {JOptionPane.showMessageDialog(null,"Successfully checked into location", "Successful", JOptionPane.INFORMATION_MESSAGE);}
            else if (checksum == -5)
            {JOptionPane.showMessageDialog(null, "Check in request timed out", "Error!", JOptionPane.ERROR_MESSAGE);}
            
            
            //</editor-fold>
          
            
            } catch (Exception ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
    
    private static void getFSPublic() throws InvalidKeySpecException, NoSuchAlgorithmException, FileNotFoundException 
    {
       
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
        FSPublic = factory.generatePublic(publicSpec);


    }
private  void sendPublicKey() throws InvalidKeySpecException, NoSuchAlgorithmException, FileNotFoundException, IOException 
    {
        Scanner in = new Scanner(new File("S:\\CN Common space\\file"));
        in.nextLine();
        in.next();

        String modulusString = in.nextLine();
        //String exponentString = "18bc01730656bde47476f7cfbd3d8f9e15ede9c389814672dc161e349b08627fc885fe9d2442ae92f0214c7e97cf0b9a9fc876df4f53517ab63d710f997b2779";

        in.next();
        in.next();
        String publicExponentString = in.nextLine();
        
        //send modulusString and publichexpponentString to FS
        out2.writeUTF(modulusString);
        out2.writeUTF(publicExponentString);

    }

    
    
    private void serializeData(byte[] encryptedData) throws IOException
    {for(byte x:encryptedData){out.writeByte(x);}}
 
    public byte[] EncryptUserPrivate(String plainMessage)
    {
        byte[] encryptedBytes = null;
        
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            
            cipher.init(Cipher.ENCRYPT_MODE, userPrivate);
            encryptedBytes = cipher.doFinal(plainMessage.getBytes());
        }
        catch (Throwable t) {System.out.println(t.getMessage());}
        
        return encryptedBytes;
    }
     
    public byte[] EncryptFSPublic(String plainMessage)
    {
        byte[] encryptedBytes = null;
        
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            
            cipher.init(Cipher.ENCRYPT_MODE, FSPublic);
            encryptedBytes = cipher.doFinal(plainMessage.getBytes());
        }
        catch (Throwable t) {System.out.println(t.getMessage());}
        
        return encryptedBytes;
    } 

    private void readFSPublicKey() throws IOException {
       modulusString = in2.readUTF();
        publicExponentString = in2.readUTF();
    }

}
