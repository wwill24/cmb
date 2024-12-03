package ue;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.fido.u2f.api.common.KeyHandle;
import com.google.android.gms.fido.u2f.api.common.RegisteredKey;

public final class a implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        KeyHandle keyHandle = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                keyHandle = (KeyHandle) SafeParcelReader.n(parcel, B, KeyHandle.CREATOR);
            } else if (u10 == 3) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                str2 = SafeParcelReader.o(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new RegisteredKey(keyHandle, str, str2);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new RegisteredKey[i10];
    }
}
