package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Frame implements Parcelable {
    public static final Parcelable.Creator<Frame> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f25316a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25317b;

    public static final class a implements Parcelable.Creator<Frame> {
        /* renamed from: a */
        public final Frame createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new Frame(parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final Frame[] newArray(int i10) {
            return new Frame[i10];
        }
    }

    public Frame(String str, String str2) {
        j.g(str, "absoluteFilePath");
        j.g(str2, "mimeType");
        this.f25316a = str;
        this.f25317b = str2;
    }

    public final String a() {
        return this.f25316a;
    }

    public final String c() {
        return this.f25317b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Frame)) {
            return false;
        }
        Frame frame = (Frame) obj;
        return j.b(this.f25316a, frame.f25316a) && j.b(this.f25317b, frame.f25317b);
    }

    public int hashCode() {
        return (this.f25316a.hashCode() * 31) + this.f25317b.hashCode();
    }

    public String toString() {
        return "Frame(absoluteFilePath=" + this.f25316a + ", mimeType=" + this.f25317b + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f25316a);
        parcel.writeString(this.f25317b);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Frame(java.lang.String r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0017
            java.lang.String r2 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r1)
            if (r2 == 0) goto L_0x0015
            android.webkit.MimeTypeMap r3 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r2 = r3.getMimeTypeFromExtension(r2)
            if (r2 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            java.lang.String r2 = "image/*"
        L_0x0017:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.Frame.<init>(java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
