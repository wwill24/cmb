package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface a extends IInterface {

    /* renamed from: android.support.v4.os.a$a  reason: collision with other inner class name */
    public static abstract class C0008a extends Binder implements a {

        /* renamed from: android.support.v4.os.a$a$a  reason: collision with other inner class name */
        private static class C0009a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f299a;

            C0009a(IBinder iBinder) {
                this.f299a = iBinder;
            }

            public IBinder asBinder() {
                return this.f299a;
            }
        }

        public C0008a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0009a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            } else if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                E(parcel.readInt(), (Bundle) b.b(parcel, Bundle.CREATOR));
                return true;
            }
        }
    }

    public static class b {
        /* access modifiers changed from: private */
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void E(int i10, Bundle bundle) throws RemoteException;
}
