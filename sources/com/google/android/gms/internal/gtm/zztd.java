package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zztd implements Iterable<Byte>, Serializable {
    private static final Comparator<zztd> zza = new zzsv();
    public static final zztd zzb = new zzta(zzvi.zzc);
    private static final zztc zzd = new zztc((zztb) null);
    private int zzc = 0;

    static {
        int i10 = zzsk.zza;
    }

    zztd() {
    }

    static int zzk(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Beginning index: ");
            sb2.append(i10);
            sb2.append(" < 0");
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i11 < i10) {
            StringBuilder sb3 = new StringBuilder(66);
            sb3.append("Beginning index larger than ending index: ");
            sb3.append(i10);
            sb3.append(", ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        } else {
            StringBuilder sb4 = new StringBuilder(37);
            sb4.append("End index: ");
            sb4.append(i11);
            sb4.append(" >= ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    public static zztd zzm(byte[] bArr) {
        return zzn(bArr, 0, bArr.length);
    }

    public static zztd zzn(byte[] bArr, int i10, int i11) {
        zzk(i10, i10 + i11, bArr.length);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new zzta(bArr2);
    }

    public static zztd zzo(String str) {
        return new zzta(str.getBytes(zzvi.zza));
    }

    static zztd zzp(byte[] bArr) {
        return new zzta(bArr);
    }

    static zztd zzq(byte[] bArr, int i10, int i11) {
        return new zzsx(bArr, i10, i11);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i10 = this.zzc;
        if (i10 == 0) {
            int zzd2 = zzd();
            i10 = zzf(zzd2, 0, zzd2);
            if (i10 == 0) {
                i10 = 1;
            }
            this.zzc = i10;
        }
        return i10;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new zzst(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            str = zzxm.zza(this);
        } else {
            str = String.valueOf(zzxm.zza(zzg(0, 47))).concat("...");
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i10);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i10);

    public abstract int zzd();

    /* access modifiers changed from: protected */
    public abstract void zze(byte[] bArr, int i10, int i11, int i12);

    /* access modifiers changed from: protected */
    public abstract int zzf(int i10, int i11, int i12);

    public abstract zztd zzg(int i10, int i11);

    /* access modifiers changed from: protected */
    public abstract String zzh(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zzi(zzss zzss) throws IOException;

    public abstract boolean zzj();

    /* access modifiers changed from: protected */
    public final int zzl() {
        return this.zzc;
    }

    public final String zzr(Charset charset) {
        return zzd() == 0 ? "" : zzh(charset);
    }
}
