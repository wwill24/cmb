package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.Intent;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.b;

public class DaemonRequest {
    /* access modifiers changed from: private */
    public Callback mCallback;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public SDKLogger mLogger;
    /* access modifiers changed from: private */
    public b mParameters;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, CompletableFuture<GraphResponse>> mRequestStore;

    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    DaemonRequest(Context context, b bVar, Callback callback) {
        this.mContext = context;
        this.mParameters = bVar;
        this.mCallback = callback;
        this.mRequestStore = DaemonReceiver.getInstance(context).getRequestStore();
        this.mLogger = SDKLogger.getInstance(context);
    }

    private CompletableFuture<GraphResponse> createRequest() {
        return CompletableFuture.supplyAsync(new Supplier<GraphResponse>() {
            public GraphResponse get() {
                String uuid = UUID.randomUUID().toString();
                try {
                    DaemonRequest.this.mParameters.put(SDKConstants.REQUEST_ID, (Object) uuid);
                    Intent intent = new Intent();
                    String string = DaemonRequest.this.mParameters.getString("type");
                    DaemonRequest.this.mLogger.logPreparingRequest(string, uuid, DaemonRequest.this.mParameters);
                    if (!string.equals(SDKMessageEnum.GET_ACCESS_TOKEN.toString()) && !string.equals(SDKMessageEnum.IS_ENV_READY.toString())) {
                        String string2 = DaemonRequest.this.mContext.getSharedPreferences(SDKConstants.PREF_DAEMON_PACKAGE_NAME, 0).getString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME, (String) null);
                        if (string2 == null) {
                            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request with a secure connection"), uuid);
                        }
                        intent.setPackage(string2);
                    }
                    intent.setAction(SDKConstants.REQUEST_ACTION);
                    Iterator<String> keys = DaemonRequest.this.mParameters.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        intent.putExtra(next, DaemonRequest.this.mParameters.getString(next));
                    }
                    CompletableFuture completableFuture = new CompletableFuture();
                    DaemonRequest.this.mRequestStore.put(uuid, completableFuture);
                    DaemonRequest.this.mContext.sendBroadcast(intent);
                    DaemonRequest.this.mLogger.logSentRequest(string, uuid, DaemonRequest.this.mParameters);
                    return (GraphResponse) completableFuture.get();
                } catch (InterruptedException | ExecutionException | JSONException unused) {
                    return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), uuid);
                }
            }
        });
    }

    private GraphResponse executeAndWait() throws ExecutionException, InterruptedException {
        return createRequest().get();
    }

    private void executeAsync() throws ExecutionException, InterruptedException {
        createRequest().thenAccept(new Consumer<GraphResponse>() {
            public void accept(GraphResponse graphResponse) {
                if (DaemonRequest.this.mCallback != null) {
                    DaemonRequest.this.mCallback.onCompleted(graphResponse);
                }
            }
        });
    }

    private GraphResponse executeAndWait(int i10) throws ExecutionException, InterruptedException, TimeoutException {
        return createRequest().get((long) i10, TimeUnit.SECONDS);
    }

    public static GraphResponse executeAndWait(Context context, b bVar, SDKMessageEnum sDKMessageEnum) {
        b bVar2;
        if (bVar == null) {
            try {
                bVar2 = new b().put("type", (Object) sDKMessageEnum.toString());
            } catch (InterruptedException | ExecutionException | JSONException unused) {
                return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null);
            }
        } else {
            bVar2 = bVar.put("type", (Object) sDKMessageEnum.toString());
        }
        return new DaemonRequest(context, bVar2, (Callback) null).executeAndWait();
    }

    public static void executeAsync(Context context, b bVar, Callback callback, SDKMessageEnum sDKMessageEnum) {
        b bVar2;
        if (bVar == null) {
            try {
                bVar2 = new b().put("type", (Object) sDKMessageEnum.toString());
            } catch (InterruptedException | ExecutionException | JSONException unused) {
                if (callback != null) {
                    callback.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null));
                    return;
                }
                return;
            }
        } else {
            bVar2 = bVar.put("type", (Object) sDKMessageEnum.toString());
        }
        new DaemonRequest(context, bVar2, callback).executeAsync();
    }

    public static GraphResponse executeAndWait(Context context, b bVar, SDKMessageEnum sDKMessageEnum, int i10) {
        b bVar2;
        if (bVar == null) {
            try {
                bVar2 = new b().put("type", (Object) sDKMessageEnum.toString());
            } catch (InterruptedException | ExecutionException | TimeoutException | JSONException unused) {
                return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null);
            }
        } else {
            bVar2 = bVar.put("type", (Object) sDKMessageEnum.toString());
        }
        return new DaemonRequest(context, bVar2, (Callback) null).executeAndWait(i10);
    }

    public static void executeAsync(Context context, b bVar, Callback callback, String str) {
        b bVar2;
        if (bVar == null) {
            try {
                bVar2 = new b().put("type", (Object) str);
            } catch (InterruptedException | ExecutionException | JSONException unused) {
                if (callback != null) {
                    callback.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null));
                    return;
                }
                return;
            }
        } else {
            bVar2 = bVar.put("type", (Object) str);
        }
        new DaemonRequest(context, bVar2, callback).executeAsync();
    }
}
