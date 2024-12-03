package ge;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.internal.base.zaf;

public final class e extends f {

    /* renamed from: a  reason: collision with root package name */
    private final u f40871a;

    public e(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, u uVar, com.google.android.gms.common.api.internal.f fVar, n nVar) {
        super(context, looper, 270, eVar, fVar, nVar);
        this.f40871a = uVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        if (queryLocalInterface instanceof a) {
            return (a) queryLocalInterface;
        }
        return new a(iBinder);
    }

    public final Feature[] getApiFeatures() {
        return zaf.zab;
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.f40871a.b();
    }

    public final int getMinApkVersion() {
        return 203400000;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    /* access modifiers changed from: protected */
    public final boolean getUseDynamicLookup() {
        return true;
    }
}
