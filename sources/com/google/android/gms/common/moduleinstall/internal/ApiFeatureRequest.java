package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import ie.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import je.b;
import je.c;

public class ApiFeatureRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new c();

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator f39106e = b.f41057a;

    /* renamed from: a  reason: collision with root package name */
    private final List f39107a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f39108b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39109c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39110d;

    public ApiFeatureRequest(@NonNull List list, boolean z10, String str, String str2) {
        p.k(list);
        this.f39107a = list;
        this.f39108b = z10;
        this.f39109c = str;
        this.f39110d = str2;
    }

    @NonNull
    public static ApiFeatureRequest S(@NonNull d dVar) {
        return c0(dVar.a(), true);
    }

    static ApiFeatureRequest c0(List list, boolean z10) {
        TreeSet treeSet = new TreeSet(f39106e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collections.addAll(treeSet, ((e) it.next()).a());
        }
        return new ApiFeatureRequest(new ArrayList(treeSet), z10, (String) null, (String) null);
    }

    @NonNull
    public List<Feature> Y() {
        return this.f39107a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        if (this.f39108b != apiFeatureRequest.f39108b || !n.b(this.f39107a, apiFeatureRequest.f39107a) || !n.b(this.f39109c, apiFeatureRequest.f39109c) || !n.b(this.f39110d, apiFeatureRequest.f39110d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(Boolean.valueOf(this.f39108b), this.f39107a, this.f39109c, this.f39110d);
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.G(parcel, 1, Y(), false);
        a.g(parcel, 2, this.f39108b);
        a.C(parcel, 3, this.f39109c, false);
        a.C(parcel, 4, this.f39110d, false);
        a.b(parcel, a10);
    }
}
