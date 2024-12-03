package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.b;

public class GameFeaturesLibrary {
    public static void canCreateShortcut(Context context, b bVar, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, bVar, callback, SDKMessageEnum.CAN_CREATE_SHORTCUT);
    }

    public static void createShortcut(Context context, b bVar, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, bVar, callback, SDKMessageEnum.CREATE_SHORTCUT);
    }

    public static void createTournamentAsync(Context context, int i10, String str, String str2, String str3, String str4, Integer num, b bVar, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put(SDKConstants.PARAM_INITIAL_SCORE, i10).put("title", (Object) str).put("image", (Object) str2).put(SDKConstants.PARAM_SORT_ORDER, (Object) str3).put(SDKConstants.PARAM_SCORE_FORMAT, (Object) str4).put(SDKConstants.PARAM_END_TIME, (Object) num).put("data", (Object) bVar), callback, SDKMessageEnum.TOURNAMENT_CREATE_ASYNC);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.TOURNAMENT_CREATE_ASYNC, e10);
        }
    }

    public static void getPayload(Context context, b bVar, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, bVar, callback, SDKMessageEnum.GET_PAYLOAD);
    }

    public static void getTournamentAsync(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (b) null, callback, SDKMessageEnum.GET_TOURNAMENT_ASYNC);
    }

    public static void getTournamentsAsync(Context context, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, (b) null, callback, SDKMessageEnum.TOURNAMENT_GET_TOURNAMENTS_ASYNC);
    }

    public static void joinTournamentAsync(Context context, String str, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, new b().put(SDKConstants.PARAM_TOURNAMENT_ID, (Object) str), callback, SDKMessageEnum.TOURNAMENT_JOIN_ASYNC);
    }

    public static void performHapticFeedback(Context context) {
        DaemonRequest.executeAsync(context, (b) null, (DaemonRequest.Callback) new DaemonRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
            }
        }, SDKMessageEnum.PERFORM_HAPTIC_FEEDBACK_ASYNC);
    }

    public static void postSessionScore(Context context, int i10, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put("score", i10), callback, SDKMessageEnum.POST_SESSION_SCORE);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.POST_SESSION_SCORE, e10);
        }
    }

    public static void postSessionScoreAsync(Context context, int i10, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put("score", i10), callback, SDKMessageEnum.POST_SESSION_SCORE_ASYNC);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.POST_SESSION_SCORE_ASYNC, e10);
        }
    }

    public static void postTournamentScoreAsync(Context context, int i10, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, new b().put("score", i10), callback, SDKMessageEnum.TOURNAMENT_POST_SCORE_ASYNC);
    }

    public static void shareTournamentAsync(Context context, Integer num, b bVar, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new b().put("score", (Object) num).put("data", (Object) bVar), callback, SDKMessageEnum.TOURNAMENT_SHARE_ASYNC);
        } catch (JSONException e10) {
            SDKLogger.logInternalError(context, SDKMessageEnum.TOURNAMENT_SHARE_ASYNC, e10);
        }
    }
}
