
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


//its a thread running on a special device that keeps waiting for user requests
public class NFC { 

     
    //<editor-fold defaultstate="collapsed" desc="Attributes">
    private static final String Venue_PUBLIC_KEY_BASE64 =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKkC/b2fjIdS8atGeX/cOP8YWeEypeGnB1ICap\n" +
            "dWajoUGGXWbl3410gZopmcXbN9imMmNNs7I9KsOKJj6b7PzP4/p74da55kaht0l63603iKandHAw\n" +
            "7PeTWpHhJ3l12tAtvtiKppHqoY4IJDunOCHjB1fpmCkEX9JQ+a3vFl1/5wIDAQAB";
    
    private static final String Venue_PRIVATE_KEY_BASE64 =
            "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIqQL9vZ+Mh1Lxq0Z5f9w4/xhZ4T\n" +
            "Kl4acHUgJql1ZqOhQYZdZuXfjXSBmimZxds32KYyY02zsj0qw4omPpvs/M/j+nvh1rnmRqG3SXrf\n" +
            "rTeIpqd0cDDs95NakeEneXXa0C2+2IqmkeqhjggkO6c4IeMHV+mYKQRf0lD5re8WXX/nAgMBAAEC\n" +
            "gYAstefrfgMr07w2Vr4SqjyfRuTBpBeIs+lTseMnzQ0ogZEeJSddx2viiytOfyL74KJUxm+KlBBQ\n" +
            "cmsUOdD8CVVt2VcH63naa835YEVojqdj3X05IZk72LbH7eoaDDr9gL3DCOs7BdCWCJyLv93AzaZJ\n" +
            "zLpu3d7kKEvKlL8La/SvkQJBAM+ouGIRYDD89JbZgKUnCbyHSd3VFfKOluc5/Fn4CcT8vhbrQgmA\n" +
            "pb8rTCs7TkC4Ya66u+zB+If5CkUOe5GkjmkCQQCq0cEk+wplQIKSc6v58+k+eORgL6ld0JdiKjgi\n" +
            "dpEMHSmtM6et6Ukhi+CWZ/oEK6O20WhOWUHqzpOCi8PponHPAkA3293FW4ExjEnK7jUBt++RjB7d\n" +
            "kj02Iw8Kofl0xhjyqT4E8kGwRq/PLblug6R4GmEEXGzCsibFhMMzckLhGY/JAkBy4yySYL23J9Iq\n" +
            "Cd5K+H+RYuHGx4eT721Bur+SfkhD64FSWoGWeGaVR2y//CKtl2Q+20zaFTI+aL3ReYtEodsFAkEA\n" +
            "ooGmtWsgxDSThLn2l+gYhfZLy+hrewTWc3rvfd59Vmdvw+06d4PFM6mlwE8SJPON2uFfaztwoOFy\n" +
            "eoxJEeDeow==";
    private PrintWriter nfcFile ;
    private PrintWriter dataFile;
    private String nonce =null,time="123";
    byte[] encryptedNonce = null;
    byte[] encryptedUID = null;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Socket Attributes">
    public ServerSocket ss;
    public Socket socket;
    public InputStream sin;
    public OutputStream sout;
    public DataInputStream in;
    public DataOutputStream out;
    public String line;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Functions">
    
