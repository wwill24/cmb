package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.share.LinkGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class AFd1oSDK extends AFd1kSDK<String> {
    private final AFb1fSDK AFLogger;
    private final String AFLogger$LogLevel;
    private final Map<String, String> AFVersionDeclaration;
    private final LinkGenerator.ResponseListener afErrorLogForExcManagerOnly;
    private final String afWarnLog;
    private final UUID getLevel;

    public AFd1oSDK(@NonNull AFc1xSDK aFc1xSDK, @NonNull UUID uuid, @NonNull String str, @NonNull Map<String, String> map, String str2, LinkGenerator.ResponseListener responseListener) {
        super(AFd1wSDK.ONELINK, new AFd1wSDK[]{AFd1wSDK.RC_CDN}, aFc1xSDK, uuid.toString());
        this.AFLogger = aFc1xSDK.values();
        this.getLevel = uuid;
        this.afWarnLog = str;
        this.AFVersionDeclaration = new HashMap(map);
        this.afErrorLogForExcManagerOnly = responseListener;
        this.AFLogger$LogLevel = str2;
    }

    private String afWarnLog() {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN);
        String packageName = this.AFLogger.valueOf.values.getPackageName();
        LinkGenerator addParameters = new LinkGenerator("af_app_invites").setBaseURL(this.afWarnLog, string, packageName).addParameter("af_siteid", packageName).addParameters(this.AFVersionDeclaration);
        AFb1zSDK.AFInAppEventType();
        String AFKeystoreWrapper = AFb1zSDK.AFKeystoreWrapper();
        if (AFKeystoreWrapper != null) {
            addParameters.setReferrerCustomerId(AFKeystoreWrapper);
        }
        return addParameters.generateLink();
    }

    /* access modifiers changed from: protected */
    public final AFc1oSDK<String> AFInAppEventParameterName(@NonNull String str) {
        return this.afErrorLog.values(this.afWarnLog, this.AFVersionDeclaration, this.AFLogger$LogLevel, this.getLevel, str);
    }

    public final long AFInAppEventType() {
        return 3000;
    }

    public final void AFKeystoreWrapper() {
        AFc1dSDK<Result> aFc1dSDK;
        super.AFKeystoreWrapper();
        LinkGenerator.ResponseListener responseListener = this.afErrorLogForExcManagerOnly;
        if (responseListener == null) {
            return;
        }
        if (this.AFInAppEventType != AFc1aSDK.SUCCESS || (aFc1dSDK = this.afDebugLog) == null) {
            Throwable afDebugLog = afDebugLog();
            if (!(afDebugLog instanceof ParsingException)) {
                responseListener.onResponse(afWarnLog());
            } else if (((ParsingException) afDebugLog).getRawResponse().isSuccessful()) {
                responseListener.onResponseError("Can't parse one link data");
            } else {
                responseListener.onResponse(afWarnLog());
            }
        } else {
            responseListener.onResponse((String) aFc1dSDK.getBody());
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

    /* access modifiers changed from: protected */
    public final boolean getLevel() {
        return false;
    }
}
