package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.sessions.settings.RemoteSettings;
import fe.a;
import java.util.Arrays;
import java.util.List;

public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    private final int zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;
    private final int zze;
    private final String zzf;
    private final zzd zzg;
    private final List zzh;

    static {
        Process.myUid();
        Process.myPid();
    }

    zzd(int i10, int i11, String str, String str2, String str3, int i12, List list, zzd zzd2) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = str3;
        this.zze = i12;
        this.zzh = zzds.zzj(list);
        this.zzg = zzd2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzd) {
            zzd zzd2 = (zzd) obj;
            if (this.zza != zzd2.zza || this.zzb != zzd2.zzb || this.zze != zzd2.zze || !this.zzc.equals(zzd2.zzc) || !zzdl.zza(this.zzd, zzd2.zzd) || !zzdl.zza(this.zzf, zzd2.zzf) || !zzdl.zza(this.zzg, zzd2.zzg) || !this.zzh.equals(zzd2.zzh)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzc, this.zzd, this.zzf});
    }

    public final String toString() {
        int length = this.zzc.length() + 18;
        String str = this.zzd;
        if (str != null) {
            length += str.length();
        }
        StringBuilder sb2 = new StringBuilder(length);
        sb2.append(this.zza);
        sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb2.append(this.zzc);
        if (this.zzd != null) {
            sb2.append("[");
            if (this.zzd.startsWith(this.zzc)) {
                sb2.append(this.zzd, this.zzc.length(), this.zzd.length());
            } else {
                sb2.append(this.zzd);
            }
            sb2.append("]");
        }
        if (this.zzf != null) {
            sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb2.append(Integer.toHexString(this.zzf.hashCode()));
        }
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.s(parcel, 2, this.zzb);
        a.C(parcel, 3, this.zzc, false);
        a.C(parcel, 4, this.zzd, false);
        a.s(parcel, 5, this.zze);
        a.C(parcel, 6, this.zzf, false);
        a.A(parcel, 7, this.zzg, i10, false);
        a.G(parcel, 8, this.zzh, false);
        a.b(parcel, a10);
    }
}
