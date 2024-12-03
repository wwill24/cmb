package ce;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.p002authapi.zbb;

public abstract class o extends zbb implements p {
    public o() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    /* access modifiers changed from: protected */
    public final boolean zba(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            m();
        } else if (i10 != 2) {
            return false;
        } else {
            h();
        }
        return true;
    }
}
