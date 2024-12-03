package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.a;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import pe.b;
import we.t;
import we.v;

@DynamiteApi
public class AppMeasurementDynamiteService extends zzcb {

    /* renamed from: a  reason: collision with root package name */
    u4 f39623a = null;

    /* renamed from: b  reason: collision with root package name */
    private final Map f39624b = new a();

    @EnsuresNonNull({"scion"})
    private final void c() {
        if (this.f39623a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void f(zzcf zzcf, String str) {
        c();
        this.f39623a.N().K(zzcf, str);
    }

    public void beginAdUnitExposure(@NonNull String str, long j10) throws RemoteException {
        c();
        this.f39623a.y().l(str, j10);
    }

    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        c();
        this.f39623a.I().o(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j10) throws RemoteException {
        c();
        this.f39623a.I().I((Boolean) null);
    }

    public void endAdUnitExposure(@NonNull String str, long j10) throws RemoteException {
        c();
        this.f39623a.y().m(str, j10);
    }

    public void generateEventId(zzcf zzcf) throws RemoteException {
        c();
        long t02 = this.f39623a.N().t0();
        c();
        this.f39623a.N().J(zzcf, t02);
    }

    public void getAppInstanceId(zzcf zzcf) throws RemoteException {
        c();
        this.f39623a.f().z(new j6(this, zzcf));
    }

    public void getCachedAppInstanceId(zzcf zzcf) throws RemoteException {
        c();
        f(zzcf, this.f39623a.I().V());
    }

    public void getConditionalUserProperties(String str, String str2, zzcf zzcf) throws RemoteException {
        c();
        this.f39623a.f().z(new u9(this, zzcf, str, str2));
    }

    public void getCurrentScreenClass(zzcf zzcf) throws RemoteException {
        c();
        f(zzcf, this.f39623a.I().W());
    }

    public void getCurrentScreenName(zzcf zzcf) throws RemoteException {
        c();
        f(zzcf, this.f39623a.I().X());
    }

    public void getGmpAppId(zzcf zzcf) throws RemoteException {
        String str;
        c();
        u6 I = this.f39623a.I();
        if (I.f40059a.O() != null) {
            str = I.f40059a.O();
        } else {
            try {
                str = v.c(I.f40059a.c(), "google_app_id", I.f40059a.R());
            } catch (IllegalStateException e10) {
                I.f40059a.d().r().b("getGoogleAppId failed with exception", e10);
                str = null;
            }
        }
        f(zzcf, str);
    }

    public void getMaxUserProperties(String str, zzcf zzcf) throws RemoteException {
        c();
        this.f39623a.I().Q(str);
        c();
        this.f39623a.N().I(zzcf, 25);
    }

    public void getSessionId(zzcf zzcf) throws RemoteException {
        c();
        u6 I = this.f39623a.I();
        I.f40059a.f().z(new h6(I, zzcf));
    }

    public void getTestFlag(zzcf zzcf, int i10) throws RemoteException {
        c();
        if (i10 == 0) {
            this.f39623a.N().K(zzcf, this.f39623a.I().Y());
        } else if (i10 == 1) {
            this.f39623a.N().J(zzcf, this.f39623a.I().U().longValue());
        } else if (i10 == 2) {
            t9 N = this.f39623a.N();
            double doubleValue = this.f39623a.I().S().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble(StreamManagement.AckRequest.ELEMENT, doubleValue);
            try {
                zzcf.zze(bundle);
            } catch (RemoteException e10) {
                N.f40059a.d().w().b("Error returning double value to wrapper", e10);
            }
        } else if (i10 == 3) {
            this.f39623a.N().I(zzcf, this.f39623a.I().T().intValue());
        } else if (i10 == 4) {
            this.f39623a.N().E(zzcf, this.f39623a.I().R().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z10, zzcf zzcf) throws RemoteException {
        c();
        this.f39623a.f().z(new h8(this, zzcf, str, str2, z10));
    }

    public void initForTests(@NonNull Map map) throws RemoteException {
        c();
    }

    public void initialize(pe.a aVar, zzcl zzcl, long j10) throws RemoteException {
        u4 u4Var = this.f39623a;
        if (u4Var == null) {
            this.f39623a = u4.H((Context) p.k((Context) b.f(aVar)), zzcl, Long.valueOf(j10));
        } else {
            u4Var.d().w().a("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzcf zzcf) throws RemoteException {
        c();
        this.f39623a.f().z(new v9(this, zzcf));
    }

    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z10, boolean z11, long j10) throws RemoteException {
        c();
        this.f39623a.I().s(str, str2, bundle, z10, z11, j10);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcf, long j10) throws RemoteException {
        Bundle bundle2;
        c();
        p.g(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.f39623a.f().z(new h7(this, zzcf, new zzau(str2, new zzas(bundle), "app", j10), str));
    }

    public void logHealthData(int i10, @NonNull String str, @NonNull pe.a aVar, @NonNull pe.a aVar2, @NonNull pe.a aVar3) throws RemoteException {
        Object obj;
        Object obj2;
        c();
        Object obj3 = null;
        if (aVar == null) {
            obj = null;
        } else {
            obj = b.f(aVar);
        }
        if (aVar2 == null) {
            obj2 = null;
        } else {
            obj2 = b.f(aVar2);
        }
        if (aVar3 != null) {
            obj3 = b.f(aVar3);
        }
        this.f39623a.d().G(i10, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(@NonNull pe.a aVar, @NonNull Bundle bundle, long j10) throws RemoteException {
        c();
        t6 t6Var = this.f39623a.I().f40329c;
        if (t6Var != null) {
            this.f39623a.I().p();
            t6Var.onActivityCreated((Activity) b.f(aVar), bundle);
        }
    }

    public void onActivityDestroyed(@NonNull pe.a aVar, long j10) throws RemoteException {
        c();
        t6 t6Var = this.f39623a.I().f40329c;
        if (t6Var != null) {
            this.f39623a.I().p();
            t6Var.onActivityDestroyed((Activity) b.f(aVar));
        }
    }

    public void onActivityPaused(@NonNull pe.a aVar, long j10) throws RemoteException {
        c();
        t6 t6Var = this.f39623a.I().f40329c;
        if (t6Var != null) {
            this.f39623a.I().p();
            t6Var.onActivityPaused((Activity) b.f(aVar));
        }
    }

    public void onActivityResumed(@NonNull pe.a aVar, long j10) throws RemoteException {
        c();
        t6 t6Var = this.f39623a.I().f40329c;
        if (t6Var != null) {
            this.f39623a.I().p();
            t6Var.onActivityResumed((Activity) b.f(aVar));
        }
    }

    public void onActivitySaveInstanceState(pe.a aVar, zzcf zzcf, long j10) throws RemoteException {
        c();
        t6 t6Var = this.f39623a.I().f40329c;
        Bundle bundle = new Bundle();
        if (t6Var != null) {
            this.f39623a.I().p();
            t6Var.onActivitySaveInstanceState((Activity) b.f(aVar), bundle);
        }
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.f39623a.d().w().b("Error returning bundle value to wrapper", e10);
        }
    }

    public void onActivityStarted(@NonNull pe.a aVar, long j10) throws RemoteException {
        c();
        if (this.f39623a.I().f40329c != null) {
            this.f39623a.I().p();
            Activity activity = (Activity) b.f(aVar);
        }
    }

    public void onActivityStopped(@NonNull pe.a aVar, long j10) throws RemoteException {
        c();
        if (this.f39623a.I().f40329c != null) {
            this.f39623a.I().p();
            Activity activity = (Activity) b.f(aVar);
        }
    }

    public void performAction(Bundle bundle, zzcf zzcf, long j10) throws RemoteException {
        c();
        zzcf.zze((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzci zzci) throws RemoteException {
        t tVar;
        c();
        synchronized (this.f39624b) {
            tVar = (t) this.f39624b.get(Integer.valueOf(zzci.zzd()));
            if (tVar == null) {
                tVar = new x9(this, zzci);
                this.f39624b.put(Integer.valueOf(zzci.zzd()), tVar);
            }
        }
        this.f39623a.I().x(tVar);
    }

    public void resetAnalyticsData(long j10) throws RemoteException {
        c();
        this.f39623a.I().y(j10);
    }

    public void setConditionalUserProperty(@NonNull Bundle bundle, long j10) throws RemoteException {
        c();
        if (bundle == null) {
            this.f39623a.d().r().a("Conditional user property must not be null");
        } else {
            this.f39623a.I().E(bundle, j10);
        }
    }

    public void setConsent(@NonNull Bundle bundle, long j10) throws RemoteException {
        c();
        u6 I = this.f39623a.I();
        I.f40059a.f().A(new t5(I, bundle, j10));
    }

    public void setConsentThirdParty(@NonNull Bundle bundle, long j10) throws RemoteException {
        c();
        this.f39623a.I().G(bundle, -20, j10);
    }

    public void setCurrentScreen(@NonNull pe.a aVar, @NonNull String str, @NonNull String str2, long j10) throws RemoteException {
        c();
        this.f39623a.K().D((Activity) b.f(aVar), str, str2);
    }

    public void setDataCollectionEnabled(boolean z10) throws RemoteException {
        c();
        u6 I = this.f39623a.I();
        I.i();
        I.f40059a.f().z(new r6(I, z10));
    }

    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        Bundle bundle2;
        c();
        u6 I = this.f39623a.I();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        I.f40059a.f().z(new u5(I, bundle2));
    }

    public void setEventInterceptor(zzci zzci) throws RemoteException {
        c();
        w9 w9Var = new w9(this, zzci);
        if (this.f39623a.f().C()) {
            this.f39623a.I().H(w9Var);
        } else {
            this.f39623a.f().z(new h9(this, w9Var));
        }
    }

    public void setInstanceIdProvider(zzck zzck) throws RemoteException {
        c();
    }

    public void setMeasurementEnabled(boolean z10, long j10) throws RemoteException {
        c();
        this.f39623a.I().I(Boolean.valueOf(z10));
    }

    public void setMinimumSessionDuration(long j10) throws RemoteException {
        c();
    }

    public void setSessionTimeoutDuration(long j10) throws RemoteException {
        c();
        u6 I = this.f39623a.I();
        I.f40059a.f().z(new y5(I, j10));
    }

    public void setUserId(@NonNull String str, long j10) throws RemoteException {
        c();
        u6 I = this.f39623a.I();
        if (str == null || !TextUtils.isEmpty(str)) {
            I.f40059a.f().z(new v5(I, str));
            I.L((String) null, "_id", str, true, j10);
            return;
        }
        I.f40059a.d().w().a("User ID must be non-empty or null");
    }

    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull pe.a aVar, boolean z10, long j10) throws RemoteException {
        c();
        this.f39623a.I().L(str, str2, b.f(aVar), z10, j10);
    }

    public void unregisterOnMeasurementEventListener(zzci zzci) throws RemoteException {
        t tVar;
        c();
        synchronized (this.f39624b) {
            tVar = (t) this.f39624b.remove(Integer.valueOf(zzci.zzd()));
        }
        if (tVar == null) {
            tVar = new x9(this, zzci);
        }
        this.f39623a.I().N(tVar);
    }
}
