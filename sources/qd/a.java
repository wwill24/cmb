package qd;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import bd.b;
import bd.c;

public interface a extends IInterface {

    /* renamed from: qd.a$a  reason: collision with other inner class name */
    public static abstract class C0504a extends b implements a {

        /* renamed from: qd.a$a$a  reason: collision with other inner class name */
        public static class C0505a extends bd.a implements a {
            C0505a(IBinder iBinder) {
                super(iBinder);
            }

            public final Bundle r(Bundle bundle) throws RemoteException {
                Parcel c10 = c();
                c.b(c10, bundle);
                Parcel f10 = f(c10);
                Bundle bundle2 = (Bundle) c.a(f10, Bundle.CREATOR);
                f10.recycle();
                return bundle2;
            }
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new C0505a(iBinder);
        }
    }

    Bundle r(Bundle bundle) throws RemoteException;
}
