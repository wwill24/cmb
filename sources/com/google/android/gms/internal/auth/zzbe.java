package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;
import vd.b;
import vd.c;

public final class zzbe extends f {
    private final Bundle zze;

    public zzbe(Context context, Looper looper, e eVar, c cVar, com.google.android.gms.common.api.internal.f fVar, n nVar) {
        super(context, looper, 16, eVar, fVar, nVar);
        Bundle bundle;
        if (cVar == null) {
            bundle = new Bundle();
        } else {
            bundle = cVar.a();
        }
        this.zze = bundle;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof zzbh) {
            return (zzbh) queryLocalInterface;
        }
        return new zzbh(iBinder);
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zze;
    }

    public final int getMinApkVersion() {
        return com.google.android.gms.common.e.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    public final boolean requiresSignIn() {
        e clientSettings = getClientSettings();
        if (TextUtils.isEmpty(clientSettings.b()) || clientSettings.e(b.f42094a).isEmpty()) {
            return false;
        }
        return true;
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
