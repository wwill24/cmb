package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzcp implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<zzcp> CREATOR = new zzco();
    private String zza;
    private String zzb;
    private String zzc;

    @Deprecated
    public zzcp() {
    }

    @Deprecated
    public final int describeContents() {
        return 0;
    }

    @Deprecated
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzc;
    }

    @Deprecated
    zzcp(Parcel parcel) {
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }
}
