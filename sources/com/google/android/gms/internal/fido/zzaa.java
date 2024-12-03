package com.google.android.gms.internal.fido;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;

public final class zzaa extends f {
    public zzaa(Context context, Looper looper, e eVar, com.google.android.gms.common.api.internal.f fVar, n nVar) {
        super(context, looper, 262, eVar, fVar, nVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fido.sourcedevice.internal.ISourceDirectTransferService");
        if (queryLocalInterface instanceof zzt) {
            return (zzt) queryLocalInterface;
        }
        return new zzt(iBinder);
    }

    public final int getMinApkVersion() {
        return 203000000;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.fido.sourcedevice.internal.ISourceDirectTransferService";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.fido.sourcedevice.service.START";
    }

    /* access modifiers changed from: protected */
    public final boolean getUseDynamicLookup() {
        return true;
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
