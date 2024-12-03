package te;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.fido.sourcedevice.SourceStartDirectTransferOptions;
import java.util.ArrayList;

public final class b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        ArrayList arrayList = null;
        String str = null;
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 3) {
                arrayList = SafeParcelReader.s(parcel, B, Account.CREATOR);
            } else if (u10 == 4) {
                z11 = SafeParcelReader.v(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                str = SafeParcelReader.o(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new SourceStartDirectTransferOptions(i10, z10, arrayList, z11, str);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new SourceStartDirectTransferOptions[i10];
    }
}
