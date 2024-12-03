package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFc1vSDK;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;

public abstract class AFd1qSDK extends AFd1kSDK<String> {
    private final AFb1fSDK AFLogger;
    @NonNull
    private final Map<String, Object> AFLogger$LogLevel;
    private final PurchaseHandler.PurchaseValidationCallback AFVersionDeclaration;
    private final AFb1gSDK afErrorLogForExcManagerOnly;

    public AFd1qSDK(@NonNull AFd1wSDK aFd1wSDK, @NonNull AFd1wSDK[] aFd1wSDKArr, @NonNull AFc1xSDK aFc1xSDK, String str, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        super(aFd1wSDK, aFd1wSDKArr, aFc1xSDK, str);
        String str2;
        String str3;
        AFb1fSDK values = aFc1xSDK.values();
        this.AFLogger = values;
        AFb1gSDK afErrorLog = aFc1xSDK.afErrorLog();
        this.afErrorLogForExcManagerOnly = afErrorLog;
        HashMap hashMap = new HashMap(new HashMap(map));
        hashMap.put("app_id", values.valueOf.values.getPackageName());
        String AFInAppEventParameterName = AFb1fSDK.AFInAppEventParameterName();
        if (AFInAppEventParameterName != null) {
            hashMap.put("cuid", AFInAppEventParameterName);
        }
        Context context = values.valueOf.values;
        hashMap.put("app_version_name", AFa1dSDK.values(context, context.getPackageName()));
        HashMap hashMap2 = new HashMap();
        AFc1vSDK.AFa1wSDK AFKeystoreWrapper = AFa1bSDK.AFKeystoreWrapper(values.valueOf.values, new HashMap());
        String str4 = null;
        if (AFKeystoreWrapper != null) {
            str2 = AFKeystoreWrapper.AFInAppEventType;
        } else {
            str2 = null;
        }
        if (!AFb1nSDK.AFInAppEventParameterName(str2)) {
            hashMap2.put("advertising_id", str2);
        }
        AFc1vSDK.AFa1wSDK values2 = AFa1bSDK.values(values.valueOf.values.getContentResolver());
        if (values2 != null) {
            str3 = values2.AFInAppEventType;
        } else {
            str3 = null;
        }
        if (!AFb1nSDK.AFInAppEventParameterName(str3)) {
            hashMap2.put("oaid", str3);
        }
        AFc1vSDK.AFa1wSDK values3 = AFa1bSDK.values(values.valueOf.values.getContentResolver());
        str4 = values3 != null ? values3.AFInAppEventType : str4;
        if (!AFb1nSDK.AFInAppEventParameterName(str4)) {
            hashMap2.put("amazon_aid", str4);
        }
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            String AFInAppEventType = this.afRDLog.AFInAppEventType(afErrorLog);
            if (!AFb1nSDK.AFInAppEventParameterName(AFInAppEventType)) {
                hashMap2.put("imei", AFInAppEventType);
            }
        }
        hashMap2.put(ProfileConstants.Field.APPSFLYER_ID, AFb1xSDK.AFInAppEventParameterName(new WeakReference(values.valueOf.values)));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Build.VERSION.SDK_INT);
        hashMap2.put(SoftwareInfoForm.OS_VERSION, sb2.toString());
        hashMap2.put("sdk_version", AFb1zSDK.AFKeystoreWrapper);
        hashMap.put("device_data", hashMap2);
        this.AFLogger$LogLevel = hashMap;
        this.AFVersionDeclaration = purchaseValidationCallback;
    }

    public final void AFKeystoreWrapper() {
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback;
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback2;
        super.AFKeystoreWrapper();
        Throwable afDebugLog = afDebugLog();
        if (!(afDebugLog == null || (purchaseValidationCallback2 = this.AFVersionDeclaration) == null)) {
            purchaseValidationCallback2.onFailure(afDebugLog);
        }
        AFc1dSDK<Result> aFc1dSDK = this.afDebugLog;
        if (aFc1dSDK != null && (purchaseValidationCallback = this.AFVersionDeclaration) != null) {
            purchaseValidationCallback.onResponse(aFc1dSDK);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean AFLogger() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener afErrorLog() {
        return null;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final Map<String, Object> afErrorLogForExcManagerOnly() {
        return this.AFLogger$LogLevel;
    }
}
