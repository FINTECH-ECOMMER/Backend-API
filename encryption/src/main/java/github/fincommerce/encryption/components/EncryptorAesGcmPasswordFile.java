package github.fincommerce.encryption.components;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Security;

import static github.fincommerce.encryption.config.Config.ENCRYPT_ALGO;
import static github.fincommerce.encryption.config.Config.ENCRYPT_PROVIDER;
import static github.fincommerce.encryption.config.Config.IV_LENGTH_BYTE;
import static github.fincommerce.encryption.config.Config.TAG_LENGTH_BIT;
import static github.fincommerce.encryption.config.Config.SALT_LENGTH_BYTE;
public class EncryptorAesGcmPasswordFile {

    static byte[] salt = CryptoUtils.getRandomNonce(SALT_LENGTH_BYTE);

    public static byte[] encrypt(byte[] pText, String password) throws Exception {

        // GCM recommended 12 bytes iv?
        byte[] iv = CryptoUtils.getRandomNonce(IV_LENGTH_BYTE);

        // secret key from password
        SecretKey aesKeyFromPassword = CryptoUtils.getAESKeyFromPassword(password.toCharArray(), salt);
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO, ENCRYPT_PROVIDER);

        // ASE-GCM needs GCMParameterSpec
        cipher.init(Cipher.ENCRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
        byte[] cipherText = cipher.doFinal(pText);

        // prefix IV and Salt to cipher text
        return ByteBuffer.allocate(iv.length + salt.length + cipherText.length)
                .put(iv)
                .put(salt)
                .put(cipherText)
                .array();

    }

    // we need the same password, salt and iv to decrypt it
    private static byte[] decrypt(byte[] cText, String password) throws Exception {

        // get back the iv and salt that was prefixed in the cipher text
        ByteBuffer bb = ByteBuffer.wrap(cText);

        byte[] iv = new byte[12];
        bb.get(iv);

        byte[] salt = new byte[16];
        bb.get(salt);

        byte[] cipherText = new byte[bb.remaining()];
        bb.get(cipherText);

        // get back the aes key from the same password and salt
        SecretKey aesKeyFromPassword = CryptoUtils.getAESKeyFromPassword(password.toCharArray(), salt);
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO, ENCRYPT_PROVIDER);
        cipher.init(Cipher.DECRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
        return cipher.doFinal(cipherText);

    }

    public static void encryptFile(String fromFile, String toFile, String password) throws Exception {

        // read a normal txt file
        byte[] fileContent = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(fromFile).toURI()));

        // encrypt with a password
        byte[] encryptedText = EncryptorAesGcmPasswordFile.encrypt(fileContent, password);

        // save a file
        Path path = Paths.get(toFile);
        Files.write(path, encryptedText);

    }

    public static byte[] decryptFile(String fromEncryptedFile, String password) throws Exception {

        // read a file
        byte[] fileContent = Files.readAllBytes(Paths.get(fromEncryptedFile));
        return EncryptorAesGcmPasswordFile.decrypt(fileContent, password);

    }
}
