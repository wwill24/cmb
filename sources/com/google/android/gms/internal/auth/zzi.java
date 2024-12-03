package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;
import ud.b;

final class zzi extends f {
    zzi(Context context, Looper looper, e eVar, com.google.android.gms.common.api.internal.f fVar, n nVar) {
        super(context, looper, 224, eVar, fVar, nVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.account.data.IGoogleAuthService");
        if (queryLocalInterface instanceof zzp) {
            return (zzp) queryLocalInterface;
        }
        return new zzp(iBinder);
    }

    public final void disconnect(String str) {
        "GoogleAuthServiceClientImpl disconnected with reason: ".concat(String.valueOf(str));
        super.disconnect(str);
    }

    public final Feature[] getApiFeatures() {
        return new Feature[]{b.f42035j, b.f42034i, b.f42026a};
    }

    public final int getMinApkVersion() {
        return 17895000;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.account.data.IGoogleAuthService";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.account.authapi.START";
    }

    /* access modifiers changed from: protected */
    public final boolean getUseDynamicLookup() {
        return true;
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
