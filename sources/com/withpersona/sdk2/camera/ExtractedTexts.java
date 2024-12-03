package com.withpersona.sdk2.camera;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ExtractedTexts implements Parcelable {
    public static final Parcelable.Creator<ExtractedTexts> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Date f14125a;

    /* renamed from: b  reason: collision with root package name */
    private final Date f14126b;

    public static final class a implements Parcelable.Creator<ExtractedTexts> {
        /* renamed from: a */
        public final ExtractedTexts createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new ExtractedTexts((Date) parcel.readSerializable(), (Date) parcel.readSerializable());
        }

        /* renamed from: b */
        public final ExtractedTexts[] newArray(int i10) {
            return new ExtractedTexts[i10];
        }
    }

    public ExtractedTexts(Date date, Date date2) {
        j.g(date, "dateOfBirth");
        j.g(date2, "expirationDate");
        this.f14125a = date;
        this.f14126b = date2;
    }

    public final Date a() {
        return this.f14125a;
    }

    public final Date c() {
        return this.f14126b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtractedTexts)) {
            return false;
        }
        ExtractedTexts extractedTexts = (ExtractedTexts) obj;
        return j.b(this.f14125a, extractedTexts.f14125a) && j.b(this.f14126b, extractedTexts.f14126b);
    }

    public int hashCode() {
        return (this.f14125a.hashCode() * 31) + this.f14126b.hashCode();
    }

    public String toString() {
        return "ExtractedTexts(dateOfBirth=" + this.f14125a + ", expirationDate=" + this.f14126b + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeSerializable(this.f14125a);
        parcel.writeSerializable(this.f14126b);
    }
}
