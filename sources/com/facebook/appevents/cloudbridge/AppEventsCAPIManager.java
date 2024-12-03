package com.facebook.appevents.cloudbridge;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR@\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8A@@X\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsCAPIManager;", "", "()V", "SETTINGS_PATH", "", "TAG", "kotlin.jvm.PlatformType", "isEnabled", "", "isEnabled$facebook_core_release", "()Z", "setEnabled$facebook_core_release", "(Z)V", "valuesToSave", "", "savedCloudBridgeCredentials", "getSavedCloudBridgeCredentials$facebook_core_release", "()Ljava/util/Map;", "setSavedCloudBridgeCredentials$facebook_core_release", "(Ljava/util/Map;)V", "enable", "", "getCAPIGSettingsFromGraphResponse", "response", "Lcom/facebook/GraphResponse;", "getCAPIGSettingsFromGraphResponse$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventsCAPIManager {
    public static final AppEventsCAPIManager INSTANCE = new AppEventsCAPIManager();
    private static final String SETTINGS_PATH = "/cloudbridge_settings";
    private static final String TAG = AppEventsCAPIManager.class.getCanonicalName();
    private static boolean isEnabled;

    private AppEventsCAPIManager() {
    }

    public static final void enable() {
        try {
            GraphRequest graphRequest = new GraphRequest((AccessToken) null, j.p(FacebookSdk.getApplicationId(), SETTINGS_PATH), (Bundle) null, HttpMethod.GET, new a(), (String) null, 32, (DefaultConstructorMarker) null);
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str != null) {
                companion.log(loggingBehavior, str, " \n\nCreating Graph Request: \n=============\n%s\n\n ", graphRequest);
                graphRequest.executeAsync();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (JSONException e10) {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
            String str2 = TAG;
            if (str2 != null) {
                companion2.log(loggingBehavior2, str2, " \n\nGraph Request Exception: \n=============\n%s\n\n ", b.b(e10));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m56enable$lambda0(GraphResponse graphResponse) {
        j.g(graphResponse, "response");
        INSTANCE.getCAPIGSettingsFromGraphResponse$facebook_core_release(graphResponse);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045 A[Catch:{ all -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053 A[Catch:{ all -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061 A[Catch:{ all -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0062 A[Catch:{ all -> 0x0097 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.lang.Object> getSavedCloudBridgeCredentials$facebook_core_release() {
        /*
            java.lang.Class<com.facebook.appevents.cloudbridge.AppEventsCAPIManager> r0 = com.facebook.appevents.cloudbridge.AppEventsCAPIManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = "com.facebook.sdk.CloudBridgeSavedCredentials"
            r4 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r3, r4)     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x0018
            return r2
        L_0x0018:
            com.facebook.appevents.cloudbridge.SettingsAPIFields r3 = com.facebook.appevents.cloudbridge.SettingsAPIFields.DATASETID     // Catch:{ all -> 0x0097 }
            java.lang.String r5 = r3.getRawValue()     // Catch:{ all -> 0x0097 }
            java.lang.String r5 = r1.getString(r5, r2)     // Catch:{ all -> 0x0097 }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r6 = com.facebook.appevents.cloudbridge.SettingsAPIFields.URL     // Catch:{ all -> 0x0097 }
            java.lang.String r7 = r6.getRawValue()     // Catch:{ all -> 0x0097 }
            java.lang.String r7 = r1.getString(r7, r2)     // Catch:{ all -> 0x0097 }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r8 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ACCESSKEY     // Catch:{ all -> 0x0097 }
            java.lang.String r9 = r8.getRawValue()     // Catch:{ all -> 0x0097 }
            java.lang.String r1 = r1.getString(r9, r2)     // Catch:{ all -> 0x0097 }
            r9 = 1
            if (r5 == 0) goto L_0x0042
            boolean r10 = kotlin.text.r.w(r5)     // Catch:{ all -> 0x0097 }
            if (r10 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r10 = r4
            goto L_0x0043
        L_0x0042:
            r10 = r9
        L_0x0043:
            if (r10 != 0) goto L_0x0096
            if (r7 == 0) goto L_0x0050
            boolean r10 = kotlin.text.r.w(r7)     // Catch:{ all -> 0x0097 }
            if (r10 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r10 = r4
            goto L_0x0051
        L_0x0050:
            r10 = r9
        L_0x0051:
            if (r10 != 0) goto L_0x0096
            if (r1 == 0) goto L_0x005e
            boolean r10 = kotlin.text.r.w(r1)     // Catch:{ all -> 0x0097 }
            if (r10 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r10 = r4
            goto L_0x005f
        L_0x005e:
            r10 = r9
        L_0x005f:
            if (r10 == 0) goto L_0x0062
            goto L_0x0096
        L_0x0062:
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0097 }
            r10.<init>()     // Catch:{ all -> 0x0097 }
            java.lang.String r6 = r6.getRawValue()     // Catch:{ all -> 0x0097 }
            r10.put(r6, r7)     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = r3.getRawValue()     // Catch:{ all -> 0x0097 }
            r10.put(r3, r5)     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = r8.getRawValue()     // Catch:{ all -> 0x0097 }
            r10.put(r3, r1)     // Catch:{ all -> 0x0097 }
            com.facebook.internal.Logger$Companion r3 = com.facebook.internal.Logger.Companion     // Catch:{ all -> 0x0097 }
            com.facebook.LoggingBehavior r6 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ all -> 0x0097 }
            java.lang.String r8 = TAG     // Catch:{ all -> 0x0097 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0097 }
            java.lang.String r11 = " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n "
            r12 = 3
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ all -> 0x0097 }
            r12[r4] = r5     // Catch:{ all -> 0x0097 }
            r12[r9] = r7     // Catch:{ all -> 0x0097 }
            r4 = 2
            r12[r4] = r1     // Catch:{ all -> 0x0097 }
            r3.log((com.facebook.LoggingBehavior) r6, (java.lang.String) r8, (java.lang.String) r11, (java.lang.Object[]) r12)     // Catch:{ all -> 0x0097 }
            return r10
        L_0x0096:
            return r2
        L_0x0097:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsCAPIManager.getSavedCloudBridgeCredentials$facebook_core_release():java.util.Map");
    }

    public final void getCAPIGSettingsFromGraphResponse$facebook_core_release(GraphResponse graphResponse) {
        Object obj;
        j.g(graphResponse, "response");
        boolean z10 = false;
        if (graphResponse.getError() != null) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str != null) {
                companion.log(loggingBehavior, str, " \n\nGraph Response Error: \n================\nResponse Error: %s\nResponse Error Exception: %s\n\n ", graphResponse.getError().toString(), String.valueOf(graphResponse.getError().getException()));
                Map<String, Object> savedCloudBridgeCredentials$facebook_core_release = getSavedCloudBridgeCredentials$facebook_core_release();
                if (savedCloudBridgeCredentials$facebook_core_release != null) {
                    URL url = new URL(String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.URL.getRawValue())));
                    AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                    String valueOf = String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.DATASETID.getRawValue()));
                    AppEventsConversionsAPITransformerWebRequests.configure(valueOf, url.getProtocol() + "://" + url.getHost(), String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.ACCESSKEY.getRawValue())));
                    isEnabled = true;
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Logger.Companion companion2 = Logger.Companion;
        LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
        String str2 = TAG;
        if (str2 != null) {
            companion2.log(loggingBehavior2, str2, " \n\nGraph Response Received: \n================\n%s\n\n ", graphResponse);
            b jSONObject = graphResponse.getJSONObject();
            try {
                Utility utility = Utility.INSTANCE;
                if (jSONObject == null) {
                    obj = null;
                } else {
                    obj = jSONObject.get("data");
                }
                if (obj != null) {
                    Map<String, Object> convertJSONObjectToHashMap = Utility.convertJSONObjectToHashMap(new b((String) CollectionsKt___CollectionsKt.P(Utility.convertJSONArrayToList((a) obj))));
                    String str3 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.URL.getRawValue());
                    String str4 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.DATASETID.getRawValue());
                    String str5 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.ACCESSKEY.getRawValue());
                    if (str3 == null || str4 == null || str5 == null) {
                        j.f(str2, "TAG");
                        companion2.log(loggingBehavior2, str2, "CloudBridge Settings API response doesn't have valid data");
                        return;
                    }
                    try {
                        AppEventsConversionsAPITransformerWebRequests.configure(str4, str3, str5);
                        setSavedCloudBridgeCredentials$facebook_core_release(convertJSONObjectToHashMap);
                        SettingsAPIFields settingsAPIFields = SettingsAPIFields.ENABLED;
                        if (convertJSONObjectToHashMap.get(settingsAPIFields.getRawValue()) != null) {
                            Object obj2 = convertJSONObjectToHashMap.get(settingsAPIFields.getRawValue());
                            if (obj2 != null) {
                                z10 = ((Boolean) obj2).booleanValue();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                        }
                        isEnabled = z10;
                    } catch (MalformedURLException e10) {
                        Logger.Companion companion3 = Logger.Companion;
                        LoggingBehavior loggingBehavior3 = LoggingBehavior.APP_EVENTS;
                        String str6 = TAG;
                        j.f(str6, "TAG");
                        companion3.log(loggingBehavior3, str6, "CloudBridge Settings API response doesn't have valid url\n %s ", b.b(e10));
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
            } catch (JSONException e11) {
                Logger.Companion companion4 = Logger.Companion;
                LoggingBehavior loggingBehavior4 = LoggingBehavior.APP_EVENTS;
                String str7 = TAG;
                j.f(str7, "TAG");
                companion4.log(loggingBehavior4, str7, "CloudBridge Settings API response is not a valid json: \n%s ", b.b(e11));
            } catch (NullPointerException e12) {
                Logger.Companion companion5 = Logger.Companion;
                LoggingBehavior loggingBehavior5 = LoggingBehavior.APP_EVENTS;
                String str8 = TAG;
                j.f(str8, "TAG");
                companion5.log(loggingBehavior5, str8, "CloudBridge Settings API response is not a valid json: \n%s ", b.b(e12));
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public final boolean isEnabled$facebook_core_release() {
        return isEnabled;
    }

    public final void setEnabled$facebook_core_release(boolean z10) {
        isEnabled = z10;
    }

    public final void setSavedCloudBridgeCredentials$facebook_core_release(Map<String, ? extends Object> map) {
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.CLOUDBRIDGE_SAVED_CREDENTIALS, 0);
        if (sharedPreferences != null) {
            if (map == null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.apply();
                return;
            }
            SettingsAPIFields settingsAPIFields = SettingsAPIFields.DATASETID;
            Object obj = map.get(settingsAPIFields.getRawValue());
            SettingsAPIFields settingsAPIFields2 = SettingsAPIFields.URL;
            Object obj2 = map.get(settingsAPIFields2.getRawValue());
            SettingsAPIFields settingsAPIFields3 = SettingsAPIFields.ACCESSKEY;
            Object obj3 = map.get(settingsAPIFields3.getRawValue());
            if (obj != null && obj2 != null && obj3 != null) {
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString(settingsAPIFields.getRawValue(), obj.toString());
                edit2.putString(settingsAPIFields2.getRawValue(), obj2.toString());
                edit2.putString(settingsAPIFields3.getRawValue(), obj3.toString());
                edit2.apply();
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG.toString(), " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", obj, obj2, obj3);
            }
        }
    }
}
