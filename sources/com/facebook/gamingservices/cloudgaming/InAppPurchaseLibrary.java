package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.b;

public class InAppPurchaseLibrary {
    public static void cancelSubscription(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put(SDKConstants.PARAM_PURCHASE_TOKEN, (Object) str), callback, SDKMessageEnum.CANCEL_SUBSCRIPTION);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.CANCEL_SUBSCRIPTION, e10);
        }
    }

    public static void consumePurchase(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put(SDKConstants.PARAM_PURCHASE_TOKEN, (Object) str), callback, SDKMessageEnum.CONSUME_PURCHASE);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.CONSUME_PURCHASE, e10);
        }
    }

    public static void getCatalog(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (b) null, callback, SDKMessageEnum.GET_CATALOG);
    }

    public static void getPurchases(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (b) null, callback, SDKMessageEnum.GET_PURCHASES);
    }

    public static void getSubscribableCatalog(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (b) null, callback, SDKMessageEnum.GET_SUBSCRIBABLE_CATALOG);
    }

    public static void getSubscriptions(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (b) null, callback, SDKMessageEnum.GET_SUBSCRIPTIONS);
    }

    public static void onReady(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (b) null, callback, SDKMessageEnum.ON_READY);
    }

    public static void purchase(Context context, String str, String str2, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put(SDKConstants.PARAM_PRODUCT_ID, (Object) str).put(SDKConstants.PARAM_DEVELOPER_PAYLOAD, (Object) str2), callback, SDKMessageEnum.PURCHASE);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.PURCHASE, e10);
        }
    }

    public static void purchaseSubscription(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put(SDKConstants.PARAM_PRODUCT_ID, (Object) str), callback, SDKMessageEnum.PURCHASE_SUBSCRIPTION);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.PURCHASE_SUBSCRIPTION, e10);
        }
    }
}
