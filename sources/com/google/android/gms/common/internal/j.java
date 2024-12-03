package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzb;

public interface j extends IInterface {

    public static abstract class a extends zzb implements j {
        @NonNull
        public static j c(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            if (queryLocalInterface instanceof j) {
                return (j) queryLocalInterface;
            }
            return new x1(iBinder);
        }
    }

    void cancel() throws RemoteException;
}
