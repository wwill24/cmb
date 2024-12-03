package yd;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.J(parcel, B);
            } else {
                pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, B, PendingIntent.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new SaveAccountLinkingTokenResult(pendingIntent);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new SaveAccountLinkingTokenResult[i10];
    }
}
