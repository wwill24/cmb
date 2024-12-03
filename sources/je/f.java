package je;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public abstract class f extends zab implements g {
    public f() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallStatusListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zaa(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        zac.zab(parcel);
        i0((ModuleInstallStatusUpdate) zac.zaa(parcel, ModuleInstallStatusUpdate.CREATOR));
        return true;
    }
}
