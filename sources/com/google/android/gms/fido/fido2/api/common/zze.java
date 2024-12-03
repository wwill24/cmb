package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import se.i;

public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f39380a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f39381b;

    public zze(byte[] bArr, byte[] bArr2) {
        this.f39380a = bArr;
        this.f39381b = bArr2;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.k(parcel, 1, this.f39380a, false);
        a.k(parcel, 2, this.f39381b, false);
        a.b(parcel, a10);
    }
}
