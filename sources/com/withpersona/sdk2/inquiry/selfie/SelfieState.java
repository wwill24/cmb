package com.withpersona.sdk2.inquiry.selfie;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import com.withpersona.sdk2.inquiry.selfie.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class SelfieState implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private final List<Selfie> f27235a;

    public static final class CaptureTransition extends SelfieState {
        public static final Parcelable.Creator<CaptureTransition> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final SelfieState f27241b;

        /* renamed from: c  reason: collision with root package name */
        private final Selfie.Direction f27242c;

        public static final class a implements Parcelable.Creator<CaptureTransition> {
            /* renamed from: a */
            public final CaptureTransition createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new CaptureTransition((SelfieState) parcel.readParcelable(CaptureTransition.class.getClassLoader()), Selfie.Direction.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final CaptureTransition[] newArray(int i10) {
                return new CaptureTransition[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CaptureTransition(SelfieState selfieState, Selfie.Direction direction) {
            super(selfieState.g(), (DefaultConstructorMarker) null);
            j.g(selfieState, "nextState");
            j.g(direction, "completedPose");
            this.f27241b = selfieState;
            this.f27242c = direction;
        }

        public int describeContents() {
            return 0;
        }

        public final Selfie.Direction h() {
            return this.f27242c;
        }

        public final SelfieState i() {
            return this.f27241b;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeParcelable(this.f27241b, i10);
            parcel.writeString(this.f27242c.name());
        }
    }

    public static final class CountdownToCapture extends SelfieState {
        public static final Parcelable.Creator<CountdownToCapture> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final int f27243b;

        /* renamed from: c  reason: collision with root package name */
        private final SelfieError f27244c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Selfie.Direction> f27245d;

        /* renamed from: e  reason: collision with root package name */
        private final long f27246e;

        public static final class a implements Parcelable.Creator<CountdownToCapture> {
            /* renamed from: a */
            public final CountdownToCapture createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                SelfieError valueOf = parcel.readInt() == 0 ? null : SelfieError.valueOf(parcel.readString());
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                for (int i10 = 0; i10 != readInt2; i10++) {
                    arrayList.add(Selfie.Direction.valueOf(parcel.readString()));
                }
                return new CountdownToCapture(readInt, valueOf, arrayList, parcel.readLong());
            }

            /* renamed from: b */
            public final CountdownToCapture[] newArray(int i10) {
                return new CountdownToCapture[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CountdownToCapture(int i10, SelfieError selfieError, List list, long j10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(i10, (i11 & 2) != 0 ? null : selfieError, list, j10);
        }

        public static /* synthetic */ CountdownToCapture i(CountdownToCapture countdownToCapture, int i10, SelfieError selfieError, List<Selfie.Direction> list, long j10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = countdownToCapture.f27243b;
            }
            if ((i11 & 2) != 0) {
                selfieError = countdownToCapture.f27244c;
            }
            SelfieError selfieError2 = selfieError;
            if ((i11 & 4) != 0) {
                list = countdownToCapture.f27245d;
            }
            List<Selfie.Direction> list2 = list;
            if ((i11 & 8) != 0) {
                j10 = countdownToCapture.f27246e;
            }
            return countdownToCapture.h(i10, selfieError2, list2, j10);
        }

        public final long d() {
            return this.f27246e;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CountdownToCapture)) {
                return false;
            }
            CountdownToCapture countdownToCapture = (CountdownToCapture) obj;
            return this.f27243b == countdownToCapture.f27243b && this.f27244c == countdownToCapture.f27244c && j.b(this.f27245d, countdownToCapture.f27245d) && this.f27246e == countdownToCapture.f27246e;
        }

        public final List<Selfie.Direction> f() {
            return this.f27245d;
        }

        public final CountdownToCapture h(int i10, SelfieError selfieError, List<? extends Selfie.Direction> list, long j10) {
            j.g(list, "sidesNeeded");
            return new CountdownToCapture(i10, selfieError, list, j10);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.f27243b) * 31;
            SelfieError selfieError = this.f27244c;
            return ((((hashCode + (selfieError == null ? 0 : selfieError.hashCode())) * 31) + this.f27245d.hashCode()) * 31) + Long.hashCode(this.f27246e);
        }

        public final int j() {
            return this.f27243b;
        }

        public final SelfieError k() {
            return this.f27244c;
        }

        public String toString() {
            return "CountdownToCapture(countDown=" + this.f27243b + ", selfieError=" + this.f27244c + ", sidesNeeded=" + this.f27245d + ", startCaptureTimestamp=" + this.f27246e + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f27243b);
            SelfieError selfieError = this.f27244c;
            if (selfieError == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(selfieError.name());
            }
            List<Selfie.Direction> list = this.f27245d;
            parcel.writeInt(list.size());
            for (Selfie.Direction name : list) {
                parcel.writeString(name.name());
            }
            parcel.writeLong(this.f27246e);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CountdownToCapture(int i10, SelfieError selfieError, List<? extends Selfie.Direction> list, long j10) {
            super(q.j(), (DefaultConstructorMarker) null);
            j.g(list, "sidesNeeded");
            this.f27243b = i10;
            this.f27244c = selfieError;
            this.f27245d = list;
            this.f27246e = j10;
        }
    }

    public static final class CountdownToManualCapture extends SelfieState implements e {
        public static final Parcelable.Creator<CountdownToManualCapture> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final int f27247b;

        /* renamed from: c  reason: collision with root package name */
        private final SelfieError f27248c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Selfie.Direction> f27249d;

        /* renamed from: e  reason: collision with root package name */
        private final long f27250e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f27251f;

        public static final class a implements Parcelable.Creator<CountdownToManualCapture> {
            /* renamed from: a */
            public final CountdownToManualCapture createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                SelfieError valueOf = parcel.readInt() == 0 ? null : SelfieError.valueOf(parcel.readString());
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                for (int i10 = 0; i10 != readInt2; i10++) {
                    arrayList.add(Selfie.Direction.valueOf(parcel.readString()));
                }
                return new CountdownToManualCapture(readInt, valueOf, arrayList, parcel.readLong(), parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final CountdownToManualCapture[] newArray(int i10) {
                return new CountdownToManualCapture[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CountdownToManualCapture(int i10, SelfieError selfieError, List list, long j10, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(i10, (i11 & 2) != 0 ? null : selfieError, list, j10, (i11 & 16) != 0 ? true : z10);
        }

        public static /* synthetic */ CountdownToManualCapture i(CountdownToManualCapture countdownToManualCapture, int i10, SelfieError selfieError, List<Selfie.Direction> list, long j10, boolean z10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = countdownToManualCapture.f27247b;
            }
            if ((i11 & 2) != 0) {
                selfieError = countdownToManualCapture.f27248c;
            }
            SelfieError selfieError2 = selfieError;
            if ((i11 & 4) != 0) {
                list = countdownToManualCapture.f();
            }
            List<Selfie.Direction> list2 = list;
            if ((i11 & 8) != 0) {
                j10 = countdownToManualCapture.d();
            }
            long j11 = j10;
            if ((i11 & 16) != 0) {
                z10 = countdownToManualCapture.a();
            }
            return countdownToManualCapture.h(i10, selfieError2, list2, j11, z10);
        }

        public boolean a() {
            return this.f27251f;
        }

        public Selfie.Direction c() {
            return e.a.a(this);
        }

        public long d() {
            return this.f27250e;
        }

        public int describeContents() {
            return 0;
        }

        public boolean e() {
            return e.a.b(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CountdownToManualCapture)) {
                return false;
            }
            CountdownToManualCapture countdownToManualCapture = (CountdownToManualCapture) obj;
            return this.f27247b == countdownToManualCapture.f27247b && this.f27248c == countdownToManualCapture.f27248c && j.b(f(), countdownToManualCapture.f()) && d() == countdownToManualCapture.d() && a() == countdownToManualCapture.a();
        }

        public List<Selfie.Direction> f() {
            return this.f27249d;
        }

        public final CountdownToManualCapture h(int i10, SelfieError selfieError, List<? extends Selfie.Direction> list, long j10, boolean z10) {
            j.g(list, "sidesNeeded");
            return new CountdownToManualCapture(i10, selfieError, list, j10, z10);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.f27247b) * 31;
            SelfieError selfieError = this.f27248c;
            int hashCode2 = (((((hashCode + (selfieError == null ? 0 : selfieError.hashCode())) * 31) + f().hashCode()) * 31) + Long.hashCode(d())) * 31;
            boolean a10 = a();
            if (a10) {
                a10 = true;
            }
            return hashCode2 + (a10 ? 1 : 0);
        }

        public final int j() {
            return this.f27247b;
        }

        public final SelfieError k() {
            return this.f27248c;
        }

        public String toString() {
            return "CountdownToManualCapture(countDown=" + this.f27247b + ", selfieError=" + this.f27248c + ", sidesNeeded=" + f() + ", startCaptureTimestamp=" + d() + ", autoCaptureSupported=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f27247b);
            SelfieError selfieError = this.f27248c;
            if (selfieError == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(selfieError.name());
            }
            List<Selfie.Direction> list = this.f27249d;
            parcel.writeInt(list.size());
            for (Selfie.Direction name : list) {
                parcel.writeString(name.name());
            }
            parcel.writeLong(this.f27250e);
            parcel.writeInt(this.f27251f ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CountdownToManualCapture(int i10, SelfieError selfieError, List<? extends Selfie.Direction> list, long j10, boolean z10) {
            super(q.j(), (DefaultConstructorMarker) null);
            j.g(list, "sidesNeeded");
            this.f27247b = i10;
            this.f27248c = selfieError;
            this.f27249d = list;
            this.f27250e = j10;
            this.f27251f = z10;
        }
    }

    public static final class FinalizeVideoCapture extends SelfieState {
        public static final Parcelable.Creator<FinalizeVideoCapture> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final List<Selfie> f27252b;

        /* renamed from: c  reason: collision with root package name */
        private final long f27253c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f27254d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f27255e;

        public static final class a implements Parcelable.Creator<FinalizeVideoCapture> {
            /* renamed from: a */
            public final FinalizeVideoCapture createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(FinalizeVideoCapture.class.getClassLoader()));
                }
                return new FinalizeVideoCapture(arrayList, parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final FinalizeVideoCapture[] newArray(int i10) {
                return new FinalizeVideoCapture[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FinalizeVideoCapture(List list, long j10, boolean z10, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, j10, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11);
        }

        public static /* synthetic */ FinalizeVideoCapture i(FinalizeVideoCapture finalizeVideoCapture, List<Selfie> list, long j10, boolean z10, boolean z11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = finalizeVideoCapture.g();
            }
            if ((i10 & 2) != 0) {
                j10 = finalizeVideoCapture.f27253c;
            }
            long j11 = j10;
            if ((i10 & 4) != 0) {
                z10 = finalizeVideoCapture.f27254d;
            }
            boolean z12 = z10;
            if ((i10 & 8) != 0) {
                z11 = finalizeVideoCapture.f27255e;
            }
            return finalizeVideoCapture.h(list, j11, z12, z11);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FinalizeVideoCapture)) {
                return false;
            }
            FinalizeVideoCapture finalizeVideoCapture = (FinalizeVideoCapture) obj;
            return j.b(g(), finalizeVideoCapture.g()) && this.f27253c == finalizeVideoCapture.f27253c && this.f27254d == finalizeVideoCapture.f27254d && this.f27255e == finalizeVideoCapture.f27255e;
        }

        public List<Selfie> g() {
            return this.f27252b;
        }

        public final FinalizeVideoCapture h(List<? extends Selfie> list, long j10, boolean z10, boolean z11) {
            j.g(list, "selfies");
            return new FinalizeVideoCapture(list, j10, z10, z11);
        }

        public int hashCode() {
            int hashCode = ((g().hashCode() * 31) + Long.hashCode(this.f27253c)) * 31;
            boolean z10 = this.f27254d;
            boolean z11 = true;
            if (z10) {
                z10 = true;
            }
            int i10 = (hashCode + (z10 ? 1 : 0)) * 31;
            boolean z12 = this.f27255e;
            if (!z12) {
                z11 = z12;
            }
            return i10 + (z11 ? 1 : 0);
        }

        public final long j() {
            return this.f27253c;
        }

        public final boolean k() {
            return this.f27254d;
        }

        public final boolean l() {
            return this.f27255e;
        }

        public String toString() {
            return "FinalizeVideoCapture(selfies=" + g() + ", minDurationMs=" + this.f27253c + ", isDelayComplete=" + this.f27254d + ", isFinalizeComplete=" + this.f27255e + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<Selfie> list = this.f27252b;
            parcel.writeInt(list.size());
            for (Selfie writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            parcel.writeLong(this.f27253c);
            parcel.writeInt(this.f27254d ? 1 : 0);
            parcel.writeInt(this.f27255e ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinalizeVideoCapture(List<? extends Selfie> list, long j10, boolean z10, boolean z11) {
            super(list, (DefaultConstructorMarker) null);
            j.g(list, "selfies");
            this.f27252b = list;
            this.f27253c = j10;
            this.f27254d = z10;
            this.f27255e = z11;
        }
    }

    public static final class ShowInstructions extends SelfieState {
        public static final Parcelable.Creator<ShowInstructions> CREATOR = new a();

        public static final class a implements Parcelable.Creator<ShowInstructions> {
            /* renamed from: a */
            public final ShowInstructions createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                parcel.readInt();
                return new ShowInstructions();
            }

            /* renamed from: b */
            public final ShowInstructions[] newArray(int i10) {
                return new ShowInstructions[i10];
            }
        }

        public ShowInstructions() {
            super(q.j(), (DefaultConstructorMarker) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(1);
        }
    }

    public static final class ShowPoseHint extends SelfieState {
        public static final Parcelable.Creator<ShowPoseHint> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final List<Selfie> f27256b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Selfie.Direction> f27257c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f27258d;

        public static final class a implements Parcelable.Creator<ShowPoseHint> {
            /* renamed from: a */
            public final ShowPoseHint createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                boolean z10 = false;
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(ShowPoseHint.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(Selfie.Direction.valueOf(parcel.readString()));
                }
                if (parcel.readInt() != 0) {
                    z10 = true;
                }
                return new ShowPoseHint(arrayList, arrayList2, z10);
            }

            /* renamed from: b */
            public final ShowPoseHint[] newArray(int i10) {
                return new ShowPoseHint[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowPoseHint(List<? extends Selfie> list, List<? extends Selfie.Direction> list2, boolean z10) {
            super(list, (DefaultConstructorMarker) null);
            j.g(list, "selfies");
            j.g(list2, "sidesNeeded");
            this.f27256b = list;
            this.f27257c = list2;
            this.f27258d = z10;
        }

        public final boolean a() {
            return this.f27258d;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowPoseHint)) {
                return false;
            }
            ShowPoseHint showPoseHint = (ShowPoseHint) obj;
            return j.b(g(), showPoseHint.g()) && j.b(this.f27257c, showPoseHint.f27257c) && this.f27258d == showPoseHint.f27258d;
        }

        public final List<Selfie.Direction> f() {
            return this.f27257c;
        }

        public List<Selfie> g() {
            return this.f27256b;
        }

        public int hashCode() {
            int hashCode = ((g().hashCode() * 31) + this.f27257c.hashCode()) * 31;
            boolean z10 = this.f27258d;
            if (z10) {
                z10 = true;
            }
            return hashCode + (z10 ? 1 : 0);
        }

        public String toString() {
            return "ShowPoseHint(selfies=" + g() + ", sidesNeeded=" + this.f27257c + ", autoCaptureSupported=" + this.f27258d + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<Selfie> list = this.f27256b;
            parcel.writeInt(list.size());
            for (Selfie writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            List<Selfie.Direction> list2 = this.f27257c;
            parcel.writeInt(list2.size());
            for (Selfie.Direction name : list2) {
                parcel.writeString(name.name());
            }
            parcel.writeInt(this.f27258d ? 1 : 0);
        }
    }

    public static final class StartCaptureFaceDetected extends SelfieState {
        public static final Parcelable.Creator<StartCaptureFaceDetected> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final List<Selfie.Direction> f27264b;

        /* renamed from: c  reason: collision with root package name */
        private final long f27265c;

        public static final class a implements Parcelable.Creator<StartCaptureFaceDetected> {
            /* renamed from: a */
            public final StartCaptureFaceDetected createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(Selfie.Direction.valueOf(parcel.readString()));
                }
                return new StartCaptureFaceDetected(arrayList, parcel.readLong());
            }

            /* renamed from: b */
            public final StartCaptureFaceDetected[] newArray(int i10) {
                return new StartCaptureFaceDetected[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StartCaptureFaceDetected(List<? extends Selfie.Direction> list, long j10) {
            super(q.j(), (DefaultConstructorMarker) null);
            j.g(list, "sidesNeeded");
            this.f27264b = list;
            this.f27265c = j10;
        }

        public final long d() {
            return this.f27265c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StartCaptureFaceDetected)) {
                return false;
            }
            StartCaptureFaceDetected startCaptureFaceDetected = (StartCaptureFaceDetected) obj;
            return j.b(this.f27264b, startCaptureFaceDetected.f27264b) && this.f27265c == startCaptureFaceDetected.f27265c;
        }

        public final List<Selfie.Direction> f() {
            return this.f27264b;
        }

        public int hashCode() {
            return (this.f27264b.hashCode() * 31) + Long.hashCode(this.f27265c);
        }

        public String toString() {
            return "StartCaptureFaceDetected(sidesNeeded=" + this.f27264b + ", startCaptureTimestamp=" + this.f27265c + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<Selfie.Direction> list = this.f27264b;
            parcel.writeInt(list.size());
            for (Selfie.Direction name : list) {
                parcel.writeString(name.name());
            }
            parcel.writeLong(this.f27265c);
        }
    }

    public static final class Submit extends SelfieState {
        public static final Parcelable.Creator<Submit> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final List<Selfie> f27266b;

        public static final class a implements Parcelable.Creator<Submit> {
            /* renamed from: a */
            public final Submit createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(Submit.class.getClassLoader()));
                }
                return new Submit(arrayList);
            }

            /* renamed from: b */
            public final Submit[] newArray(int i10) {
                return new Submit[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Submit(List<? extends Selfie> list) {
            super(list, (DefaultConstructorMarker) null);
            j.g(list, "selfies");
            this.f27266b = list;
        }

        public int describeContents() {
            return 0;
        }

        public List<Selfie> g() {
            return this.f27266b;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<Selfie> list = this.f27266b;
            parcel.writeInt(list.size());
            for (Selfie writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
    }

    public static final class WaitForCameraFeed extends SelfieState {
        public static final Parcelable.Creator<WaitForCameraFeed> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final boolean f27267b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f27268c;

        public static final class a implements Parcelable.Creator<WaitForCameraFeed> {
            /* renamed from: a */
            public final WaitForCameraFeed createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                boolean z10 = true;
                boolean z11 = parcel.readInt() != 0;
                if (parcel.readInt() == 0) {
                    z10 = false;
                }
                return new WaitForCameraFeed(z11, z10);
            }

            /* renamed from: b */
            public final WaitForCameraFeed[] newArray(int i10) {
                return new WaitForCameraFeed[i10];
            }
        }

        public WaitForCameraFeed() {
            this(false, false, 3, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ WaitForCameraFeed(boolean z10, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11);
        }

        public static /* synthetic */ WaitForCameraFeed i(WaitForCameraFeed waitForCameraFeed, boolean z10, boolean z11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = waitForCameraFeed.f27267b;
            }
            if ((i10 & 2) != 0) {
                z11 = waitForCameraFeed.f27268c;
            }
            return waitForCameraFeed.h(z10, z11);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WaitForCameraFeed)) {
                return false;
            }
            WaitForCameraFeed waitForCameraFeed = (WaitForCameraFeed) obj;
            return this.f27267b == waitForCameraFeed.f27267b && this.f27268c == waitForCameraFeed.f27268c;
        }

        public final WaitForCameraFeed h(boolean z10, boolean z11) {
            return new WaitForCameraFeed(z10, z11);
        }

        public int hashCode() {
            boolean z10 = this.f27267b;
            boolean z11 = true;
            if (z10) {
                z10 = true;
            }
            int i10 = (z10 ? 1 : 0) * true;
            boolean z12 = this.f27268c;
            if (!z12) {
                z11 = z12;
            }
            return i10 + (z11 ? 1 : 0);
        }

        public final boolean j() {
            return this.f27268c;
        }

        public final boolean k() {
            return this.f27267b;
        }

        public String toString() {
            return "WaitForCameraFeed(hasRequestedCameraPermissions=" + this.f27267b + ", hasRequestedAudioPermissions=" + this.f27268c + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f27267b ? 1 : 0);
            parcel.writeInt(this.f27268c ? 1 : 0);
        }

        public WaitForCameraFeed(boolean z10, boolean z11) {
            super(q.j(), (DefaultConstructorMarker) null);
            this.f27267b = z10;
            this.f27268c = z11;
        }
    }

    private SelfieState(List<? extends Selfie> list) {
        this.f27235a = list;
    }

    public /* synthetic */ SelfieState(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    public List<Selfie> g() {
        return this.f27235a;
    }

    public static final class Capture extends SelfieState implements e {
        public static final Parcelable.Creator<Capture> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final List<Selfie> f27236b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Selfie.Direction> f27237c;

        /* renamed from: d  reason: collision with root package name */
        private final SelfieError f27238d;

        /* renamed from: e  reason: collision with root package name */
        private final long f27239e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f27240f;

        public static final class a implements Parcelable.Creator<Capture> {
            /* renamed from: a */
            public final Capture createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(Capture.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(Selfie.Direction.valueOf(parcel.readString()));
                }
                return new Capture(arrayList, arrayList2, parcel.readInt() == 0 ? null : SelfieError.valueOf(parcel.readString()), parcel.readLong(), parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final Capture[] newArray(int i10) {
                return new Capture[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Capture(List list, List list2, SelfieError selfieError, long j10, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? q.j() : list, list2, (i10 & 4) != 0 ? null : selfieError, j10, (i10 & 16) != 0 ? true : z10);
        }

        public static /* synthetic */ Capture i(Capture capture, List<Selfie> list, List<Selfie.Direction> list2, SelfieError selfieError, long j10, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = capture.g();
            }
            if ((i10 & 2) != 0) {
                list2 = capture.f();
            }
            List<Selfie.Direction> list3 = list2;
            if ((i10 & 4) != 0) {
                selfieError = capture.f27238d;
            }
            SelfieError selfieError2 = selfieError;
            if ((i10 & 8) != 0) {
                j10 = capture.d();
            }
            long j11 = j10;
            if ((i10 & 16) != 0) {
                z10 = capture.a();
            }
            return capture.h(list, list3, selfieError2, j11, z10);
        }

        public boolean a() {
            return this.f27240f;
        }

        public Selfie.Direction c() {
            return e.a.a(this);
        }

        public long d() {
            return this.f27239e;
        }

        public int describeContents() {
            return 0;
        }

        public boolean e() {
            return e.a.b(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Capture)) {
                return false;
            }
            Capture capture = (Capture) obj;
            return j.b(g(), capture.g()) && j.b(f(), capture.f()) && this.f27238d == capture.f27238d && d() == capture.d() && a() == capture.a();
        }

        public List<Selfie.Direction> f() {
            return this.f27237c;
        }

        public List<Selfie> g() {
            return this.f27236b;
        }

        public final Capture h(List<? extends Selfie> list, List<? extends Selfie.Direction> list2, SelfieError selfieError, long j10, boolean z10) {
            j.g(list, "selfies");
            j.g(list2, "sidesNeeded");
            return new Capture(list, list2, selfieError, j10, z10);
        }

        public int hashCode() {
            int hashCode = ((g().hashCode() * 31) + f().hashCode()) * 31;
            SelfieError selfieError = this.f27238d;
            int hashCode2 = (((hashCode + (selfieError == null ? 0 : selfieError.hashCode())) * 31) + Long.hashCode(d())) * 31;
            boolean a10 = a();
            if (a10) {
                a10 = true;
            }
            return hashCode2 + (a10 ? 1 : 0);
        }

        public final SelfieError j() {
            return this.f27238d;
        }

        public String toString() {
            return "Capture(selfies=" + g() + ", sidesNeeded=" + f() + ", selfieError=" + this.f27238d + ", startCaptureTimestamp=" + d() + ", autoCaptureSupported=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<Selfie> list = this.f27236b;
            parcel.writeInt(list.size());
            for (Selfie writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            List<Selfie.Direction> list2 = this.f27237c;
            parcel.writeInt(list2.size());
            for (Selfie.Direction name : list2) {
                parcel.writeString(name.name());
            }
            SelfieError selfieError = this.f27238d;
            if (selfieError == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(selfieError.name());
            }
            parcel.writeLong(this.f27239e);
            parcel.writeInt(this.f27240f ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Capture(List<? extends Selfie> list, List<? extends Selfie.Direction> list2, SelfieError selfieError, long j10, boolean z10) {
            super(list, (DefaultConstructorMarker) null);
            j.g(list, "selfies");
            j.g(list2, "sidesNeeded");
            this.f27236b = list;
            this.f27237c = list2;
            this.f27238d = selfieError;
            this.f27239e = j10;
            this.f27240f = z10;
        }
    }

    public static final class StartCapture extends SelfieState implements e {
        public static final Parcelable.Creator<StartCapture> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final boolean f27259b;

        /* renamed from: c  reason: collision with root package name */
        private final SelfieError f27260c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Selfie.Direction> f27261d;

        /* renamed from: e  reason: collision with root package name */
        private final long f27262e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f27263f;

        public static final class a implements Parcelable.Creator<StartCapture> {
            /* renamed from: a */
            public final StartCapture createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                boolean z10 = parcel.readInt() != 0;
                SelfieError valueOf = parcel.readInt() == 0 ? null : SelfieError.valueOf(parcel.readString());
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(Selfie.Direction.valueOf(parcel.readString()));
                }
                return new StartCapture(z10, valueOf, arrayList, parcel.readLong(), parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final StartCapture[] newArray(int i10) {
                return new StartCapture[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ StartCapture(boolean z10, SelfieError selfieError, List list, long j10, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? SelfieError.FaceNotCentered : selfieError, list, j10, (i10 & 16) != 0 ? true : z11);
        }

        public static /* synthetic */ StartCapture i(StartCapture startCapture, boolean z10, SelfieError selfieError, List<Selfie.Direction> list, long j10, boolean z11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = startCapture.f27259b;
            }
            if ((i10 & 2) != 0) {
                selfieError = startCapture.f27260c;
            }
            SelfieError selfieError2 = selfieError;
            if ((i10 & 4) != 0) {
                list = startCapture.f();
            }
            List<Selfie.Direction> list2 = list;
            if ((i10 & 8) != 0) {
                j10 = startCapture.d();
            }
            long j11 = j10;
            if ((i10 & 16) != 0) {
                z11 = startCapture.a();
            }
            return startCapture.h(z10, selfieError2, list2, j11, z11);
        }

        public boolean a() {
            return this.f27263f;
        }

        public Selfie.Direction c() {
            return e.a.a(this);
        }

        public long d() {
            return this.f27262e;
        }

        public int describeContents() {
            return 0;
        }

        public boolean e() {
            return e.a.b(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StartCapture)) {
                return false;
            }
            StartCapture startCapture = (StartCapture) obj;
            return this.f27259b == startCapture.f27259b && this.f27260c == startCapture.f27260c && j.b(f(), startCapture.f()) && d() == startCapture.d() && a() == startCapture.a();
        }

        public List<Selfie.Direction> f() {
            return this.f27261d;
        }

        public final StartCapture h(boolean z10, SelfieError selfieError, List<? extends Selfie.Direction> list, long j10, boolean z11) {
            j.g(list, "sidesNeeded");
            return new StartCapture(z10, selfieError, list, j10, z11);
        }

        public int hashCode() {
            boolean z10 = this.f27259b;
            boolean z11 = true;
            if (z10) {
                z10 = true;
            }
            int i10 = (z10 ? 1 : 0) * true;
            SelfieError selfieError = this.f27260c;
            int hashCode = (((((i10 + (selfieError == null ? 0 : selfieError.hashCode())) * 31) + f().hashCode()) * 31) + Long.hashCode(d())) * 31;
            boolean a10 = a();
            if (!a10) {
                z11 = a10;
            }
            return hashCode + (z11 ? 1 : 0);
        }

        public final boolean j() {
            return this.f27259b;
        }

        public final SelfieError k() {
            return this.f27260c;
        }

        public String toString() {
            return "StartCapture(centered=" + this.f27259b + ", selfieError=" + this.f27260c + ", sidesNeeded=" + f() + ", startCaptureTimestamp=" + d() + ", autoCaptureSupported=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f27259b ? 1 : 0);
            SelfieError selfieError = this.f27260c;
            if (selfieError == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(selfieError.name());
            }
            List<Selfie.Direction> list = this.f27261d;
            parcel.writeInt(list.size());
            for (Selfie.Direction name : list) {
                parcel.writeString(name.name());
            }
            parcel.writeLong(this.f27262e);
            parcel.writeInt(this.f27263f ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StartCapture(boolean z10, SelfieError selfieError, List<? extends Selfie.Direction> list, long j10, boolean z11) {
            super(q.j(), (DefaultConstructorMarker) null);
            j.g(list, "sidesNeeded");
            this.f27259b = z10;
            this.f27260c = selfieError;
            this.f27261d = list;
            this.f27262e = j10;
            this.f27263f = z11;
        }
    }
}
