package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f38416a;

    /* renamed from: b  reason: collision with root package name */
    private int f38417b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f38418c;

    GoogleSignInOptionsExtensionParcelable(int i10, int i11, Bundle bundle) {
        this.f38416a = i10;
        this.f38417b = i11;
        this.f38418c = bundle;
    }

    public int getType() {
        return this.f38417b;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38416a);
        a.s(parcel, 2, getType());
        a.j(parcel, 3, this.f38418c, false);
        a.b(parcel, a10);
    }
}
