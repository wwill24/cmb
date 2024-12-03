package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;
import ud.b;

public final class zzam extends f {
    public zzam(Context context, Looper looper, e eVar, d.b bVar, d.c cVar) {
        super(context, looper, 120, eVar, bVar, cVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        return com.google.android.gms.auth.account.f.c(iBinder);
    }

    public final Feature[] getApiFeatures() {
        return new Feature[]{b.f42037l};
    }

    public final int getMinApkVersion() {
        return com.google.android.gms.common.e.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.account.IWorkAccountService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.account.workaccount.START";
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
