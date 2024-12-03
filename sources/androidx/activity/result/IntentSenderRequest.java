package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final c f381e = new c((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final IntentSender f382a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f383b;

    /* renamed from: c  reason: collision with root package name */
    private final int f384c;

    /* renamed from: d  reason: collision with root package name */
    private final int f385d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final IntentSender f386a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f387b;

        /* renamed from: c  reason: collision with root package name */
        private int f388c;

        /* renamed from: d  reason: collision with root package name */
        private int f389d;

        public a(IntentSender intentSender) {
            j.g(intentSender, "intentSender");
            this.f386a = intentSender;
        }

        public final IntentSenderRequest a() {
            return new IntentSenderRequest(this.f386a, this.f387b, this.f388c, this.f389d);
        }

        public final a b(Intent intent) {
            this.f387b = intent;
            return this;
        }

        public final a c(int i10, int i11) {
            this.f389d = i10;
            this.f388c = i11;
            return this;
        }
    }

    public static final class b implements Parcelable.Creator<IntentSenderRequest> {
        b() {
        }

        /* renamed from: a */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            j.g(parcel, "inParcel");
            return new IntentSenderRequest(parcel);
        }

        /* renamed from: b */
        public IntentSenderRequest[] newArray(int i10) {
            return new IntentSenderRequest[i10];
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i10, int i11) {
        j.g(intentSender, "intentSender");
        this.f382a = intentSender;
        this.f383b = intent;
        this.f384c = i10;
        this.f385d = i11;
    }

    public final Intent a() {
        return this.f383b;
    }

    public final int c() {
        return this.f384c;
    }

    public final int d() {
        return this.f385d;
    }

    public int describeContents() {
        return 0;
    }

    public final IntentSender e() {
        return this.f382a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "dest");
        parcel.writeParcelable(this.f382a, i10);
        parcel.writeParcelable(this.f383b, i10);
        parcel.writeInt(this.f384c);
        parcel.writeInt(this.f385d);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IntentSenderRequest(android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.j.g(r4, r0)
            java.lang.Class<android.content.IntentSender> r0 = android.content.IntentSender.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r4.readParcelable(r0)
            kotlin.jvm.internal.j.d(r0)
            android.content.IntentSender r0 = (android.content.IntentSender) r0
            java.lang.Class<android.content.Intent> r1 = android.content.Intent.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r4.readParcelable(r1)
            android.content.Intent r1 = (android.content.Intent) r1
            int r2 = r4.readInt()
            int r4 = r4.readInt()
            r3.<init>(r0, r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.IntentSenderRequest.<init>(android.os.Parcel):void");
    }
}
