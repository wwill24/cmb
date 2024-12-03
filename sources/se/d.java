package se;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialDescriptor;
import java.util.ArrayList;

public final class d implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        byte[] bArr = null;
        ArrayList<Transport> arrayList = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                arrayList = SafeParcelReader.s(parcel, B, Transport.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new PublicKeyCredentialDescriptor(str, bArr, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new PublicKeyCredentialDescriptor[i10];
    }
}
