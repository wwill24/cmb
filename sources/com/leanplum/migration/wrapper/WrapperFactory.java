package com.leanplum.migration.wrapper;

import android.content.Context;
import android.content.SharedPreferences;
import com.leanplum.Leanplum;
import com.leanplum.callbacks.CleverTapInstanceCallback;
import com.leanplum.internal.AESCrypt;
import com.leanplum.internal.Constants;
import com.leanplum.internal.LeanplumInternal;
import com.leanplum.internal.Log;
import com.leanplum.migration.model.MigrationConfig;
import com.leanplum.utils.CommonExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J \u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/leanplum/migration/wrapper/WrapperFactory;", "", "()V", "createWrapper", "Lcom/leanplum/migration/wrapper/IWrapper;", "callbacks", "", "Lcom/leanplum/callbacks/CleverTapInstanceCallback;", "getDeviceAndUserFromPrefs", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class WrapperFactory {
    public static final WrapperFactory INSTANCE = new WrapperFactory();

    private WrapperFactory() {
    }

    private final Pair<String, String> getDeviceAndUserFromPrefs(Context context) {
        String appId = MigrationConfig.getAppId();
        if (appId == null) {
            return new Pair<>(null, null);
        }
        SharedPreferences leanplumPrefs = CommonExtensionsKt.getLeanplumPrefs(context);
        AESCrypt aESCrypt = new AESCrypt(appId, (String) null);
        return new Pair<>(aESCrypt.decodePreference(leanplumPrefs, Constants.Params.DEVICE_ID, (String) null), aESCrypt.decodePreference(leanplumPrefs, Constants.Params.USER_ID, (String) null));
    }

    public final IWrapper createWrapper(List<? extends CleverTapInstanceCallback> list) {
        String str;
        String str2;
        j.g(list, "callbacks");
        MigrationConfig migrationConfig = MigrationConfig.INSTANCE;
        String accountId = migrationConfig.getAccountId();
        String accountToken = migrationConfig.getAccountToken();
        String accountRegion = migrationConfig.getAccountRegion();
        if (accountId == null || accountToken == null || accountRegion == null) {
            return NullWrapper.INSTANCE;
        }
        Context context = Leanplum.getContext();
        if (context == null) {
            return StaticMethodsWrapper.INSTANCE;
        }
        j.f(context, "Leanplum.getContext() ?:…turn StaticMethodsWrapper");
        if (LeanplumInternal.hasCalledStart()) {
            String deviceId = Leanplum.getDeviceId();
            str = Leanplum.getUserId();
            str2 = deviceId;
        } else {
            Pair<String, String> deviceAndUserFromPrefs = getDeviceAndUserFromPrefs(context);
            str2 = deviceAndUserFromPrefs.c();
            str = deviceAndUserFromPrefs.d();
        }
        if (str2 == null) {
            return StaticMethodsWrapper.INSTANCE;
        }
        CTWrapper cTWrapper = new CTWrapper(accountId, accountToken, accountRegion, str2, str);
        long currentTimeMillis = System.currentTimeMillis();
        cTWrapper.launch(context, list);
        Log.d("Wrapper: launch took " + (System.currentTimeMillis() - currentTimeMillis) + " millis", new Object[0]);
        return cTWrapper;
    }
}
