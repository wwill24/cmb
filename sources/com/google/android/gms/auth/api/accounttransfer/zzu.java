package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import fe.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzu extends zzbz {
    public static final Parcelable.Creator<zzu> CREATOR = new c();

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap f38213g;

    /* renamed from: a  reason: collision with root package name */
    final Set f38214a;

    /* renamed from: b  reason: collision with root package name */
    final int f38215b;

    /* renamed from: c  reason: collision with root package name */
    private zzw f38216c;

    /* renamed from: d  reason: collision with root package name */
    private String f38217d;

    /* renamed from: e  reason: collision with root package name */
    private String f38218e;

    /* renamed from: f  reason: collision with root package name */
    private String f38219f;

    static {
        HashMap hashMap = new HashMap();
        f38213g = hashMap;
        hashMap.put("authenticatorInfo", FastJsonResponse.Field.Y("authenticatorInfo", 2, zzw.class));
        hashMap.put("signature", FastJsonResponse.Field.i0("signature", 3));
        hashMap.put("package", FastJsonResponse.Field.i0("package", 4));
    }

    public zzu() {
        this.f38214a = new HashSet(3);
        this.f38215b = 1;
    }

    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        int q02 = field.q0();
        if (q02 == 2) {
            this.f38216c = (zzw) fastJsonResponse;
            this.f38214a.add(Integer.valueOf(q02));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", new Object[]{Integer.valueOf(q02), fastJsonResponse.getClass().getCanonicalName()}));
    }

    public final /* synthetic */ Map getFieldMappings() {
        return f38213g;
    }

    /* access modifiers changed from: protected */
    public final Object getFieldValue(FastJsonResponse.Field field) {
        int q02 = field.q0();
        if (q02 == 1) {
            return Integer.valueOf(this.f38215b);
        }
        if (q02 == 2) {
            return this.f38216c;
        }
        if (q02 == 3) {
            return this.f38217d;
        }
        if (q02 == 4) {
            return this.f38218e;
        }
        int q03 = field.q0();
        throw new IllegalStateException("Unknown SafeParcelable id=" + q03);
    }

    /* access modifiers changed from: protected */
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f38214a.contains(Integer.valueOf(field.q0()));
    }

    /* access modifiers changed from: protected */
    public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        int q02 = field.q0();
        if (q02 == 3) {
            this.f38217d = str2;
        } else if (q02 == 4) {
            this.f38218e = str2;
        } else {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(q02)}));
        }
        this.f38214a.add(Integer.valueOf(q02));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        Set set = this.f38214a;
        if (set.contains(1)) {
            a.s(parcel, 1, this.f38215b);
        }
        if (set.contains(2)) {
            a.A(parcel, 2, this.f38216c, i10, true);
        }
        if (set.contains(3)) {
            a.C(parcel, 3, this.f38217d, true);
        }
        if (set.contains(4)) {
            a.C(parcel, 4, this.f38218e, true);
        }
        if (set.contains(5)) {
            a.C(parcel, 5, this.f38219f, true);
        }
        a.b(parcel, a10);
    }

    zzu(Set set, int i10, zzw zzw, String str, String str2, String str3) {
        this.f38214a = set;
        this.f38215b = i10;
        this.f38216c = zzw;
        this.f38217d = str;
        this.f38218e = str2;
        this.f38219f = str3;
    }
}
