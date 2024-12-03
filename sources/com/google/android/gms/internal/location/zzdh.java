package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.e;
import com.mparticle.identity.IdentityHttpResponse;
import fe.a;
import java.util.Locale;
import net.bytebuddy.description.type.TypeDescription;

public final class zzdh extends AbstractSafeParcelable implements e {
    public static final Parcelable.Creator<zzdh> CREATOR = new zzdi();
    private final String zza;
    private final long zzb;
    private final short zzc;
    private final double zzd;
    private final double zze;
    private final float zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;

    public zzdh(String str, int i10, short s10, double d10, double d11, float f10, long j10, int i11, int i12) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: ".concat(String.valueOf(str)));
        } else if (f10 <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f10);
        } else if (d10 > 90.0d || d10 < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d10);
        } else if (d11 > 180.0d || d11 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d11);
        } else {
            int i13 = i10 & 7;
            if (i13 != 0) {
                this.zzc = s10;
                this.zza = str;
                this.zzd = d10;
                this.zze = d11;
                this.zzf = f10;
                this.zzb = j10;
                this.zzg = i13;
                this.zzh = i11;
                this.zzi = i12;
                return;
            }
            throw new IllegalArgumentException("No supported transition specified: " + i10);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdh) {
            zzdh zzdh = (zzdh) obj;
            if (this.zzf == zzdh.zzf && this.zzd == zzdh.zzd && this.zze == zzdh.zze && this.zzc == zzdh.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final long getExpirationTime() {
        return this.zzb;
    }

    public final double getLatitude() {
        return this.zzd;
    }

    public final int getLoiteringDelay() {
        return this.zzi;
    }

    public final double getLongitude() {
        return this.zze;
    }

    public final int getNotificationResponsiveness() {
        return this.zzh;
    }

    public final float getRadius() {
        return this.zzf;
    }

    public final String getRequestId() {
        return this.zza;
    }

    public final int getTransitionTypes() {
        return this.zzg;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzd);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zze);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzf)) * 31) + this.zzc) * 31) + this.zzg;
    }

    public final String toString() {
        String str;
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        short s10 = this.zzc;
        if (s10 == -1) {
            str = "INVALID";
        } else if (s10 != 1) {
            str = IdentityHttpResponse.UNKNOWN;
        } else {
            str = "CIRCLE";
        }
        objArr[0] = str;
        objArr[1] = this.zza.replaceAll("\\p{C}", TypeDescription.Generic.OfWildcardType.SYMBOL);
        objArr[2] = Integer.valueOf(this.zzg);
        objArr[3] = Double.valueOf(this.zzd);
        objArr[4] = Double.valueOf(this.zze);
        objArr[5] = Float.valueOf(this.zzf);
        objArr[6] = Integer.valueOf(this.zzh / 1000);
        objArr[7] = Integer.valueOf(this.zzi);
        objArr[8] = Long.valueOf(this.zzb);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.v(parcel, 2, this.zzb);
        a.B(parcel, 3, this.zzc);
        a.l(parcel, 4, this.zzd);
        a.l(parcel, 5, this.zze);
        a.o(parcel, 6, this.zzf);
        a.s(parcel, 7, this.zzg);
        a.s(parcel, 8, this.zzh);
        a.s(parcel, 9, this.zzi);
        a.b(parcel, a10);
    }
}
