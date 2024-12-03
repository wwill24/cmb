package com.withpersona.sdk2.inquiry.nfc;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public abstract class PassportNfcReaderOutput implements Parcelable {

    public static final class Cancel extends PassportNfcReaderOutput {
        public static final Parcelable.Creator<Cancel> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public static final Cancel f27034a = new Cancel();

        public static final class a implements Parcelable.Creator<Cancel> {
            /* renamed from: a */
            public final Cancel createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                parcel.readInt();
                return Cancel.f27034a;
            }

            /* renamed from: b */
            public final Cancel[] newArray(int i10) {
                return new Cancel[i10];
            }
        }

        private Cancel() {
            super((DefaultConstructorMarker) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(1);
        }
    }

    public static final class Error extends PassportNfcReaderOutput {
        public static final Parcelable.Creator<Error> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f27035a;

        /* renamed from: b  reason: collision with root package name */
        private final ErrorType f27036b;

        public static final class a implements Parcelable.Creator<Error> {
            /* renamed from: a */
            public final Error createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Error(parcel.readString(), ErrorType.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final Error[] newArray(int i10) {
                return new Error[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(String str, ErrorType errorType) {
            super((DefaultConstructorMarker) null);
            j.g(errorType, "cause");
            this.f27035a = str;
            this.f27036b = errorType;
        }

        public final ErrorType a() {
            return this.f27036b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27035a);
            parcel.writeString(this.f27036b.name());
        }
    }

    public enum ErrorType {
        AuthenticationError,
        Unknown
    }

    public static final class Success extends PassportNfcReaderOutput {
        public static final Parcelable.Creator<Success> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Uri f27040a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f27041b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f27042c;

        /* renamed from: d  reason: collision with root package name */
        private final PassportInfo f27043d;

        public static final class a implements Parcelable.Creator<Success> {
            /* renamed from: a */
            public final Success createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Success((Uri) parcel.readParcelable(Success.class.getClassLoader()), (Uri) parcel.readParcelable(Success.class.getClassLoader()), (Uri) parcel.readParcelable(Success.class.getClassLoader()), PassportInfo.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: b */
            public final Success[] newArray(int i10) {
                return new Success[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(Uri uri, Uri uri2, Uri uri3, PassportInfo passportInfo) {
            super((DefaultConstructorMarker) null);
            j.g(uri, "dg1Uri");
            j.g(uri2, "dg2Uri");
            j.g(uri3, "sodUri");
            j.g(passportInfo, "passportInfo");
            this.f27040a = uri;
            this.f27041b = uri2;
            this.f27042c = uri3;
            this.f27043d = passportInfo;
        }

        public final Uri a() {
            return this.f27040a;
        }

        public final Uri c() {
            return this.f27041b;
        }

        public final PassportInfo d() {
            return this.f27043d;
        }

        public int describeContents() {
            return 0;
        }

        public final Uri e() {
            return this.f27042c;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeParcelable(this.f27040a, i10);
            parcel.writeParcelable(this.f27041b, i10);
            parcel.writeParcelable(this.f27042c, i10);
            this.f27043d.writeToParcel(parcel, i10);
        }
    }

    private PassportNfcReaderOutput() {
    }

    public /* synthetic */ PassportNfcReaderOutput(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
