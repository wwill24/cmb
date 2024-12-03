package ze;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zak;

public abstract class b extends zab implements c {
    public b() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zaa(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 3:
                ConnectionResult connectionResult = (ConnectionResult) zac.zaa(parcel, ConnectionResult.CREATOR);
                zaa zaa = (zaa) zac.zaa(parcel, zaa.CREATOR);
                zac.zab(parcel);
                break;
            case 4:
                Status status = (Status) zac.zaa(parcel, Status.CREATOR);
                zac.zab(parcel);
                break;
            case 6:
                Status status2 = (Status) zac.zaa(parcel, Status.CREATOR);
                zac.zab(parcel);
                break;
            case 7:
                Status status3 = (Status) zac.zaa(parcel, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) zac.zaa(parcel, GoogleSignInAccount.CREATOR);
                zac.zab(parcel);
                break;
            case 8:
                zac.zab(parcel);
                n((zak) zac.zaa(parcel, zak.CREATOR));
                break;
            case 9:
                zag zag = (zag) zac.zaa(parcel, zag.CREATOR);
                zac.zab(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
