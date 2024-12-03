package com.leanplum.migration.wrapper;

import android.app.Application;
import android.content.Context;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.b;
import com.leanplum.callbacks.CleverTapInstanceCallback;
import com.leanplum.migration.MigrationConstants;
import com.leanplum.migration.push.FcmMigrationHandler;
import com.leanplum.migration.push.HmsMigrationHandler;
import com.leanplum.migration.push.MiPushMigrationHandler;
import com.leanplum.migration.wrapper.IWrapper;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/leanplum/migration/wrapper/StaticMethodsWrapper;", "Lcom/leanplum/migration/wrapper/IWrapper;", "()V", "registerLifecycleCallback", "", "app", "Landroid/app/Application;", "setLogLevel", "lpLevel", "", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class StaticMethodsWrapper implements IWrapper {
    public static final StaticMethodsWrapper INSTANCE = new StaticMethodsWrapper();

    private StaticMethodsWrapper() {
    }

    public void addInstanceCallback(CleverTapInstanceCallback cleverTapInstanceCallback) {
        j.g(cleverTapInstanceCallback, "callback");
        IWrapper.DefaultImpls.addInstanceCallback(this, cleverTapInstanceCallback);
    }

    public void advanceTo(String str, String str2, Map<String, ? extends Object> map) {
        IWrapper.DefaultImpls.advanceTo(this, str, str2, map);
    }

    public FcmMigrationHandler getFcmHandler() {
        return IWrapper.DefaultImpls.getFcmHandler(this);
    }

    public HmsMigrationHandler getHmsHandler() {
        return IWrapper.DefaultImpls.getHmsHandler(this);
    }

    public MiPushMigrationHandler getMiPushHandler() {
        return IWrapper.DefaultImpls.getMiPushHandler(this);
    }

    public void launch(Context context, List<? extends CleverTapInstanceCallback> list) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(list, "callbacks");
        IWrapper.DefaultImpls.launch(this, context, list);
    }

    public void registerLifecycleCallback(Application application) {
        j.g(application, "app");
        b.a(application);
    }

    public void removeInstanceCallback(CleverTapInstanceCallback cleverTapInstanceCallback) {
        j.g(cleverTapInstanceCallback, "callback");
        IWrapper.DefaultImpls.removeInstanceCallback(this, cleverTapInstanceCallback);
    }

    public void setLogLevel(int i10) {
        CleverTapAPI.d0(MigrationConstants.INSTANCE.mapLogLevel(i10));
    }

    public void setTrafficSourceInfo(Map<String, String> map) {
        j.g(map, "info");
        IWrapper.DefaultImpls.setTrafficSourceInfo(this, map);
    }

    public void setUserAttributes(Map<String, ? extends Object> map) {
        IWrapper.DefaultImpls.setUserAttributes(this, map);
    }

    public void setUserId(String str) {
        IWrapper.DefaultImpls.setUserId(this, str);
    }

    public void track(String str, double d10, String str2, Map<String, ? extends Object> map) {
        IWrapper.DefaultImpls.track(this, str, d10, str2, map);
    }

    public void trackGooglePlayPurchase(String str, String str2, double d10, String str3, String str4, String str5, Map<String, ? extends Object> map) {
        j.g(str, "event");
        IWrapper.DefaultImpls.trackGooglePlayPurchase(this, str, str2, d10, str3, str4, str5, map);
    }

    public void trackPurchase(String str, double d10, String str2, Map<String, ? extends Object> map) {
        j.g(str, "event");
        IWrapper.DefaultImpls.trackPurchase(this, str, d10, str2, map);
    }
}
