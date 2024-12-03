package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.gamingservices.GamingPayload;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class CloudGameLoginHandler {
    private static final int DEFAULT_TIMEOUT_IN_SEC = 5;
    private static boolean IS_RUNNING_IN_CLOUD = false;
    private static SDKLogger mLogger;

    private static List<String> convertPermissionsStringIntoPermissionsList(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!str.isEmpty()) {
            a aVar = new a(str);
            for (int i10 = 0; i10 < aVar.o(); i10++) {
                arrayList.add(aVar.get(i10).toString());
            }
        }
        return arrayList;
    }

    public static void gameLoadComplete(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (b) null, callback, SDKMessageEnum.MARK_GAME_LOADED);
    }

    public static synchronized AccessToken init(Context context) throws FacebookException {
        AccessToken init;
        synchronized (CloudGameLoginHandler.class) {
            init = init(context, 5);
        }
        return init;
    }

    private static boolean isCloudEnvReady(Context context, int i10) {
        GraphResponse executeAndWait = DaemonRequest.executeAndWait(context, (b) null, SDKMessageEnum.IS_ENV_READY, i10);
        if (executeAndWait == null || executeAndWait.getJSONObject() == null || executeAndWait.getError() != null) {
            return false;
        }
        return true;
    }

    public static boolean isRunningInCloud() {
        return IS_RUNNING_IN_CLOUD;
    }

    private static AccessToken setCurrentAccessToken(b bVar) throws JSONException {
        AccessTokenSource accessTokenSource;
        Date date;
        Date date2;
        Date date3;
        b bVar2 = bVar;
        String optString = bVar2.optString(SDKConstants.PARAM_ACCESS_TOKEN);
        String optString2 = bVar2.optString(SDKConstants.PARAM_ACCESS_TOKEN_SOURCE);
        String optString3 = bVar2.optString(SDKConstants.PARAM_APP_ID);
        String optString4 = bVar2.optString(SDKConstants.PARAM_DECLINED_PERMISSIONS);
        String optString5 = bVar2.optString(SDKConstants.PARAM_EXPIRED_PERMISSIONS);
        String optString6 = bVar2.optString(SDKConstants.PARAM_EXPIRATION_TIME);
        String optString7 = bVar2.optString(SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME);
        String optString8 = bVar2.optString(SDKConstants.PARAM_GRAPH_DOMAIN);
        String optString9 = bVar2.optString(SDKConstants.PARAM_LAST_REFRESH_TIME);
        String optString10 = bVar2.optString("permissions");
        String optString11 = bVar2.optString(SDKConstants.PARAM_USER_ID);
        String optString12 = bVar2.optString(SDKConstants.PARAM_SESSION_ID);
        String str = null;
        if (optString.isEmpty() || optString3.isEmpty() || optString11.isEmpty()) {
            return null;
        }
        SDKLogger sDKLogger = mLogger;
        if (sDKLogger != null) {
            sDKLogger.setAppID(optString3);
            mLogger.setUserID(optString11);
            mLogger.setSessionID(optString12);
        }
        List<String> convertPermissionsStringIntoPermissionsList = convertPermissionsStringIntoPermissionsList(optString10);
        List<String> convertPermissionsStringIntoPermissionsList2 = convertPermissionsStringIntoPermissionsList(optString4);
        List<String> convertPermissionsStringIntoPermissionsList3 = convertPermissionsStringIntoPermissionsList(optString5);
        if (!optString2.isEmpty()) {
            accessTokenSource = AccessTokenSource.valueOf(optString2);
        } else {
            accessTokenSource = null;
        }
        if (!optString6.isEmpty()) {
            date = new Date(((long) Integer.parseInt(optString6)) * 1000);
        } else {
            date = null;
        }
        if (!optString9.isEmpty()) {
            date2 = new Date(((long) Integer.parseInt(optString9)) * 1000);
        } else {
            date2 = null;
        }
        if (!optString7.isEmpty()) {
            date3 = new Date(((long) Integer.parseInt(optString7)) * 1000);
        } else {
            date3 = null;
        }
        if (!optString8.isEmpty()) {
            str = optString8;
        }
        AccessToken accessToken = new AccessToken(optString, optString3, optString11, convertPermissionsStringIntoPermissionsList, convertPermissionsStringIntoPermissionsList2, convertPermissionsStringIntoPermissionsList3, accessTokenSource, date, date2, date3, str);
        AccessToken.setCurrentAccessToken(accessToken);
        return accessToken;
    }

    private static void setPackageName(b bVar, Context context) {
        String optString = bVar.optString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME);
        if (!optString.isEmpty()) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SDKConstants.PREF_DAEMON_PACKAGE_NAME, 0).edit();
            edit.putString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME, optString);
            edit.commit();
            return;
        }
        throw new FacebookException("Could not establish a secure connection.");
    }

    public static synchronized AccessToken init(Context context, int i10) throws FacebookException {
        AccessToken currentAccessToken;
        synchronized (CloudGameLoginHandler.class) {
            if (i10 <= 0) {
                i10 = 5;
            }
            if (isCloudEnvReady(context, i10)) {
                mLogger = SDKLogger.getInstance(context);
                GraphResponse executeAndWait = DaemonRequest.executeAndWait(context, (b) null, SDKMessageEnum.GET_ACCESS_TOKEN, i10);
                if (executeAndWait == null || executeAndWait.getJSONObject() == null) {
                    throw new FacebookException("Cannot receive response.");
                } else if (executeAndWait.getError() == null) {
                    setPackageName(executeAndWait.getJSONObject(), context);
                    try {
                        currentAccessToken = setCurrentAccessToken(executeAndWait.getJSONObject());
                        GamingPayload.loadPayloadFromCloudGame(executeAndWait.getJSONObject().optString("payload"));
                        Profile.fetchProfileForCurrentAccessToken();
                        IS_RUNNING_IN_CLOUD = true;
                        mLogger.logLoginSuccess();
                    } catch (JSONException e10) {
                        throw new FacebookException("Cannot properly handle response.", (Throwable) e10);
                    }
                } else {
                    throw new FacebookException(executeAndWait.getError().getErrorMessage());
                }
            } else {
                throw new FacebookException("Not running in Cloud environment.");
            }
        }
        return currentAccessToken;
    }
}
