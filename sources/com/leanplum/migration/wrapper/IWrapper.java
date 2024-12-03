package com.leanplum.migration.wrapper;

import android.app.Application;
import android.content.Context;
import com.leanplum.callbacks.CleverTapInstanceCallback;
import com.leanplum.migration.push.FcmMigrationHandler;
import com.leanplum.migration.push.HmsMigrationHandler;
import com.leanplum.migration.push.MiPushMigrationHandler;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J4\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017H\u0016J\u001e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0016J\u001c\u0010$\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0017H\u0016J \u0010%\u001a\u00020\u000f2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017H\u0016J\u0012\u0010'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0014H\u0016J<\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u00142\u0006\u0010+\u001a\u00020,2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017H\u0016JX\u0010-\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010\u00142\u0006\u0010+\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u00142\b\u00100\u001a\u0004\u0018\u00010\u00142\b\u00101\u001a\u0004\u0018\u00010\u00142\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017H\u0016J:\u00102\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u00142\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017H\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u00063"}, d2 = {"Lcom/leanplum/migration/wrapper/IWrapper;", "", "fcmHandler", "Lcom/leanplum/migration/push/FcmMigrationHandler;", "getFcmHandler", "()Lcom/leanplum/migration/push/FcmMigrationHandler;", "hmsHandler", "Lcom/leanplum/migration/push/HmsMigrationHandler;", "getHmsHandler", "()Lcom/leanplum/migration/push/HmsMigrationHandler;", "miPushHandler", "Lcom/leanplum/migration/push/MiPushMigrationHandler;", "getMiPushHandler", "()Lcom/leanplum/migration/push/MiPushMigrationHandler;", "addInstanceCallback", "", "callback", "Lcom/leanplum/callbacks/CleverTapInstanceCallback;", "advanceTo", "state", "", "info", "params", "", "launch", "context", "Landroid/content/Context;", "callbacks", "", "registerLifecycleCallback", "app", "Landroid/app/Application;", "removeInstanceCallback", "setLogLevel", "lpLevel", "", "setTrafficSourceInfo", "setUserAttributes", "attributes", "setUserId", "userId", "track", "event", "value", "", "trackGooglePlayPurchase", "item", "currencyCode", "purchaseData", "dataSignature", "trackPurchase", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public interface IWrapper {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void addInstanceCallback(IWrapper iWrapper, CleverTapInstanceCallback cleverTapInstanceCallback) {
            j.g(cleverTapInstanceCallback, "callback");
        }

        public static void advanceTo(IWrapper iWrapper, String str, String str2, Map<String, ? extends Object> map) {
        }

        public static FcmMigrationHandler getFcmHandler(IWrapper iWrapper) {
            return null;
        }

        public static HmsMigrationHandler getHmsHandler(IWrapper iWrapper) {
            return null;
        }

        public static MiPushMigrationHandler getMiPushHandler(IWrapper iWrapper) {
            return null;
        }

        public static void launch(IWrapper iWrapper, Context context, List<? extends CleverTapInstanceCallback> list) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(list, "callbacks");
        }

        public static void registerLifecycleCallback(IWrapper iWrapper, Application application) {
            j.g(application, "app");
        }

        public static void removeInstanceCallback(IWrapper iWrapper, CleverTapInstanceCallback cleverTapInstanceCallback) {
            j.g(cleverTapInstanceCallback, "callback");
        }

        public static void setLogLevel(IWrapper iWrapper, int i10) {
        }

        public static void setTrafficSourceInfo(IWrapper iWrapper, Map<String, String> map) {
            j.g(map, "info");
        }

        public static void setUserAttributes(IWrapper iWrapper, Map<String, ? extends Object> map) {
        }

        public static void setUserId(IWrapper iWrapper, String str) {
        }

        public static void track(IWrapper iWrapper, String str, double d10, String str2, Map<String, ? extends Object> map) {
        }

        public static void trackGooglePlayPurchase(IWrapper iWrapper, String str, String str2, double d10, String str3, String str4, String str5, Map<String, ? extends Object> map) {
            j.g(str, "event");
        }

        public static void trackPurchase(IWrapper iWrapper, String str, double d10, String str2, Map<String, ? extends Object> map) {
            j.g(str, "event");
        }
    }

    void addInstanceCallback(CleverTapInstanceCallback cleverTapInstanceCallback);

    void advanceTo(String str, String str2, Map<String, ? extends Object> map);

    FcmMigrationHandler getFcmHandler();

    HmsMigrationHandler getHmsHandler();

    MiPushMigrationHandler getMiPushHandler();

    void launch(Context context, List<? extends CleverTapInstanceCallback> list);

    void registerLifecycleCallback(Application application);

    void removeInstanceCallback(CleverTapInstanceCallback cleverTapInstanceCallback);

    void setLogLevel(int i10);

    void setTrafficSourceInfo(Map<String, String> map);

    void setUserAttributes(Map<String, ? extends Object> map);

    void setUserId(String str);

    void track(String str, double d10, String str2, Map<String, ? extends Object> map);

    void trackGooglePlayPurchase(String str, String str2, double d10, String str3, String str4, String str5, Map<String, ? extends Object> map);

    void trackPurchase(String str, double d10, String str2, Map<String, ? extends Object> map);
}
