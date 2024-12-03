package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.fido.zzap;
import com.google.android.gms.internal.fido.zzaq;
import com.google.android.gms.internal.fido.zzbl;
import fe.a;
import java.util.Arrays;
import ue.b;

@Deprecated
public class SignResponseData extends ResponseData {
    @NonNull
    public static final Parcelable.Creator<SignResponseData> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f39451a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39452b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39453c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f39454d;

    public SignResponseData(@NonNull byte[] bArr, @NonNull String str, @NonNull byte[] bArr2, @NonNull byte[] bArr3) {
        this.f39451a = (byte[]) p.k(bArr);
        this.f39452b = (String) p.k(str);
        this.f39453c = (byte[]) p.k(bArr2);
        this.f39454d = (byte[]) p.k(bArr3);
    }

    @NonNull
    public String S() {
        return this.f39452b;
    }

    @NonNull
    public byte[] Y() {
        return this.f39451a;
    }

    @NonNull
    public byte[] c0() {
        return this.f39453c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignResponseData)) {
            return false;
        }
        SignResponseData signResponseData = (SignResponseData) obj;
        if (!Arrays.equals(this.f39451a, signResponseData.f39451a) || !n.b(this.f39452b, signResponseData.f39452b) || !Arrays.equals(this.f39453c, signResponseData.f39453c) || !Arrays.equals(this.f39454d, signResponseData.f39454d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(Arrays.hashCode(this.f39451a)), this.f39452b, Integer.valueOf(Arrays.hashCode(this.f39453c)), Integer.valueOf(Arrays.hashCode(this.f39454d)));
    }

    @NonNull
    public String toString() {
        zzap zza = zzaq.zza(this);
        zzbl zzd = zzbl.zzd();
        byte[] bArr = this.f39451a;
        zza.zzb("keyHandle", zzd.zze(bArr, 0, bArr.length));
        zza.zzb("clientDataString", this.f39452b);
        zzbl zzd2 = zzbl.zzd();
        byte[] bArr2 = this.f39453c;
        zza.zzb("signatureData", zzd2.zze(bArr2, 0, bArr2.length));
        zzbl zzd3 = zzbl.zzd();
        byte[] bArr3 = this.f39454d;
        zza.zzb("application", zzd3.zze(bArr3, 0, bArr3.length));
        return zza.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.k(parcel, 2, Y(), false);
        a.C(parcel, 3, S(), false);
        a.k(parcel, 4, c0(), false);
        a.k(parcel, 5, this.f39454d, false);
        a.b(parcel, a10);
    }
}
