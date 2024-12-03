package a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: a.b$a$a  reason: collision with other inner class name */
        private static class C0001a implements b {

            /* renamed from: b  reason: collision with root package name */
            public static b f6b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f7a;

            C0001a(IBinder iBinder) {
                this.f7a = iBinder;
            }

            public boolean S(a aVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z10 = false;
                    if (!this.f7a.transact(3, obtain, obtain2, 0) && a.f() != null) {
                        return a.f().S(aVar);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean U(long j10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeLong(j10);
                    boolean z10 = false;
                    if (!this.f7a.transact(2, obtain, obtain2, 0) && a.f() != null) {
                        return a.f().U(j10);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean Y(a aVar, Bundle bundle) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z10 = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f7a.transact(10, obtain, obtain2, 0) && a.f() != null) {
                        return a.f().Y(aVar, bundle);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f7a;
            }

            public boolean g0(a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z10 = true;
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    if (!this.f7a.transact(4, obtain, obtain2, 0) && a.f() != null) {
                        return a.f().g0(aVar, uri, bundle, list);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static b c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0001a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public static b f() {
            return C0001a.f6b;
        }
    }

    boolean S(a aVar) throws RemoteException;

    boolean U(long j10) throws RemoteException;

    boolean Y(a aVar, Bundle bundle) throws RemoteException;

    boolean g0(a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;
}
