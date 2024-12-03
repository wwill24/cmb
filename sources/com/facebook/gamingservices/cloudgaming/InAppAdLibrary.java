package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.b;

public class InAppAdLibrary {
    public static void loadInterstitialAd(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put(SDKConstants.PARAM_PLACEMENT_ID, (Object) str), callback, SDKMessageEnum.LOAD_INTERSTITIAL_AD);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.LOAD_INTERSTITIAL_AD, e10);
        }
    }

    public static void loadRewardedVideo(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put(SDKConstants.PARAM_PLACEMENT_ID, (Object) str), callback, SDKMessageEnum.LOAD_REWARDED_VIDEO);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.LOAD_REWARDED_VIDEO, e10);
        }
    }

    public static void showInterstitialAd(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put(SDKConstants.PARAM_PLACEMENT_ID, (Object) str), callback, SDKMessageEnum.SHOW_INTERSTITIAL_AD);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.SHOW_INTERSTITIAL_AD, e10);
        }
    }

    public static void showRewardedVideo(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put(SDKConstants.PARAM_PLACEMENT_ID, (Object) str), callback, SDKMessageEnum.SHOW_REWARDED_VIDEO);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.SHOW_REWARDED_VIDEO, e10);
        }
    }
}
