package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.io.IOException;

public abstract class AFd1kSDK<Result> extends AFd1tSDK<AFc1dSDK<Result>> {
    private AFa1lSDK AFLogger;
    public AFc1dSDK<Result> afDebugLog;
    protected final AFc1pSDK afErrorLog;
    private String afErrorLogForExcManagerOnly;
    protected final AFb1uSDK afInfoLog;
    public final AFe1xSDK afRDLog;

    private AFd1kSDK(@NonNull AFd1wSDK aFd1wSDK, @NonNull AFd1wSDK[] aFd1wSDKArr, @NonNull AFc1pSDK aFc1pSDK, @NonNull AFe1xSDK aFe1xSDK, @NonNull AFb1uSDK aFb1uSDK, @NonNull AFa1lSDK aFa1lSDK, String str) {
        super(aFd1wSDK, aFd1wSDKArr, str);
        this.afErrorLog = aFc1pSDK;
        this.afRDLog = aFe1xSDK;
        this.afInfoLog = aFb1uSDK;
        this.AFLogger = aFa1lSDK;
    }

    @NonNull
    public AFc1aSDK AFInAppEventParameterName() throws Exception {
        if (!getLevel() || !this.afRDLog.AFKeystoreWrapper()) {
            String str = this.afRDLog.AFInAppEventType;
            if (str == null || str.trim().isEmpty()) {
                AppsFlyerRequestListener afErrorLog2 = afErrorLog();
                if (afErrorLog2 != null) {
                    afErrorLog2.onError(RequestError.NO_DEV_KEY, AFb1dSDK.AFKeystoreWrapper);
                }
                throw new AFd1uSDK();
            }
            AFc1oSDK AFInAppEventParameterName = AFInAppEventParameterName(str);
            if (AFLogger()) {
                values(AFInAppEventParameterName.AFKeystoreWrapper);
            }
            AFc1dSDK<Result> values = AFInAppEventParameterName.values();
            this.afDebugLog = values;
            this.afInfoLog.AFInAppEventType(AFInAppEventParameterName.AFKeystoreWrapper.values(), values.getStatusCode(), values.getBody().toString());
            AppsFlyerRequestListener afErrorLog3 = afErrorLog();
            if (afErrorLog3 != null) {
                if (values.isSuccessful()) {
                    afErrorLog3.onSuccess();
                } else {
                    int i10 = RequestError.RESPONSE_CODE_FAILURE;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(AFb1dSDK.values);
                    sb2.append(" ");
                    sb2.append(values.getStatusCode());
                    afErrorLog3.onError(i10, sb2.toString());
                }
            }
            if (values.isSuccessful()) {
                return AFc1aSDK.SUCCESS;
            }
            return AFc1aSDK.FAILURE;
        }
        AppsFlyerRequestListener afErrorLog4 = afErrorLog();
        if (afErrorLog4 != null) {
            afErrorLog4.onError(RequestError.STOP_TRACKING, AFb1dSDK.AFInAppEventParameterName);
        }
        throw new AFd1pSDK();
    }

    /* access modifiers changed from: protected */
    public abstract AFc1oSDK<Result> AFInAppEventParameterName(@NonNull String str);

    public long AFInAppEventType() {
        return DateUtils.MILLIS_IN_MINUTE;
    }

    public final void AFInAppEventType(Throwable th2) {
        AFLogger.afErrorLog("Error while sending request to server: ".concat(String.valueOf(th2)), th2, true);
        AppsFlyerRequestListener afErrorLog2 = afErrorLog();
        if (afErrorLog2 != null) {
            String message = th2.getMessage();
            int i10 = RequestError.NETWORK_FAILURE;
            if (message == null) {
                message = "";
            }
            afErrorLog2.onError(i10, message);
        }
    }

    public void AFKeystoreWrapper() {
        String str;
        if (this.AFInAppEventType == AFc1aSDK.SUCCESS) {
            String str2 = this.afErrorLogForExcManagerOnly;
            if (str2 != null) {
                this.AFLogger.AFInAppEventType(str2);
            }
        } else if (!valueOf() && (str = this.afErrorLogForExcManagerOnly) != null) {
            this.AFLogger.AFInAppEventType(str);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean AFLogger();

    /* access modifiers changed from: protected */
    public abstract AppsFlyerRequestListener afErrorLog();

    /* access modifiers changed from: protected */
    public boolean getLevel() {
        return true;
    }

    public boolean valueOf() {
        if (afDebugLog() instanceof AFd1pSDK) {
            return false;
        }
        if (this.AFInAppEventType == AFc1aSDK.TIMEOUT) {
            return true;
        }
        Throwable afDebugLog2 = afDebugLog();
        if (!(afDebugLog2 instanceof IOException) || (afDebugLog2 instanceof ParsingException)) {
            return false;
        }
        return true;
    }

    public final void values() {
        String str;
        super.values();
        if (AFLogger() && (str = this.afRDLog.AFInAppEventType) != null && !str.trim().isEmpty()) {
            values(AFInAppEventParameterName(str).AFKeystoreWrapper);
        }
    }

    public AFd1kSDK(@NonNull AFd1wSDK aFd1wSDK, @NonNull AFd1wSDK[] aFd1wSDKArr, @NonNull AFc1xSDK aFc1xSDK, String str) {
        this(aFd1wSDK, aFd1wSDKArr, aFc1xSDK.AFKeystoreWrapper(), aFc1xSDK.AFVersionDeclaration(), aFc1xSDK.AFLogger$LogLevel(), aFc1xSDK.afWarnLog(), str);
    }

    private void values(AFc1sSDK aFc1sSDK) {
        String str = this.afErrorLogForExcManagerOnly;
        this.afErrorLogForExcManagerOnly = this.AFLogger.values(new AFc1rSDK(aFc1sSDK.values(), aFc1sSDK.AFInAppEventType(), "6.10.0", this.AFKeystoreWrapper));
        if (str != null) {
            this.AFLogger.AFInAppEventType(str);
        }
    }

    public AFd1kSDK(@NonNull AFd1wSDK aFd1wSDK, @NonNull AFd1wSDK[] aFd1wSDKArr, @NonNull AFc1xSDK aFc1xSDK, String str, String str2) {
        this(aFd1wSDK, aFd1wSDKArr, aFc1xSDK.AFKeystoreWrapper(), aFc1xSDK.AFVersionDeclaration(), aFc1xSDK.AFLogger$LogLevel(), aFc1xSDK.afWarnLog(), str);
        this.afErrorLogForExcManagerOnly = str2;
    }
}
