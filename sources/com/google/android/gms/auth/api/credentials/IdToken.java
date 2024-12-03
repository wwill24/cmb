package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import xd.f;

@Deprecated
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<IdToken> CREATOR = new f();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f38267a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f38268b;

    public IdToken(@NonNull String str, @NonNull String str2) {
        p.b(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        p.b(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.f38267a = str;
        this.f38268b = str2;
    }

    @NonNull
    public String S() {
        return this.f38267a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        if (!n.b(this.f38267a, idToken.f38267a) || !n.b(this.f38268b, idToken.f38268b)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getIdToken() {
        return this.f38268b;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, S(), false);
        a.C(parcel, 2, getIdToken(), false);
        a.b(parcel, a10);
    }
}
