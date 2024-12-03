package com.google.android.gms.common.moduleinstall.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;
import je.e;
import je.g;

public final class c extends zaa {
    c(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
    }

    public final void c(e eVar, ApiFeatureRequest apiFeatureRequest) throws RemoteException {
        Parcel zaa = zaa();
        zac.zae(zaa, eVar);
        zac.zad(zaa, apiFeatureRequest);
        zac(1, zaa);
    }

    public final void f(e eVar, ApiFeatureRequest apiFeatureRequest, g gVar) throws RemoteException {
        Parcel zaa = zaa();
        zac.zae(zaa, eVar);
        zac.zad(zaa, apiFeatureRequest);
        zac.zae(zaa, gVar);
        zac(2, zaa);
    }

    public final void g(h hVar, g gVar) throws RemoteException {
        Parcel zaa = zaa();
        zac.zae(zaa, hVar);
        zac.zae(zaa, gVar);
        zac(6, zaa);
    }
}
