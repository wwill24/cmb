package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;

public class AccountChangeEventsResponse extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    final int f38183a;

    /* renamed from: b  reason: collision with root package name */
    final List f38184b;

    AccountChangeEventsResponse(int i10, List list) {
        this.f38183a = i10;
        this.f38184b = (List) p.k(list);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38183a);
        a.G(parcel, 2, this.f38184b, false);
        a.b(parcel, a10);
    }
}
