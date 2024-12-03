package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

public final class zzde implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        LocationRequest locationRequest = null;
        ArrayList<ClientIdentity> arrayList = null;
        String str = null;
        String str2 = null;
        long j10 = Long.MAX_VALUE;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                locationRequest = (LocationRequest) SafeParcelReader.n(parcel2, B, LocationRequest.CREATOR);
            } else if (u10 != 5) {
                switch (u10) {
                    case 8:
                        z10 = SafeParcelReader.v(parcel2, B);
                        break;
                    case 9:
                        z11 = SafeParcelReader.v(parcel2, B);
                        break;
                    case 10:
                        str = SafeParcelReader.o(parcel2, B);
                        break;
                    case 11:
                        z12 = SafeParcelReader.v(parcel2, B);
                        break;
                    case 12:
                        z13 = SafeParcelReader.v(parcel2, B);
                        break;
                    case 13:
                        str2 = SafeParcelReader.o(parcel2, B);
                        break;
                    case 14:
                        j10 = SafeParcelReader.F(parcel2, B);
                        break;
                    default:
                        SafeParcelReader.J(parcel2, B);
                        break;
                }
            } else {
                arrayList = SafeParcelReader.s(parcel2, B, ClientIdentity.CREATOR);
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzdd(locationRequest, arrayList, z10, z11, str, z12, z13, str2, j10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzdd[i10];
    }
}
