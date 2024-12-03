package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class RawExtraction implements Parcelable {
    public static final Parcelable.Creator<RawExtraction> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f25716a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25717b;

    public static final class a implements Parcelable.Creator<RawExtraction> {
        /* renamed from: a */
        public final RawExtraction createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new RawExtraction(parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final RawExtraction[] newArray(int i10) {
            return new RawExtraction[i10];
        }
    }

    public RawExtraction(String str, String str2) {
        j.g(str, "type");
        j.g(str2, "value");
        this.f25716a = str;
        this.f25717b = str2;
    }

    public final String a() {
        return this.f25716a;
    }

    public final String c() {
        return this.f25717b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f25716a);
        parcel.writeString(this.f25717b);
    }
}
