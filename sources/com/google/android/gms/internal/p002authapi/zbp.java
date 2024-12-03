package com.google.android.gms.internal.p002authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

/* renamed from: com.google.android.gms.internal.auth-api.zbp  reason: invalid package */
public final class zbp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zbp> CREATOR = new zbq();
    private final Credential zba;

    public zbp(Credential credential) {
        this.zba = credential;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, this.zba, i10, false);
        a.b(parcel, a10);
    }
}
