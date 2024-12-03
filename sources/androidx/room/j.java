package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.i;

public interface j extends IInterface {

    public static abstract class a extends Binder implements j {

        /* renamed from: androidx.room.j$a$a  reason: collision with other inner class name */
        private static class C0075a implements j {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f6858a;

            C0075a(IBinder iBinder) {
                this.f6858a = iBinder;
            }

            public void D(int i10, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeInt(i10);
                    obtain.writeStringArray(strArr);
                    this.f6858a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public int Q(i iVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeStrongInterface(iVar);
                    obtain.writeString(str);
                    this.f6858a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6858a;
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static j c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof j)) {
                return new C0075a(iBinder);
            }
            return (j) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            }
            if (i10 != 1598968902) {
                if (i10 == 1) {
                    int Q = Q(i.a.c(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(Q);
                } else if (i10 == 2) {
                    s0(i.a.c(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                } else if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                } else {
                    D(parcel.readInt(), parcel.createStringArray());
                }
                return true;
            }
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
            return true;
        }
    }

    void D(int i10, String[] strArr) throws RemoteException;

    int Q(i iVar, String str) throws RemoteException;

    void s0(i iVar, int i10) throws RemoteException;
}
