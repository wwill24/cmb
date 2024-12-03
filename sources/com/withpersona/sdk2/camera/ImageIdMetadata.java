package com.withpersona.sdk2.camera;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ImageIdMetadata implements Parcelable {
    public static final Parcelable.Creator<ImageIdMetadata> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f14132a;

    public static final class a implements Parcelable.Creator<ImageIdMetadata> {
        /* renamed from: a */
        public final ImageIdMetadata createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new ImageIdMetadata(parcel.readString());
        }

        /* renamed from: b */
        public final ImageIdMetadata[] newArray(int i10) {
            return new ImageIdMetadata[i10];
        }
    }

    public ImageIdMetadata(String str) {
        j.g(str, "textOnImage");
        this.f14132a = str;
    }

    public final String a() {
        return this.f14132a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageIdMetadata) && j.b(this.f14132a, ((ImageIdMetadata) obj).f14132a);
    }

    public int hashCode() {
        return this.f14132a.hashCode();
    }

    public String toString() {
        return "ImageIdMetadata(textOnImage=" + this.f14132a + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f14132a);
    }
}
