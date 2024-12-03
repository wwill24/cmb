package com.facebook.devicerequests.internal;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"com/facebook/devicerequests/internal/DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1", "Landroid/net/nsd/NsdManager$RegistrationListener;", "onRegistrationFailed", "", "serviceInfo", "Landroid/net/nsd/NsdServiceInfo;", "errorCode", "", "onServiceRegistered", "NsdServiceInfo", "onServiceUnregistered", "onUnregistrationFailed", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1 implements NsdManager.RegistrationListener {
    final /* synthetic */ String $nsdServiceName;
    final /* synthetic */ String $userCode;

    DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1(String str, String str2) {
        this.$nsdServiceName = str;
        this.$userCode = str2;
    }

    public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i10) {
        j.g(nsdServiceInfo, "serviceInfo");
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        DeviceRequestsHelper.cleanUpAdvertisementService(this.$userCode);
    }

    public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
        j.g(nsdServiceInfo, "NsdServiceInfo");
        if (!j.b(this.$nsdServiceName, nsdServiceInfo.getServiceName())) {
            DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
            DeviceRequestsHelper.cleanUpAdvertisementService(this.$userCode);
        }
    }

    public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
        j.g(nsdServiceInfo, "serviceInfo");
    }

    public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i10) {
        j.g(nsdServiceInfo, "serviceInfo");
    }
}
