package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class EnabledIdClass implements Parcelable {
    public static final Parcelable.Creator<EnabledIdClass> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f25313a;

    /* renamed from: b  reason: collision with root package name */
    private final IdConfig f25314b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25315c;

    public static final class a implements Parcelable.Creator<EnabledIdClass> {
        /* renamed from: a */
        public final EnabledIdClass createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new EnabledIdClass(parcel.readInt(), IdConfig.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* renamed from: b */
        public final EnabledIdClass[] newArray(int i10) {
            return new EnabledIdClass[i10];
        }
    }

    public EnabledIdClass(int i10, IdConfig idConfig, String str) {
        j.g(idConfig, "idConfig");
        j.g(str, "name");
        this.f25313a = i10;
        this.f25314b = idConfig;
        this.f25315c = str;
    }

    public final int a() {
        return this.f25313a;
    }

    public final IdConfig c() {
        return this.f25314b;
    }

    public final String d() {
        return this.f25315c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnabledIdClass)) {
            return false;
        }
        EnabledIdClass enabledIdClass = (EnabledIdClass) obj;
        return this.f25313a == enabledIdClass.f25313a && j.b(this.f25314b, enabledIdClass.f25314b) && j.b(this.f25315c, enabledIdClass.f25315c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f25313a) * 31) + this.f25314b.hashCode()) * 31) + this.f25315c.hashCode();
    }

    public String toString() {
        return "EnabledIdClass(iconRes=" + this.f25313a + ", idConfig=" + this.f25314b + ", name=" + this.f25315c + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeInt(this.f25313a);
        this.f25314b.writeToParcel(parcel, i10);
        parcel.writeString(this.f25315c);
    }
}
