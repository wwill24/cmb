package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import fe.a;
import java.util.ArrayList;
import java.util.Map;

public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f39160a;

    /* renamed from: b  reason: collision with root package name */
    final String f39161b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList f39162c;

    zal(int i10, String str, ArrayList arrayList) {
        this.f39160a = i10;
        this.f39161b = str;
        this.f39162c = arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39160a);
        a.C(parcel, 2, this.f39161b, false);
        a.G(parcel, 3, this.f39162c, false);
        a.b(parcel, a10);
    }

    zal(String str, Map map) {
        ArrayList arrayList;
        this.f39160a = 1;
        this.f39161b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, (FastJsonResponse.Field) map.get(str2)));
            }
        }
        this.f39162c = arrayList;
    }
}
