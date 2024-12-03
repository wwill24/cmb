package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzdc implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        String str = null;
        String str2 = null;
        int i10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    iBinder = SafeParcelReader.C(parcel, B);
                    break;
                case 3:
                    iBinder2 = SafeParcelReader.C(parcel, B);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, B, PendingIntent.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 6:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzdb(i10, iBinder, iBinder2, pendingIntent, str, str2);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzdb[i10];
    }
}
