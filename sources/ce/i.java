package ce;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.j;

final class i extends l {
    i(d dVar) {
        super(dVar);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ j createFailedResult(Status status) {
        return status;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        g gVar = (g) bVar;
        ((s) gVar.getService()).f(new h(this), gVar.e());
    }
}
