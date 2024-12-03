package com.leanplum.internal;

import androidx.annotation.NonNull;
import com.leanplum.internal.Constants;
import com.leanplum.internal.Request;
import com.leanplum.migration.MigrationManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.b;

public class RequestSender {
    private static RequestSender INSTANCE = new RequestSender();
    private final RequestBatchFactory batchFactory = new RequestBatchFactory();
    private final LeanplumEventCallbackManager eventCallbackManager = new LeanplumEventCallbackManager();
    private final List<Map<String, Object>> localErrors = new ArrayList();
    private final RequestUuidHelper uuidHelper = new RequestUuidHelper();

    private void addLocalError(Request request) {
        this.localErrors.add(createArgsDictionary(request));
    }

    static Map<String, Object> createArgsDictionary(Request request) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.Params.DEVICE_ID, APIConfig.getInstance().deviceId());
        hashMap.put(Constants.Params.USER_ID, APIConfig.getInstance().userId());
        hashMap.put("action", request.getApiAction());
        hashMap.put("sdkVersion", Constants.LEANPLUM_VERSION);
        hashMap.put(Constants.Params.DEV_MODE, Boolean.toString(Constants.isDevelopmentModeEnabled));
        hashMap.put("time", Double.toString(((double) new Date().getTime()) / 1000.0d));
        hashMap.put(Constants.Params.REQUEST_ID, request.getRequestId());
        hashMap.put("ct", Boolean.valueOf(MigrationManager.getState().useCleverTap()));
        String str = APIConfig.getInstance().token();
        if (str != null) {
            hashMap.put("token", str);
        }
        hashMap.putAll(request.getParams());
        return hashMap;
    }

    private RequestBatch createNextBatch() {
        if (this.localErrors.size() > 0) {
            return this.batchFactory.createErrorBatch(this.localErrors);
        }
        return this.batchFactory.createNextBatch();
    }

    public static RequestSender getInstance() {
        return INSTANCE;
    }

    private boolean handleDatabaseError(Request request) {
        if (!LeanplumEventDataManager.sharedInstance().hasDatabaseError()) {
            return false;
        }
        if (!RequestBuilder.ACTION_LOG.equals(request.getApiAction())) {
            return true;
        }
        addLocalError(request);
        return true;
    }

    private void invokeCallbacksWithError(@NonNull Exception exc) {
        this.eventCallbackManager.invokeAllCallbacksWithError(exc);
    }

    private void saveRequest(Request request) {
        if (!handleDatabaseError(request)) {
            Map<String, Object> createArgsDictionary = createArgsDictionary(request);
            try {
                if (this.uuidHelper.attachUuid(createArgsDictionary)) {
                    LeanplumEventDataManager.sharedInstance().insertEvent(JsonConverter.toJson(createArgsDictionary));
                    if (request.response != null || (request.error != null && !Util.isConnected())) {
                        this.eventCallbackManager.addCallbacks(request, request.response, request.error);
                    }
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendSync(@NonNull Request request) {
        if (!Constants.isTestMode) {
            saveRequest(request);
            if (Constants.isDevelopmentModeEnabled || Request.RequestType.IMMEDIATE.equals(request.getType())) {
                try {
                    if (validateConfig(request)) {
                        sendRequests();
                    }
                } catch (Throwable th2) {
                    Log.exception(th2);
                }
            }
        }
    }

    public static void setInstance(RequestSender requestSender) {
        INSTANCE = requestSender;
    }

    private boolean validateConfig(@NonNull Request request) {
        if (APIConfig.getInstance().appId() == null) {
            Log.e("Cannot send request. appId is not set.", new Object[0]);
            return false;
        } else if (APIConfig.getInstance().accessKey() == null) {
            Log.e("Cannot send request. accessKey is not set.", new Object[0]);
            return false;
        } else if (Util.isConnected()) {
            return true;
        } else {
            Log.d("Device is offline, will try sending requests again later.", new Object[0]);
            Request.ErrorCallback errorCallback = request.error;
            if (errorCallback != null) {
                errorCallback.error(new Exception("Leanplum: device is offline"));
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void invokeCallbacks(@NonNull b bVar) {
        this.eventCallbackManager.invokeCallbacks(bVar);
    }

    public void send(@NonNull final Request request) {
        if (MigrationManager.getState().useLeanplum()) {
            OperationQueue.sharedInstance().addOperation(new Runnable() {
                public void run() {
                    RequestSender.this.sendSync(request);
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x013f A[SYNTHETIC, Splitter:B:52:0x013f] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0179 A[SYNTHETIC, Splitter:B:62:0x0179] */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendRequests() {
        /*
            r12 = this;
            java.lang.String r0 = "\n"
            com.leanplum.internal.CountAggregator r1 = com.leanplum.Leanplum.countAggregator()
            r1.sendAllCounts()
            com.leanplum.internal.RequestBatch r1 = r12.createNextBatch()
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0014
            return
        L_0x0014:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            com.leanplum.internal.APIConfig r2 = com.leanplum.internal.APIConfig.getInstance()
            boolean r2 = r2.attachApiKeys(r6)
            if (r2 != 0) goto L_0x0024
            return
        L_0x0024:
            java.lang.String r2 = r1.getJson()
            java.lang.String r3 = "data"
            r6.put(r3, r2)
            java.lang.String r2 = com.leanplum.internal.Constants.LEANPLUM_VERSION
            java.lang.String r3 = "sdkVersion"
            r6.put(r3, r2)
            java.lang.String r2 = "action"
            java.lang.String r3 = "multi"
            r6.put(r2, r3)
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            long r2 = r2.getTime()
            double r2 = (double) r2
            r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r2 = r2 / r4
            java.lang.String r2 = java.lang.Double.toString(r2)
            java.lang.String r3 = "time"
            r6.put(r3, r2)
            r2 = 0
            r10 = 0
            com.leanplum.internal.http.NetworkOperation r11 = new com.leanplum.internal.http.NetworkOperation     // Catch:{ JSONException -> 0x0143, Exception -> 0x0115 }
            com.leanplum.internal.APIConfig r3 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x0143, Exception -> 0x0115 }
            java.lang.String r4 = r3.getApiHost()     // Catch:{ JSONException -> 0x0143, Exception -> 0x0115 }
            com.leanplum.internal.APIConfig r3 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x0143, Exception -> 0x0115 }
            java.lang.String r5 = r3.getApiPath()     // Catch:{ JSONException -> 0x0143, Exception -> 0x0115 }
            java.lang.String r7 = "POST"
            com.leanplum.internal.APIConfig r3 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x0143, Exception -> 0x0115 }
            boolean r8 = r3.getApiSSL()     // Catch:{ JSONException -> 0x0143, Exception -> 0x0115 }
            int r9 = com.leanplum.internal.Constants.NETWORK_TIMEOUT_SECONDS     // Catch:{ JSONException -> 0x0143, Exception -> 0x0115 }
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x0143, Exception -> 0x0115 }
            org.json.b r2 = r11.getJsonResponse()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            int r3 = r11.getResponseCode()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 < r4) goto L_0x00b9
            r4 = 299(0x12b, float:4.19E-43)
            if (r3 > r4) goto L_0x00b9
            boolean r3 = com.leanplum.internal.RequestUtil.updateApiConfig(r2)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            if (r3 == 0) goto L_0x0095
            r12.sendRequests()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r11.disconnect()     // Catch:{ all -> 0x017d }
            return
        L_0x0095:
            boolean r3 = com.leanplum.migration.MigrationManager.refreshStateMidSession(r2)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            if (r3 == 0) goto L_0x00a2
            java.lang.String r3 = "Migration state will be refreshed."
            java.lang.Object[] r4 = new java.lang.Object[r10]     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            com.leanplum.internal.Log.i(r3, r4)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
        L_0x00a2:
            r12.invokeCallbacks(r2)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r2 = r12.localErrors     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r2.clear()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            com.leanplum.internal.RequestBatchFactory r2 = r12.batchFactory     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r2.deleteFinishedBatch(r1)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            boolean r2 = r1.isFull()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            if (r2 == 0) goto L_0x0109
            r12.sendRequests()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            goto L_0x0109
        L_0x00b9:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r4.<init>()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            java.lang.String r5 = "HTTP error "
            r4.append(r5)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r4.append(r3)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            if (r2 == 0) goto L_0x00e4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r5.<init>()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r5.append(r4)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            java.lang.String r4 = ": "
            r5.append(r4)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r5.append(r2)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
        L_0x00e4:
            java.lang.Object[] r2 = new java.lang.Object[r10]     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            com.leanplum.internal.Log.i(r4, r2)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r2 = -1
            if (r3 == r2) goto L_0x0101
            r2 = 408(0x198, float:5.72E-43)
            if (r3 == r2) goto L_0x0101
            r2 = 429(0x1ad, float:6.01E-43)
            if (r3 == r2) goto L_0x0101
            r2 = 500(0x1f4, float:7.0E-43)
            if (r3 < r2) goto L_0x00fc
            r2 = 599(0x257, float:8.4E-43)
            if (r3 <= r2) goto L_0x0101
        L_0x00fc:
            com.leanplum.internal.RequestBatchFactory r2 = r12.batchFactory     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r2.deleteFinishedBatch(r1)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
        L_0x0101:
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r2.<init>(r4)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
            r12.invokeCallbacksWithError(r2)     // Catch:{ JSONException -> 0x0111, Exception -> 0x010e }
        L_0x0109:
            r11.disconnect()     // Catch:{ all -> 0x017d }
            goto L_0x0181
        L_0x010e:
            r1 = move-exception
            r2 = r11
            goto L_0x0116
        L_0x0111:
            r2 = move-exception
            goto L_0x0146
        L_0x0113:
            r0 = move-exception
            goto L_0x0177
        L_0x0115:
            r1 = move-exception
        L_0x0116:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r3.<init>()     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = "Unable to send request: "
            r3.append(r4)     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0113 }
            r3.append(r4)     // Catch:{ all -> 0x0113 }
            r3.append(r0)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = com.leanplum.internal.Log.getStackTraceString(r1)     // Catch:{ all -> 0x0113 }
            r3.append(r0)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0113 }
            java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ all -> 0x0113 }
            com.leanplum.internal.Log.e((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ all -> 0x0113 }
            r12.invokeCallbacksWithError(r1)     // Catch:{ all -> 0x0113 }
            if (r2 == 0) goto L_0x0181
            r2.disconnect()     // Catch:{ all -> 0x017d }
            goto L_0x0181
        L_0x0143:
            r3 = move-exception
            r11 = r2
            r2 = r3
        L_0x0146:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r3.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = "Error parsing JSON response: "
            r3.append(r4)     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0175 }
            r3.append(r4)     // Catch:{ all -> 0x0175 }
            r3.append(r0)     // Catch:{ all -> 0x0175 }
            java.lang.String r0 = com.leanplum.internal.Log.getStackTraceString(r2)     // Catch:{ all -> 0x0175 }
            r3.append(r0)     // Catch:{ all -> 0x0175 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0175 }
            java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ all -> 0x0175 }
            com.leanplum.internal.Log.e((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ all -> 0x0175 }
            com.leanplum.internal.RequestBatchFactory r0 = r12.batchFactory     // Catch:{ all -> 0x0175 }
            r0.deleteFinishedBatch(r1)     // Catch:{ all -> 0x0175 }
            r12.invokeCallbacksWithError(r2)     // Catch:{ all -> 0x0175 }
            if (r11 == 0) goto L_0x0181
            goto L_0x0109
        L_0x0175:
            r0 = move-exception
            r2 = r11
        L_0x0177:
            if (r2 == 0) goto L_0x017c
            r2.disconnect()     // Catch:{ all -> 0x017d }
        L_0x017c:
            throw r0     // Catch:{ all -> 0x017d }
        L_0x017d:
            r0 = move-exception
            com.leanplum.internal.Log.exception(r0)
        L_0x0181:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.RequestSender.sendRequests():void");
    }
}
