package com.withpersona.sdk2.inquiry.document;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class DocumentDescription implements Parcelable {
    public static final Parcelable.Creator<DocumentDescription> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f24963a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24964b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24965c;

    /* renamed from: d  reason: collision with root package name */
    private final String f24966d;

    public static final class a implements Parcelable.Creator<DocumentDescription> {
        /* renamed from: a */
        public final DocumentDescription createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new DocumentDescription(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final DocumentDescription[] newArray(int i10) {
            return new DocumentDescription[i10];
        }
    }

    public DocumentDescription(String str, String str2, String str3, String str4) {
        j.g(str, "kind");
        j.g(str2, "title");
        j.g(str3, "prompt");
        j.g(str4, "description");
        this.f24963a = str;
        this.f24964b = str2;
        this.f24965c = str3;
        this.f24966d = str4;
    }

    public final String a() {
        return this.f24966d;
    }

    public final String c() {
        return this.f24963a;
    }

    public final String d() {
        return this.f24965c;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f24964b;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f24963a);
        parcel.writeString(this.f24964b);
        parcel.writeString(this.f24965c);
        parcel.writeString(this.f24966d);
    }
}
