package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import com.google.android.gms.internal.fido.zzap;
import com.google.android.gms.internal.fido.zzaq;
import com.google.android.gms.internal.fido.zzbl;
import fe.a;
import java.util.Arrays;

@Deprecated
public class RegisterResponseData extends ResponseData {
    @NonNull
    public static final Parcelable.Creator<RegisterResponseData> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f39437a;

    /* renamed from: b  reason: collision with root package name */
    private final ProtocolVersion f39438b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39439c;

    RegisterResponseData(byte[] bArr, String str, String str2) {
        this.f39437a = bArr;
        try {
            this.f39438b = ProtocolVersion.a(str);
            this.f39439c = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @NonNull
    public String S() {
        return this.f39439c;
    }

    @NonNull
    public byte[] Y() {
        return this.f39437a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RegisterResponseData)) {
            return false;
        }
        RegisterResponseData registerResponseData = (RegisterResponseData) obj;
        if (!n.b(this.f39438b, registerResponseData.f39438b) || !Arrays.equals(this.f39437a, registerResponseData.f39437a) || !n.b(this.f39439c, registerResponseData.f39439c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39438b, Integer.valueOf(Arrays.hashCode(this.f39437a)), this.f39439c);
    }

    @NonNull
    public String toString() {
        zzap zza = zzaq.zza(this);
        zza.zzb("protocolVersion", this.f39438b);
        zzbl zzd = zzbl.zzd();
        byte[] bArr = this.f39437a;
        zza.zzb("registerData", zzd.zze(bArr, 0, bArr.length));
        String str = this.f39439c;
        if (str != null) {
            zza.zzb("clientDataString", str);
        }
        return zza.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.k(parcel, 2, Y(), false);
        a.C(parcel, 3, this.f39438b.toString(), false);
        a.C(parcel, 4, S(), false);
        a.b(parcel, a10);
    }
}
