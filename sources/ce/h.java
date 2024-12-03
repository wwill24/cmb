package ce;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class h extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f34061a;

    h(i iVar) {
        this.f34061a = iVar;
    }

    public final void zbc(Status status) throws RemoteException {
        this.f34061a.setResult(status);
    }
}
