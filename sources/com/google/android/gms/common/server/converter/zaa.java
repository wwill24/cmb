package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import fe.a;

public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f39137a;

    /* renamed from: b  reason: collision with root package name */
    private final StringToIntConverter f39138b;

    zaa(int i10, StringToIntConverter stringToIntConverter) {
        this.f39137a = i10;
        this.f39138b = stringToIntConverter;
    }

    public static zaa S(FastJsonResponse.a aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final FastJsonResponse.a Y() {
        StringToIntConverter stringToIntConverter = this.f39138b;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39137a);
        a.A(parcel, 2, this.f39138b, i10, false);
        a.b(parcel, a10);
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.f39137a = 1;
        this.f39138b = stringToIntConverter;
    }
}
