package ce;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public interface r extends IInterface {
    void X(Status status) throws RemoteException;

    void t(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException;

    void zbc(Status status) throws RemoteException;
}
