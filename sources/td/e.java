package td;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.appset.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class e implements Parcelable.Creator<zzc> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        int i10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                i10 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzc(str, i10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzc[i10];
    }
}
