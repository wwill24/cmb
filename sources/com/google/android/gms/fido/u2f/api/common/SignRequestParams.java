package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import fe.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Deprecated
public class SignRequestParams extends RequestParams {
    @NonNull
    public static final Parcelable.Creator<SignRequestParams> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    private final Integer f39443a;

    /* renamed from: b  reason: collision with root package name */
    private final Double f39444b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f39445c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f39446d;

    /* renamed from: e  reason: collision with root package name */
    private final List f39447e;

    /* renamed from: f  reason: collision with root package name */
    private final ChannelIdValue f39448f;

    /* renamed from: g  reason: collision with root package name */
    private final String f39449g;

    /* renamed from: h  reason: collision with root package name */
    private final Set f39450h;

    SignRequestParams(Integer num, Double d10, Uri uri, byte[] bArr, List list, ChannelIdValue channelIdValue, String str) {
        boolean z10;
        boolean z11;
        this.f39443a = num;
        this.f39444b = d10;
        this.f39445c = uri;
        this.f39446d = bArr;
        boolean z12 = false;
        if (list == null || list.isEmpty()) {
            z10 = false;
        } else {
            z10 = true;
        }
        p.b(z10, "registeredKeys must not be null or empty");
        this.f39447e = list;
        this.f39448f = channelIdValue;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RegisteredKey registeredKey = (RegisteredKey) it.next();
            if (registeredKey.S() == null && uri == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            p.b(z11, "registered key has null appId and no request appId is provided");
            String Y = registeredKey.Y();
            p.b(true, "register request has null challenge and no default challenge isprovided");
            if (registeredKey.S() != null) {
                hashSet.add(Uri.parse(registeredKey.S()));
            }
        }
        this.f39450h = hashSet;
        p.b((str == null || str.length() <= 80) ? true : z12, "Display Hint cannot be longer than 80 characters");
        this.f39449g = str;
    }

    @NonNull
    public Uri S() {
        return this.f39445c;
    }

    @NonNull
    public ChannelIdValue Y() {
        return this.f39448f;
    }

    @NonNull
    public byte[] c0() {
        return this.f39446d;
    }

    public boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignRequestParams)) {
            return false;
        }
        SignRequestParams signRequestParams = (SignRequestParams) obj;
        if (!n.b(this.f39443a, signRequestParams.f39443a) || !n.b(this.f39444b, signRequestParams.f39444b) || !n.b(this.f39445c, signRequestParams.f39445c) || !Arrays.equals(this.f39446d, signRequestParams.f39446d) || !this.f39447e.containsAll(signRequestParams.f39447e) || !signRequestParams.f39447e.containsAll(this.f39447e) || !n.b(this.f39448f, signRequestParams.f39448f) || !n.b(this.f39449g, signRequestParams.f39449g)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String f0() {
        return this.f39449g;
    }

    public int hashCode() {
        return n.c(this.f39443a, this.f39445c, this.f39444b, this.f39447e, this.f39448f, this.f39449g, Integer.valueOf(Arrays.hashCode(this.f39446d)));
    }

    @NonNull
    public List<RegisteredKey> i0() {
        return this.f39447e;
    }

    @NonNull
    public Integer m0() {
        return this.f39443a;
    }

    public Double q0() {
        return this.f39444b;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.u(parcel, 2, m0(), false);
        a.n(parcel, 3, q0(), false);
        a.A(parcel, 4, S(), i10, false);
        a.k(parcel, 5, c0(), false);
        a.G(parcel, 6, i0(), false);
        a.A(parcel, 7, Y(), i10, false);
        a.C(parcel, 8, f0(), false);
        a.b(parcel, a10);
    }
}
