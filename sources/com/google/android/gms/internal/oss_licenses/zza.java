package com.google.android.gms.internal.oss_licenses;

import android.os.Parcel;
import android.os.Parcelable;

public final class zza implements Parcelable, Comparable<zza> {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    private final String zzi;
    private final long zzj;
    private final int zzk;
    private final String zzl;

    private zza(Parcel parcel) {
        this.zzi = parcel.readString();
        this.zzj = parcel.readLong();
        this.zzk = parcel.readInt();
        this.zzl = parcel.readString();
    }

    /* synthetic */ zza(Parcel parcel, zzb zzb) {
        this(parcel);
    }

    private zza(String str, long j10, int i10, String str2) {
        this.zzi = str;
        this.zzj = j10;
        this.zzk = i10;
        this.zzl = str2;
    }

    static zza zza(String str, long j10, int i10, String str2) {
        return new zza(str, j10, i10, str2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.zzi.compareToIgnoreCase(((zza) obj).zzi);
    }

    public final int describeContents() {
        return 0;
    }

    public final String getPath() {
        return this.zzl;
    }

    public final String toString() {
        return this.zzi;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.zzi);
        parcel.writeLong(this.zzj);
        parcel.writeInt(this.zzk);
        parcel.writeString(this.zzl);
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzk;
    }
}
