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

public class AuthenticatorAssertionResponse extends AuthenticatorResponse {
    @NonNull
    public static final Parcelable.Creator<AuthenticatorAssertionResponse> CREATOR = new p();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f39256a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f39257b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39258c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f39259d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f39260e;

    AuthenticatorAssertionResponse(@NonNull byte[] bArr, @NonNull byte[] bArr2, @NonNull byte[] bArr3, @NonNull byte[] bArr4, byte[] bArr5) {
        this.f39256a = (byte[]) p.k(bArr);
        this.f39257b = (byte[]) p.k(bArr2);
        this.f39258c = (byte[]) p.k(bArr3);
        this.f39259d = (byte[]) p.k(bArr4);
        this.f39260e = bArr5;
    }

    @NonNull
    public byte[] S() {
        return this.f39258c;
    }

    @NonNull
    public byte[] Y() {
        return this.f39257b;
    }

    @NonNull
    @Deprecated
    public byte[] c0() {
        return this.f39256a;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticatorAssertionResponse)) {
            return false;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = (AuthenticatorAssertionResponse) obj;
        if (!Arrays.equals(this.f39256a, authenticatorAssertionResponse.f39256a) || !Arrays.equals(this.f39257b, authenticatorAssertionResponse.f39257b) || !Arrays.equals(this.f39258c, authenticatorAssertionResponse.f39258c) || !Arrays.equals(this.f39259d, authenticatorAssertionResponse.f39259d) || !Arrays.equals(this.f39260e, authenticatorAssertionResponse.f39260e)) {
            return false;
        }
        return true;
    }

    @NonNull
    public byte[] f0() {
        return this.f39259d;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(Arrays.hashCode(this.f39256a)), Integer.valueOf(Arrays.hashCode(this.f39257b)), Integer.valueOf(Arrays.hashCode(this.f39258c)), Integer.valueOf(Arrays.hashCode(this.f39259d)), Integer.valueOf(Arrays.hashCode(this.f39260e)));
    }

    public byte[] i0() {
        return this.f39260e;
    }

    @NonNull
    public String toString() {
        zzap zza = zzaq.zza(this);
        zzbl zzd = zzbl.zzd();
        byte[] bArr = this.f39256a;
        zza.zzb("keyHandle", zzd.zze(bArr, 0, bArr.length));
        zzbl zzd2 = zzbl.zzd();
        byte[] bArr2 = this.f39257b;
        zza.zzb("clientDataJSON", zzd2.zze(bArr2, 0, bArr2.length));
        zzbl zzd3 = zzbl.zzd();
        byte[] bArr3 = this.f39258c;
        zza.zzb("authenticatorData", zzd3.zze(bArr3, 0, bArr3.length));
        zzbl zzd4 = zzbl.zzd();
        byte[] bArr4 = this.f39259d;
        zza.zzb("signature", zzd4.zze(bArr4, 0, bArr4.length));
        byte[] bArr5 = this.f39260e;
        if (bArr5 != null) {
            zza.zzb("userHandle", zzbl.zzd().zze(bArr5, 0, bArr5.length));
        }
        return zza.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.k(parcel, 2, c0(), false);
        a.k(parcel, 3, Y(), false);
        a.k(parcel, 4, S(), false);
        a.k(parcel, 5, f0(), false);
        a.k(parcel, 6, i0(), false);
        a.b(parcel, a10);
    }
}
