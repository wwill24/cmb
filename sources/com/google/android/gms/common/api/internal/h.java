package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public interface h extends IInterface {

    public static abstract class a extends zab implements h {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @NonNull
        public static h asInterface(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            if (queryLocalInterface instanceof h) {
                return (h) queryLocalInterface;
            }
            return new t1(iBinder);
        }

        /* access modifiers changed from: protected */
        public final boolean zaa(int i10, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                return false;
            }
            zac.zab(parcel);
            onResult((Status) zac.zaa(parcel, Status.CREATOR));
            return true;
        }
    }

    void onResult(@NonNull Status status) throws RemoteException;
}
