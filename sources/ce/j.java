package ce;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class j extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f34062a;

    j(k kVar) {
        this.f34062a = kVar;
    }

    public final void X(Status status) throws RemoteException {
        this.f34062a.setResult(status);
    }
}
