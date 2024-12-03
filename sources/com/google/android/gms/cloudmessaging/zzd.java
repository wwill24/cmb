package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzd implements Parcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    Messenger f38483a;

    /* renamed from: b  reason: collision with root package name */
    b f38484b;

    public zzd(IBinder iBinder) {
        this.f38483a = new Messenger(iBinder);
    }

    public final IBinder a() {
        Messenger messenger = this.f38483a;
        return messenger != null ? messenger.getBinder() : this.f38484b.asBinder();
    }

    public final void c(Message message) throws RemoteException {
        Messenger messenger = this.f38483a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f38484b.L(message);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zzd) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        Messenger messenger = this.f38483a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f38484b.asBinder());
        }
    }
}
