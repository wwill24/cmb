package com.google.android.gms.internal.p002authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbx  reason: invalid package */
public abstract class zbx extends zbb implements zby {
    public zbx() {
        super("com.google.android.gms.auth.api.identity.internal.IBeginSignInCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zba(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        zbc.zbb(parcel);
        zbb((Status) zbc.zba(parcel, Status.CREATOR), (BeginSignInResult) zbc.zba(parcel, BeginSignInResult.CREATOR));
        return true;
    }
}
