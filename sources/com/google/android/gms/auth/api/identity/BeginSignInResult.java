package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import yd.a;

public final class BeginSignInResult extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<BeginSignInResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final PendingIntent f38303a;

    public BeginSignInResult(@NonNull PendingIntent pendingIntent) {
        this.f38303a = (PendingIntent) p.k(pendingIntent);
    }

    @NonNull
    public PendingIntent S() {
        return this.f38303a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.A(parcel, 1, S(), i10, false);
        fe.a.b(parcel, a10);
    }
}
