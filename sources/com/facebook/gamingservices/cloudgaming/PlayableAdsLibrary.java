package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.b;

public class PlayableAdsLibrary {
    public static void markGameLoaded(Context context, b bVar, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, bVar, callback, SDKMessageEnum.MARK_GAME_LOADED);
    }

    public static void openAppStore(Context context, b bVar, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, bVar, callback, SDKMessageEnum.OPEN_APP_STORE);
    }
}
