package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;

public final class AFd1sSDK extends AFd1kSDK<String> {
    @NonNull
    private final String AFLogger;
    private final AFe1tSDK afErrorLogForExcManagerOnly;

    public AFd1sSDK(@NonNull AFc1xSDK aFc1xSDK, @NonNull String str, AFe1tSDK aFe1tSDK) {
        super(AFd1wSDK.IMPRESSIONS, new AFd1wSDK[]{AFd1wSDK.RC_CDN}, aFc1xSDK, str);
        this.AFLogger = str;
        this.afErrorLogForExcManagerOnly = aFe1tSDK;
    }

    /* access modifiers changed from: protected */
    public final AFc1oSDK<String> AFInAppEventParameterName(@NonNull String str) {
        return this.afErrorLog.AFInAppEventType(this.AFLogger);
    }

    public final void AFKeystoreWrapper() {
        super.AFKeystoreWrapper();
        AFc1dSDK<Result> aFc1dSDK = this.afDebugLog;
        if (aFc1dSDK != null) {
            int statusCode = aFc1dSDK.getStatusCode();
            if (statusCode == 200) {
                StringBuilder sb2 = new StringBuilder("Cross promotion impressions success: ");
                sb2.append(this.AFLogger);
                AFLogger.afInfoLog(sb2.toString(), false);
            } else if (statusCode == 301 || statusCode == 302) {
                StringBuilder sb3 = new StringBuilder("Cross promotion redirection success: ");
                sb3.append(this.AFLogger);
                AFLogger.afInfoLog(sb3.toString(), false);
                String AFInAppEventType = aFc1dSDK.AFInAppEventType("Location");
                AFe1tSDK aFe1tSDK = this.afErrorLogForExcManagerOnly;
                if (aFe1tSDK != null && AFInAppEventType != null) {
                    aFe1tSDK.AFInAppEventParameterName = AFInAppEventType;
                    Context context = aFe1tSDK.AFInAppEventType.get();
                    if (context != null) {
                        try {
                            if (aFe1tSDK.AFInAppEventParameterName != null) {
                                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(aFe1tSDK.AFInAppEventParameterName)).setFlags(268435456));
                            }
                        } catch (Exception e10) {
                            AFLogger.afErrorLog("Failed to open cross promotion url, does OS have browser installed?".concat(String.valueOf(e10)), e10);
                        }
                    }
                }
            } else {
                StringBuilder sb4 = new StringBuilder("call to ");
                sb4.append(this.AFLogger);
                sb4.append(" failed: ");
                sb4.append(statusCode);
                AFLogger.afInfoLog(sb4.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean AFLogger() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener afErrorLog() {
        return null;
    }
}
