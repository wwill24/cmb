package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzb;

public interface i extends IInterface {

    public static abstract class a extends zzb implements i {
        @NonNull
        public static i c(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof i) {
                return (i) queryLocalInterface;
            }
            return new w1(iBinder);
        }
    }

    @NonNull
    Account zzb() throws RemoteException;
}
