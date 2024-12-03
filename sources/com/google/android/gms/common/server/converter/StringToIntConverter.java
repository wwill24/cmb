package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import fe.a;
import java.util.ArrayList;
import java.util.HashMap;

public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {
    @NonNull
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f39134a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f39135b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray f39136c;

    public StringToIntConverter() {
        this.f39134a = 1;
        this.f39135b = new HashMap();
        this.f39136c = new SparseArray();
    }

    public final /* bridge */ /* synthetic */ Object E(@NonNull Object obj) {
        Integer num = (Integer) this.f39135b.get((String) obj);
        if (num == null) {
            return (Integer) this.f39135b.get("gms_unknown");
        }
        return num;
    }

    @NonNull
    public StringToIntConverter S(@NonNull String str, int i10) {
        this.f39135b.put(str, Integer.valueOf(i10));
        this.f39136c.put(i10, str);
        return this;
    }

    @NonNull
    public final /* bridge */ /* synthetic */ Object u(@NonNull Object obj) {
        String str = (String) this.f39136c.get(((Integer) obj).intValue());
        if (str != null || !this.f39135b.containsKey("gms_unknown")) {
            return str;
        }
        return "gms_unknown";
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39134a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f39135b.keySet()) {
            arrayList.add(new zac(str, ((Integer) this.f39135b.get(str)).intValue()));
        }
        a.G(parcel, 2, arrayList, false);
        a.b(parcel, a10);
    }

    StringToIntConverter(int i10, ArrayList arrayList) {
        this.f39134a = i10;
        this.f39135b = new HashMap();
        this.f39136c = new SparseArray();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zac zac = (zac) arrayList.get(i11);
            S(zac.f39140b, zac.f39141c);
        }
    }
}
