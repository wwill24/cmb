package com.appsflyer;

import androidx.annotation.NonNull;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.share.LinkGenerator;
import java.util.Map;
import org.json.JSONException;
import org.json.b;

public class AppsFlyer2dXConversionCallback implements AppsFlyerConversionListener, DeepLinkListener, LinkGenerator.ResponseListener {
    private void AFInAppEventType(String str, String str2) {
        try {
            b bVar = new b();
            bVar.put("status", (Object) "failure");
            bVar.put("data", (Object) str2);
            char c10 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1390007222) {
                if (hashCode == 1050716216) {
                    if (str.equals("onInstallConversionFailure")) {
                        c10 = 0;
                    }
                }
            } else if (str.equals("onAttributionFailure")) {
                c10 = 1;
            }
            if (c10 == 0) {
                onInstallConversionFailureNative(bVar);
            } else if (c10 == 1) {
                onAttributionFailureNative(bVar);
            }
        } catch (JSONException e10) {
            AFLogger.afErrorLogForExcManagerOnly("2dx error", e10);
            e10.printStackTrace();
        }
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        onAppOpenAttributionNative(map);
    }

    public native void onAppOpenAttributionNative(Object obj);

    public void onAttributionFailure(String str) {
        AFInAppEventType("onInstallConversionFailure", str);
    }

    public native void onAttributionFailureNative(Object obj);

    public void onConversionDataFail(String str) {
        AFInAppEventType("onAttributionFailure", str);
    }

    public void onConversionDataSuccess(Map<String, Object> map) {
        onInstallConversionDataLoadedNative(map);
    }

    public void onDeepLinking(@NonNull DeepLinkResult deepLinkResult) {
        onDeepLinkingNative(deepLinkResult);
    }

    public native void onDeepLinkingNative(@NonNull DeepLinkResult deepLinkResult);

    public native void onInstallConversionDataLoadedNative(Object obj);

    public native void onInstallConversionFailureNative(Object obj);

    public void onResponse(String str) {
        onResponseNative(str);
    }

    public void onResponseError(String str) {
        onResponseErrorNative(str);
    }

    public native void onResponseErrorNative(String str);

    public native void onResponseNative(String str);
}
