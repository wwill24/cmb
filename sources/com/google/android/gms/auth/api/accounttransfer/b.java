package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        int i10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    arrayList = SafeParcelReader.q(parcel, B);
                    break;
                case 3:
                    arrayList2 = SafeParcelReader.q(parcel, B);
                    break;
                case 4:
                    arrayList3 = SafeParcelReader.q(parcel, B);
                    break;
                case 5:
                    arrayList4 = SafeParcelReader.q(parcel, B);
                    break;
                case 6:
                    arrayList5 = SafeParcelReader.q(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzs(i10, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzs[i10];
    }
}
