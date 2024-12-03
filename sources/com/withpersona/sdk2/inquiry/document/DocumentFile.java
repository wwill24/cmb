package com.withpersona.sdk2.inquiry.document;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class DocumentFile implements Parcelable {

    public static final class Local extends DocumentFile {
        public static final Parcelable.Creator<Local> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f24969a;

        /* renamed from: b  reason: collision with root package name */
        private final CaptureMethod f24970b;

        /* renamed from: c  reason: collision with root package name */
        private final int f24971c;

        public static final class a implements Parcelable.Creator<Local> {
            /* renamed from: a */
            public final Local createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Local(parcel.readString(), CaptureMethod.CREATOR.createFromParcel(parcel), parcel.readInt());
            }

            /* renamed from: b */
            public final Local[] newArray(int i10) {
                return new Local[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Local(String str, CaptureMethod captureMethod, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, captureMethod, (i11 & 4) != 0 ? 0 : i10);
        }

        public static /* synthetic */ Local c(Local local, String str, CaptureMethod captureMethod, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = local.f24969a;
            }
            if ((i11 & 2) != 0) {
                captureMethod = local.f24970b;
            }
            if ((i11 & 4) != 0) {
                i10 = local.f24971c;
            }
            return local.a(str, captureMethod, i10);
        }

        public final Local a(String str, CaptureMethod captureMethod, int i10) {
            j.g(str, "absoluteFilePath");
            j.g(captureMethod, "captureMethod");
            return new Local(str, captureMethod, i10);
        }

        public final String d() {
            return this.f24969a;
        }

        public int describeContents() {
            return 0;
        }

        public final CaptureMethod e() {
            return this.f24970b;
        }

        public boolean equals(Object obj) {
            Class<?> cls;
            if (this == obj) {
                return true;
            }
            Class<Local> cls2 = Local.class;
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!j.b(cls2, cls)) {
                return false;
            }
            j.e(obj, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.document.DocumentFile.Local");
            return j.b(this.f24969a, ((Local) obj).f24969a);
        }

        public final int f() {
            return this.f24971c;
        }

        public int hashCode() {
            return this.f24969a.hashCode();
        }

        public String toString() {
            return "Local(absoluteFilePath=" + this.f24969a + ", captureMethod=" + this.f24970b + ", uploadProgress=" + this.f24971c + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f24969a);
            this.f24970b.writeToParcel(parcel, i10);
            parcel.writeInt(this.f24971c);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Local(String str, CaptureMethod captureMethod, int i10) {
            super((DefaultConstructorMarker) null);
            j.g(str, "absoluteFilePath");
            j.g(captureMethod, "captureMethod");
            this.f24969a = str;
            this.f24970b = captureMethod;
            this.f24971c = i10;
        }
    }

    public static final class Remote extends DocumentFile {
        public static final Parcelable.Creator<Remote> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f24972a;

        /* renamed from: b  reason: collision with root package name */
        private final String f24973b;

        /* renamed from: c  reason: collision with root package name */
        private final String f24974c;

        /* renamed from: d  reason: collision with root package name */
        private final String f24975d;

        public static final class a implements Parcelable.Creator<Remote> {
            /* renamed from: a */
            public final Remote createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Remote(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* renamed from: b */
            public final Remote[] newArray(int i10) {
                return new Remote[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Remote(String str, String str2, String str3, String str4) {
            super((DefaultConstructorMarker) null);
            j.g(str3, "remoteUrl");
            j.g(str4, "documentFileId");
            this.f24972a = str;
            this.f24973b = str2;
            this.f24974c = str3;
            this.f24975d = str4;
        }

        public final String a() {
            return this.f24972a;
        }

        public final String c() {
            return this.f24975d;
        }

        public final String d() {
            return this.f24973b;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f24974c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Remote)) {
                return false;
            }
            Remote remote = (Remote) obj;
            return j.b(this.f24972a, remote.f24972a) && j.b(this.f24973b, remote.f24973b) && j.b(this.f24974c, remote.f24974c) && j.b(this.f24975d, remote.f24975d);
        }

        public int hashCode() {
            String str = this.f24972a;
            int i10 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f24973b;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return ((((hashCode + i10) * 31) + this.f24974c.hashCode()) * 31) + this.f24975d.hashCode();
        }

        public String toString() {
            return "Remote(absoluteFilePath=" + this.f24972a + ", filename=" + this.f24973b + ", remoteUrl=" + this.f24974c + ", documentFileId=" + this.f24975d + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f24972a);
            parcel.writeString(this.f24973b);
            parcel.writeString(this.f24974c);
            parcel.writeString(this.f24975d);
        }
    }

    private DocumentFile() {
    }

    public /* synthetic */ DocumentFile(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
