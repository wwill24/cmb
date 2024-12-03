package h9;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class a implements ga.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f15429a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15430b;

    public a(String str, String str2) {
        this.f15429a = str;
        this.f15430b = str2;
        if (str != null && !c(str, "-----BEGIN PUBLIC KEY-----\n", "-----END PUBLIC KEY-----")) {
            throw new IllegalArgumentException("public rsa key is wrong format");
        } else if (str2 != null && !c(str2, "-----BEGIN PRIVATE KEY-----\n", "-----END PRIVATE KEY-----")) {
            throw new IllegalArgumentException("private rsa key is wrong format");
        }
    }

    private static String b(String str, String str2, String str3) {
        return str3.replace(str, "").replace(str2, "");
    }

    private static boolean c(String str, String str2, String str3) {
        return str.startsWith(str2) && str.endsWith(str3);
    }

    private static byte[] d(String str, byte[] bArr) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(b("-----BEGIN PUBLIC KEY-----\n", "-----END PUBLIC KEY-----", str).getBytes("UTF-8"), 2)));
        Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
        instance.init(1, generatePublic);
        return instance.doFinal(bArr);
    }

    public byte[] a(byte[] bArr) {
        try {
            return d(this.f15429a, bArr);
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            fa.a.g("RlcsCrypto", "Error encrypting asmmetrically.", e10);
            return null;
        }
    }
}
