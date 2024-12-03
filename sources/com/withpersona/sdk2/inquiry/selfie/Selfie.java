package com.withpersona.sdk2.inquiry.selfie;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class Selfie implements Parcelable {

    public enum CaptureMethod {
        AUTO("auto"),
        MANUAL("manual");
        
        private final String method;

        private CaptureMethod(String str) {
            this.method = str;
        }

        public final String b() {
            return this.method;
        }
    }

    public enum Direction {
        CENTER,
        LEFT,
        RIGHT
    }

    public static final class SelfieImage extends Selfie {
        public static final Parcelable.Creator<SelfieImage> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f27187a;

        /* renamed from: b  reason: collision with root package name */
        private final CaptureMethod f27188b;

        /* renamed from: c  reason: collision with root package name */
        private final Direction f27189c;

        public static final class a implements Parcelable.Creator<SelfieImage> {
            /* renamed from: a */
            public final SelfieImage createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new SelfieImage(parcel.readString(), CaptureMethod.valueOf(parcel.readString()), Direction.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final SelfieImage[] newArray(int i10) {
                return new SelfieImage[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelfieImage(String str, CaptureMethod captureMethod, Direction direction) {
            super((DefaultConstructorMarker) null);
            j.g(str, "absoluteFilePath");
            j.g(captureMethod, "captureMethod");
            j.g(direction, "direction");
            this.f27187a = str;
            this.f27188b = captureMethod;
            this.f27189c = direction;
        }

        public String a() {
            return this.f27187a;
        }

        public CaptureMethod c() {
            return this.f27188b;
        }

        public final Direction d() {
            return this.f27189c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SelfieImage)) {
                return false;
            }
            SelfieImage selfieImage = (SelfieImage) obj;
            return j.b(a(), selfieImage.a()) && c() == selfieImage.c() && this.f27189c == selfieImage.f27189c;
        }

        public int hashCode() {
            return (((a().hashCode() * 31) + c().hashCode()) * 31) + this.f27189c.hashCode();
        }

        public String toString() {
            return "SelfieImage(absoluteFilePath=" + a() + ", captureMethod=" + c() + ", direction=" + this.f27189c + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27187a);
            parcel.writeString(this.f27188b.name());
            parcel.writeString(this.f27189c.name());
        }
    }

    public static final class SelfieVideo extends Selfie {
        public static final Parcelable.Creator<SelfieVideo> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f27190a;

        /* renamed from: b  reason: collision with root package name */
        private final CaptureMethod f27191b;

        public static final class a implements Parcelable.Creator<SelfieVideo> {
            /* renamed from: a */
            public final SelfieVideo createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new SelfieVideo(parcel.readString(), CaptureMethod.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final SelfieVideo[] newArray(int i10) {
                return new SelfieVideo[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelfieVideo(String str, CaptureMethod captureMethod) {
            super((DefaultConstructorMarker) null);
            j.g(str, "absoluteFilePath");
            j.g(captureMethod, "captureMethod");
            this.f27190a = str;
            this.f27191b = captureMethod;
        }

        public String a() {
            return this.f27190a;
        }

        public CaptureMethod c() {
            return this.f27191b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SelfieVideo)) {
                return false;
            }
            SelfieVideo selfieVideo = (SelfieVideo) obj;
            return j.b(a(), selfieVideo.a()) && c() == selfieVideo.c();
        }

        public int hashCode() {
            return (a().hashCode() * 31) + c().hashCode();
        }

        public String toString() {
            return "SelfieVideo(absoluteFilePath=" + a() + ", captureMethod=" + c() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27190a);
            parcel.writeString(this.f27191b.name());
        }
    }

    private Selfie() {
    }

    public /* synthetic */ Selfie(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String a();

    public abstract CaptureMethod c();
}
