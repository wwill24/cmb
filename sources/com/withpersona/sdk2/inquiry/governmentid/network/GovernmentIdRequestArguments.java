package com.withpersona.sdk2.inquiry.governmentid.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class GovernmentIdRequestArguments implements Parcelable {
    public static final Parcelable.Creator<GovernmentIdRequestArguments> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<GovernmentId> f25832a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25833b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25834c;

    public static final class a implements Parcelable.Creator<GovernmentIdRequestArguments> {
        /* renamed from: a */
        public final GovernmentIdRequestArguments createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                arrayList.add(parcel.readParcelable(GovernmentIdRequestArguments.class.getClassLoader()));
            }
            return new GovernmentIdRequestArguments(arrayList, parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final GovernmentIdRequestArguments[] newArray(int i10) {
            return new GovernmentIdRequestArguments[i10];
        }
    }

    public GovernmentIdRequestArguments(List<? extends GovernmentId> list, String str, String str2) {
        j.g(list, "ids");
        j.g(str, "fieldKeyDocument");
        j.g(str2, "fieldKeyIdClass");
        this.f25832a = list;
        this.f25833b = str;
        this.f25834c = str2;
    }

    public final String a() {
        return this.f25833b;
    }

    public final String c() {
        return this.f25834c;
    }

    public final List<GovernmentId> d() {
        return this.f25832a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GovernmentIdRequestArguments)) {
            return false;
        }
        GovernmentIdRequestArguments governmentIdRequestArguments = (GovernmentIdRequestArguments) obj;
        return j.b(this.f25832a, governmentIdRequestArguments.f25832a) && j.b(this.f25833b, governmentIdRequestArguments.f25833b) && j.b(this.f25834c, governmentIdRequestArguments.f25834c);
    }

    public int hashCode() {
        return (((this.f25832a.hashCode() * 31) + this.f25833b.hashCode()) * 31) + this.f25834c.hashCode();
    }

    public String toString() {
        return "GovernmentIdRequestArguments(ids=" + this.f25832a + ", fieldKeyDocument=" + this.f25833b + ", fieldKeyIdClass=" + this.f25834c + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<GovernmentId> list = this.f25832a;
        parcel.writeInt(list.size());
        for (GovernmentId writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i10);
        }
        parcel.writeString(this.f25833b);
        parcel.writeString(this.f25834c);
    }
}
