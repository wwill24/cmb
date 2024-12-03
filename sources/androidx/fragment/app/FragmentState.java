package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final String f5685a;

    /* renamed from: b  reason: collision with root package name */
    final String f5686b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f5687c;

    /* renamed from: d  reason: collision with root package name */
    final int f5688d;

    /* renamed from: e  reason: collision with root package name */
    final int f5689e;

    /* renamed from: f  reason: collision with root package name */
    final String f5690f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f5691g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f5692h;

    /* renamed from: j  reason: collision with root package name */
    final boolean f5693j;

    /* renamed from: k  reason: collision with root package name */
    final Bundle f5694k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f5695l;

    /* renamed from: m  reason: collision with root package name */
    final int f5696m;

    /* renamed from: n  reason: collision with root package name */
    Bundle f5697n;

    class a implements Parcelable.Creator<FragmentState> {
        a() {
        }

        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: b */
        public FragmentState[] newArray(int i10) {
            return new FragmentState[i10];
        }
    }

    FragmentState(Fragment fragment) {
        this.f5685a = fragment.getClass().getName();
        this.f5686b = fragment.mWho;
        this.f5687c = fragment.mFromLayout;
        this.f5688d = fragment.mFragmentId;
        this.f5689e = fragment.mContainerId;
        this.f5690f = fragment.mTag;
        this.f5691g = fragment.mRetainInstance;
        this.f5692h = fragment.mRemoving;
        this.f5693j = fragment.mDetached;
        this.f5694k = fragment.mArguments;
        this.f5695l = fragment.mHidden;
        this.f5696m = fragment.mMaxState.ordinal();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Fragment a(@NonNull l lVar, @NonNull ClassLoader classLoader) {
        Fragment a10 = lVar.a(classLoader, this.f5685a);
        Bundle bundle = this.f5694k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a10.setArguments(this.f5694k);
        a10.mWho = this.f5686b;
        a10.mFromLayout = this.f5687c;
        a10.mRestored = true;
        a10.mFragmentId = this.f5688d;
        a10.mContainerId = this.f5689e;
        a10.mTag = this.f5690f;
        a10.mRetainInstance = this.f5691g;
        a10.mRemoving = this.f5692h;
        a10.mDetached = this.f5693j;
        a10.mHidden = this.f5695l;
        a10.mMaxState = Lifecycle.State.values()[this.f5696m];
        Bundle bundle2 = this.f5697n;
        if (bundle2 != null) {
            a10.mSavedFragmentState = bundle2;
        } else {
            a10.mSavedFragmentState = new Bundle();
        }
        return a10;
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f5685a);
        sb2.append(" (");
        sb2.append(this.f5686b);
        sb2.append(")}:");
        if (this.f5687c) {
            sb2.append(" fromLayout");
        }
        if (this.f5689e != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f5689e));
        }
        String str = this.f5690f;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f5690f);
        }
        if (this.f5691g) {
            sb2.append(" retainInstance");
        }
        if (this.f5692h) {
            sb2.append(" removing");
        }
        if (this.f5693j) {
            sb2.append(" detached");
        }
        if (this.f5695l) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f5685a);
        parcel.writeString(this.f5686b);
        parcel.writeInt(this.f5687c ? 1 : 0);
        parcel.writeInt(this.f5688d);
        parcel.writeInt(this.f5689e);
        parcel.writeString(this.f5690f);
        parcel.writeInt(this.f5691g ? 1 : 0);
        parcel.writeInt(this.f5692h ? 1 : 0);
        parcel.writeInt(this.f5693j ? 1 : 0);
        parcel.writeBundle(this.f5694k);
        parcel.writeInt(this.f5695l ? 1 : 0);
        parcel.writeBundle(this.f5697n);
        parcel.writeInt(this.f5696m);
    }

    FragmentState(Parcel parcel) {
        this.f5685a = parcel.readString();
        this.f5686b = parcel.readString();
        boolean z10 = true;
        this.f5687c = parcel.readInt() != 0;
        this.f5688d = parcel.readInt();
        this.f5689e = parcel.readInt();
        this.f5690f = parcel.readString();
        this.f5691g = parcel.readInt() != 0;
        this.f5692h = parcel.readInt() != 0;
        this.f5693j = parcel.readInt() != 0;
        this.f5694k = parcel.readBundle();
        this.f5695l = parcel.readInt() == 0 ? false : z10;
        this.f5697n = parcel.readBundle();
        this.f5696m = parcel.readInt();
    }
}
