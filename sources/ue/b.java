package ue;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.fido.u2f.api.common.SignResponseData;

public final class b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        byte[] bArr = null;
        String str = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 == 3) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 4) {
                bArr2 = SafeParcelReader.g(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                bArr3 = SafeParcelReader.g(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new SignResponseData(bArr, str, bArr2, bArr3);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new SignResponseData[i10];
    }
}
