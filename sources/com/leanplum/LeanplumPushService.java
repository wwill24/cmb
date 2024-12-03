package com.leanplum;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.p;
import com.leanplum.callbacks.VariablesChangedCallback;
import com.leanplum.internal.ActionManager;
import com.leanplum.internal.Constants;
import com.leanplum.internal.JsonConverter;
import com.leanplum.internal.LeanplumInternal;
import com.leanplum.internal.Log;
import com.leanplum.internal.PushActionPersistenceKt;
import com.leanplum.internal.Request;
import com.leanplum.internal.RequestBuilder;
import com.leanplum.internal.RequestSender;
import com.leanplum.internal.Util;
import com.leanplum.internal.VarCache;
import com.leanplum.utils.BuildUtil;
import com.mparticle.kits.LeanplumKit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.b;

public class LeanplumPushService {
    public static final String LEANPLUM_ACTION_PARAM = "lp_action_param";
    public static final String LEANPLUM_MESSAGE_ID = "lp_message_id";
    public static final String LEANPLUM_MESSAGE_PARAM = "lp_message_param";
    public static final String LEANPLUM_NOTIFICATION = "LP_NOTIFICATION";
    public static final String LEANPLUM_SENDER_ID = "44059457771";
    private static final int NOTIFICATION_ID = 1;
    private static final String OPEN_ACTION = "Open";
    private static final String OPEN_URL = "Open URL";
    private static final String URL = "URL";
    private static Class<? extends Activity> callbackClass;
    private static LeanplumPushNotificationCustomizer customizer;
    private static final PushProviders pushProviders = new PushProviders();
    private static boolean useNotificationBuilderCustomizer = false;

    /* access modifiers changed from: private */
    public static boolean areActionsEmbedded(Bundle bundle) {
        return bundle.containsKey(Constants.Keys.PUSH_MESSAGE_ACTION);
    }

    @TargetApi(31)
    private static Intent createActivityIntent(Context context, Bundle bundle) {
        Intent deepLinkIntent;
        String string = bundle.getString(Constants.Keys.PUSH_MESSAGE_ACTION);
        if (string == null || !string.contains("Open URL") || (deepLinkIntent = getDeepLinkIntent(bundle)) == null) {
            Intent actionIntent = getActionIntent(context);
            if (actionIntent == null) {
                return null;
            }
            actionIntent.putExtras(bundle);
            actionIntent.addFlags(335544320);
            return actionIntent;
        }
        resolveIntentActivity(context, deepLinkIntent);
        if (getMessageId(bundle) != null) {
            deepLinkIntent.putExtras(bundle);
        }
        return deepLinkIntent;
    }

    private static Intent createBroadcastIntent(Context context, Bundle bundle) {
        Intent intent = new Intent(context, LeanplumPushReceiver.class);
        intent.addCategory("lpAction");
        intent.putExtras(bundle);
        return intent;
    }

    private static PendingIntent createContentIntent(Context context, Bundle bundle) {
        if (BuildUtil.shouldDisableTrampolines(context)) {
            return PendingIntent.getActivity(context, new Random().nextInt(), createActivityIntent(context, bundle), BuildUtil.createIntentFlags(134217728));
        }
        return PendingIntent.getBroadcast(context.getApplicationContext(), new Random().nextInt(), createBroadcastIntent(context, bundle), BuildUtil.createIntentFlags(0));
    }

    private static Intent getActionIntent(Context context) {
        Class<? extends Activity> callbackClass2 = getCallbackClass();
        if (callbackClass2 != null) {
            return new Intent(context, callbackClass2);
        }
        return context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
    }

    private static Class<? extends Activity> getCallbackClass() {
        return callbackClass;
    }

    private static Intent getDeepLinkIntent(Bundle bundle) {
        try {
            String string = bundle.getString(Constants.Keys.PUSH_MESSAGE_ACTION);
            if (string == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(new b(string).getString("URL")));
            intent.setFlags(268435456);
            return intent;
        } catch (JSONException unused) {
            return null;
        }
    }

