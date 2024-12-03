package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
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

public final class zzn extends zza implements zzo {
    zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    public final Location zzd() throws RemoteException {
        Parcel zzb = zzb(7, zza());
        Location location = (Location) zzc.zza(zzb, Location.CREATOR);
        zzb.recycle();
        return location;
    }

    public final j zze(CurrentLocationRequest currentLocationRequest, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, currentLocationRequest);
        zzc.zze(zza, zzq);
        Parcel zzb = zzb(87, zza);
        j c10 = j.a.c(zzb.readStrongBinder());
        zzb.recycle();
        return c10;
    }

    public final LocationAvailability zzf(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzb = zzb(34, zza);
        LocationAvailability locationAvailability = (LocationAvailability) zzc.zza(zzb, LocationAvailability.CREATOR);
        zzb.recycle();
        return locationAvailability;
    }

    public final void zzg(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzm zzm) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, geofencingRequest);
        zzc.zzd(zza, pendingIntent);
        zzc.zze(zza, zzm);
        zzc(57, zza);
    }

    public final void zzh(LocationSettingsRequest locationSettingsRequest, zzs zzs, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, locationSettingsRequest);
        zzc.zze(zza, zzs);
        zza.writeString((String) null);
        zzc(63, zza);
    }

    public final void zzi(zzk zzk) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzk);
        zzc(67, zza);
    }

    public final void zzj(LastLocationRequest lastLocationRequest, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, lastLocationRequest);
        zzc.zze(zza, zzq);
        zzc(82, zza);
    }

    public final void zzk(zzdb zzdb, LocationRequest locationRequest, h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzdb);
        zzc.zzd(zza, locationRequest);
        zzc.zze(zza, hVar);
        zzc(88, zza);
    }

    public final void zzl(PendingIntent pendingIntent, h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, pendingIntent);
        zzc.zze(zza, hVar);
        zzc(73, zza);
    }

    public final void zzm(PendingIntent pendingIntent) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, pendingIntent);
        zzc(6, zza);
    }

    public final void zzn(PendingIntent pendingIntent, zzm zzm, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, pendingIntent);
        zzc.zze(zza, zzm);
        zza.writeString(str);
        zzc(2, zza);
    }

    public final void zzo(String[] strArr, zzm zzm, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeStringArray(strArr);
        zzc.zze(zza, zzm);
        zza.writeString(str);
        zzc(3, zza);
    }

    public final void zzp(PendingIntent pendingIntent, h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, pendingIntent);
        zzc.zze(zza, hVar);
        zzc(69, zza);
    }

    public final void zzq(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, activityTransitionRequest);
        zzc.zzd(zza, pendingIntent);
        zzc.zze(zza, hVar);
        zzc(72, zza);
    }

    public final void zzr(long j10, boolean z10, PendingIntent pendingIntent) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j10);
        zzc.zzc(zza, true);
        zzc.zzd(zza, pendingIntent);
        zzc(5, zza);
    }

    public final void zzs(zzb zzb, PendingIntent pendingIntent, h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzb);
        zzc.zzd(zza, pendingIntent);
        zzc.zze(zza, hVar);
        zzc(70, zza);
    }

    public final void zzt(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, pendingIntent);
        zzc.zzd(zza, sleepSegmentRequest);
        zzc.zze(zza, hVar);
        zzc(79, zza);
    }

    public final void zzu(Location location) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, location);
        zzc(13, zza);
    }

    public final void zzv(Location location, h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, location);
        zzc.zze(zza, hVar);
        zzc(85, zza);
    }

    public final void zzw(boolean z10) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, z10);
        zzc(12, zza);
    }

    public final void zzx(boolean z10, h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, z10);
        zzc.zze(zza, hVar);
        zzc(84, zza);
    }

    public final void zzy(zzdb zzdb, h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzdb);
        zzc.zze(zza, hVar);
        zzc(89, zza);
    }

    public final void zzz(zzdf zzdf) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzdf);
        zzc(59, zza);
    }
}
