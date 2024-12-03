package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.p;

public abstract class d<R extends j, A extends a.b> extends BasePendingResult<R> implements e<R> {
    private final a<?> mApi;
    private final a.c<A> mClientKey;

    @Deprecated
    protected d(@NonNull a.c<A> cVar, @NonNull com.google.android.gms.common.api.d dVar) {
        super((com.google.android.gms.common.api.d) p.l(dVar, "GoogleApiClient must not be null"));
        this.mClientKey = (a.c) p.k(cVar);
        this.mApi = null;
    }

    private void setFailedResult(@NonNull RemoteException remoteException) {
        setFailedResult(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
    }

    /* access modifiers changed from: protected */
    public abstract void doExecute(@NonNull A a10) throws RemoteException;

    public final a<?> getApi() {
        return this.mApi;
    }

    @NonNull
    public final a.c<A> getClientKey() {
        return this.mClientKey;
    }

    /* access modifiers changed from: protected */
    public void onSetFailedResult(@NonNull R r10) {
    }

    public final void run(@NonNull A a10) throws DeadObjectException {
        try {
            doExecute(a10);
        } catch (DeadObjectException e10) {
            setFailedResult((RemoteException) e10);
            throw e10;
        } catch (RemoteException e11) {
            setFailedResult(e11);
        }
    }

    public /* bridge */ /* synthetic */ void setResult(@NonNull Object obj) {
        super.setResult((j) obj);
    }

    protected d(@NonNull a<?> aVar, @NonNull com.google.android.gms.common.api.d dVar) {
        super((com.google.android.gms.common.api.d) p.l(dVar, "GoogleApiClient must not be null"));
        p.l(aVar, "Api must not be null");
        this.mClientKey = aVar.b();
        this.mApi = aVar;
    }

    public final void setFailedResult(@NonNull Status status) {
        p.b(!status.i0(), "Failed result must not be success");
        j createFailedResult = createFailedResult(status);
        setResult(createFailedResult);
        onSetFailedResult(createFailedResult);
    }

    protected d(@NonNull BasePendingResult.a<R> aVar) {
        super(aVar);
        this.mClientKey = new a.c<>();
        this.mApi = null;
    }
}
