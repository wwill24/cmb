package com.leanplum.internal;

import com.leanplum.internal.Constants;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class RequestUtil {
    public static String getReadableErrorMessage(String str) {
        if (str == null || str.length() == 0) {
            return "API error";
        }
        if (str.startsWith("App not found")) {
            Constants.isInPermanentFailureState = true;
            return "No app matching the provided app ID was found.";
        } else if (str.startsWith("Invalid access key")) {
            Constants.isInPermanentFailureState = true;
            return "The access key you provided is not valid for this app.";
        } else if (str.startsWith("Development mode requested but not permitted")) {
            Constants.isInPermanentFailureState = true;
            return "A call to Leanplum.setAppIdForDevelopmentMode with your production key was made, which is not permitted.";
        } else {
            return "API error: " + str;
        }
    }

    public static String getResponseError(b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            b optJSONObject = bVar.optJSONObject("error");
            if (optJSONObject == null) {
                return null;
            }
            return optJSONObject.getString("message");
        } catch (JSONException e10) {
            Log.e("Could not parse JSON response.", (Throwable) e10);
            return null;
        }
    }

    public static b getResponseForId(b bVar, String str) {
        try {
            a jSONArray = bVar.getJSONArray("response");
            if (jSONArray != null) {
                for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                    b j10 = jSONArray.j(i10);
                    if (j10 != null && str.equalsIgnoreCase(j10.getString(Constants.Params.REQUEST_ID))) {
                        return j10;
                    }
                }
            }
            return null;
        } catch (JSONException e10) {
            Log.e("Could not get response for id: " + str, (Throwable) e10);
            return null;
        }
    }

    public static boolean isResponseSuccess(b bVar) {
        if (bVar == null) {
            return false;
        }
        try {
            return bVar.getBoolean("success");
        } catch (JSONException e10) {
            Log.e("Could not parse JSON response.", (Throwable) e10);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c9 A[Catch:{ JSONException -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean updateApiConfig(org.json.b r8) {
        /*
            java.lang.String r0 = "response"
            r1 = 0
            boolean r2 = r8.isNull(r0)     // Catch:{ JSONException -> 0x00f9 }
            if (r2 != 0) goto L_0x00ff
            org.json.a r8 = r8.getJSONArray(r0)     // Catch:{ JSONException -> 0x00f9 }
            r0 = r1
        L_0x000e:
            int r2 = r8.o()     // Catch:{ JSONException -> 0x00f9 }
            if (r0 >= r2) goto L_0x00ff
            org.json.b r2 = r8.j(r0)     // Catch:{ JSONException -> 0x00f9 }
            boolean r3 = isResponseSuccess(r2)     // Catch:{ JSONException -> 0x00f9 }
            if (r3 == 0) goto L_0x0020
            goto L_0x00f5
        L_0x0020:
            if (r2 == 0) goto L_0x00f5
            java.lang.String r8 = "apiHost"
            java.lang.String r8 = r2.optString(r8)     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r0 = "apiPath"
            java.lang.String r0 = r2.optString(r0)     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r3 = "devServerHost"
            java.lang.String r2 = r2.optString(r3)     // Catch:{ JSONException -> 0x00f9 }
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x00f9 }
            r4 = 1
            if (r3 != 0) goto L_0x004b
            com.leanplum.internal.APIConfig r3 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r3 = r3.getApiHost()     // Catch:{ JSONException -> 0x00f9 }
            boolean r3 = r8.equals(r3)     // Catch:{ JSONException -> 0x00f9 }
            if (r3 != 0) goto L_0x004b
            r3 = r4
            goto L_0x004c
        L_0x004b:
            r3 = r1
        L_0x004c:
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x00f9 }
            if (r5 != 0) goto L_0x0062
            com.leanplum.internal.APIConfig r5 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r5 = r5.getApiPath()     // Catch:{ JSONException -> 0x00f9 }
            boolean r5 = r0.equals(r5)     // Catch:{ JSONException -> 0x00f9 }
            if (r5 != 0) goto L_0x0062
            r5 = r4
            goto L_0x0063
        L_0x0062:
            r5 = r1
        L_0x0063:
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00f9 }
            if (r6 != 0) goto L_0x0079
            com.leanplum.internal.APIConfig r6 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r6 = r6.getSocketHost()     // Catch:{ JSONException -> 0x00f9 }
            boolean r6 = r2.equals(r6)     // Catch:{ JSONException -> 0x00f9 }
            if (r6 != 0) goto L_0x0079
            r6 = r4
            goto L_0x007a
        L_0x0079:
            r6 = r1
        L_0x007a:
            if (r3 != 0) goto L_0x0081
            if (r5 == 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r8 = r1
            goto L_0x00c7
        L_0x0081:
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x00f9 }
            if (r3 == 0) goto L_0x008f
            com.leanplum.internal.APIConfig r8 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r8 = r8.getApiHost()     // Catch:{ JSONException -> 0x00f9 }
        L_0x008f:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x00f9 }
            if (r3 == 0) goto L_0x009d
            com.leanplum.internal.APIConfig r0 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r0 = r0.getApiPath()     // Catch:{ JSONException -> 0x00f9 }
        L_0x009d:
            com.leanplum.internal.APIConfig r3 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x00f9 }
            boolean r3 = r3.getApiSSL()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00f9 }
            r5.<init>()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r7 = "Changing API endpoint to "
            r5.append(r7)     // Catch:{ JSONException -> 0x00f9 }
            r5.append(r8)     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r7 = "/"
            r5.append(r7)     // Catch:{ JSONException -> 0x00f9 }
            r5.append(r0)     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ JSONException -> 0x00f9 }
            com.leanplum.internal.Log.d(r5, r7)     // Catch:{ JSONException -> 0x00f9 }
            com.leanplum.Leanplum.setApiConnectionSettings(r8, r0, r3)     // Catch:{ JSONException -> 0x00f9 }
            r8 = r4
        L_0x00c7:
            if (r6 == 0) goto L_0x00f3
            com.leanplum.internal.APIConfig r8 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x00f9 }
            int r8 = r8.getSocketPort()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00f9 }
            r0.<init>()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r3 = "Changing socket to "
            r0.append(r3)     // Catch:{ JSONException -> 0x00f9 }
            r0.append(r2)     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r3 = ":"
            r0.append(r3)     // Catch:{ JSONException -> 0x00f9 }
            r0.append(r8)     // Catch:{ JSONException -> 0x00f9 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00f9 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ JSONException -> 0x00f9 }
            com.leanplum.internal.Log.d(r0, r3)     // Catch:{ JSONException -> 0x00f9 }
            com.leanplum.Leanplum.setSocketConnectionSettings(r2, r8)     // Catch:{ JSONException -> 0x00f9 }
            goto L_0x00f4
        L_0x00f3:
            r4 = r8
        L_0x00f4:
            return r4
        L_0x00f5:
            int r0 = r0 + 1
            goto L_0x000e
        L_0x00f9:
            r8 = move-exception
            java.lang.String r0 = "Error parsing response for API config"
            com.leanplum.internal.Log.e((java.lang.String) r0, (java.lang.Throwable) r8)
        L_0x00ff:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.RequestUtil.updateApiConfig(org.json.b):boolean");
    }
}
