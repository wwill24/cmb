package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.AccessToken;
import com.facebook.internal.InstallReferrerUtil;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, d2 = {"com/facebook/internal/InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "onInstallReferrerServiceDisconnected", "", "onInstallReferrerSetupFinished", "responseCode", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1 implements InstallReferrerStateListener {
    final /* synthetic */ InstallReferrerUtil.Callback $callback;
    final /* synthetic */ InstallReferrerClient $referrerClient;

    InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1(InstallReferrerClient installReferrerClient, InstallReferrerUtil.Callback callback) {
        this.$referrerClient = installReferrerClient;
        this.$callback = callback;
    }

    public void onInstallReferrerServiceDisconnected() {
    }

    public void onInstallReferrerSetupFinished(int i10) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (i10 == 0) {
                try {
                    ReferrerDetails installReferrer = this.$referrerClient.getInstallReferrer();
                    j.f(installReferrer, "{\n                      referrerClient.installReferrer\n                    }");
                    String installReferrer2 = installReferrer.getInstallReferrer();
                    if (installReferrer2 != null && (StringsKt__StringsKt.O(installReferrer2, "fb", false, 2, (Object) null) || StringsKt__StringsKt.O(installReferrer2, AccessToken.DEFAULT_GRAPH_DOMAIN, false, 2, (Object) null))) {
                        this.$callback.onReceiveReferrerUrl(installReferrer2);
                    }
                    InstallReferrerUtil.INSTANCE.updateReferrer();
                } catch (RemoteException unused) {
                    return;
                }
            } else if (i10 == 2) {
                try {
                    InstallReferrerUtil.INSTANCE.updateReferrer();
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                    return;
                }
            }
            try {
                this.$referrerClient.endConnection();
            } catch (Exception unused2) {
            }
        }
    }
}
