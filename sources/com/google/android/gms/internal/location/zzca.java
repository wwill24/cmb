package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.location.LocationSettingsRequest;

final class zzca extends zzcb {
    final /* synthetic */ LocationSettingsRequest zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzca(zzcc zzcc, d dVar, LocationSettingsRequest locationSettingsRequest, String str) {
        super(dVar);
        this.zza = locationSettingsRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        boolean z10;
        zzda zzda = (zzda) bVar;
        LocationSettingsRequest locationSettingsRequest = this.zza;
        if (locationSettingsRequest != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.b(z10, "locationSettingsRequest can't be null");
        ((zzo) zzda.getService()).zzh(locationSettingsRequest, new zzcr(this), (String) null);
    }
}
