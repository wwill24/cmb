package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

public final class zzey extends zzas {
    zzey(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    public final void zze() throws RemoteException {
        zzl(2, zza());
    }

    public final void zzf(Map map, long j10, String str, List<zzcp> list) throws RemoteException {
        Parcel zza = zza();
        zza.writeMap(map);
        zza.writeLong(j10);
        zza.writeString(str);
        zza.writeTypedList(list);
        zzl(1, zza);
    }
}
