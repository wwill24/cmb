package com.google.android.gms.internal.p001authapiphone;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzw  reason: invalid package */
public final class zzw extends f<zzh> {
    public zzw(Context context, Looper looper, e eVar, com.google.android.gms.common.api.internal.f fVar, n nVar) {
        super(context, looper, 126, eVar, fVar, nVar);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        if (queryLocalInterface instanceof zzh) {
            return (zzh) queryLocalInterface;
        }
        return new zzh(iBinder);
    }

    public final Feature[] getApiFeatures() {
        return zzac.zze;
    }

    public final int getMinApkVersion() {
        return com.google.android.gms.common.e.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START";
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
