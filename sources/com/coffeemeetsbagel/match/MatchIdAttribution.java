package com.coffeemeetsbagel.match;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class MatchIdAttribution implements Parcelable {
    public static final Parcelable.Creator<MatchIdAttribution> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f34487a;

    /* renamed from: b  reason: collision with root package name */
    private final String f34488b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f34489c;

    public static final class a implements Parcelable.Creator<MatchIdAttribution> {
        /* renamed from: a */
        public final MatchIdAttribution createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new MatchIdAttribution(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* renamed from: b */
        public final MatchIdAttribution[] newArray(int i10) {
            return new MatchIdAttribution[i10];
        }
    }

    public MatchIdAttribution(String str, String str2, Integer num) {
        j.g(str, "matchId");
        j.g(str2, "profileId");
        this.f34487a = str;
        this.f34488b = str2;
        this.f34489c = num;
    }

    public final Integer a() {
        return this.f34489c;
    }

    public final String c() {
        return this.f34487a;
    }

    public final String d() {
        return this.f34488b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchIdAttribution)) {
            return false;
        }
        MatchIdAttribution matchIdAttribution = (MatchIdAttribution) obj;
        return j.b(this.f34487a, matchIdAttribution.f34487a) && j.b(this.f34488b, matchIdAttribution.f34488b) && j.b(this.f34489c, matchIdAttribution.f34489c);
    }

    public int hashCode() {
        int hashCode = ((this.f34487a.hashCode() * 31) + this.f34488b.hashCode()) * 31;
        Integer num = this.f34489c;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "MatchIdAttribution(matchId=" + this.f34487a + ", profileId=" + this.f34488b + ", attribution=" + this.f34489c + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        int i11;
        j.g(parcel, "out");
        parcel.writeString(this.f34487a);
        parcel.writeString(this.f34488b);
        Integer num = this.f34489c;
        if (num == null) {
            i11 = 0;
        } else {
            parcel.writeInt(1);
            i11 = num.intValue();
        }
        parcel.writeInt(i11);
    }
}
