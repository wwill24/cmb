package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzb;

public interface zzo extends IInterface {
    @Deprecated
    Location zzd() throws RemoteException;

    @Deprecated
    j zze(CurrentLocationRequest currentLocationRequest, zzq zzq) throws RemoteException;

    @Deprecated
    LocationAvailability zzf(String str) throws RemoteException;

    void zzg(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzm zzm) throws RemoteException;

    void zzh(LocationSettingsRequest locationSettingsRequest, zzs zzs, String str) throws RemoteException;

    void zzi(zzk zzk) throws RemoteException;

    @Deprecated
    void zzj(LastLocationRequest lastLocationRequest, zzq zzq) throws RemoteException;

    void zzk(zzdb zzdb, LocationRequest locationRequest, h hVar) throws RemoteException;

    void zzl(PendingIntent pendingIntent, h hVar) throws RemoteException;

    void zzm(PendingIntent pendingIntent) throws RemoteException;

    void zzn(PendingIntent pendingIntent, zzm zzm, String str) throws RemoteException;

    void zzo(String[] strArr, zzm zzm, String str) throws RemoteException;

    void zzp(PendingIntent pendingIntent, h hVar) throws RemoteException;

    void zzq(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, h hVar) throws RemoteException;

    void zzr(long j10, boolean z10, PendingIntent pendingIntent) throws RemoteException;

    void zzs(zzb zzb, PendingIntent pendingIntent, h hVar) throws RemoteException;

    void zzt(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, h hVar) throws RemoteException;

    @Deprecated
    void zzu(Location location) throws RemoteException;

    void zzv(Location location, h hVar) throws RemoteException;

    @Deprecated
    void zzw(boolean z10) throws RemoteException;

    void zzx(boolean z10, h hVar) throws RemoteException;

    void zzy(zzdb zzdb, h hVar) throws RemoteException;

    @Deprecated
    void zzz(zzdf zzdf) throws RemoteException;
}
