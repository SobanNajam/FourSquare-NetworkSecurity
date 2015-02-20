
public final class CryptoPacket {

    private final byte[] encryptedData;
    private final byte[] encryptedSymmetricKey;
    private final byte[] symmetricCipherInitializationVector;

    public CryptoPacket(byte[] encryptedData, byte[] encryptedSymmetricKey, byte[] symmetricCipherInitializationVector) {
        this.encryptedData = encryptedData;
        this.encryptedSymmetricKey = encryptedSymmetricKey;
        this.symmetricCipherInitializationVector = symmetricCipherInitializationVector;
    }

    public byte[] getEncryptedData() {
        return encryptedData;
    }

    public byte[] getEncryptedSymmetricKey() {
        return encryptedSymmetricKey;
    }

    public byte[] getSymmetricCipherInitializationVector() {
        return symmetricCipherInitializationVector;
    }
}