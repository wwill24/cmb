package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class Feature extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<Feature> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    private final String f38490a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final int f38491b;

    /* renamed from: c  reason: collision with root package name */
    private final long f38492c;

    public Feature(@NonNull String str, int i10, long j10) {
        this.f38490a = str;
        this.f38491b = i10;
        this.f38492c = j10;
    }

    public Feature(@NonNull String str, long j10) {
        this.f38490a = str;
        this.f38492c = j10;
        this.f38491b = -1;
    }

    @NonNull
    public String S() {
        return this.f38490a;
    }

    public long Y() {
        long j10 = this.f38492c;
        return j10 == -1 ? (long) this.f38491b : j10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((S() == null || !S().equals(feature.S())) && (S() != null || feature.S() != null)) || Y() != feature.Y()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return n.c(S(), Long.valueOf(Y()));
    }

    @NonNull
    public final String toString() {
        n.a d10 = n.d(this);
        d10.a("name", S());
        d10.a(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Long.valueOf(Y()));
        return d10.toString();
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, S(), false);
        a.s(parcel, 2, this.f38491b);
        a.v(parcel, 3, Y());
        a.b(parcel, a10);
    }
}
