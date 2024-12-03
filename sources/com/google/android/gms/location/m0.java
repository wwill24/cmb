package com.google.android.gms.location;

import android.os.IInterface;
import android.os.RemoteException;

public interface m0 extends IInterface {
    void zzd(LocationAvailability locationAvailability) throws RemoteException;

    void zze(LocationResult locationResult) throws RemoteException;

    void zzf() throws RemoteException;
}
