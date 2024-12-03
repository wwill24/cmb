package com.leanplum.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.leanplum.Leanplum;
import com.leanplum.internal.Constants;
import com.leanplum.utils.SharedPreferencesUtil;
import java.util.Map;

public class APIConfig {
    private static final APIConfig INSTANCE = new APIConfig();
    private String accessKey;
    private String apiHost = "api.leanplum.com";
    private String apiPath = "api";
    private boolean apiSSL = true;
    private String appId;
    private String deviceId;
    private String socketHost = "dev.leanplum.com";
    private int socketPort = 443;
    private String token;
    private String userId;

    APIConfig() {
        load();
    }

    public static APIConfig getInstance() {
        return INSTANCE;
    }

    private void load() {
        Context context = Leanplum.getContext();
        if (context == null) {
            Log.e("Leanplum context is null. Please call Leanplum.setApplicationContext(context) before anything else.", new Object[0]);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0);
        String string = sharedPreferences.getString(Constants.Defaults.TOKEN_KEY, (String) null);
        if (string != null) {
            this.token = string;
        }
        String string2 = sharedPreferences.getString(Constants.Defaults.API_HOST_KEY, (String) null);
        if (string2 != null) {
            this.apiHost = string2;
        }
        String string3 = sharedPreferences.getString(Constants.Defaults.API_PATH_KEY, (String) null);
        if (string3 != null) {
            this.apiPath = string3;
        }
        this.apiSSL = sharedPreferences.getBoolean(Constants.Defaults.API_SSL_KEY, true);
        String string4 = sharedPreferences.getString(Constants.Defaults.SOCKET_HOST_KEY, (String) null);
        if (string4 != null) {
            this.socketHost = string4;
        }
        int i10 = sharedPreferences.getInt(Constants.Defaults.SOCKET_PORT_KEY, 0);
        if (i10 != 0) {
            this.socketPort = i10;
        }
    }

    public String accessKey() {
        return this.accessKey;
    }

    public String appId() {
        return this.appId;
    }

    public boolean attachApiKeys(Map<String, Object> map) {
        String str = this.appId;
        if (str == null || this.accessKey == null) {
            Log.e("API keys are not set. Please use Leanplum.setAppIdForDevelopmentMode or Leanplum.setAppIdForProductionMode.", new Object[0]);
            return false;
        }
        map.put("appId", str);
        map.put(Constants.Params.CLIENT_KEY, this.accessKey);
        map.put(Constants.Params.CLIENT, Constants.CLIENT);
        return true;
    }

    public String deviceId() {
        return this.deviceId;
    }

    public String getApiHost() {
        return this.apiHost;
    }

    public String getApiPath() {
        return this.apiPath;
    }

    public boolean getApiSSL() {
        return this.apiSSL;
    }

    public String getSocketHost() {
        return this.socketHost;
    }

    public int getSocketPort() {
        return this.socketPort;
    }

    public void save() {
        Context context = Leanplum.getContext();
        if (context == null) {
            Log.e("Leanplum context is null. Please call Leanplum.setApplicationContext(context) before anything else.", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0).edit();
        edit.putString(Constants.Defaults.TOKEN_KEY, this.token);
        edit.putString(Constants.Defaults.API_HOST_KEY, this.apiHost);
        edit.putString(Constants.Defaults.API_PATH_KEY, this.apiPath);
        edit.putBoolean(Constants.Defaults.API_SSL_KEY, this.apiSSL);
        edit.putString(Constants.Defaults.SOCKET_HOST_KEY, this.socketHost);
        edit.putInt(Constants.Defaults.SOCKET_PORT_KEY, this.socketPort);
        SharedPreferencesUtil.commitChanges(edit);
    }

    public void setApiConfig(String str, String str2, boolean z10) {
        if (!TextUtils.isEmpty(str)) {
            this.apiHost = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.apiPath = str2;
        }
        this.apiSSL = z10;
        save();
    }

    public void setAppId(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.appId = str.trim();
        }
        if (!TextUtils.isEmpty(str2)) {
            this.accessKey = str2.trim();
        }
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setSocketConfig(String str, int i10) {
        if (!TextUtils.isEmpty(str)) {
            this.socketHost = str;
            this.socketPort = i10;
            save();
        }
    }

    public void setToken(String str) {
        this.token = str;
        save();
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String token() {
        return this.token;
    }

    public String userId() {
        return this.userId;
    }
}
