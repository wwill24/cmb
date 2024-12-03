package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import yd.d;

public class SavePasswordResult extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SavePasswordResult> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final PendingIntent f38336a;

    public SavePasswordResult(@NonNull PendingIntent pendingIntent) {
        this.f38336a = (PendingIntent) p.k(pendingIntent);
    }

    @NonNull
    public PendingIntent S() {
        return this.f38336a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SavePasswordResult)) {
            return false;
        }
        return n.b(this.f38336a, ((SavePasswordResult) obj).f38336a);
    }

    public int hashCode() {
        return n.c(this.f38336a);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, S(), i10, false);
        a.b(parcel, a10);
    }
}
