package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Map;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.json.JSONException;
import org.json.b;

public final class AFb1oSDK {
    private final boolean AFInAppEventParameterName;
    @NonNull
    public final String AFInAppEventType;
    @NonNull
    public final String AFKeystoreWrapper;
    public final AFb1nSDK valueOf;
    @NonNull
    public final AFf1wSDK values;

    public AFb1oSDK() {
    }

    public AFb1oSDK(String str) throws JSONException {
        AFf1wSDK aFf1wSDK;
        if (str != null) {
            try {
                b bVar = new b(str);
                String string = bVar.getString(RosterVer.ELEMENT);
                this.AFInAppEventType = string;
                this.AFInAppEventParameterName = bVar.optBoolean("test_mode");
                this.AFKeystoreWrapper = str;
                if (string.startsWith("default")) {
                    aFf1wSDK = AFf1wSDK.DEFAULT;
                } else {
                    aFf1wSDK = AFf1wSDK.CUSTOM;
                }
                this.values = aFf1wSDK;
                AFb1nSDK aFb1nSDK = null;
                b optJSONObject = bVar.optJSONObject("features");
                this.valueOf = optJSONObject != null ? new AFb1nSDK(optJSONObject) : aFb1nSDK;
            } catch (JSONException e10) {
                AFLogger.afErrorLogForExcManagerOnly("Error in RC config parsing", e10);
                throw new JSONException("Failed to parse remote configuration JSON");
            }
        } else {
            throw new JSONException("Failed to parse remote configuration JSON: originalJson is null");
        }
    }

    public static void AFInAppEventParameterName(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (AFa1qSDK.AFInAppEventParameterName().AFInAppEventType != null) {
            try {
                DeepLink AFInAppEventType2 = DeepLink.AFInAppEventType(map);
                AFInAppEventType2.AFInAppEventType.put("is_deferred", false);
                deepLinkResult = new DeepLinkResult(AFInAppEventType2, (DeepLinkResult.Error) null);
            } catch (JSONException e10) {
                AFLogger.afErrorLog("[DDL] Error occurred", e10, true);
                deepLinkResult = new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.UNEXPECTED);
            } catch (Throwable th2) {
                AFInAppEventParameterName(new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null));
                throw th2;
            }
            AFInAppEventParameterName(deepLinkResult);
            return;
        }
        AFKeystoreWrapper(map);
    }

    public static void AFInAppEventType(String str, DeepLinkResult.Error error) {
        if (AFa1qSDK.AFInAppEventParameterName().AFInAppEventType != null) {
            AFLogger.afDebugLog("[DDL] Error occurred: ".concat(String.valueOf(str)));
            AFInAppEventParameterName(new DeepLinkResult((DeepLink) null, error));
            return;
        }
        AFInAppEventParameterName(str);
    }

    private static void AFKeystoreWrapper(Map<String, String> map) {
        if (AFb1zSDK.valueOf != null) {
            try {
                StringBuilder sb2 = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb2.append(map.toString());
                AFLogger.afDebugLog(sb2.toString());
                AFb1zSDK.valueOf.onAppOpenAttribution(map);
            } catch (Throwable th2) {
                AFLogger.afErrorLog(th2.getLocalizedMessage(), th2);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AFb1oSDK.class != obj.getClass()) {
            return false;
        }
        AFb1oSDK aFb1oSDK = (AFb1oSDK) obj;
        if (this.AFInAppEventParameterName == aFb1oSDK.AFInAppEventParameterName && this.AFInAppEventType.equals(aFb1oSDK.AFInAppEventType)) {
            return this.AFKeystoreWrapper.equals(aFb1oSDK.AFKeystoreWrapper);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((((this.AFInAppEventParameterName ? 1 : 0) * true) + this.AFInAppEventType.hashCode()) * 31) + this.AFKeystoreWrapper.hashCode();
        AFb1nSDK aFb1nSDK = this.valueOf;
        if (aFb1nSDK != null) {
            return (hashCode * 31) + aFb1nSDK.hashCode();
        }
        return hashCode;
    }

    static void AFInAppEventParameterName(DeepLinkResult deepLinkResult) {
        if (AFa1qSDK.AFInAppEventParameterName().AFInAppEventType != null) {
            StringBuilder sb2 = new StringBuilder("[DDL] Calling onDeepLinking with:\n");
            sb2.append(deepLinkResult.toString());
            AFLogger.afDebugLog(sb2.toString());
            try {
                AFa1qSDK.AFInAppEventParameterName().AFInAppEventType.onDeepLinking(deepLinkResult);
            } catch (Throwable th2) {
                AFLogger.afErrorLog(th2.getLocalizedMessage(), th2);
            }
        } else {
            AFLogger.afDebugLog("[DDL] skipping, no callback registered");
        }
    }

    private static void AFInAppEventParameterName(String str) {
        if (AFb1zSDK.valueOf != null) {
            try {
                AFLogger.afDebugLog("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                AFb1zSDK.valueOf.onAttributionFailure(str);
            } catch (Throwable th2) {
                AFLogger.afErrorLog(th2.getLocalizedMessage(), th2);
            }
        }
    }
}
