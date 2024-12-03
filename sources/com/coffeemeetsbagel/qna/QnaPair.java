package com.coffeemeetsbagel.qna;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class QnaPair implements Parcelable {
    public static final Parcelable.Creator<QnaPair> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f36210a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36211b;

    /* renamed from: c  reason: collision with root package name */
    private final String f36212c;

    /* renamed from: d  reason: collision with root package name */
    private final String f36213d;

    public static final class a implements Parcelable.Creator<QnaPair> {
        /* renamed from: a */
        public final QnaPair createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new QnaPair(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final QnaPair[] newArray(int i10) {
            return new QnaPair[i10];
        }
    }

    public QnaPair(String str, String str2, String str3, String str4) {
        j.g(str, "questionId");
        j.g(str2, "question");
        j.g(str3, "answer");
        this.f36210a = str;
        this.f36211b = str2;
        this.f36212c = str3;
        this.f36213d = str4;
    }

    public final String a() {
        return this.f36212c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QnaPair)) {
            return false;
        }
        QnaPair qnaPair = (QnaPair) obj;
        return j.b(this.f36210a, qnaPair.f36210a) && j.b(this.f36211b, qnaPair.f36211b) && j.b(this.f36212c, qnaPair.f36212c) && j.b(this.f36213d, qnaPair.f36213d);
    }

    public int hashCode() {
        int hashCode = ((((this.f36210a.hashCode() * 31) + this.f36211b.hashCode()) * 31) + this.f36212c.hashCode()) * 31;
        String str = this.f36213d;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "QnaPair(questionId=" + this.f36210a + ", question=" + this.f36211b + ", answer=" + this.f36212c + ", placeholder=" + this.f36213d + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f36210a);
        parcel.writeString(this.f36211b);
        parcel.writeString(this.f36212c);
        parcel.writeString(this.f36213d);
    }
}
