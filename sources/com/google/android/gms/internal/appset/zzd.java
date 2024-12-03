package com.google.android.gms.internal.appset;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;
import com.leanplum.messagetemplates.MessageTemplateConstants;

public final class zzd extends f<zzg> {
    protected zzd(Context context, Looper looper, e eVar, com.google.android.gms.common.api.internal.f fVar, n nVar) {
        super(context, looper, (int) MessageTemplateConstants.Values.CENTER_POPUP_WIDTH, eVar, fVar, nVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appset.internal.IAppSetService");
        if (queryLocalInterface instanceof zzg) {
            return (zzg) queryLocalInterface;
        }
        return new zzg(iBinder);
    }

    public final Feature[] getApiFeatures() {
        return td.f.f41948b;
    }

    public final int getMinApkVersion() {
        return 212800000;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.appset.internal.IAppSetService";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.appset.service.START";
    }

    /* access modifiers changed from: protected */
    public final boolean getUseDynamicLookup() {
        return true;
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
