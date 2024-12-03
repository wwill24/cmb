package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzc extends zzh implements zze {
    zzc(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    public final int zza(int i10, String str, String str2) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        Parcel zzp = zzp(5, zzo);
        int readInt = zzp.readInt();
        zzp.recycle();
        return readInt;
    }

    public final int zzc(int i10, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i10);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzj.zzb(zzo, bundle);
        Parcel zzp = zzp(10, zzo);
        int readInt = zzp.readInt();
        zzp.recycle();
        return readInt;
    }

    public final Bundle zzd(int i10, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(9);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzj.zzb(zzo, bundle);
        Parcel zzp = zzp(902, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zze(int i10, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(9);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzj.zzb(zzo, bundle);
        Parcel zzp = zzp(12, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zzf(int i10, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzo.writeString((String) null);
        Parcel zzp = zzp(3, zzo);
        Bundle bundle = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle;
    }

    public final Bundle zzg(int i10, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i10);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzo.writeString((String) null);
        zzj.zzb(zzo, bundle);
        Parcel zzp = zzp(8, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zzh(int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(6);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzj.zzb(zzo, bundle);
        Parcel zzp = zzp(9, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zzi(int i10, String str, String str2, String str3) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        Parcel zzp = zzp(4, zzo);
        Bundle bundle = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle;
    }

    public final Bundle zzj(int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i10);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzj.zzb(zzo, bundle);
        Parcel zzp = zzp(11, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zzk(int i10, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzj.zzb(zzo, bundle);
        Parcel zzp = zzp(2, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    public final Bundle zzl(int i10, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i10);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzj.zzb(zzo, bundle);
        zzj.zzb(zzo, bundle2);
        Parcel zzp = zzp(901, zzo);
        Bundle bundle3 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle3;
    }

    public final Bundle zzm(int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(8);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString("subs");
        zzj.zzb(zzo, bundle);
        Parcel zzp = zzp(801, zzo);
        Bundle bundle2 = (Bundle) zzj.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.internal.play_billing.zzg, android.os.IBinder] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzn(int r2, java.lang.String r3, android.os.Bundle r4, com.google.android.gms.internal.play_billing.zzg r5) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r2 = r1.zzo()
            r0 = 12
            r2.writeInt(r0)
            r2.writeString(r3)
            com.google.android.gms.internal.play_billing.zzj.zzb(r2, r4)
            r2.writeStrongBinder(r5)
            r3 = 1201(0x4b1, float:1.683E-42)
            r1.zzq(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzc.zzn(int, java.lang.String, android.os.Bundle, com.google.android.gms.internal.play_billing.zzg):void");
    }

    public final int zzr(int i10, String str, String str2) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i10);
        zzo.writeString(str);
        zzo.writeString(str2);
        Parcel zzp = zzp(1, zzo);
        int readInt = zzp.readInt();
        zzp.recycle();
        return readInt;
    }
}
