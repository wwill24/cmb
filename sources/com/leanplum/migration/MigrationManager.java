package com.leanplum.migration;

import com.clevertap.android.sdk.BuildConfig;
import com.leanplum.callbacks.CleverTapInstanceCallback;
import com.leanplum.internal.Log;
import com.leanplum.internal.OperationQueue;
import com.leanplum.internal.Request;
import com.leanplum.internal.RequestBuilder;
import com.leanplum.internal.RequestSender;
import com.leanplum.migration.model.MigrationConfig;
import com.leanplum.migration.model.MigrationState;
import com.leanplum.migration.wrapper.IWrapper;
import com.leanplum.migration.wrapper.NullWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007J\u001c\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0007J\u001c\u0010\r\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\nH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\fH\u0007J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0007J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015J\u001c\u0010\u0019\u001a\u00020\u00152\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aR*\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c8F@BX\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/leanplum/migration/MigrationManager;", "", "Lcom/leanplum/migration/model/MigrationState;", "getState", "Lcom/leanplum/callbacks/CleverTapInstanceCallback;", "callback", "", "addCleverTapInstanceCallback", "removeCleverTapInstanceCallback", "updateWrapper", "Lkotlin/Function1;", "fetchState", "", "fetchStateAsync", "Lorg/json/b;", "responseBody", "refreshStateMidSession", "oldState", "newState", "handleStateTransition", "trackGooglePlayPurchases", "", "getCleverTapVersion", "verifyCleverTapVersion", "attributeName", "mapAttributeName", "", "attribute", "Lcom/leanplum/migration/wrapper/IWrapper;", "<set-?>", "wrapper", "Lcom/leanplum/migration/wrapper/IWrapper;", "getWrapper", "()Lcom/leanplum/migration/wrapper/IWrapper;", "getWrapper$annotations", "()V", "", "instanceCallbackList", "Ljava/util/List;", "<init>", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class MigrationManager {
    public static final MigrationManager INSTANCE = new MigrationManager();
    private static final List<CleverTapInstanceCallback> instanceCallbackList = new ArrayList();
    private static IWrapper wrapper = NullWrapper.INSTANCE;

    private MigrationManager() {
    }

    public static final synchronized void addCleverTapInstanceCallback(CleverTapInstanceCallback cleverTapInstanceCallback) {
        synchronized (MigrationManager.class) {
            j.g(cleverTapInstanceCallback, "callback");
            instanceCallbackList.add(cleverTapInstanceCallback);
            wrapper.addInstanceCallback(cleverTapInstanceCallback);
        }
    }

    public static final void fetchState(Function1<? super MigrationState, Unit> function1) {
        j.g(function1, "callback");
        if (getState() != MigrationState.Undefined) {
            updateWrapper();
            function1.invoke(getState());
            return;
        }
        INSTANCE.fetchStateAsync(new MigrationManager$fetchState$1(function1));
    }

    private final void fetchStateAsync(Function1<? super Boolean, Unit> function1) {
        Request create = RequestBuilder.withGetMigrateState().andType(Request.RequestType.IMMEDIATE).create();
        create.onError(new MigrationManager$fetchStateAsync$1(function1));
        create.onResponse(new MigrationManager$fetchStateAsync$2(function1));
        RequestSender.getInstance().send(create);
    }

    private final String getCleverTapVersion() {
        try {
            Object obj = BuildConfig.class.getField("VERSION_NAME").get((Object) null);
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final MigrationState getState() {
        return MigrationState.Companion.from(MigrationConfig.INSTANCE.getState());
    }

    public static final synchronized IWrapper getWrapper() {
        IWrapper iWrapper;
        synchronized (MigrationManager.class) {
            iWrapper = wrapper;
        }
        return iWrapper;
    }

    public static /* synthetic */ void getWrapper$annotations() {
    }

    /* access modifiers changed from: private */
    public final void handleStateTransition(MigrationState migrationState, MigrationState migrationState2) {
        if (migrationState.useLeanplum() && !migrationState2.useLeanplum()) {
            OperationQueue.sharedInstance().addOperation(MigrationManager$handleStateTransition$1.INSTANCE);
        }
        if (!migrationState.useCleverTap() && migrationState2.useCleverTap()) {
            OperationQueue.sharedInstance().addOperation(MigrationManager$handleStateTransition$2.INSTANCE);
        }
        if (migrationState.useCleverTap() && !migrationState2.useCleverTap()) {
            updateWrapper();
        }
    }

    public static final boolean refreshStateMidSession(b bVar) {
        j.g(bVar, "responseBody");
        String handleMigrateState = new ResponseHandler().handleMigrateState(bVar);
        if (handleMigrateState == null || !(!j.b(handleMigrateState, MigrationConfig.INSTANCE.getHash()))) {
            return false;
        }
        INSTANCE.fetchStateAsync(MigrationManager$refreshStateMidSession$1.INSTANCE);
        return true;
    }

    public static final synchronized void removeCleverTapInstanceCallback(CleverTapInstanceCallback cleverTapInstanceCallback) {
        synchronized (MigrationManager.class) {
            j.g(cleverTapInstanceCallback, "callback");
            instanceCallbackList.remove(cleverTapInstanceCallback);
            wrapper.removeInstanceCallback(cleverTapInstanceCallback);
        }
    }

    public static final boolean trackGooglePlayPurchases() {
        return MigrationConfig.INSTANCE.getTrackGooglePlayPurchases();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void updateWrapper() {
        /*
            java.lang.Class<com.leanplum.migration.MigrationManager> r0 = com.leanplum.migration.MigrationManager.class
            monitor-enter(r0)
            boolean r1 = com.leanplum.internal.Constants.isNoop()     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x000f
            com.leanplum.migration.wrapper.NullWrapper r1 = com.leanplum.migration.wrapper.NullWrapper.INSTANCE     // Catch:{ all -> 0x0052 }
            wrapper = r1     // Catch:{ all -> 0x0052 }
            monitor-exit(r0)
            return
        L_0x000f:
            com.leanplum.migration.model.MigrationState r1 = getState()     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.useCleverTap()     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x0038
            com.leanplum.migration.wrapper.IWrapper r1 = wrapper     // Catch:{ all -> 0x0052 }
            com.leanplum.migration.wrapper.NullWrapper r2 = com.leanplum.migration.wrapper.NullWrapper.INSTANCE     // Catch:{ all -> 0x0052 }
            boolean r1 = kotlin.jvm.internal.j.b(r1, r2)     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x002d
            com.leanplum.migration.wrapper.IWrapper r1 = wrapper     // Catch:{ all -> 0x0052 }
            com.leanplum.migration.wrapper.StaticMethodsWrapper r2 = com.leanplum.migration.wrapper.StaticMethodsWrapper.INSTANCE     // Catch:{ all -> 0x0052 }
            boolean r1 = kotlin.jvm.internal.j.b(r1, r2)     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x0038
        L_0x002d:
            com.leanplum.migration.wrapper.WrapperFactory r1 = com.leanplum.migration.wrapper.WrapperFactory.INSTANCE     // Catch:{ all -> 0x0052 }
            java.util.List<com.leanplum.callbacks.CleverTapInstanceCallback> r2 = instanceCallbackList     // Catch:{ all -> 0x0052 }
            com.leanplum.migration.wrapper.IWrapper r1 = r1.createWrapper(r2)     // Catch:{ all -> 0x0052 }
            wrapper = r1     // Catch:{ all -> 0x0052 }
            goto L_0x0050
        L_0x0038:
            com.leanplum.migration.wrapper.IWrapper r1 = wrapper     // Catch:{ all -> 0x0052 }
            com.leanplum.migration.wrapper.NullWrapper r2 = com.leanplum.migration.wrapper.NullWrapper.INSTANCE     // Catch:{ all -> 0x0052 }
            boolean r1 = kotlin.jvm.internal.j.b(r1, r2)     // Catch:{ all -> 0x0052 }
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0050
            com.leanplum.migration.model.MigrationState r1 = getState()     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.useCleverTap()     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x0050
            wrapper = r2     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r0)
            return
        L_0x0052:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.migration.MigrationManager.updateWrapper():void");
    }

    public static final void verifyCleverTapVersion() {
        String cleverTapVersion = INSTANCE.getCleverTapVersion();
        if (!j.b("4.6.6", cleverTapVersion)) {
            Log.e("Your CleverTap SDK dependency version is:\n" + "com.clevertap.android:clevertap-android-sdk:" + cleverTapVersion + 10 + "but you must use the supported by Leanplum SDK:\n" + "com.clevertap.android:clevertap-android-sdk:" + "4.6.6", new Object[0]);
        }
    }

    public final String mapAttributeName(String str) {
        j.g(str, "attributeName");
        Map<String, String> attributeMap = MigrationConfig.INSTANCE.getAttributeMap();
        String str2 = attributeMap != null ? attributeMap.get(str) : null;
        return str2 != null ? str2 : str;
    }

    public final String mapAttributeName(Map.Entry<String, ? extends Object> entry) {
        j.g(entry, "attribute");
        Map<String, String> attributeMap = MigrationConfig.INSTANCE.getAttributeMap();
        String str = attributeMap != null ? attributeMap.get(entry.getKey()) : null;
        return str != null ? str : entry.getKey();
    }
}
