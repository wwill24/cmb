package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class CloudMessage extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<CloudMessage> CREATOR = new d();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    Intent f38428a;

    public CloudMessage(@NonNull Intent intent) {
        this.f38428a = intent;
    }

    @NonNull
    public Intent S() {
        return this.f38428a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, this.f38428a, i10, false);
        a.b(parcel, a10);
    }
}
