package com.coffeemeetsbagel.photo;

import android.os.Parcel;
import android.os.Parcelable;
import com.coffeemeetsbagel.models.enums.MediaItemType;
import com.coffeemeetsbagel.models.interfaces.MediaItemContract;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Photo implements MediaItemContract.MediaItem, Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f35781a;

    /* renamed from: b  reason: collision with root package name */
    private final String f35782b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35783c;

    /* renamed from: d  reason: collision with root package name */
    private final String f35784d;

    /* renamed from: e  reason: collision with root package name */
    private final String f35785e;

    public static final class a implements Parcelable.Creator<Photo> {
        /* renamed from: a */
        public final Photo createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new Photo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final Photo[] newArray(int i10) {
            return new Photo[i10];
        }
    }

    public Photo(String str, String str2, int i10, String str3, String str4) {
        j.g(str, "id");
        j.g(str3, "profileId");
        j.g(str4, "phoneUrl");
        this.f35781a = str;
        this.f35782b = str2;
        this.f35783c = i10;
        this.f35784d = str3;
        this.f35785e = str4;
    }

    public final String a() {
        return this.f35782b;
    }

    public final String c() {
        return this.f35781a;
    }

    public final int d() {
        return this.f35783c;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f35784d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Photo)) {
            return false;
        }
        Photo photo = (Photo) obj;
        return j.b(this.f35781a, photo.f35781a) && j.b(this.f35782b, photo.f35782b) && this.f35783c == photo.f35783c && j.b(this.f35784d, photo.f35784d) && j.b(this.f35785e, photo.f35785e);
    }

    public MediaItemType getType() {
        return MediaItemType.PHOTO;
    }

    public String getUrl() {
        return this.f35785e;
    }

    public int hashCode() {
        int hashCode = this.f35781a.hashCode() * 31;
        String str = this.f35782b;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.f35783c)) * 31) + this.f35784d.hashCode()) * 31) + this.f35785e.hashCode();
    }

    public String toString() {
        return "Photo(id=" + this.f35781a + ", caption=" + this.f35782b + ", position=" + this.f35783c + ", profileId=" + this.f35784d + ", phoneUrl=" + this.f35785e + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f35781a);
        parcel.writeString(this.f35782b);
        parcel.writeInt(this.f35783c);
        parcel.writeString(this.f35784d);
        parcel.writeString(this.f35785e);
    }
}
