package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class ProxyResponse extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public final int f38363a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final PendingIntent f38364b;

    /* renamed from: c  reason: collision with root package name */
    public final int f38365c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f38366d;

    /* renamed from: e  reason: collision with root package name */
    final int f38367e;

    /* renamed from: f  reason: collision with root package name */
    final Bundle f38368f;

    ProxyResponse(int i10, int i11, PendingIntent pendingIntent, int i12, Bundle bundle, byte[] bArr) {
        this.f38367e = i10;
        this.f38363a = i11;
        this.f38365c = i12;
        this.f38368f = bundle;
        this.f38366d = bArr;
        this.f38364b = pendingIntent;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38363a);
        a.A(parcel, 2, this.f38364b, i10, false);
        a.s(parcel, 3, this.f38365c);
        a.j(parcel, 4, this.f38368f, false);
        a.k(parcel, 5, this.f38366d, false);
        a.s(parcel, 1000, this.f38367e);
        a.b(parcel, a10);
    }
}
