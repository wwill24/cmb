package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;

public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<TokenData> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f38185a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38186b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f38187c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f38188d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f38189e;

    /* renamed from: f  reason: collision with root package name */
    private final List f38190f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38191g;

    TokenData(int i10, String str, Long l10, boolean z10, boolean z11, List list, String str2) {
        this.f38185a = i10;
        this.f38186b = p.g(str);
        this.f38187c = l10;
        this.f38188d = z10;
        this.f38189e = z11;
        this.f38190f = list;
        this.f38191g = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        if (!TextUtils.equals(this.f38186b, tokenData.f38186b) || !n.b(this.f38187c, tokenData.f38187c) || this.f38188d != tokenData.f38188d || this.f38189e != tokenData.f38189e || !n.b(this.f38190f, tokenData.f38190f) || !n.b(this.f38191g, tokenData.f38191g)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(this.f38186b, this.f38187c, Boolean.valueOf(this.f38188d), Boolean.valueOf(this.f38189e), this.f38190f, this.f38191g);
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38185a);
        a.C(parcel, 2, this.f38186b, false);
        a.x(parcel, 3, this.f38187c, false);
        a.g(parcel, 4, this.f38188d);
        a.g(parcel, 5, this.f38189e);
        a.E(parcel, 6, this.f38190f, false);
        a.C(parcel, 7, this.f38191g, false);
        a.b(parcel, a10);
    }
}
