package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import fe.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    final int f39166a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f39167b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39168c;

    zan(int i10, ArrayList arrayList, String str) {
        this.f39166a = i10;
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zal zal = (zal) arrayList.get(i11);
            String str2 = zal.f39161b;
            HashMap hashMap2 = new HashMap();
            int size2 = ((ArrayList) p.k(zal.f39162c)).size();
            for (int i12 = 0; i12 < size2; i12++) {
                zam zam = (zam) zal.f39162c.get(i12);
                hashMap2.put(zam.f39164b, zam.f39165c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f39167b = hashMap;
        this.f39168c = (String) p.k(str);
        c0();
    }

    public final String S() {
        return this.f39168c;
    }

    public final Map Y(String str) {
        return (Map) this.f39167b.get(str);
    }

    public final void c0() {
        for (String str : this.f39167b.keySet()) {
            Map map = (Map) this.f39167b.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).c1(this);
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.f39167b.keySet()) {
            sb2.append(str);
            sb2.append(":\n");
            Map map = (Map) this.f39167b.get(str);
            for (String str2 : map.keySet()) {
                sb2.append("  ");
                sb2.append(str2);
                sb2.append(": ");
                sb2.append(map.get(str2));
            }
        }
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39166a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f39167b.keySet()) {
            arrayList.add(new zal(str, (Map) this.f39167b.get(str)));
        }
        a.G(parcel, 2, arrayList, false);
        a.C(parcel, 3, this.f39168c, false);
        a.b(parcel, a10);
    }
}
