package je;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

public interface e extends IInterface {
    void b0(Status status, ModuleInstallResponse moduleInstallResponse) throws RemoteException;

    void c0(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse) throws RemoteException;

    void k0(Status status) throws RemoteException;

    void p(Status status, ModuleInstallIntentResponse moduleInstallIntentResponse) throws RemoteException;
}
