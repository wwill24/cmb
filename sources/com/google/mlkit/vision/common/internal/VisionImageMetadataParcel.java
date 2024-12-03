package com.google.mlkit.vision.common.internal;

import ah.f;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class VisionImageMetadataParcel extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public final int f21522a;

    /* renamed from: b  reason: collision with root package name */
    public final int f21523b;

    /* renamed from: c  reason: collision with root package name */
    public final long f21524c;

    /* renamed from: d  reason: collision with root package name */
    public final int f21525d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21526e;

    public VisionImageMetadataParcel(int i10, int i11, int i12, long j10, int i13) {
        this.f21522a = i10;
        this.f21523b = i11;
        this.f21526e = i12;
        this.f21524c = j10;
        this.f21525d = i13;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f21522a);
        a.s(parcel, 2, this.f21523b);
        a.s(parcel, 3, this.f21526e);
        a.v(parcel, 4, this.f21524c);
        a.s(parcel, 5, this.f21525d);
        a.b(parcel, a10);
    }
}
