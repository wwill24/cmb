package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import fe.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Deprecated
public class RegisterRequestParams extends RequestParams {
    @NonNull
    public static final Parcelable.Creator<RegisterRequestParams> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final Integer f39429a;

    /* renamed from: b  reason: collision with root package name */
    private final Double f39430b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f39431c;

    /* renamed from: d  reason: collision with root package name */
    private final List f39432d;

    /* renamed from: e  reason: collision with root package name */
    private final List f39433e;

    /* renamed from: f  reason: collision with root package name */
    private final ChannelIdValue f39434f;

    /* renamed from: g  reason: collision with root package name */
    private final String f39435g;

    /* renamed from: h  reason: collision with root package name */
    private Set f39436h;

    RegisterRequestParams(Integer num, Double d10, Uri uri, List list, List list2, ChannelIdValue channelIdValue, String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        this.f39429a = num;
        this.f39430b = d10;
        this.f39431c = uri;
        boolean z13 = false;
        if (list == null || list.isEmpty()) {
            z10 = false;
        } else {
            z10 = true;
        }
        p.b(z10, "empty list of register requests is provided");
        this.f39432d = list;
        this.f39433e = list2;
        this.f39434f = channelIdValue;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RegisterRequest registerRequest = (RegisterRequest) it.next();
            if (uri == null && registerRequest.S() == null) {
                z12 = false;
            } else {
                z12 = true;
            }
            p.b(z12, "register request has null appId and no request appId is provided");
            if (registerRequest.S() != null) {
                hashSet.add(Uri.parse(registerRequest.S()));
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            RegisteredKey registeredKey = (RegisteredKey) it2.next();
            if (uri == null && registeredKey.S() == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            p.b(z11, "registered key has null appId and no request appId is provided");
            if (registeredKey.S() != null) {
                hashSet.add(Uri.parse(registeredKey.S()));
            }
        }
        this.f39436h = hashSet;
        p.b((str == null || str.length() <= 80) ? true : z13, "Display Hint cannot be longer than 80 characters");
        this.f39435g = str;
    }

    @NonNull
    public Uri S() {
        return this.f39431c;
    }

    @NonNull
    public ChannelIdValue Y() {
        return this.f39434f;
    }

    @NonNull
    public String c0() {
        return this.f39435g;
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        List list2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequestParams)) {
            return false;
        }
        RegisterRequestParams registerRequestParams = (RegisterRequestParams) obj;
        if (!n.b(this.f39429a, registerRequestParams.f39429a) || !n.b(this.f39430b, registerRequestParams.f39430b) || !n.b(this.f39431c, registerRequestParams.f39431c) || !n.b(this.f39432d, registerRequestParams.f39432d) || ((((list = this.f39433e) != null || registerRequestParams.f39433e != null) && (list == null || (list2 = registerRequestParams.f39433e) == null || !list.containsAll(list2) || !registerRequestParams.f39433e.containsAll(this.f39433e))) || !n.b(this.f39434f, registerRequestParams.f39434f) || !n.b(this.f39435g, registerRequestParams.f39435g))) {
            return false;
        }
        return true;
    }

    @NonNull
    public List<RegisterRequest> f0() {
        return this.f39432d;
    }

    public int hashCode() {
        return n.c(this.f39429a, this.f39431c, this.f39430b, this.f39432d, this.f39433e, this.f39434f, this.f39435g);
    }

    @NonNull
    public List<RegisteredKey> i0() {
        return this.f39433e;
    }

    @NonNull
    public Integer m0() {
        return this.f39429a;
    }

    @NonNull
    public Double q0() {
        return this.f39430b;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.u(parcel, 2, m0(), false);
        a.n(parcel, 3, q0(), false);
        a.A(parcel, 4, S(), i10, false);
        a.G(parcel, 5, f0(), false);
        a.G(parcel, 6, i0(), false);
        a.A(parcel, 7, Y(), i10, false);
        a.C(parcel, 8, c0(), false);
        a.b(parcel, a10);
    }
}
