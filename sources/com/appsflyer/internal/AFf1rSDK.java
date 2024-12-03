package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFf1uSDK;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.util.Observable;
import java.util.Observer;

public final class AFf1rSDK extends AFf1uSDK {
    private final AFc1xSDK AFInAppEventParameterName;
    final ProviderInfo valueOf;

    public AFf1rSDK(ProviderInfo providerInfo, Runnable runnable, AFc1xSDK aFc1xSDK) {
        super("af_referrer", providerInfo.authority, runnable);
        this.AFInAppEventParameterName = aFc1xSDK;
        this.valueOf = providerInfo;
    }

    public final void AFInAppEventType(final Context context) {
        this.AFInAppEventParameterName.AFInAppEventParameterName().execute(new Runnable() {
            public final void run() {
                AFf1rSDK aFf1rSDK = AFf1rSDK.this;
                aFf1rSDK.afRDLog = System.currentTimeMillis();
                aFf1rSDK.afDebugLog = AFf1uSDK.AFa1ySDK.STARTED;
                aFf1rSDK.addObserver(new Observer() {
                    public final void update(Observable observable, Object obj) {
                        AFf1uSDK.this.AFInAppEventType.run();
                    }
                });
                StringBuilder sb2 = new StringBuilder("content://");
                sb2.append(AFf1rSDK.this.valueOf.authority);
                sb2.append("/transaction_id");
                Uri parse = Uri.parse(sb2.toString());
                ContentResolver contentResolver = context.getContentResolver();
                StringBuilder sb3 = new StringBuilder("app_id=");
                sb3.append(context.getPackageName());
                Cursor query = contentResolver.query(parse, (String[]) null, sb3.toString(), (String[]) null, (String) null);
                if (query != null) {
                    int columnIndex = query.getColumnIndex(FirebaseAnalytics.Param.TRANSACTION_ID);
                    if (columnIndex == -1) {
                        AFLogger.afWarnLog("[Preinstall]: Wrong column name");
                        AFf1rSDK.this.values.put("response", "FEATURE_NOT_SUPPORTED");
                    } else {
                        AFf1rSDK.this.values.put("response", MessageTemplateConstants.Values.OK_TEXT);
                        if (query.moveToFirst()) {
                            String string = query.getString(columnIndex);
                            query.close();
                            if (string != null && !string.isEmpty()) {
                                AFf1rSDK.this.values.put("referrer", string);
                            }
                        }
                    }
                } else {
                    AFLogger.afWarnLog("[Preinstall]: ContentProvider query failed, got null Cursor");
                    AFf1rSDK.this.values.put("response", "SERVICE_UNAVAILABLE");
                }
                AFf1rSDK aFf1rSDK2 = AFf1rSDK.this;
                aFf1rSDK2.values.put("api_ver", Long.valueOf(AFa1dSDK.AFKeystoreWrapper(context, aFf1rSDK2.valueOf.packageName)));
                AFf1rSDK aFf1rSDK3 = AFf1rSDK.this;
                aFf1rSDK3.values.put("api_ver_name", AFa1dSDK.values(context, aFf1rSDK3.valueOf.packageName));
                AFf1rSDK.this.valueOf();
            }
        });
    }
}
