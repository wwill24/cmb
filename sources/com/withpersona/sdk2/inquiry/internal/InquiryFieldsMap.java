package com.withpersona.sdk2.inquiry.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class InquiryFieldsMap implements Parcelable {
    public static final Parcelable.Creator<InquiryFieldsMap> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, InquiryField> f26147a;

    public static final class a implements Parcelable.Creator<InquiryFieldsMap> {
        /* renamed from: a */
        public final InquiryFieldsMap createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                linkedHashMap.put(parcel.readString(), parcel.readParcelable(InquiryFieldsMap.class.getClassLoader()));
            }
            return new InquiryFieldsMap(linkedHashMap);
        }

        /* renamed from: b */
        public final InquiryFieldsMap[] newArray(int i10) {
            return new InquiryFieldsMap[i10];
        }
    }

    public InquiryFieldsMap(Map<String, ? extends InquiryField> map) {
        j.g(map, "fields");
        this.f26147a = map;
    }

    public final Map<String, InquiryField> a() {
        return this.f26147a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        Map<String, InquiryField> map = this.f26147a;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeParcelable((Parcelable) next.getValue(), i10);
        }
    }
}
