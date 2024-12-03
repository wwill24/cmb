package com.google.android.gms.fido.sourcedevice;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;
import te.b;

public class SourceStartDirectTransferOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<SourceStartDirectTransferOptions> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private int f39392a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f39393b;

    /* renamed from: c  reason: collision with root package name */
    private List f39394c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f39395d;

    /* renamed from: e  reason: collision with root package name */
    private String f39396e;

    public SourceStartDirectTransferOptions(int i10, boolean z10, @NonNull List list, boolean z11, @NonNull String str) {
        this.f39392a = i10;
        this.f39393b = z10;
        this.f39394c = list;
        this.f39395d = z11;
        this.f39396e = str;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39392a);
        a.g(parcel, 2, this.f39393b);
        a.G(parcel, 3, this.f39394c, false);
        a.g(parcel, 4, this.f39395d);
        a.C(parcel, 5, this.f39396e, false);
        a.b(parcel, a10);
    }
}
