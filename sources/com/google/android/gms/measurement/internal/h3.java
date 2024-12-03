package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbo;
import java.util.ArrayList;
import java.util.List;
import we.d;

public final class h3 extends zzbm implements d {
    h3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void B(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzq);
        zzc(18, zza);
    }

    public final void H(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzq);
        zzc(6, zza);
    }

    public final void J(Bundle bundle, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zzbo.zzd(zza, zzq);
        zzc(19, zza);
    }

    public final List K(String str, String str2, String str3, boolean z10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeString(str3);
        int i10 = zzbo.zza;
        zza.writeInt(z10 ? 1 : 0);
        Parcel zzb = zzb(15, zza);
        ArrayList<zzlk> createTypedArrayList = zzb.createTypedArrayList(zzlk.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final String M(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzq);
        Parcel zzb = zzb(11, zza);
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final void O(zzau zzau, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzau);
        zzbo.zzd(zza, zzq);
        zzc(1, zza);
    }

    public final List P(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(17, zza);
        ArrayList<zzac> createTypedArrayList = zzb.createTypedArrayList(zzac.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final List Z(String str, String str2, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, zzq);
        Parcel zzb = zzb(16, zza);
        ArrayList<zzac> createTypedArrayList = zzb.createTypedArrayList(zzac.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final void j0(zzac zzac, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzac);
        zzbo.zzd(zza, zzq);
        zzc(12, zza);
    }

    public final byte[] r0(zzau zzau, String str) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzau);
        zza.writeString(str);
        Parcel zzb = zzb(9, zza);
        byte[] createByteArray = zzb.createByteArray();
        zzb.recycle();
        return createByteArray;
    }

    public final void s(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzq);
        zzc(4, zza);
    }

    public final void t0(zzlk zzlk, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzlk);
        zzbo.zzd(zza, zzq);
        zzc(2, zza);
    }

    public final void v(long j10, String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j10);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc(10, zza);
    }

    public final void y(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzq);
        zzc(20, zza);
    }

    public final List z(String str, String str2, boolean z10, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        int i10 = zzbo.zza;
        zza.writeInt(z10 ? 1 : 0);
        zzbo.zzd(zza, zzq);
        Parcel zzb = zzb(14, zza);
        ArrayList<zzlk> createTypedArrayList = zzb.createTypedArrayList(zzlk.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }
}
