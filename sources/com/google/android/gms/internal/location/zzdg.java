package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzdg implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        zzdd zzdd = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        String str = null;
        int i10 = 1;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    zzdd = (zzdd) SafeParcelReader.n(parcel, B, zzdd.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.C(parcel, B);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, B, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = SafeParcelReader.C(parcel, B);
                    break;
                case 6:
                    iBinder3 = SafeParcelReader.C(parcel, B);
                    break;
                case 8:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzdf(i10, zzdd, iBinder, iBinder2, pendingIntent, iBinder3, str);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzdf[i10];
    }
}
