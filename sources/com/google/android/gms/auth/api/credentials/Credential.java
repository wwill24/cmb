package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Collections;
import java.util.List;

@Deprecated
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Credential> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f38228a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38229b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f38230c;

    /* renamed from: d  reason: collision with root package name */
    private final List f38231d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38232e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38233f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38234g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38235h;

    Credential(String str, String str2, Uri uri, List list, String str3, String str4, String str5, String str6) {
        List list2;
        Boolean bool;
        String trim = ((String) p.l(str, "credential identifier cannot be null")).trim();
        p.h(trim, "credential identifier cannot be empty");
        if (str3 == null || !TextUtils.isEmpty(str3)) {
            if (str4 != null) {
                if (TextUtils.isEmpty(str4)) {
                    bool = Boolean.FALSE;
                } else {
                    Uri parse = Uri.parse(str4);
                    if (!parse.isAbsolute() || !parse.isHierarchical() || TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getAuthority())) {
                        bool = Boolean.FALSE;
                    } else {
                        boolean z10 = true;
                        if (!"http".equalsIgnoreCase(parse.getScheme()) && !"https".equalsIgnoreCase(parse.getScheme())) {
                            z10 = false;
                        }
                        bool = Boolean.valueOf(z10);
                    }
                }
                if (!bool.booleanValue()) {
                    throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
                }
            }
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                if (str2 != null && TextUtils.isEmpty(str2.trim())) {
                    str2 = null;
                }
                this.f38229b = str2;
                this.f38230c = uri;
                if (list == null) {
                    list2 = Collections.emptyList();
                } else {
                    list2 = Collections.unmodifiableList(list);
                }
                this.f38231d = list2;
                this.f38228a = trim;
                this.f38232e = str3;
                this.f38233f = str4;
                this.f38234g = str5;
                this.f38235h = str6;
                return;
            }
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        throw new IllegalArgumentException("Password must not be empty if set");
    }

    public String S() {
        return this.f38233f;
    }

    public String Y() {
        return this.f38235h;
    }

    public String c0() {
        return this.f38234g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        if (!TextUtils.equals(this.f38228a, credential.f38228a) || !TextUtils.equals(this.f38229b, credential.f38229b) || !n.b(this.f38230c, credential.f38230c) || !TextUtils.equals(this.f38232e, credential.f38232e) || !TextUtils.equals(this.f38233f, credential.f38233f)) {
            return false;
        }
        return true;
    }

    public String f0() {
        return this.f38228a;
    }

    public int hashCode() {
        return n.c(this.f38228a, this.f38229b, this.f38230c, this.f38232e, this.f38233f);
    }

    public List<IdToken> i0() {
        return this.f38231d;
    }

    public String m0() {
        return this.f38229b;
    }

    public String q0() {
        return this.f38232e;
    }

    public Uri t0() {
        return this.f38230c;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, f0(), false);
        a.C(parcel, 2, m0(), false);
        a.A(parcel, 3, t0(), i10, false);
        a.G(parcel, 4, i0(), false);
        a.C(parcel, 5, q0(), false);
        a.C(parcel, 6, S(), false);
        a.C(parcel, 9, c0(), false);
        a.C(parcel, 10, Y(), false);
        a.b(parcel, a10);
    }
}
