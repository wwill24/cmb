package com.withpersona.sdk2.inquiry.selfie;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public interface ProcessVideoError extends Parcelable {

    public static final class FaceDoesNotMatchConstraints implements ProcessVideoError {
        public static final Parcelable.Creator<FaceDoesNotMatchConstraints> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public static final FaceDoesNotMatchConstraints f27175a = new FaceDoesNotMatchConstraints();

        public static final class a implements Parcelable.Creator<FaceDoesNotMatchConstraints> {
            /* renamed from: a */
            public final FaceDoesNotMatchConstraints createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                parcel.readInt();
                return FaceDoesNotMatchConstraints.f27175a;
            }

            /* renamed from: b */
            public final FaceDoesNotMatchConstraints[] newArray(int i10) {
                return new FaceDoesNotMatchConstraints[i10];
            }
        }

        private FaceDoesNotMatchConstraints() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(1);
        }
    }

    public static final class RequiredPoseMissing implements ProcessVideoError {
        public static final Parcelable.Creator<RequiredPoseMissing> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Selfie.Direction f27176a;

        public static final class a implements Parcelable.Creator<RequiredPoseMissing> {
            /* renamed from: a */
            public final RequiredPoseMissing createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new RequiredPoseMissing(Selfie.Direction.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final RequiredPoseMissing[] newArray(int i10) {
                return new RequiredPoseMissing[i10];
            }
        }

        public RequiredPoseMissing(Selfie.Direction direction) {
            j.g(direction, "direction");
            this.f27176a = direction;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequiredPoseMissing) && this.f27176a == ((RequiredPoseMissing) obj).f27176a;
        }

        public int hashCode() {
            return this.f27176a.hashCode();
        }

        public String toString() {
            return "RequiredPoseMissing(direction=" + this.f27176a + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27176a.name());
        }
    }

    public static final class TooManyFaces implements ProcessVideoError {
        public static final Parcelable.Creator<TooManyFaces> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public static final TooManyFaces f27177a = new TooManyFaces();

        public static final class a implements Parcelable.Creator<TooManyFaces> {
            /* renamed from: a */
            public final TooManyFaces createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                parcel.readInt();
                return TooManyFaces.f27177a;
            }

            /* renamed from: b */
            public final TooManyFaces[] newArray(int i10) {
                return new TooManyFaces[i10];
            }
        }

        private TooManyFaces() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(1);
        }
    }

    public static final class VideoAnalysisNotAvailable implements ProcessVideoError {
        public static final Parcelable.Creator<VideoAnalysisNotAvailable> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public static final VideoAnalysisNotAvailable f27178a = new VideoAnalysisNotAvailable();

        public static final class a implements Parcelable.Creator<VideoAnalysisNotAvailable> {
            /* renamed from: a */
            public final VideoAnalysisNotAvailable createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                parcel.readInt();
                return VideoAnalysisNotAvailable.f27178a;
            }

            /* renamed from: b */
            public final VideoAnalysisNotAvailable[] newArray(int i10) {
                return new VideoAnalysisNotAvailable[i10];
            }
        }

        private VideoAnalysisNotAvailable() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(1);
        }
    }

    public static final class ZeroFacesDetected implements ProcessVideoError {
        public static final Parcelable.Creator<ZeroFacesDetected> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public static final ZeroFacesDetected f27179a = new ZeroFacesDetected();

        public static final class a implements Parcelable.Creator<ZeroFacesDetected> {
            /* renamed from: a */
            public final ZeroFacesDetected createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                parcel.readInt();
                return ZeroFacesDetected.f27179a;
            }

            /* renamed from: b */
            public final ZeroFacesDetected[] newArray(int i10) {
                return new ZeroFacesDetected[i10];
            }
        }

        private ZeroFacesDetected() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(1);
        }
    }
}
