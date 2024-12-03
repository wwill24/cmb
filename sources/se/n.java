package se;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.fido.fido2.api.common.zzy;

public final class n implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        long j10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.J(parcel, B);
            } else {
                j10 = SafeParcelReader.F(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzy(j10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzy[i10];
    }
}
