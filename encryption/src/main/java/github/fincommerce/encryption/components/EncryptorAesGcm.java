package github.fincommerce.encryption.components;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.ByteBuffer;
import java.security.Security;

import static github.fincommerce.encryption.config.Config.ENCRYPT_ALGO;
import static github.fincommerce.encryption.config.Config.ENCRYPT_PROVIDER;
import static github.fincommerce.encryption.config.Config.IV_LENGTH_BYTE;
import static github.fincommerce.encryption.config.Config.TAG_LENGTH_BIT;
import static github.fincommerce.encryption.config.Config.UTF_8;
public class EncryptorAesGcm {

    // EncryptorAesGcm-GCM needs GCMParameterSpec
    public static byte[] encrypt(byte[] pText, SecretKey secret, byte[] iv) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO,ENCRYPT_PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, secret, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
        return cipher.doFinal(pText);
    }

    // prefix IV length + IV bytes to cipher text
    public static byte[] encryptWithPrefixIV(byte[] pText, SecretKey secret, byte[] iv) throws Exception {
        byte[] cipherText = encrypt(pText, secret, iv);
        return ByteBuffer.allocate(iv.length + cipherText.length)
                .put(iv)
                .put(cipherText)
                .array();
    }

    public static String decrypt(byte[] cText, SecretKey secret, byte[] iv) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO,ENCRYPT_PROVIDER);
        cipher.init(Cipher.DECRYPT_MODE, secret, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
        byte[] plainText = cipher.doFinal(cText);
        return new String(plainText, UTF_8);
    }

    public static String decryptWithPrefixIV(byte[] cText, SecretKey secret) throws Exception {
        var result = "";
        try {
            ByteBuffer bb = ByteBuffer.wrap(cText);
            byte[] iv = new byte[IV_LENGTH_BYTE];
            bb.get(iv);
            //bb.get(iv, 0, iv.length);

            byte[] cipherText = new byte[bb.remaining()];
            bb.get(cipherText);
            result =  decrypt(cipherText, secret, iv);
        }
        catch (Exception e) {
            result = "";

        }
        return  result;

    }
}