    static String getMessageId(Bundle bundle) {
        String string = bundle.getString(Constants.Keys.PUSH_MESSAGE_ID_NO_MUTE_WITH_ACTION);
        if (string == null && (string = bundle.getString(Constants.Keys.PUSH_MESSAGE_ID_MUTE_WITH_ACTION)) == null && (string = bundle.getString(Constants.Keys.PUSH_MESSAGE_ID_NO_MUTE)) == null) {
            string = bundle.getString(Constants.Keys.PUSH_MESSAGE_ID_MUTE);
        }
        if (string != null) {
            bundle.putString(Constants.Keys.PUSH_MESSAGE_ID, string);
        }
        return string;
    }

    @NonNull
    static PushProviders getPushProviders() {
        return pushProviders;
    }

    static void handleNotification(Context context, Bundle bundle) {
        PushTracking.trackDelivery(context, bundle);
        if (PushTracking.isFcmSilentPush(bundle) || shouldMuteNotification(bundle)) {
            return;
        }
        if (getMessageId(bundle) == null || !LeanplumInternal.hasCalledStart()) {
            showNotification(context, bundle);
        } else {
            showNotification(context, bundle);
        }
    }

    private static boolean isActivityWithIntentStarted(Context context, Bundle bundle) {
        Intent deepLinkIntent;
        String string = bundle.getString(Constants.Keys.PUSH_MESSAGE_ACTION);
        if (!(string == null || !string.contains("Open URL") || (deepLinkIntent = getDeepLinkIntent(bundle)) == null)) {
            resolveIntentActivity(context, deepLinkIntent);
            String messageId = getMessageId(bundle);
            if (messageId != null) {
                try {
                    context.startActivity(deepLinkIntent);
                    new ActionContext(ActionManager.PUSH_NOTIFICATION_ACTION_NAME, (Map<String, Object>) null, messageId).track(OPEN_ACTION, 0.0d, (Map<String, Object>) null);
                    return true;
                } catch (ActivityNotFoundException unused) {
                }
            }
        }
        return false;
    }

    static void onActivityNotificationClick(@NonNull Bundle bundle) {
        if (bundle.containsKey(Constants.Keys.PUSH_OCCURRENCE_ID)) {
            String str = (String) bundle.get(Constants.Keys.PUSH_OCCURRENCE_ID);
            if (PushActionPersistenceKt.isOpened(str)) {
                Log.i("Open Action from activity intent is already executed.", new Object[0]);
                return;
            }
            Log.d("Executing Open Action from push notification.", new Object[0]);
            PushActionPersistenceKt.recordOpenAction(str);
            PushTracking.trackOpen(bundle);
            if (getDeepLinkIntent(bundle) != null) {
                String messageId = getMessageId(bundle);
                if (messageId != null) {
                    new ActionContext(ActionManager.PUSH_NOTIFICATION_ACTION_NAME, (Map<String, Object>) null, messageId).track(OPEN_ACTION, 0.0d, (Map<String, Object>) null);
                    return;
                }
                return;
            }
            performActionAfterIssuedStart(bundle);
            return;
        }
        Log.i("Skipping execution of Open Action because occurrenceId is missing.", new Object[0]);
    }

    static void onStart() {
        PushProviders pushProviders2 = pushProviders;
        pushProviders2.init();
        pushProviders2.updateRegistrationIdsAndBackend();
    }

    static void openNotification(Context context, Intent intent) {
        Bundle preHandlePushNotification = preHandlePushNotification(context, intent);
        if (preHandlePushNotification != null) {
            openNotification(context, preHandlePushNotification);
        }
    }

    public static Map<String, Object> parseNotificationBundle(Bundle bundle) {
        try {
            String string = bundle.getString(Constants.Keys.PUSH_MESSAGE_ACTION);
            String string2 = bundle.getString(Constants.Keys.PUSH_MESSAGE_TEXT);
            String messageId = getMessageId(bundle);
            HashMap hashMap = new HashMap();
            hashMap.put(LEANPLUM_ACTION_PARAM, JsonConverter.fromJson(string));
            hashMap.put(LEANPLUM_MESSAGE_PARAM, string2);
            hashMap.put(LEANPLUM_MESSAGE_ID, messageId);
            return hashMap;
        } catch (Throwable unused) {
            Log.i("Failed to parse notification bundle.", new Object[0]);
            return null;
        }
    }

    private static void performActionAfterIssuedStart(@NonNull Bundle bundle) {
        LeanplumInternal.addStartIssuedHandler(new v(bundle));
    }

