package com.leanplum.internal;

import android.content.Context;
import android.text.TextUtils;

public class ApiConfigLoader {
    private static final String ENV_DEV = "development";
    private static final String ENV_PROD = "production";
    private static final String STRING_APPID = "leanplum_app_id";
    private static final String STRING_DEV_KEY = "leanplum_dev_key";
    private static final String STRING_ENV = "leanplum_environment";
    private static final String STRING_PROD_KEY = "leanplum_prod_key";
    private Context context;

    @FunctionalInterface
    public interface KeyListener {
        void onKeysLoaded(String str, String str2);
    }

    public ApiConfigLoader(Context context2) {
        this.context = context2;
    }

    private String getStringResource(String str) {
        try {
            return this.context.getString(this.context.getResources().getIdentifier(str, "string", this.context.getPackageName()));
        } catch (Throwable th2) {
            Log.e("Cannot load string for key = %s. Message = %s", str, th2.getMessage());
            return null;
        }
    }

    public void loadFromResources(KeyListener keyListener, KeyListener keyListener2) {
        String stringResource = getStringResource(STRING_APPID);
        String stringResource2 = getStringResource(STRING_PROD_KEY);
        String stringResource3 = getStringResource(STRING_DEV_KEY);
        String stringResource4 = getStringResource(STRING_ENV);
        if (!TextUtils.isEmpty(stringResource)) {
            boolean equals = ENV_DEV.equals(stringResource4);
            boolean z10 = !TextUtils.isEmpty(stringResource2);
            boolean z11 = !TextUtils.isEmpty(stringResource3);
            if (equals && z11) {
                keyListener2.onKeysLoaded(stringResource, stringResource3);
                Log.i("Using appId and accessKey from Android resources for development environment.", new Object[0]);
            } else if (!equals && z10) {
                keyListener.onKeysLoaded(stringResource, stringResource2);
                Log.i("Using appId and accessKey from Android resources for production environment.", new Object[0]);
            }
        }
    }
}
