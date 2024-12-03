package com.withpersona.sdk2.inquiry.ui.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class Suggestion implements Parcelable {
    public static final Parcelable.Creator<Suggestion> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f29442a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29443b;

    public static final class a implements Parcelable.Creator<Suggestion> {
        /* renamed from: a */
        public final Suggestion createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new Suggestion(parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final Suggestion[] newArray(int i10) {
            return new Suggestion[i10];
        }
    }

    public Suggestion(String str, String str2) {
        j.g(str, "id");
        j.g(str2, "address");
        this.f29442a = str;
        this.f29443b = str2;
    }

    public final String a() {
        return this.f29443b;
    }

    public final String c() {
        return this.f29442a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.valueOf(this.f29443b);
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f29442a);
        parcel.writeString(this.f29443b);
    }
}
