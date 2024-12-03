package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;
import com.google.android.gms.internal.fido.zzba;
import com.google.android.gms.internal.fido.zzh;
import fe.a;
import java.util.Arrays;
import java.util.List;
import se.d;

public class PublicKeyCredentialDescriptor extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialDescriptor> CREATOR = new d();

    /* renamed from: d  reason: collision with root package name */
    private static zzba f39324d = zzba.zzi(zzh.zza, zzh.zzb);
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final PublicKeyCredentialType f39325a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f39326b;

    /* renamed from: c  reason: collision with root package name */
    private final List f39327c;

    public PublicKeyCredentialDescriptor(@NonNull String str, @NonNull byte[] bArr, List<Transport> list) {
        p.k(str);
        try {
            this.f39325a = PublicKeyCredentialType.a(str);
            this.f39326b = (byte[]) p.k(bArr);
            this.f39327c = list;
        } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @NonNull
    public byte[] S() {
        return this.f39326b;
    }

    public List<Transport> Y() {
        return this.f39327c;
    }

    @NonNull
    public String c0() {
        return this.f39325a.toString();
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        if (!(obj instanceof PublicKeyCredentialDescriptor)) {
            return false;
        }
        PublicKeyCredentialDescriptor publicKeyCredentialDescriptor = (PublicKeyCredentialDescriptor) obj;
        if (!this.f39325a.equals(publicKeyCredentialDescriptor.f39325a) || !Arrays.equals(this.f39326b, publicKeyCredentialDescriptor.f39326b)) {
            return false;
        }
        List list2 = this.f39327c;
        if (list2 == null && publicKeyCredentialDescriptor.f39327c == null) {
            return true;
        }
        if (list2 == null || (list = publicKeyCredentialDescriptor.f39327c) == null || !list2.containsAll(list) || !publicKeyCredentialDescriptor.f39327c.containsAll(this.f39327c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39325a, Integer.valueOf(Arrays.hashCode(this.f39326b)), this.f39327c);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, c0(), false);
        a.k(parcel, 3, S(), false);
        a.G(parcel, 4, Y(), false);
        a.b(parcel, a10);
    }
}