    /* access modifiers changed from: private */
    public static void performPushNotificationAction(@NonNull final Bundle bundle) {
        LeanplumActivityHelper.queueActionUponActive(new VariablesChangedCallback() {
            public void variablesChanged() {
                try {
                    final String messageId = LeanplumPushService.getMessageId(bundle);
                    if (messageId == null) {
                        return;
                    }
                    if (LeanplumPushService.areActionsEmbedded(bundle)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(Constants.Values.DEFAULT_PUSH_ACTION, JsonConverter.fromJson(bundle.getString(Constants.Keys.PUSH_MESSAGE_ACTION)));
                        ActionContext actionContext = new ActionContext(ActionManager.PUSH_NOTIFICATION_ACTION_NAME, hashMap, messageId);
                        actionContext.preventRealtimeUpdating();
                        actionContext.update();
                        actionContext.runTrackedActionNamed(Constants.Values.DEFAULT_PUSH_ACTION);
                        return;
                    }
                    Leanplum.addOnceVariablesChangedAndNoDownloadsPendingHandler(new VariablesChangedCallback() {
                        public void variablesChanged() {
                            try {
                                LeanplumPushService.requireMessageContent(messageId, new VariablesChangedCallback() {
                                    public void variablesChanged() {
                                        try {
                                            LeanplumInternal.performTrackedAction(Constants.Values.DEFAULT_PUSH_ACTION, messageId);
                                        } catch (Throwable th2) {
                                            Log.exception(th2);
                                        }
                                    }
                                });
                            } catch (Throwable th2) {
                                Log.exception(th2);
                            }
                        }
                    });
                } catch (Throwable th2) {
                    Log.exception(th2);
                }
            }
        });
    }

