package com.google.android.gms.internal.play_billing;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.bouncycastle.i18n.LocalizedMessage;
import org.jivesoftware.smack.util.StringUtils;

public final class zzcg {
    static final Charset zza = Charset.forName(StringUtils.USASCII);
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzbe zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i10 = zzbe.zza;
        zzbc zzbc = new zzbc(bArr, 0, 0, false, (zzbb) null);
        try {
            zzbc.zza(0);
            zzf = zzbc;
        } catch (zzci e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static int zza(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    static int zzb(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    static Object zzc(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zzb);
    }
}
