package je;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public abstract class d extends zab implements e {
    public d() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zaa(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            zac.zab(parcel);
            c0((Status) zac.zaa(parcel, Status.CREATOR), (ModuleAvailabilityResponse) zac.zaa(parcel, ModuleAvailabilityResponse.CREATOR));
        } else if (i10 == 2) {
            zac.zab(parcel);
            b0((Status) zac.zaa(parcel, Status.CREATOR), (ModuleInstallResponse) zac.zaa(parcel, ModuleInstallResponse.CREATOR));
        } else if (i10 == 3) {
            zac.zab(parcel);
            p((Status) zac.zaa(parcel, Status.CREATOR), (ModuleInstallIntentResponse) zac.zaa(parcel, ModuleInstallIntentResponse.CREATOR));
        } else if (i10 != 4) {
            return false;
        } else {
            zac.zab(parcel);
            k0((Status) zac.zaa(parcel, Status.CREATOR));
        }
        return true;
    }
}
