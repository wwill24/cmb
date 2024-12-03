package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

final class u0 implements l {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f39060a;

    u0(IBinder iBinder) {
        this.f39060a = iBinder;
    }

    public final void N(k kVar, GetServiceRequest getServiceRequest) throws RemoteException {
        IBinder iBinder;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (kVar != null) {
                iBinder = kVar.asBinder();
            } else {
                iBinder = null;
            }
            obtain.writeStrongBinder(iBinder);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                m1.a(getServiceRequest, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f39060a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f39060a;
    }
}
