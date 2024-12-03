package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import fe.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzo extends zzbz {
    public static final Parcelable.Creator<zzo> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap f38200f;

    /* renamed from: a  reason: collision with root package name */
    final Set f38201a;

    /* renamed from: b  reason: collision with root package name */
    final int f38202b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f38203c;

    /* renamed from: d  reason: collision with root package name */
    private int f38204d;

    /* renamed from: e  reason: collision with root package name */
    private zzs f38205e;

    static {
        HashMap hashMap = new HashMap();
        f38200f = hashMap;
        hashMap.put("authenticatorData", FastJsonResponse.Field.c0("authenticatorData", 2, zzu.class));
        hashMap.put("progress", FastJsonResponse.Field.Y("progress", 4, zzs.class));
    }

    public zzo() {
        this.f38201a = new HashSet(1);
        this.f38202b = 1;
    }

    public final void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        int q02 = field.q0();
        if (q02 == 2) {
            this.f38203c = arrayList;
            this.f38201a.add(Integer.valueOf(q02));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", new Object[]{Integer.valueOf(q02), arrayList.getClass().getCanonicalName()}));
    }

    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        int q02 = field.q0();
        if (q02 == 4) {
            this.f38205e = (zzs) fastJsonResponse;
            this.f38201a.add(Integer.valueOf(q02));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", new Object[]{Integer.valueOf(q02), fastJsonResponse.getClass().getCanonicalName()}));
    }

    public final /* synthetic */ Map getFieldMappings() {
        return f38200f;
    }

    /* access modifiers changed from: protected */
    public final Object getFieldValue(FastJsonResponse.Field field) {
        int q02 = field.q0();
        if (q02 == 1) {
            return Integer.valueOf(this.f38202b);
        }
        if (q02 == 2) {
            return this.f38203c;
        }
        if (q02 == 4) {
            return this.f38205e;
        }
        int q03 = field.q0();
        throw new IllegalStateException("Unknown SafeParcelable id=" + q03);
    }

    /* access modifiers changed from: protected */
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f38201a.contains(Integer.valueOf(field.q0()));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        Set set = this.f38201a;
        if (set.contains(1)) {
            a.s(parcel, 1, this.f38202b);
        }
        if (set.contains(2)) {
            a.G(parcel, 2, this.f38203c, true);
        }
        if (set.contains(3)) {
            a.s(parcel, 3, this.f38204d);
        }
        if (set.contains(4)) {
            a.A(parcel, 4, this.f38205e, i10, true);
        }
        a.b(parcel, a10);
    }

    zzo(Set set, int i10, ArrayList arrayList, int i11, zzs zzs) {
        this.f38201a = set;
        this.f38202b = i10;
        this.f38203c = arrayList;
        this.f38204d = i11;
        this.f38205e = zzs;
    }
}