    public static void postHandlePushNotification(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.d("Could not post handle push notification, extras are null.", new Object[0]);
        } else {
            performActionAfterIssuedStart(extras);
        }
    }

    public static Bundle preHandlePushNotification(Context context, Intent intent) {
        if (intent == null) {
            Log.i("Unable to pre handle push notification, Intent is null.", new Object[0]);
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return extras;
        }
        Log.i("Unable to pre handle push notification, extras are null.", new Object[0]);
        return null;
    }

    /* access modifiers changed from: private */
    public static void requireMessageContent(final String str, final VariablesChangedCallback variablesChangedCallback) {
        Leanplum.addOnceVariablesChangedAndNoDownloadsPendingHandler(new VariablesChangedCallback() {
            public void variablesChanged() {
                try {
                    Map<String, Object> messages = VarCache.messages();
                    String str = str;
                    if (str != null) {
                        if (messages == null || !messages.containsKey(str)) {
                            Request create = RequestBuilder.withGetVarsAction().andParam(Constants.Params.INCLUDE_DEFAULTS, Boolean.toString(false)).andParam(Constants.Params.INCLUDE_MESSAGE_ID, str).andType(Request.RequestType.IMMEDIATE).create();
                            create.onResponse(new Request.ResponseCallback() {
                                public void response(b bVar) {
                                    String str;
                                    if (bVar == null) {
                                        try {
                                            Log.e("No response received from the server. Please contact us to investigate.", new Object[0]);
                                        } catch (Throwable th2) {
                                            Log.exception(th2);
                                            return;
                                        }
                                    } else {
                                        Map mapFromJson = JsonConverter.mapFromJson(bVar.optJSONObject("vars"));
                                        Map mapFromJson2 = JsonConverter.mapFromJson(bVar.optJSONObject(Constants.Keys.MESSAGES));
                                        Map mapFromJson3 = JsonConverter.mapFromJson(bVar.optJSONObject("regions"));
                                        List listFromJson = JsonConverter.listFromJson(bVar.optJSONArray(Constants.Keys.VARIANTS));
                                        List listFromJson2 = JsonConverter.listFromJson(bVar.optJSONArray(Constants.Keys.LOCAL_CAPS));
                                        b optJSONObject = bVar.optJSONObject("vars");
                                        if (optJSONObject != null) {
                                            str = optJSONObject.toString();
                                        } else {
                                            str = null;
                                        }
                                        VarCache.applyVariableDiffs(mapFromJson, mapFromJson2, mapFromJson3, listFromJson, listFromJson2, (Map<String, Object>) null, str, bVar.optString(Constants.Keys.VARS_SIGNATURE));
                                    }
                                    variablesChangedCallback.variablesChanged();
                                }
                            });
                            create.onError(new Request.ErrorCallback() {
                                public void error(Exception exc) {
                                    variablesChangedCallback.variablesChanged();
                                }
                            });
                            RequestSender.getInstance().send(create);
                            return;
                        }
                    }
                    variablesChangedCallback.variablesChanged();
                } catch (Throwable th2) {
                    Log.exception(th2);
                }
            }
        });
    }

    private static void resolveIntentActivity(Context context, Intent intent) {
        ActivityInfo activityInfo;
        String str;
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
            for (ResolveInfo next : queryIntentActivities) {
                if (next != null && (activityInfo = next.activityInfo) != null && (str = activityInfo.name) != null) {
                    if (str.contains(context.getPackageName())) {
                        intent.setPackage(next.activityInfo.packageName);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static void setCustomizer(LeanplumPushNotificationCustomizer leanplumPushNotificationCustomizer) {
        setCustomizer(leanplumPushNotificationCustomizer, false);
    }

    public static void setDefaultCallbackClass(Class<? extends Activity> cls) {
        callbackClass = cls;
    }

    static boolean shouldMuteNotification(@NonNull Bundle bundle) {
        if (LeanplumActivityHelper.getCurrentActivity() == null || LeanplumActivityHelper.isActivityPaused || (!bundle.containsKey(Constants.Keys.PUSH_MESSAGE_ID_MUTE_WITH_ACTION) && !bundle.containsKey(Constants.Keys.PUSH_MESSAGE_ID_MUTE))) {
            return false;
        }
        return true;
    }

    static void showDeviceRegisteredPush(Context context, Context context2) {
        try {
            p.e defaultCompatNotificationBuilder = LeanplumNotificationHelper.getDefaultCompatNotificationBuilder(context, BuildUtil.isNotificationChannelSupported(context));
            if (defaultCompatNotificationBuilder != null) {
                defaultCompatNotificationBuilder.x(17301620).m(LeanplumKit.NAME).l("Your device is registered.");
                defaultCompatNotificationBuilder.k(PendingIntent.getActivity(context2.getApplicationContext(), 0, new Intent(), BuildUtil.createIntentFlags(0)));
                ((NotificationManager) context2.getSystemService("notification")).notify(0, defaultCompatNotificationBuilder.b());
            }
        } catch (Throwable unused) {
        }
    }

    @TargetApi(16)
    private static void showNotification(Context context, Bundle bundle) {
        int i10;
        Notification.Builder builder;
        p.e eVar;
        boolean z10;
        int i11;
        String string;
        Context context2 = context;
        Bundle bundle2 = bundle;
        if (context2 != null && bundle2 != null) {
            if (!LeanplumNotificationHelper.isApplicationIconValid(context)) {
                i10 = LeanplumNotificationHelper.getDefaultPushNotificationIconResourceId(context);
            } else {
                i10 = 0;
            }
            NotificationManager notificationManager = (NotificationManager) context2.getSystemService("notification");
            if (notificationManager != null) {
                PendingIntent createContentIntent = createContentIntent(context, bundle);
                String applicationName = Util.getApplicationName(context.getApplicationContext());
                if (bundle2.getString("title") != null) {
                    applicationName = bundle2.getString("title");
                }
                String str = applicationName;
                String string2 = bundle2.getString(Constants.Keys.PUSH_MESSAGE_TEXT);
                Bitmap bigPictureBitmap = LeanplumNotificationHelper.getBigPictureBitmap(context2, bundle2.getString(Constants.Keys.PUSH_MESSAGE_IMAGE_URL));
                if (customizer == null || useNotificationBuilderCustomizer) {
                    builder = LeanplumNotificationHelper.getNotificationBuilder(context, bundle, createContentIntent, str, string2, i10);
                    eVar = null;
                } else {
                    eVar = LeanplumNotificationHelper.getNotificationCompatBuilder(context, bundle, createContentIntent, str, string2, bigPictureBitmap, i10);
                    builder = null;
                }
                if (eVar != null || builder != null) {
                    LeanplumPushNotificationCustomizer leanplumPushNotificationCustomizer = customizer;
                    if (leanplumPushNotificationCustomizer != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    boolean z11 = useNotificationBuilderCustomizer;
                    if ((z10 && (!z11)) && eVar == null) {
                        return;
                    }
                    if (leanplumPushNotificationCustomizer != null && z11 && builder == null) {
                        return;
                    }
                    if (leanplumPushNotificationCustomizer != null || builder != null) {
                        if (leanplumPushNotificationCustomizer != null) {
                            if (!z11) {
                                leanplumPushNotificationCustomizer.customize(eVar, bundle2);
                            } else if (bigPictureBitmap != null) {
                                try {
                                    Notification.BigPictureStyle bigPictureStyle = LeanplumNotificationHelper.getBigPictureStyle(bundle2, bigPictureBitmap, str, string2);
                                    customizer.customize(builder, bundle2, bigPictureStyle);
                                    LeanplumNotificationHelper.setModifiedBigPictureStyle(builder, bigPictureStyle);
                                } catch (Throwable th2) {
                                    Log.e("Unable to customize push notification: %s", Log.getStackTraceString(th2));
                                    return;
                                }
                            } else {
                                leanplumPushNotificationCustomizer.customize(builder, bundle2, (Notification.Style) null);
                            }
                        } else if (bigPictureBitmap != null) {
                            LeanplumNotificationHelper.setModifiedBigPictureStyle(builder, LeanplumNotificationHelper.getBigPictureStyle(bundle2, bigPictureBitmap, str, string2));
                        }
                        Object obj = bundle2.get(Constants.Keys.PUSH_MESSAGE_NOTIFICATION_ID);
                        if (obj instanceof Number) {
                            i11 = ((Number) obj).intValue();
                        } else if (obj instanceof String) {
                            try {
                                i11 = Integer.parseInt((String) obj);
                            } catch (NumberFormatException unused) {
                            }
                        } else {
                            if (bundle2.containsKey(Constants.Keys.PUSH_MESSAGE_ID) && (string = bundle2.getString(Constants.Keys.PUSH_MESSAGE_ID)) != null) {
                                i11 = string.hashCode();
                            }
                            i11 = 1;
                        }
                        try {
                            if (ActionContext.shouldFetchChainedMessage(JsonConverter.fromJson(bundle2.getString(Constants.Keys.PUSH_MESSAGE_ACTION)))) {
                                final CountDownLatch countDownLatch = new CountDownLatch(1);
                                Leanplum.forceContentUpdate((VariablesChangedCallback) new VariablesChangedCallback() {
                                    public void variablesChanged() {
                                        countDownLatch.countDown();
                                    }
                                });
                                countDownLatch.await(3, TimeUnit.SECONDS);
                            }
                            if (builder != null) {
                                notificationManager.notify(i11, builder.build());
                            } else {
                                notificationManager.notify(i11, eVar.b());
                            }
                        } catch (NullPointerException e10) {
                            Log.e("Unable to show push notification.", (Throwable) e10);
                        } catch (Throwable th3) {
                            Log.e("Unable to show push notification.", th3);
                            Log.exception(th3);
                        }
                    }
                }
            }
        }
    }

    public static void unregister() {
        try {
            Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
            Context context = Leanplum.getContext();
            intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), BuildUtil.createIntentFlags(0)));
            intent.setPackage("com.google.android.gms");
            context.startService(intent);
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public static void setCustomizer(LeanplumPushNotificationCustomizer leanplumPushNotificationCustomizer, boolean z10) {
        customizer = leanplumPushNotificationCustomizer;
        useNotificationBuilderCustomizer = z10;
    }

    static void openNotification(Context context, @NonNull Bundle bundle) {
        boolean z10 = false;
        Log.d("Opening push notification action.", new Object[0]);
        PushTracking.trackOpen(bundle);
        if (!isActivityWithIntentStarted(context, bundle)) {
            Class<? extends Activity> callbackClass2 = getCallbackClass();
            Activity currentActivity = LeanplumActivityHelper.getCurrentActivity();
            if (currentActivity == null || LeanplumActivityHelper.isActivityPaused || (callbackClass2 != null && !callbackClass2.isInstance(currentActivity))) {
                z10 = true;
            }
            if (z10) {
                Intent actionIntent = getActionIntent(context);
                if (actionIntent != null) {
                    actionIntent.putExtras(bundle);
                    actionIntent.addFlags(335544320);
                    context.startActivity(actionIntent);
                } else {
                    return;
                }
            }
            performActionAfterIssuedStart(bundle);
        }
    }
}
