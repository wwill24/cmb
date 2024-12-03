package com.google.android.gms.fido.fido2.api.common;

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

public class AuthenticatorAttestationResponse extends AuthenticatorResponse {
    @NonNull
    public static final Parcelable.Creator<AuthenticatorAttestationResponse> CREATOR = new q();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f39261a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f39262b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39263c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final String[] f39264d;

    AuthenticatorAttestationResponse(@NonNull byte[] bArr, @NonNull byte[] bArr2, @NonNull byte[] bArr3, @NonNull String[] strArr) {
        this.f39261a = (byte[]) p.k(bArr);
        this.f39262b = (byte[]) p.k(bArr2);
        this.f39263c = (byte[]) p.k(bArr3);
        this.f39264d = (String[]) p.k(strArr);
    }

    @NonNull
    public byte[] S() {
        return this.f39263c;
    }

    @NonNull
    public byte[] Y() {
        return this.f39262b;
    }

    @NonNull
    @Deprecated
    public byte[] c0() {
        return this.f39261a;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticatorAttestationResponse)) {
            return false;
        }
        AuthenticatorAttestationResponse authenticatorAttestationResponse = (AuthenticatorAttestationResponse) obj;
        if (!Arrays.equals(this.f39261a, authenticatorAttestationResponse.f39261a) || !Arrays.equals(this.f39262b, authenticatorAttestationResponse.f39262b) || !Arrays.equals(this.f39263c, authenticatorAttestationResponse.f39263c)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String[] f0() {
        return this.f39264d;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(Arrays.hashCode(this.f39261a)), Integer.valueOf(Arrays.hashCode(this.f39262b)), Integer.valueOf(Arrays.hashCode(this.f39263c)));
    }

    @NonNull
    public String toString() {
        zzap zza = zzaq.zza(this);
        zzbl zzd = zzbl.zzd();
        byte[] bArr = this.f39261a;
        zza.zzb("keyHandle", zzd.zze(bArr, 0, bArr.length));
        zzbl zzd2 = zzbl.zzd();
        byte[] bArr2 = this.f39262b;
        zza.zzb("clientDataJSON", zzd2.zze(bArr2, 0, bArr2.length));
        zzbl zzd3 = zzbl.zzd();
        byte[] bArr3 = this.f39263c;
        zza.zzb("attestationObject", zzd3.zze(bArr3, 0, bArr3.length));
        zza.zzb("transports", Arrays.toString(this.f39264d));
        return zza.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.k(parcel, 2, c0(), false);
        a.k(parcel, 3, Y(), false);
        a.k(parcel, 4, S(), false);
        a.D(parcel, 5, f0(), false);
        a.b(parcel, a10);
    }
}
