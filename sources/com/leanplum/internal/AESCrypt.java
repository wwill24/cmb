package com.leanplum.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.leanplum.internal.Constants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

public class AESCrypt {
    private static final String APP_ID_KEY_PREFIX = ("L" + XHTMLText.Q + 3 + NetworkProfile.FEMALE + "z");
    private static final String APP_ID_KEY_SUFFIX = (NetworkProfile.BISEXUAL + "L" + "t" + "i" + 2);
    private final String appId;
    private final String token;

    /* renamed from: com.leanplum.internal.AESCrypt$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$leanplum$internal$AESCrypt$EncryptionType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.leanplum.internal.AESCrypt$EncryptionType[] r0 = com.leanplum.internal.AESCrypt.EncryptionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$leanplum$internal$AESCrypt$EncryptionType = r0
                com.leanplum.internal.AESCrypt$EncryptionType r1 = com.leanplum.internal.AESCrypt.EncryptionType.LEGACY_TOKEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$leanplum$internal$AESCrypt$EncryptionType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.leanplum.internal.AESCrypt$EncryptionType r1 = com.leanplum.internal.AESCrypt.EncryptionType.APP_ID_KEY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.AESCrypt.AnonymousClass1.<clinit>():void");
        }
    }

    private enum EncryptionType {
        LEGACY_TOKEN(0),
        APP_ID_KEY(1);
        

        /* renamed from: id  reason: collision with root package name */
        public final int f22203id;
        public final String prefix;
        public final String prefixWithBracket;

        private EncryptionType(int i10) {
            this.f22203id = i10;
            String format2 = String.format("%02d", new Object[]{Integer.valueOf(i10)});
            this.prefix = format2;
            this.prefixWithBracket = format2 + "[";
        }

        private static EncryptionType forId(int i10) {
            if (i10 == 1) {
                return APP_ID_KEY;
            }
            return null;
        }

        public static Pair<EncryptionType, String> parseCipherText(String str) {
            if (str != null && !str.isEmpty()) {
                if (str.startsWith("[")) {
                    return Pair.create(LEGACY_TOKEN, str);
                }
                EncryptionType encryptionType = APP_ID_KEY;
                if (str.startsWith(encryptionType.prefixWithBracket)) {
                    return Pair.create(encryptionType, str.substring(encryptionType.prefixWithBracket.length() - 1));
                }
            }
            return null;
        }
    }

    public AESCrypt(String str, String str2) {
        this.appId = str;
        this.token = str2;
    }

    private String appIdKeyPassword() {
        return APP_ID_KEY_PREFIX + this.appId + APP_ID_KEY_SUFFIX;
    }

    private static String decryptInternal(String str, String str2) {
        try {
            byte[] parseCiphertextInternal = parseCiphertextInternal(str2);
            if (parseCiphertextInternal == null) {
                Log.d("Invalid ciphertext: " + str2, new Object[0]);
                return null;
            }
            byte[] performCryptOperation = performCryptOperation(2, str, parseCiphertextInternal);
            if (performCryptOperation != null) {
                return new String(performCryptOperation, "UTF-8");
            }
            return null;
        } catch (UnsupportedEncodingException e10) {
            Log.d("Could not encode UTF8 string.\n" + Log.getStackTraceString(e10), new Object[0]);
        }
    }

    public static String encryptInternal(String str, String str2) {
        try {
            return Arrays.toString(performCryptOperation(1, str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e10) {
            Log.d("Unable to encrypt " + str2, e10);
            return null;
        }
    }

    private static byte[] parseCiphertextInternal(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() < 2) {
            return null;
        }
        try {
            String[] split = trim.substring(1, trim.length() - 1).trim().split("\\s*,\\s*");
            byte[] bArr = new byte[split.length];
            for (int i10 = 0; i10 < split.length; i10++) {
                bArr[i10] = Byte.parseByte(split[i10]);
            }
            return bArr;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static byte[] performCryptOperation(int i10, String str, byte[] bArr) {
        try {
            byte[] bytes = Constants.Crypt.SALT.getBytes("UTF-8");
            byte[] bytes2 = Constants.Crypt.IV.getBytes("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBEWithMD5And128BitAES-CBC-OpenSSL").generateSecret(new PBEKeySpec(str.toCharArray(), bytes, 1000, 256)).getEncoded(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(i10, secretKeySpec, new IvParameterSpec(bytes2));
            return instance.doFinal(bArr);
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            return null;
        }
    }

    public String decodePreference(SharedPreferences sharedPreferences, String str, String str2) {
        String decrypt;
        String string = sharedPreferences.getString(str, (String) null);
        if (string == null || (decrypt = decrypt(string)) == null) {
            return str2;
        }
        return decrypt;
    }

    public String decrypt(String str) {
        Pair<EncryptionType, String> parseCipherText = EncryptionType.parseCipherText(str);
        String str2 = null;
        if (parseCipherText == null) {
            Log.d("Got null encryptionSpec for encrypted: " + str, new Object[0]);
        } else {
            int i10 = AnonymousClass1.$SwitchMap$com$leanplum$internal$AESCrypt$EncryptionType[((EncryptionType) parseCipherText.first).ordinal()];
            if (i10 == 1) {
                String str3 = this.token;
                if (str3 == null || str3.isEmpty()) {
                    Log.e("Decrypt called with null token.", new Object[0]);
                } else {
                    String decryptInternal = decryptInternal(this.token, (String) parseCipherText.second);
                    if (decryptInternal == null || parseCiphertextInternal(decryptInternal) == null) {
                        str2 = decryptInternal;
                    } else {
                        Log.e("Discarding legacy value that appears to be an encrypted value: " + decryptInternal, new Object[0]);
                        return null;
                    }
                }
            } else if (i10 == 2) {
                String str4 = this.appId;
                if (str4 == null || str4.isEmpty()) {
                    Log.e("Decrypt called with null appId.", new Object[0]);
                } else {
                    str2 = decryptInternal(appIdKeyPassword(), (String) parseCipherText.second);
                }
            }
        }
        if (str2 == null) {
            Log.d("Unable to decrypt " + str, new Object[0]);
        }
        return str2;
    }

    public String encrypt(String str) {
        if (str == null) {
            return null;
        }
        String str2 = this.appId;
        if (str2 == null || str2.isEmpty()) {
            Log.e("Encrypt called with null appId.", new Object[0]);
            return null;
        }
        String encryptInternal = encryptInternal(appIdKeyPassword(), str);
        if (encryptInternal == null) {
            Log.d("Failed to encrypt.", new Object[0]);
            return null;
        } else if (encryptInternal.isEmpty() || encryptInternal.equals(str) || !encryptInternal.startsWith("[")) {
            Log.d("Invalid ciphertext: " + encryptInternal, new Object[0]);
            return null;
        } else {
            return EncryptionType.APP_ID_KEY.prefix + encryptInternal;
        }
    }
}
