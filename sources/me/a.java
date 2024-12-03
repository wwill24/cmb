package me;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import oe.d;

public class a {
    @Deprecated
    public static byte[] a(@NonNull Context context, @NonNull String str) throws PackageManager.NameNotFoundException {
        MessageDigest b10;
        PackageInfo e10 = d.a(context).e(str, 64);
        Signature[] signatureArr = e10.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (b10 = b("SHA1")) == null) {
            return null;
        }
        return b10.digest(e10.signatures[0].toByteArray());
    }

    public static MessageDigest b(@NonNull String str) {
        int i10 = 0;
        while (i10 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i10++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
