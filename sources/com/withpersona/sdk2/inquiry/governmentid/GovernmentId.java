package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public interface GovernmentId extends Parcelable {

    public enum CaptureMethod {
        ;

        static final class AUTO extends CaptureMethod {
            AUTO(String str, int i10) {
                super(str, i10, (DefaultConstructorMarker) null);
            }

            public String toString() {
                return "auto";
            }
        }

        static final class MANUAL extends CaptureMethod {
            MANUAL(String str, int i10) {
                super(str, i10, (DefaultConstructorMarker) null);
            }

            public String toString() {
                return "manual";
            }
        }

        static final class UPLOAD extends CaptureMethod {
            UPLOAD(String str, int i10) {
                super(str, i10, (DefaultConstructorMarker) null);
            }

            public String toString() {
                return "upload";
            }
        }
    }

    public static final class GovernmentIdVideo implements GovernmentId {
        public static final Parcelable.Creator<GovernmentIdVideo> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final List<Frame> f25328a;

        /* renamed from: b  reason: collision with root package name */
        private final Side f25329b;

        /* renamed from: c  reason: collision with root package name */
        private final String f25330c;

        /* renamed from: d  reason: collision with root package name */
        private final CaptureMethod f25331d;

        public static final class a implements Parcelable.Creator<GovernmentIdVideo> {
            /* renamed from: a */
            public final GovernmentIdVideo createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(Frame.CREATOR.createFromParcel(parcel));
                }
                return new GovernmentIdVideo(arrayList, Side.valueOf(parcel.readString()), parcel.readString(), CaptureMethod.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final GovernmentIdVideo[] newArray(int i10) {
                return new GovernmentIdVideo[i10];
            }
        }

        public GovernmentIdVideo(List<Frame> list, Side side, String str, CaptureMethod captureMethod) {
            j.g(list, "frames");
            j.g(side, "side");
            j.g(str, "idClassKey");
            j.g(captureMethod, "captureMethod");
            this.f25328a = list;
            this.f25329b = side;
            this.f25330c = str;
            this.f25331d = captureMethod;
        }

        public static /* synthetic */ GovernmentIdVideo c(GovernmentIdVideo governmentIdVideo, List<Frame> list, Side side, String str, CaptureMethod captureMethod, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = governmentIdVideo.U1();
            }
            if ((i10 & 2) != 0) {
                side = governmentIdVideo.I0();
            }
            if ((i10 & 4) != 0) {
                str = governmentIdVideo.g1();
            }
            if ((i10 & 8) != 0) {
                captureMethod = governmentIdVideo.M1();
            }
            return governmentIdVideo.a(list, side, str, captureMethod);
        }

        public Side I0() {
            return this.f25329b;
        }

        public CaptureMethod M1() {
            return this.f25331d;
        }

        public List<Frame> U1() {
            return this.f25328a;
        }

        public final GovernmentIdVideo a(List<Frame> list, Side side, String str, CaptureMethod captureMethod) {
            j.g(list, "frames");
            j.g(side, "side");
            j.g(str, "idClassKey");
            j.g(captureMethod, "captureMethod");
            return new GovernmentIdVideo(list, side, str, captureMethod);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GovernmentIdVideo)) {
                return false;
            }
            GovernmentIdVideo governmentIdVideo = (GovernmentIdVideo) obj;
            return j.b(U1(), governmentIdVideo.U1()) && I0() == governmentIdVideo.I0() && j.b(g1(), governmentIdVideo.g1()) && M1() == governmentIdVideo.M1();
        }

        public String g1() {
            return this.f25330c;
        }

        public int hashCode() {
            return (((((U1().hashCode() * 31) + I0().hashCode()) * 31) + g1().hashCode()) * 31) + M1().hashCode();
        }

        public String toString() {
            return "GovernmentIdVideo(frames=" + U1() + ", side=" + I0() + ", idClassKey=" + g1() + ", captureMethod=" + M1() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<Frame> list = this.f25328a;
            parcel.writeInt(list.size());
            for (Frame writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i10);
            }
            parcel.writeString(this.f25329b.name());
            parcel.writeString(this.f25330c);
            parcel.writeString(this.f25331d.name());
        }

        public GovernmentId y(List<Frame> list) {
            return a.a(this, list);
        }
    }

    public enum Side {
        FRONT,
        BACK,
        FRONT_AND_BACK
    }

    public static final class a {
        public static GovernmentId a(GovernmentId governmentId, List<Frame> list) {
            j.g(list, "frames");
            if (governmentId instanceof GovernmentIdImage) {
                return GovernmentIdImage.c((GovernmentIdImage) governmentId, list, (Side) null, (String) null, (CaptureMethod) null, (RawExtraction) null, (GovernmentIdDetails) null, 62, (Object) null);
            }
            if (governmentId instanceof GovernmentIdVideo) {
                return GovernmentIdVideo.c((GovernmentIdVideo) governmentId, list, (Side) null, (String) null, (CaptureMethod) null, 14, (Object) null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    Side I0();

    CaptureMethod M1();

    List<Frame> U1();

    String g1();

    GovernmentId y(List<Frame> list);

    public static final class GovernmentIdImage implements GovernmentId {
        public static final Parcelable.Creator<GovernmentIdImage> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final List<Frame> f25322a;

        /* renamed from: b  reason: collision with root package name */
        private final Side f25323b;

        /* renamed from: c  reason: collision with root package name */
        private final String f25324c;

        /* renamed from: d  reason: collision with root package name */
        private final CaptureMethod f25325d;

        /* renamed from: e  reason: collision with root package name */
        private final RawExtraction f25326e;

        /* renamed from: f  reason: collision with root package name */
        private final GovernmentIdDetails f25327f;

        public static final class a implements Parcelable.Creator<GovernmentIdImage> {
            /* renamed from: a */
            public final GovernmentIdImage createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(Frame.CREATOR.createFromParcel(parcel));
                }
                Side valueOf = Side.valueOf(parcel.readString());
                String readString = parcel.readString();
                CaptureMethod valueOf2 = CaptureMethod.valueOf(parcel.readString());
                GovernmentIdDetails governmentIdDetails = null;
                RawExtraction createFromParcel = parcel.readInt() == 0 ? null : RawExtraction.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    governmentIdDetails = GovernmentIdDetails.CREATOR.createFromParcel(parcel);
                }
                return new GovernmentIdImage(arrayList, valueOf, readString, valueOf2, createFromParcel, governmentIdDetails);
            }

            /* renamed from: b */
            public final GovernmentIdImage[] newArray(int i10) {
                return new GovernmentIdImage[i10];
            }
        }

        public GovernmentIdImage(List<Frame> list, Side side, String str, CaptureMethod captureMethod, RawExtraction rawExtraction, GovernmentIdDetails governmentIdDetails) {
            j.g(list, "frames");
            j.g(side, "side");
            j.g(str, "idClassKey");
            j.g(captureMethod, "captureMethod");
            this.f25322a = list;
            this.f25323b = side;
            this.f25324c = str;
            this.f25325d = captureMethod;
            this.f25326e = rawExtraction;
            this.f25327f = governmentIdDetails;
        }

        public static /* synthetic */ GovernmentIdImage c(GovernmentIdImage governmentIdImage, List<Frame> list, Side side, String str, CaptureMethod captureMethod, RawExtraction rawExtraction, GovernmentIdDetails governmentIdDetails, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = governmentIdImage.U1();
            }
            if ((i10 & 2) != 0) {
                side = governmentIdImage.I0();
            }
            Side side2 = side;
            if ((i10 & 4) != 0) {
                str = governmentIdImage.g1();
            }
            String str2 = str;
            if ((i10 & 8) != 0) {
                captureMethod = governmentIdImage.M1();
            }
            CaptureMethod captureMethod2 = captureMethod;
            if ((i10 & 16) != 0) {
                rawExtraction = governmentIdImage.f25326e;
            }
            RawExtraction rawExtraction2 = rawExtraction;
            if ((i10 & 32) != 0) {
                governmentIdDetails = governmentIdImage.f25327f;
            }
            return governmentIdImage.a(list, side2, str2, captureMethod2, rawExtraction2, governmentIdDetails);
        }

        public Side I0() {
            return this.f25323b;
        }

        public CaptureMethod M1() {
            return this.f25325d;
        }

        public List<Frame> U1() {
            return this.f25322a;
        }

        public final GovernmentIdImage a(List<Frame> list, Side side, String str, CaptureMethod captureMethod, RawExtraction rawExtraction, GovernmentIdDetails governmentIdDetails) {
            j.g(list, "frames");
            j.g(side, "side");
            j.g(str, "idClassKey");
            j.g(captureMethod, "captureMethod");
            return new GovernmentIdImage(list, side, str, captureMethod, rawExtraction, governmentIdDetails);
        }

        public final GovernmentIdDetails d() {
            return this.f25327f;
        }

        public int describeContents() {
            return 0;
        }

        public final RawExtraction e() {
            return this.f25326e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GovernmentIdImage)) {
                return false;
            }
            GovernmentIdImage governmentIdImage = (GovernmentIdImage) obj;
            return j.b(U1(), governmentIdImage.U1()) && I0() == governmentIdImage.I0() && j.b(g1(), governmentIdImage.g1()) && M1() == governmentIdImage.M1() && j.b(this.f25326e, governmentIdImage.f25326e) && j.b(this.f25327f, governmentIdImage.f25327f);
        }

        public String g1() {
            return this.f25324c;
        }

        public int hashCode() {
            int hashCode = ((((((U1().hashCode() * 31) + I0().hashCode()) * 31) + g1().hashCode()) * 31) + M1().hashCode()) * 31;
            RawExtraction rawExtraction = this.f25326e;
            int i10 = 0;
            int hashCode2 = (hashCode + (rawExtraction == null ? 0 : rawExtraction.hashCode())) * 31;
            GovernmentIdDetails governmentIdDetails = this.f25327f;
            if (governmentIdDetails != null) {
                i10 = governmentIdDetails.hashCode();
            }
            return hashCode2 + i10;
        }

        public String toString() {
            return "GovernmentIdImage(frames=" + U1() + ", side=" + I0() + ", idClassKey=" + g1() + ", captureMethod=" + M1() + ", rawExtraction=" + this.f25326e + ", idDetails=" + this.f25327f + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<Frame> list = this.f25322a;
            parcel.writeInt(list.size());
            for (Frame writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i10);
            }
            parcel.writeString(this.f25323b.name());
            parcel.writeString(this.f25324c);
            parcel.writeString(this.f25325d.name());
            RawExtraction rawExtraction = this.f25326e;
            if (rawExtraction == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                rawExtraction.writeToParcel(parcel, i10);
            }
            GovernmentIdDetails governmentIdDetails = this.f25327f;
            if (governmentIdDetails == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            governmentIdDetails.writeToParcel(parcel, i10);
        }

        public GovernmentId y(List<Frame> list) {
            return a.a(this, list);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GovernmentIdImage(List list, Side side, String str, CaptureMethod captureMethod, RawExtraction rawExtraction, GovernmentIdDetails governmentIdDetails, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, side, str, captureMethod, (i10 & 16) != 0 ? null : rawExtraction, (i10 & 32) != 0 ? null : governmentIdDetails);
        }
    }
}
