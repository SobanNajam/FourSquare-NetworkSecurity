import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Responsible for converting a CryptoPacket into a Base64 String and vice versa.
 */
public final class CryptoPacketConverter {

    private final Base64 base64 = new Base64();

    public String convert(CryptoPacket cryptoPacket) throws CryptoException {
        final ByteArrayOutputStream stream = new ByteArrayOutputStream();

        try {
            stream.write(cryptoPacket.getEncryptedData().length);
            stream.write(cryptoPacket.getEncryptedData());
            stream.write(cryptoPacket.getEncryptedSymmetricKey().length);
            stream.write(cryptoPacket.getEncryptedSymmetricKey());
            stream.write(cryptoPacket.getSymmetricCipherInitializationVector().length);
            stream.write(cryptoPacket.getSymmetricCipherInitializationVector());
        } catch (IOException e) {
            // This is highly unlikely to occur, if not impossible.
            throw new CryptoException("Cannot convert CryptoPacket into a Base64 String", e);
        }

        final byte[] jsonPayload = stream.toByteArray();
        final byte[] base64Payload = base64.encode(jsonPayload);

        return new String(base64Payload);
    }

    public CryptoPacket convert(String base64Payload) throws CryptoException {
        final byte[] payloadBytes;
        try {
            payloadBytes = base64.decode(base64Payload.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // UTF-8 should always be supported.
            throw new CryptoException("Could not decode Base64 String", e);
        }

        final ByteArrayInputStream stream = new ByteArrayInputStream(payloadBytes);
        final byte[] encryptedData = readByteArray(stream);
        final byte[] encryptedSymmetricKey = readByteArray(stream);
        final byte[] symmetricCipherIV = readByteArray(stream);

        return new CryptoPacket(encryptedData, encryptedSymmetricKey, symmetricCipherIV);
    }

    private byte[] readByteArray(ByteArrayInputStream stream) throws CryptoException {
        final int length = stream.read();
        if (length < 0) {
            throw new CryptoException("Byte array cannot be parsed - does not represent a CryptoPacketPayload");
        }
        final byte[] bytes = new byte[length];
        final int nrBytesRead;
        try {
            nrBytesRead = stream.read(bytes);
            if (length != nrBytesRead) {
                throw new CryptoException("Invalid Base64 String. Expected " + length + " bytes but only found " + nrBytesRead);
            }
        } catch (IOException e) {
            throw new CryptoException("Invalid Base64 String. Cannot convert Base64 String into a CryptoPacket");
        }
        return bytes;
    }
}