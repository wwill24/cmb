package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();
    public int zza;
    public boolean zzb;

    public zzad() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzad)) {
            return false;
        }
        zzad zzad = (zzad) obj;
        if (this.zza != zzad.zza || !n.b(Boolean.valueOf(this.zzb), Boolean.valueOf(zzad.zzb))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(Integer.valueOf(this.zza), Boolean.valueOf(this.zzb));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 2, this.zza);
        a.g(parcel, 3, this.zzb);
        a.b(parcel, a10);
    }

    public zzad(int i10, boolean z10) {
        this.zza = i10;
        this.zzb = z10;
    }
}
