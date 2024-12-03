package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFf1uSDK;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import com.miui.referrer.api.GetAppsReferrerClient;
import com.miui.referrer.api.GetAppsReferrerDetails;
import com.miui.referrer.api.GetAppsReferrerStateListener;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import org.jivesoftware.smackx.hints.element.StoreHint;

public final class AFf1oSDK extends AFf1zSDK {
    public AFf1oSDK(Runnable runnable) {
        super(StoreHint.ELEMENT, "xiaomi", runnable);
    }

    private static boolean AFKeystoreWrapper(@NonNull Context context) {
        if (!AFf1zSDK.valueOf(context)) {
            return false;
        }
        try {
            Class.forName("com.miui.referrer.api.GetAppsReferrerClient");
            AFLogger.afDebugLog("Xiaomi Install Referrer is allowed");
            return true;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder("Class ");
            sb2.append("com.miui.referrer.api.GetAppsReferrerClient");
            sb2.append(" not found");
            AFLogger.afRDLog(sb2.toString());
            return false;
        } catch (Throwable th2) {
            AFLogger.afErrorLog("An error occurred while trying to access GetAppsReferrerClient", th2);
            return false;
        }
    }

    public final void AFInAppEventType(final Context context) {
        if (AFKeystoreWrapper(context)) {
            this.afRDLog = System.currentTimeMillis();
            this.afDebugLog = AFf1uSDK.AFa1ySDK.STARTED;
            addObserver(new Observer() {
                public final void update(Observable observable, Object obj) {
                    AFf1uSDK.this.AFInAppEventType.run();
                }
            });
            final GetAppsReferrerClient build = GetAppsReferrerClient.Companion.newBuilder(context).build();
            build.startConnection(new GetAppsReferrerStateListener() {
                public final void onGetAppsReferrerSetupFinished(int i10) {
                    AFf1oSDK.this.values.put("api_ver", Long.valueOf(AFa1dSDK.AFKeystoreWrapper(context, "com.xiaomi.mipicks")));
                    AFf1oSDK.this.values.put("api_ver_name", AFa1dSDK.values(context, "com.xiaomi.mipicks"));
                    if (i10 == -1) {
                        AFLogger.afWarnLog("XiaomiInstallReferrer SERVICE_DISCONNECTED");
                        AFf1oSDK.this.values.put("response", "SERVICE_DISCONNECTED");
                    } else if (i10 == 0) {
                        AFf1oSDK aFf1oSDK = AFf1oSDK.this;
                        GetAppsReferrerClient getAppsReferrerClient = build;
                        aFf1oSDK.values.put("response", MessageTemplateConstants.Values.OK_TEXT);
                        try {
                            AFLogger.afDebugLog("XiaomiInstallReferrer connected");
                            if (getAppsReferrerClient.isReady()) {
                                GetAppsReferrerDetails installReferrer = getAppsReferrerClient.getInstallReferrer();
                                String installReferrer2 = installReferrer.getInstallReferrer();
                                if (installReferrer2 != null) {
                                    aFf1oSDK.values.put("referrer", installReferrer2);
                                }
                                aFf1oSDK.values.put("click_ts", Long.valueOf(installReferrer.getReferrerClickTimestampSeconds()));
                                aFf1oSDK.values.put("install_begin_ts", Long.valueOf(installReferrer.getInstallBeginTimestampSeconds()));
                                HashMap hashMap = new HashMap();
                                hashMap.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                                hashMap.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                                hashMap.put("install_version", installReferrer.getInstallVersion());
                                aFf1oSDK.values.put("xiaomi_custom", hashMap);
                            } else {
                                AFLogger.afWarnLog("XiaomiReferrerClient: XiaomiInstallReferrer is not ready");
                            }
                        } catch (Throwable th2) {
                            StringBuilder sb2 = new StringBuilder("Failed to get Xiaomi install referrer: ");
                            sb2.append(th2.getMessage());
                            AFLogger.afWarnLog(sb2.toString());
                        }
                    } else if (i10 == 1) {
                        AFf1oSDK.this.values.put("response", "SERVICE_UNAVAILABLE");
                        AFLogger.afWarnLog("XiaomiInstallReferrer not supported");
                    } else if (i10 == 2) {
                        AFLogger.afWarnLog("XiaomiInstallReferrer FEATURE_NOT_SUPPORTED");
                        AFf1oSDK.this.values.put("response", "FEATURE_NOT_SUPPORTED");
                    } else if (i10 == 3) {
                        AFLogger.afWarnLog("XiaomiInstallReferrer DEVELOPER_ERROR");
                        AFf1oSDK.this.values.put("response", "DEVELOPER_ERROR");
                    } else if (i10 != 4) {
                        AFLogger.afWarnLog("responseCode not found.");
                    } else {
                        AFLogger.afWarnLog("XiaomiInstallReferrer DEVELOPER_ERROR");
                        AFf1oSDK.this.values.put("response", "PERMISSION_ERROR");
                    }
                    AFLogger.afDebugLog("Xiaomi Install Referrer collected locally");
                    AFf1oSDK.this.valueOf();
                    build.endConnection();
                }

                public final void onGetAppsServiceDisconnected() {
                }
            });
        }
    }
}
