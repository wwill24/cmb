package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.a;
import androidx.annotation.NonNull;

@SuppressLint({"BanParcelableUsage"})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final boolean f292a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f293b = null;

    /* renamed from: c  reason: collision with root package name */
    a f294c;

    class a implements Parcelable.Creator<ResultReceiver> {
        a() {
        }

        /* renamed from: a */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* renamed from: b */
        public ResultReceiver[] newArray(int i10) {
            return new ResultReceiver[i10];
        }
    }

    class b extends a.C0008a {
        b() {
        }

        public void E(int i10, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f293b;
            if (handler != null) {
                handler.post(new c(i10, bundle));
            } else {
                resultReceiver.a(i10, bundle);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f296a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f297b;

        c(int i10, Bundle bundle) {
            this.f296a = i10;
            this.f297b = bundle;
        }

        public void run() {
            ResultReceiver.this.a(this.f296a, this.f297b);
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f294c = a.C0008a.c(parcel.readStrongBinder());
    }

    /* access modifiers changed from: protected */
    public void a(int i10, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        synchronized (this) {
            if (this.f294c == null) {
                this.f294c = new b();
            }
            parcel.writeStrongBinder(this.f294c.asBinder());
        }
    }
}
