package ie;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;

public final class f implements Parcelable.Creator {
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
        return new ModuleInstallIntentResponse(pendingIntent);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ModuleInstallIntentResponse[i10];
    }
}
