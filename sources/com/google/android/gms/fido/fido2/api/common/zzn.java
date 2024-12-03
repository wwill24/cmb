package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Arrays;

public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private final long f39382a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f39383b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39384c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f39385d;

    zzn(long j10, @NonNull byte[] bArr, @NonNull byte[] bArr2, @NonNull byte[] bArr3) {
        this.f39382a = j10;
        this.f39383b = (byte[]) p.k(bArr);
        this.f39384c = (byte[]) p.k(bArr2);
        this.f39385d = (byte[]) p.k(bArr3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zzn = (zzn) obj;
        if (this.f39382a != zzn.f39382a || !Arrays.equals(this.f39383b, zzn.f39383b) || !Arrays.equals(this.f39384c, zzn.f39384c) || !Arrays.equals(this.f39385d, zzn.f39385d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(Long.valueOf(this.f39382a), this.f39383b, this.f39384c, this.f39385d);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.v(parcel, 1, this.f39382a);
        a.k(parcel, 2, this.f39383b, false);
        a.k(parcel, 3, this.f39384c, false);
        a.k(parcel, 4, this.f39385d, false);
        a.b(parcel, a10);
    }
}
