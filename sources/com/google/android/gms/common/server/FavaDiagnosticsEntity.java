package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ke.a;

public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f39131a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final String f39132b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39133c;

    public FavaDiagnosticsEntity(int i10, @NonNull String str, int i11) {
        this.f39131a = i10;
        this.f39132b = str;
        this.f39133c = i11;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.s(parcel, 1, this.f39131a);
        fe.a.C(parcel, 2, this.f39132b, false);
        fe.a.s(parcel, 3, this.f39133c);
        fe.a.b(parcel, a10);
    }
}
