package je;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;

public interface g extends IInterface {
    void i0(ModuleInstallStatusUpdate moduleInstallStatusUpdate) throws RemoteException;
}
