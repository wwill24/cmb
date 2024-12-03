package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzr implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        String str = null;
        String str2 = null;
        Point[] pointArr = null;
        zzj zzj = null;
        zzm zzm = null;
        zzn zzn = null;
        zzp zzp = null;
        zzo zzo = null;
        zzk zzk = null;
        zzg zzg = null;
        zzh zzh = null;
        zzi zzi = null;
        byte[] bArr = null;
        double d10 = 0.0d;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 3:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 4:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 5:
                    i11 = SafeParcelReader.D(parcel2, B);
                    break;
                case 6:
                    pointArr = (Point[]) SafeParcelReader.r(parcel2, B, Point.CREATOR);
                    break;
                case 7:
                    zzj = (zzj) SafeParcelReader.n(parcel2, B, zzj.CREATOR);
                    break;
                case 8:
                    zzm = (zzm) SafeParcelReader.n(parcel2, B, zzm.CREATOR);
                    break;
                case 9:
                    zzn = (zzn) SafeParcelReader.n(parcel2, B, zzn.CREATOR);
                    break;
                case 10:
                    zzp = (zzp) SafeParcelReader.n(parcel2, B, zzp.CREATOR);
                    break;
                case 11:
                    zzo = (zzo) SafeParcelReader.n(parcel2, B, zzo.CREATOR);
                    break;
                case 12:
                    zzk = (zzk) SafeParcelReader.n(parcel2, B, zzk.CREATOR);
                    break;
                case 13:
                    zzg = (zzg) SafeParcelReader.n(parcel2, B, zzg.CREATOR);
                    break;
                case 14:
                    zzh = (zzh) SafeParcelReader.n(parcel2, B, zzh.CREATOR);
                    break;
                case 15:
                    zzi = (zzi) SafeParcelReader.n(parcel2, B, zzi.CREATOR);
                    break;
                case 16:
                    bArr = SafeParcelReader.g(parcel2, B);
                    break;
                case 17:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                case 18:
                    d10 = SafeParcelReader.x(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzq(i10, str, str2, i11, pointArr, zzj, zzm, zzn, zzp, zzo, zzk, zzg, zzh, zzi, bArr, z10, d10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzq[i10];
    }
}
