package bd;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f34036a;

    /* renamed from: b  reason: collision with root package name */
    private final String f34037b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    protected a(IBinder iBinder) {
        this.f34036a = iBinder;
    }

    public final IBinder asBinder() {
        return this.f34036a;
    }

    /* access modifiers changed from: protected */
    public final Parcel c() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f34037b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel f(Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f34036a.transact(1, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e10) {
            throw e10;
        } finally {
            parcel.recycle();
        }
    }
}
