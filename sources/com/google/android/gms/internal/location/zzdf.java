package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.l0;
import com.google.android.gms.location.m0;
import com.google.android.gms.location.o0;
import com.google.android.gms.location.p0;
import fe.a;

@Deprecated
public final class zzdf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdf> CREATOR = new zzdg();
    private final int zza;
    private final zzdd zzb;
    private final p0 zzc;
    private final m0 zzd;
    private final PendingIntent zze;
    private final zzk zzf;
    private final String zzg;

    zzdf(int i10, zzdd zzdd, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        p0 p0Var;
        m0 m0Var;
        this.zza = i10;
        this.zzb = zzdd;
        zzk zzk = null;
        if (iBinder != null) {
            p0Var = o0.zzb(iBinder);
        } else {
            p0Var = null;
        }
        this.zzc = p0Var;
        this.zze = pendingIntent;
        if (iBinder2 != null) {
            m0Var = l0.zzb(iBinder2);
        } else {
            m0Var = null;
        }
        this.zzd = m0Var;
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (queryLocalInterface instanceof zzk) {
                zzk = (zzk) queryLocalInterface;
            } else {
                zzk = new zzi(iBinder3);
            }
        }
        this.zzf = zzk;
        this.zzg = str;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        IBinder iBinder;
        IBinder iBinder2;
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.A(parcel, 2, this.zzb, i10, false);
        p0 p0Var = this.zzc;
        IBinder iBinder3 = null;
        if (p0Var == null) {
            iBinder = null;
        } else {
            iBinder = p0Var.asBinder();
        }
        a.r(parcel, 3, iBinder, false);
        a.A(parcel, 4, this.zze, i10, false);
        m0 m0Var = this.zzd;
        if (m0Var == null) {
            iBinder2 = null;
        } else {
            iBinder2 = m0Var.asBinder();
        }
        a.r(parcel, 5, iBinder2, false);
        zzk zzk = this.zzf;
        if (zzk != null) {
            iBinder3 = zzk.asBinder();
        }
        a.r(parcel, 6, iBinder3, false);
        a.C(parcel, 8, this.zzg, false);
        a.b(parcel, a10);
    }
}
