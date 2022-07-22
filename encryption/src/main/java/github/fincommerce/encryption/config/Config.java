package github.fincommerce.encryption.config;

import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
public class Config {
    @Value("${ENCRYPT_ALGO}")
    public static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    @Value("${ENCRYPT_PROVIDER}")
    public static final String ENCRYPT_PROVIDER = "BC";
    @Value("${SALT_LENGTH_BYTE}")
    public static final int SALT_LENGTH_BYTE = 16;
    @Value("${TAG_LENGTH_BIT}")
    public static final int TAG_LENGTH_BIT = 128;
    @Value("${IV_LENGTH_BYTE}")
    public static final int IV_LENGTH_BYTE = 12;
    @Value("${AES_KEY_BIT}")
    public static final int AES_KEY_BIT = 256;
    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public static final String OUTPUT_FORMAT = "%-30s:%s";
}
