package ge;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class a extends zaa {
    a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void c(TelemetryData telemetryData) throws RemoteException {
        Parcel zaa = zaa();
        zac.zad(zaa, telemetryData);
        zad(1, zaa);
    }
}
