package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import pe.b;

final class zzdx extends zzdu {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ Activity zzb;
    final /* synthetic */ zzee zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdx(zzee zzee, Bundle bundle, Activity activity) {
        super(zzee.zza, true);
        this.zzc = zzee;
        this.zza = bundle;
        this.zzb = activity;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        Bundle bundle;
        if (this.zza != null) {
            bundle = new Bundle();
            if (this.zza.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.zza.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((zzcc) p.k(this.zzc.zza.zzj)).onActivityCreated(b.g(this.zzb), bundle, this.zzi);
    }
}
