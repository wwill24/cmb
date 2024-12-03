package se;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialParameters;

public final class e implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        Integer num = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.J(parcel, B);
            } else {
                num = SafeParcelReader.E(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new PublicKeyCredentialParameters(str, num.intValue());
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new PublicKeyCredentialParameters[i10];
    }
}
