package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class d<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @NonNull
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @NonNull
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    @NonNull
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zze = new Feature[0];
    private volatile String zzA;
    /* access modifiers changed from: private */
    public ConnectionResult zzB;
    /* access modifiers changed from: private */
    public boolean zzC;
    private volatile zzj zzD;
    v1 zza;
    final Handler zzb;
    @NonNull
    protected c zzc;
    @NonNull
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final g zzn;
    private final com.google.android.gms.common.d zzo;
    private final Object zzp;
    /* access modifiers changed from: private */
    public final Object zzq;
    /* access modifiers changed from: private */
    public l zzr;
    private IInterface zzs;
    /* access modifiers changed from: private */
    public final ArrayList zzt;
    private f1 zzu;
    private int zzv;
    /* access modifiers changed from: private */
    public final a zzw;
    /* access modifiers changed from: private */
    public final b zzx;
    private final int zzy;
    private final String zzz;

    public interface a {
        void c(Bundle bundle);

        void f(int i10);
    }

    public interface b {
        void g(@NonNull ConnectionResult connectionResult);
    }

    public interface c {
        void a(@NonNull ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.d$d  reason: collision with other inner class name */
    protected class C0483d implements c {
        public C0483d() {
        }

        public final void a(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.i0()) {
                d dVar = d.this;
                dVar.getRemoteService((i) null, dVar.getScopes());
            } else if (d.this.zzx != null) {
                d.this.zzx.g(connectionResult);
            }
        }
    }

    public interface e {
        void a();
    }

    protected d(@NonNull Context context, @NonNull Handler handler, @NonNull g gVar, @NonNull com.google.android.gms.common.d dVar, int i10, a aVar, b bVar) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        p.l(context, "Context must not be null");
        this.zzl = context;
        p.l(handler, "Handler must not be null");
        this.zzb = handler;
        this.zzm = handler.getLooper();
        p.l(gVar, "Supervisor must not be null");
        this.zzn = gVar;
        p.l(dVar, "API availability must not be null");
        this.zzo = dVar;
        this.zzy = i10;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = null;
    }

    static /* bridge */ /* synthetic */ void zzj(d dVar, zzj zzj2) {
        RootTelemetryConfiguration rootTelemetryConfiguration;
        dVar.zzD = zzj2;
        if (dVar.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzj2.f39089d;
            q b10 = q.b();
            if (connectionTelemetryConfiguration == null) {
                rootTelemetryConfiguration = null;
            } else {
                rootTelemetryConfiguration = connectionTelemetryConfiguration.m0();
            }
            b10.c(rootTelemetryConfiguration);
        }
    }

    static /* bridge */ /* synthetic */ void zzk(d dVar, int i10) {
        int i11;
        int i12;
        synchronized (dVar.zzp) {
            i11 = dVar.zzv;
        }
        if (i11 == 3) {
            dVar.zzC = true;
            i12 = 5;
        } else {
            i12 = 4;
        }
        Handler handler = dVar.zzb;
        handler.sendMessage(handler.obtainMessage(i12, dVar.zzd.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean zzn(d dVar, int i10, int i11, IInterface iInterface) {
        synchronized (dVar.zzp) {
            if (dVar.zzv != i10) {
                return false;
            }
            dVar.zzp(i11, iInterface);
            return true;
        }
    }

    static /* bridge */ /* synthetic */ boolean zzo(d dVar) {
        if (dVar.zzC || TextUtils.isEmpty(dVar.getServiceDescriptor()) || TextUtils.isEmpty(dVar.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(dVar.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzp(int i10, IInterface iInterface) {
        boolean z10;
        boolean z11;
        v1 v1Var;
        v1 v1Var2;
        boolean z12 = false;
        if (i10 != 4) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (iInterface == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z10 == z11) {
            z12 = true;
        }
        p.a(z12);
        synchronized (this.zzp) {
            this.zzv = i10;
            this.zzs = iInterface;
            if (i10 == 1) {
                f1 f1Var = this.zzu;
                if (f1Var != null) {
                    g gVar = this.zzn;
                    String c10 = this.zza.c();
                    p.k(c10);
                    gVar.e(c10, this.zza.b(), this.zza.a(), f1Var, zze(), this.zza.d());
                    this.zzu = null;
                }
            } else if (i10 == 2 || i10 == 3) {
                f1 f1Var2 = this.zzu;
                if (!(f1Var2 == null || (v1Var2 = this.zza) == null)) {
                    String c11 = v1Var2.c();
                    String b10 = v1Var2.b();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calling connect() while still connected, missing disconnect() for ");
                    sb2.append(c11);
                    sb2.append(" on ");
                    sb2.append(b10);
                    g gVar2 = this.zzn;
                    String c12 = this.zza.c();
                    p.k(c12);
                    gVar2.e(c12, this.zza.b(), this.zza.a(), f1Var2, zze(), this.zza.d());
                    this.zzd.incrementAndGet();
                }
                f1 f1Var3 = new f1(this, this.zzd.get());
                this.zzu = f1Var3;
                if (this.zzv != 3 || getLocalStartServiceAction() == null) {
                    v1Var = new v1(getStartServicePackage(), getStartServiceAction(), false, g.a(), getUseDynamicLookup());
                } else {
                    v1Var = new v1(getContext().getPackageName(), getLocalStartServiceAction(), true, g.a(), false);
                }
                this.zza = v1Var;
                if (v1Var.d()) {
                    if (getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.c())));
                    }
                }
                g gVar3 = this.zzn;
                String c13 = this.zza.c();
                p.k(c13);
                String b11 = this.zza.b();
                int a10 = this.zza.a();
                if (!gVar3.f(new n1(c13, b11, a10, this.zza.d()), f1Var3, zze(), getBindServiceExecutor())) {
                    String c14 = this.zza.c();
                    String b12 = this.zza.b();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("unable to connect to service: ");
                    sb3.append(c14);
                    sb3.append(" on ");
                    sb3.append(b12);
                    zzl(16, (Bundle) null, this.zzd.get());
                }
            } else if (i10 == 4) {
                p.k(iInterface);
                onConnectedLocked(iInterface);
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int j10 = this.zzo.j(this.zzl, getMinApkVersion());
        if (j10 != 0) {
            zzp(1, (IInterface) null);
            triggerNotAvailable(new C0483d(), j10, (PendingIntent) null);
            return;
        }
        connect(new C0483d());
    }

    /* access modifiers changed from: protected */
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(@NonNull c cVar) {
        p.l(cVar, "Connection progress callbacks cannot be null.");
        this.zzc = cVar;
        zzp(2, (IInterface) null);
    }

    /* access modifiers changed from: protected */
    public abstract T createServiceInterface(@NonNull IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((d1) this.zzt.get(i10)).d();
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, (IInterface) null);
    }

    public void dump(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        int i10;
        IInterface iInterface;
        l lVar;
        synchronized (this.zzp) {
            i10 = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            lVar = this.zzr;
        }
        printWriter.append(str).append("mConnectState=");
        if (i10 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i10 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i10 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i10 == 4) {
            printWriter.print("CONNECTED");
        } else if (i10 != 5) {
            printWriter.print(IdentityHttpResponse.UNKNOWN);
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (lVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(lVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.DATE_WITH_TIME_PATTERN_MS, Locale.US);
        if (this.zzh > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j10 = this.zzh;
            String format2 = simpleDateFormat.format(new Date(j10));
            append.println(j10 + " " + format2);
        }
        if (this.zzg > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            int i11 = this.zzf;
            if (i11 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i11 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i11 != 3) {
                printWriter.append(String.valueOf(i11));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j11 = this.zzg;
            String format3 = simpleDateFormat.format(new Date(j11));
            append2.println(j11 + " " + format3);
        }
        if (this.zzj > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(com.google.android.gms.common.api.b.a(this.zzi));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j12 = this.zzj;
            String format4 = simpleDateFormat.format(new Date(j12));
            append3.println(j12 + " " + format4);
        }
    }

    /* access modifiers changed from: protected */
    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    @NonNull
    public Feature[] getApiFeatures() {
        return zze;
    }

    public final Feature[] getAvailableFeatures() {
        zzj zzj2 = this.zzD;
        if (zzj2 == null) {
            return null;
        }
        return zzj2.f39087b;
    }

    /* access modifiers changed from: protected */
    public Executor getBindServiceExecutor() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    @NonNull
    public final Context getContext() {
        return this.zzl;
    }

    @NonNull
    public String getEndpointPackageName() {
        v1 v1Var;
        if (isConnected() && (v1Var = this.zza) != null) {
            return v1Var.b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    /* access modifiers changed from: protected */
    public String getLocalStartServiceAction() {
        return null;
    }

    @NonNull
    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return com.google.android.gms.common.d.f38874a;
    }

    public void getRemoteService(i iVar, @NonNull Set<Scope> set) {
        Set<Scope> set2 = set;
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        int i10 = this.zzy;
        String str = this.zzA;
        int i11 = com.google.android.gms.common.d.f38874a;
        Scope[] scopeArr = GetServiceRequest.f38929q;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f38930t;
        GetServiceRequest getServiceRequest = r3;
        GetServiceRequest getServiceRequest2 = new GetServiceRequest(6, i10, i11, (String) null, (IBinder) null, scopeArr, bundle, (Account) null, featureArr, featureArr, true, 0, false, str);
        GetServiceRequest getServiceRequest3 = getServiceRequest;
        getServiceRequest3.f38934d = this.zzl.getPackageName();
        getServiceRequest3.f38937g = getServiceRequestExtraArgs;
        if (set2 != null) {
            getServiceRequest3.f38936f = (Scope[]) set2.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            getServiceRequest3.f38938h = account;
            if (iVar != null) {
                getServiceRequest3.f38935e = iVar.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest3.f38938h = getAccount();
        }
        getServiceRequest3.f38939j = zze;
        getServiceRequest3.f38940k = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest3.f38943n = true;
        }
        try {
            synchronized (this.zzq) {
                l lVar = this.zzr;
                if (lVar != null) {
                    lVar.N(new e1(this, this.zzd.get()), getServiceRequest3);
                }
            }
        } catch (DeadObjectException unused) {
            triggerConnectionSuspended(3);
        } catch (SecurityException e10) {
            throw e10;
        } catch (RemoteException | RuntimeException unused2) {
            onPostInitHandler(8, (IBinder) null, (Bundle) null, this.zzd.get());
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    @NonNull
    public final T getService() throws DeadObjectException {
        T t10;
        synchronized (this.zzp) {
            if (this.zzv != 5) {
                checkConnected();
                t10 = this.zzs;
                p.l(t10, "Client is connected but service is null");
            } else {
                throw new DeadObjectException();
            }
        }
        return t10;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            l lVar = this.zzr;
            if (lVar == null) {
                return null;
            }
            IBinder asBinder = lVar.asBinder();
            return asBinder;
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String getServiceDescriptor();

    @NonNull
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String getStartServiceAction();

    /* access modifiers changed from: protected */
    @NonNull
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzj zzj2 = this.zzD;
        if (zzj2 == null) {
            return null;
        }
        return zzj2.f39089d;
    }

    /* access modifiers changed from: protected */
    public boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }

    public boolean isConnected() {
        boolean z10;
        synchronized (this.zzp) {
            if (this.zzv == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean isConnecting() {
        boolean z10;
        synchronized (this.zzp) {
            int i10 = this.zzv;
            z10 = true;
            if (i10 != 2) {
                if (i10 != 3) {
                    z10 = false;
                }
            }
        }
        return z10;
    }

    /* access modifiers changed from: protected */
    public void onConnectedLocked(@NonNull T t10) {
        this.zzh = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zzi = connectionResult.S();
        this.zzj = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onConnectionSuspended(int i10) {
        this.zzf = i10;
        this.zzg = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onPostInitHandler(int i10, IBinder iBinder, Bundle bundle, int i11) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(1, i11, -1, new g1(this, i10, iBinder, bundle)));
    }

    public void onUserSignOut(@NonNull e eVar) {
        eVar.a();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(@NonNull String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i10) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.zzd.get(), i10));
    }

    /* access modifiers changed from: protected */
    public void triggerNotAvailable(@NonNull c cVar, int i10, PendingIntent pendingIntent) {
        p.l(cVar, "Connection progress callbacks cannot be null.");
        this.zzc = cVar;
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(3, this.zzd.get(), i10, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    /* access modifiers changed from: protected */
    public final void zzl(int i10, Bundle bundle, int i11) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(7, i11, -1, new h1(this, i10, (Bundle) null)));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected d(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.NonNull android.os.Looper r11, int r12, com.google.android.gms.common.internal.d.a r13, com.google.android.gms.common.internal.d.b r14, java.lang.String r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.g r3 = com.google.android.gms.common.internal.g.b(r10)
            com.google.android.gms.common.d r4 = com.google.android.gms.common.d.h()
            com.google.android.gms.common.internal.p.k(r13)
            com.google.android.gms.common.internal.p.k(r14)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.d.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.d$a, com.google.android.gms.common.internal.d$b, java.lang.String):void");
    }

    public void disconnect(@NonNull String str) {
        this.zzk = str;
        disconnect();
    }

    protected d(@NonNull Context context, @NonNull Looper looper, @NonNull g gVar, @NonNull com.google.android.gms.common.d dVar, int i10, a aVar, b bVar, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        p.l(context, "Context must not be null");
        this.zzl = context;
        p.l(looper, "Looper must not be null");
        this.zzm = looper;
        p.l(gVar, "Supervisor must not be null");
        this.zzn = gVar;
        p.l(dVar, "API availability must not be null");
        this.zzo = dVar;
        this.zzb = new c1(this, looper);
        this.zzy = i10;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = str;
    }
}
