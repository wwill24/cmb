package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.appsflyer.AFLogger;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AFb1lSDK<T> {
    public final String AFInAppEventParameterName;
    public final Context AFInAppEventType;
    private final String[] AFKeystoreWrapper;
    public final FutureTask<T> valueOf = new FutureTask<>(new Callable<T>() {
        public final T call() {
            if (AFb1lSDK.this.values()) {
                return AFb1lSDK.this.AFKeystoreWrapper();
            }
            return null;
        }
    });
    public final AFc1xSDK values;

    public AFb1lSDK(Context context, AFc1xSDK aFc1xSDK, String str, String... strArr) {
        this.AFInAppEventType = context;
        this.AFInAppEventParameterName = str;
        this.AFKeystoreWrapper = strArr;
        this.values = aFc1xSDK;
    }

    /* access modifiers changed from: protected */
    public abstract T AFKeystoreWrapper();

    public T valueOf() {
        try {
            return this.valueOf.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            AFLogger.afErrorLog(e10.getMessage(), e10);
            return null;
        }
    }

    public final boolean values() {
        try {
            ProviderInfo resolveContentProvider = this.AFInAppEventType.getPackageManager().resolveContentProvider(this.AFInAppEventParameterName, 128);
            if (resolveContentProvider == null || !Arrays.asList(this.AFKeystoreWrapper).contains(AFa1dSDK.AFKeystoreWrapper(this.AFInAppEventType.getPackageManager(), resolveContentProvider.packageName))) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e10) {
            AFLogger.afErrorLog(e10.getMessage(), e10);
            return false;
        }
    }
}
