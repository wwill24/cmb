package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdb> CREATOR = new zzdc();
    private final int zza;
    private final IBinder zzb;
    private final IBinder zzc;
    private final PendingIntent zzd;
    private final String zze;
    private final String zzf;

    zzdb(int i10, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str, String str2) {
        this.zza = i10;
        this.zzb = iBinder;
        this.zzc = iBinder2;
        this.zzd = pendingIntent;
        this.zze = Build.VERSION.SDK_INT >= 30 ? null : str;
        this.zzf = str2;
    }

    public static zzdb zza(PendingIntent pendingIntent, String str, String str2) {
        return new zzdb(3, (IBinder) null, (IBinder) null, pendingIntent, (String) null, (String) null);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARNING: type inference failed for: r3v0, types: [android.os.IBinder] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.location.zzdb zzb(android.os.IInterface r7, com.google.android.gms.location.m0 r8, java.lang.String r9, java.lang.String r10) {
        /*
            com.google.android.gms.internal.location.zzdb r9 = new com.google.android.gms.internal.location.zzdb
            if (r7 != 0) goto L_0x0005
            r7 = 0
        L_0x0005:
            r2 = r7
            r1 = 2
            r4 = 0
            r5 = 0
            r0 = r9
            r3 = r8
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdb.zzb(android.os.IInterface, com.google.android.gms.location.m0, java.lang.String, java.lang.String):com.google.android.gms.internal.location.zzdb");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARNING: type inference failed for: r3v0, types: [android.os.IBinder] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.location.zzdb zzc(android.os.IInterface r7, com.google.android.gms.location.p0 r8, java.lang.String r9, java.lang.String r10) {
        /*
            com.google.android.gms.internal.location.zzdb r9 = new com.google.android.gms.internal.location.zzdb
            if (r7 != 0) goto L_0x0005
            r7 = 0
        L_0x0005:
            r2 = r7
            r1 = 1
            r4 = 0
            r5 = 0
            r0 = r9
            r3 = r8
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdb.zzc(android.os.IInterface, com.google.android.gms.location.p0, java.lang.String, java.lang.String):com.google.android.gms.internal.location.zzdb");
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.r(parcel, 2, this.zzb, false);
        a.r(parcel, 3, this.zzc, false);
        a.A(parcel, 4, this.zzd, i10, false);
        a.C(parcel, 5, this.zze, false);
        a.C(parcel, 6, this.zzf, false);
        a.b(parcel, a10);
    }
}
