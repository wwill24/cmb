package com.withpersona.sdk2.inquiry.document;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;

public enum CaptureMethod implements Parcelable {
    UPLOAD("upload"),
    MANUAL("manual");
    
    public static final Parcelable.Creator<CaptureMethod> CREATOR = null;
    private final String type;

    public static final class a implements Parcelable.Creator<CaptureMethod> {
        /* renamed from: a */
        public final CaptureMethod createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return CaptureMethod.valueOf(parcel.readString());
        }

        /* renamed from: b */
        public final CaptureMethod[] newArray(int i10) {
            return new CaptureMethod[i10];
        }
    }

    static {
        CREATOR = new a();
    }

    private CaptureMethod(String str) {
        this.type = str;
    }

    public final String c() {
        return this.type;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(name());
    }
}
