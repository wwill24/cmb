package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f20507a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20508b = "com.google.android.play.core.integrity.protocol.IIntegrityService";

    protected a(IBinder iBinder, String str) {
        this.f20507a = iBinder;
    }

    public final IBinder asBinder() {
        return this.f20507a;
    }

    /* access modifiers changed from: protected */
    public final Parcel c() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f20508b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void f(int i10, Parcel parcel) throws RemoteException {
        try {
            this.f20507a.transact(2, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
