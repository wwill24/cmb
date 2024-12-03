package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class ClientIdentity extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new v();

    /* renamed from: a  reason: collision with root package name */
    public final int f38919a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38920b;

    public ClientIdentity(int i10, String str) {
        this.f38919a = i10;
        this.f38920b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        if (clientIdentity.f38919a != this.f38919a || !n.b(clientIdentity.f38920b, this.f38920b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f38919a;
    }

    @NonNull
    public final String toString() {
        int i10 = this.f38919a;
        String str = this.f38920b;
        return i10 + CertificateUtil.DELIMITER + str;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38919a);
        a.C(parcel, 2, this.f38920b, false);
        a.b(parcel, a10);
    }
}
