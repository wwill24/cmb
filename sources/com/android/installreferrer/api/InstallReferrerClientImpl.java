package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.installreferrer.commons.InstallReferrerCommons;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import qd.a;

class InstallReferrerClientImpl extends InstallReferrerClient {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f9055a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final Context f9056b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public qd.a f9057c;

    /* renamed from: d  reason: collision with root package name */
    private ServiceConnection f9058d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientState {
        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
    }

    private final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final InstallReferrerStateListener f9059a;

        private b(InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener != null) {
                this.f9059a = installReferrerStateListener;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service connected.");
            qd.a unused = InstallReferrerClientImpl.this.f9057c = a.C0504a.c(iBinder);
            int unused2 = InstallReferrerClientImpl.this.f9055a = 2;
            this.f9059a.onInstallReferrerSetupFinished(0);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Install Referrer service disconnected.");
            qd.a unused = InstallReferrerClientImpl.this.f9057c = null;
            int unused2 = InstallReferrerClientImpl.this.f9055a = 0;
            this.f9059a.onInstallReferrerServiceDisconnected();
        }
    }

    public InstallReferrerClientImpl(Context context) {
        this.f9056b = context.getApplicationContext();
    }

    private boolean c() {
        try {
            if (this.f9056b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public void endConnection() {
        this.f9055a = 3;
        if (this.f9058d != null) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Unbinding from service.");
            this.f9056b.unbindService(this.f9058d);
            this.f9058d = null;
        }
        this.f9057c = null;
    }

    public ReferrerDetails getInstallReferrer() throws RemoteException {
        if (isReady()) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f9056b.getPackageName());
            try {
                return new ReferrerDetails(this.f9057c.r(bundle));
            } catch (RemoteException e10) {
                InstallReferrerCommons.logWarn("InstallReferrerClient", "RemoteException getting install referrer information");
                this.f9055a = 0;
                throw e10;
            }
        } else {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
    }

    public boolean isReady() {
        return (this.f9055a != 2 || this.f9057c == null || this.f9058d == null) ? false : true;
    }

    public void startConnection(InstallReferrerStateListener installReferrerStateListener) {
        ServiceInfo serviceInfo;
        if (isReady()) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i10 = this.f9055a;
        if (i10 == 1) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
        } else if (i10 == 3) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
        } else {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Starting install referrer service setup.");
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            List<ResolveInfo> queryIntentServices = this.f9056b.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty() || (serviceInfo = queryIntentServices.get(0).serviceInfo) == null) {
                this.f9055a = 0;
                InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service unavailable on device.");
                installReferrerStateListener.onInstallReferrerSetupFinished(2);
                return;
            }
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (!"com.android.vending".equals(str) || str2 == null || !c()) {
                InstallReferrerCommons.logWarn("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
                this.f9055a = 0;
                installReferrerStateListener.onInstallReferrerSetupFinished(2);
                return;
            }
            Intent intent2 = new Intent(intent);
            b bVar = new b(installReferrerStateListener);
            this.f9058d = bVar;
            try {
                if (this.f9056b.bindService(intent2, bVar, 1)) {
                    InstallReferrerCommons.logVerbose("InstallReferrerClient", "Service was bonded successfully.");
                    return;
                }
                InstallReferrerCommons.logWarn("InstallReferrerClient", "Connection to service is blocked.");
                this.f9055a = 0;
                installReferrerStateListener.onInstallReferrerSetupFinished(1);
            } catch (SecurityException unused) {
                InstallReferrerCommons.logWarn("InstallReferrerClient", "No permission to connect to service.");
                this.f9055a = 0;
                installReferrerStateListener.onInstallReferrerSetupFinished(4);
            }
        }
    }
}
