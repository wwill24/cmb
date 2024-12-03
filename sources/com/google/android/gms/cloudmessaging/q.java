package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

final class q {

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f38462a;

    /* renamed from: b  reason: collision with root package name */
    private final zzd f38463b;

    q(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f38462a = new Messenger(iBinder);
            this.f38463b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f38463b = new zzd(iBinder);
            this.f38462a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            if (valueOf.length() != 0) {
                "Invalid interface descriptor: ".concat(valueOf);
            }
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f38462a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzd zzd = this.f38463b;
        if (zzd != null) {
            zzd.c(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
