package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableEntryException;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.x500.X500Principal;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f41939a;

    /* renamed from: b  reason: collision with root package name */
    private KeyStore f41940b;

    public a(Context context) {
        this.f41939a = context;
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.f41940b = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
        } catch (KeyStoreException unused) {
            this.f41940b = null;
        } catch (Exception unused2) {
        }
    }

    private void a(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException, NoSuchProviderException, InvalidKeyException, IOException {
        SharedPreferences sharedPreferences = this.f41939a.getSharedPreferences("rsa_storage", 0);
        if (sharedPreferences.getString("encrypted_key", (String) null) == null) {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            String encodeToString = Base64.encodeToString(d(str, bArr), 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("encrypted_key", encodeToString);
            edit.apply();
        }
    }

    private void c(String str) throws KeyStoreException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException {
        if (this.f41940b != null) {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            Calendar instance2 = Calendar.getInstance();
            Calendar instance3 = Calendar.getInstance();
            instance3.add(1, 30);
            if (!this.f41940b.containsAlias(str)) {
                KeyGenParameterSpec.Builder encryptionPaddings = new KeyGenParameterSpec.Builder(str, 3).setEncryptionPaddings(new String[]{"PKCS1Padding"});
                instance.initialize(encryptionPaddings.setCertificateSubject(new X500Principal("CN=" + str)).setCertificateSerialNumber(BigInteger.TEN).setKeyValidityStart(instance2.getTime()).setKeyValidityEnd(instance3.getTime()).build());
                instance.generateKeyPair();
            }
        }
    }

    private byte[] d(String str, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException, NoSuchProviderException, InvalidKeyException, IOException {
        KeyStore keyStore = this.f41940b;
        if (keyStore == null) {
            return new byte[0];
        }
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidKeyStoreBCWorkaround");
        instance.init(1, ((KeyStore.PrivateKeyEntry) keyStore.getEntry(str, (KeyStore.ProtectionParameter) null)).getCertificate().getPublicKey());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, instance);
        cipherOutputStream.write(bArr);
        cipherOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) throws Exception {
        c(str);
        a(str);
    }
}
