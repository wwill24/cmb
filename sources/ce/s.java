package ce;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p002authapi.zba;
import com.google.android.gms.internal.p002authapi.zbc;

public final class s extends zba {
    s(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void c(r rVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, rVar);
        zbc.zbc(zba, googleSignInOptions);
        zbb(103, zba);
    }

    public final void f(r rVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, rVar);
        zbc.zbc(zba, googleSignInOptions);
        zbb(102, zba);
    }
}
