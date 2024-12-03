package com.facebook.gamingservices.cloudgaming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import java.net.HttpURLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.b;

public class DaemonReceiver {
    private static SDKLogger mLogger;
    /* access modifiers changed from: private */
    public static ConcurrentHashMap<String, CompletableFuture<GraphResponse>> requestStore;
    private static DaemonReceiver single_instance;

    private static class DaemonBroadcastReceiver extends BroadcastReceiver {
        private DaemonBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            CompletableFuture completableFuture;
            try {
                b bVar = new b(intent.getStringExtra(SDKConstants.RECEIVER_PAYLOAD));
                String string = bVar.getString(SDKConstants.REQUEST_ID);
                if (DaemonReceiver.requestStore.containsKey(string) && (completableFuture = (CompletableFuture) DaemonReceiver.requestStore.remove(string)) != null) {
                    completableFuture.complete(DaemonReceiver.processResponse(bVar, string));
                }
            } catch (JSONException unused) {
            }
        }
    }

    private DaemonReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter(SDKConstants.RECEIVER_INTENT);
        HandlerThread handlerThread = new HandlerThread(SDKConstants.RECEIVER_HANDLER);
        handlerThread.start();
        context.registerReceiver(new DaemonBroadcastReceiver(), intentFilter, (String) null, new Handler(handlerThread.getLooper()));
        requestStore = new ConcurrentHashMap<>();
        mLogger = SDKLogger.getInstance(context);
    }

    private static GraphResponse createDefaultErrorResponse(String str) {
        return createErrorResponse(new FacebookRequestError(20, "UNSUPPORTED_FORMAT", "The response format is invalid."), str);
    }

    static GraphResponse createErrorResponse(FacebookRequestError facebookRequestError, String str) {
        mLogger.logSendingErrorResponse(facebookRequestError, str);
        return new GraphResponse(new GraphRequest(), (HttpURLConnection) null, facebookRequestError);
    }

    private static GraphResponse createSuccessResponse(b bVar, String str) {
        if (bVar.optJSONObject("success") != null) {
            mLogger.logSendingSuccessResponse(str);
            return new GraphResponse(new GraphRequest(), (HttpURLConnection) null, "", bVar.optJSONObject("success"));
        } else if (bVar.optJSONArray("success") == null) {
            return createDefaultErrorResponse(str);
        } else {
            mLogger.logSendingSuccessResponse(str);
            return new GraphResponse(new GraphRequest(), (HttpURLConnection) null, "", bVar.optJSONArray("success"));
        }
    }

    static synchronized DaemonReceiver getInstance(Context context) {
        DaemonReceiver daemonReceiver;
        synchronized (DaemonReceiver.class) {
            if (single_instance == null) {
                single_instance = new DaemonReceiver(context);
            }
            daemonReceiver = single_instance;
        }
        return daemonReceiver;
    }

    /* access modifiers changed from: private */
    public static GraphResponse processResponse(b bVar, String str) {
        if (!bVar.isNull("success")) {
            return createSuccessResponse(bVar, str);
        }
        if (!bVar.isNull("error")) {
            return createErrorResponse(bVar, str);
        }
        return createDefaultErrorResponse(str);
    }

    /* access modifiers changed from: package-private */
    public synchronized ConcurrentHashMap<String, CompletableFuture<GraphResponse>> getRequestStore() {
        return requestStore;
    }

    private static GraphResponse createErrorResponse(b bVar, String str) {
        b optJSONObject = bVar.optJSONObject("error");
        if (optJSONObject != null) {
            return createErrorResponse(new FacebookRequestError(optJSONObject.optInt("code"), optJSONObject.optString("type"), optJSONObject.optString("message")), str);
        }
        return createDefaultErrorResponse(str);
    }
}