    public NFC(String venID){
    
        try {
            ss = new ServerSocket(6789);
            socket = ss.accept();
            sin = socket.getInputStream();
            sout = socket.getOutputStream();
            in = new DataInputStream(sin);
            out = new DataOutputStream(sout);
            
            out.writeUTF(venID);
            System.out.println("ven id = "+venID);
            checkForSession();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "My msg");
        }
    
    }
    
    private void checkForSession() throws Exception {
        
    //<editor-fold defaultstate="collapsed" desc="Redundant Code">
        /*
         * Scanner in = new Scanner(new File("S:\\CN Common space\\nfc"));
         * int checksum = in.nextInt();
         * in.close();
         * 
         * if (checksum == 1) {
         * startNFC();
         * } else {
         * }
         */
        //</editor-fold>
    line = in.readUTF();
    System.out.println("I am here without wrerer");
    
    if (Integer.parseInt(line) == 1)startNFC();
    else {System.out.println("Error in receving 1 from User");}


    }

    private static String EncryptVenuePrivate(final RandomSymmetricCipher cipher, byte[] encryptedNonce) throws CryptoException {
        final CryptoPacket cryptoPacket = cipher.encrypt(encryptedNonce, Venue_PRIVATE_KEY_BASE64);
        final CryptoPacketConverter cryptoPacketConverter = new CryptoPacketConverter();
        final String base64EncryptedData = cryptoPacketConverter.convert(cryptoPacket);
        return base64EncryptedData;
    }

    private static String getRandomNonce() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        SecureRandom ran = new SecureRandom();
        for (int i = 0; i < 5; i++) {
            char c = chars[ran.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }

    private void startNFC() throws Exception {

    //<editor-fold defaultstate="collapsed" desc="Nonce">
    nonce = getRandomNonce();
    out.writeUTF(nonce);      
   
    //<editor-fold defaultstate="collapsed" desc="Redundant Code">
        
        //<editor-fold defaultstate="collapsed" desc="Signal Nonce">
        /*
        nfcFile = new PrintWriter("S:\\CN Common space\\nfc", "UTF-8");
        nfcFile.print("2");
        nfcFile.close();
        */
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Wrtie Nonce">
        /*    
        dataFile = new PrintWriter("S:\\CN Common space\\data", "UTF-8");
        dataFile.print(nonce);
        dataFile.close();
        */

        //</editor-fold>
        
        //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Wait for user's data">
        
    //<editor-fold defaultstate="collapsed" desc="Redundant Code">
        /*
        Scanner in = new Scanner(new File("S:\\CN Common space\\nfc"));
        int checksum = in.nextInt();
        in.close();
        
        while (checksum != 3) {
            Thread.sleep(500);
            in = new Scanner(new File("S:\\CN Common space\\nfc"));
            checksum = in.nextInt();
            in.close();
        }
        */
        //</editor-fold>
    

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Encrypt Data">
        readData();
        final RandomSymmetricCipher cipher = new RandomSymmetricCipher();
        String re_enc_nonce = EncryptVenuePrivate(cipher, encryptedNonce);
        String re_enc_uid = EncryptVenuePrivate(cipher, encryptedUID);
        String re_enc_nonceClear = EncryptVenuePrivate(cipher, nonce.getBytes());
        time =String.valueOf(Calendar.getInstance().getTimeInMillis());
        String re_enc_timeClear = EncryptVenuePrivate(cipher, time.getBytes());
        
        //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Send Re-encrypted Data">
    
    //<editor-fold defaultstate="collapsed" desc="Redundant Code">
        /*
        dataFile = new PrintWriter("S:\\CN Common space\\data", "UTF-8");
        dataFile.println(re_enc_nonce);
        dataFile.println(re_enc_uid);
        dataFile.println(re_enc_nonceClear);
        dataFile.println(re_enc_timeClear);
        dataFile.close();
        
        nfcFile = new PrintWriter("S:\\CN Common space\\nfc", "UTF-8");
        nfcFile.print("4");
        nfcFile.close();
        */
        //</editor-fold>
    
        out.writeUTF(re_enc_nonce);
        out.writeUTF(re_enc_uid);
        out.writeUTF(re_enc_nonceClear);
        out.writeUTF(re_enc_timeClear);
        
        //</editor-fold>


    }
    
    private void readData(){
        
        ArrayList<Byte> arrb= new ArrayList<>();
        try {
            int enNSize= in.readInt(),enUIDSize= in.readInt();
            System.out.println(enNSize+" "+enUIDSize);
            
            encryptedNonce = new byte[enNSize];
            
            encryptedUID = new byte[enUIDSize];
            
            for (int i=0;i<enNSize;i++){
                encryptedNonce[i]= in.readByte();System.out.print (encryptedNonce[i]+" ");
            }System.out.println();
            
            for (int i=0;i<enUIDSize;i++){
                encryptedUID[i] = in.readByte();System.out.print(encryptedUID[i]+" ");
            }System.out.println();
        
        
        
        } catch (Exception ex) {
            Logger.getLogger(NFC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
    
     //</editor-fold>
   
}
