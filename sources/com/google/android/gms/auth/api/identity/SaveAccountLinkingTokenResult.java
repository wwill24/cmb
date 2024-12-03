package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import yd.c;

public class SaveAccountLinkingTokenResult extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SaveAccountLinkingTokenResult> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final PendingIntent f38329a;

    public SaveAccountLinkingTokenResult(PendingIntent pendingIntent) {
        this.f38329a = pendingIntent;
    }

    public PendingIntent S() {
        return this.f38329a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenResult)) {
            return false;
        }
        return n.b(this.f38329a, ((SaveAccountLinkingTokenResult) obj).f38329a);
    }

    public int hashCode() {
        return n.c(this.f38329a);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, S(), i10, false);
        a.b(parcel, a10);
    }
}
