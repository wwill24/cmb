package com.leanplum.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.leanplum.ActionContext;
import com.leanplum.Leanplum;
import com.leanplum.LeanplumLocalPushListenerService;
import com.leanplum.internal.Constants;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import com.leanplum.utils.BuildUtil;
import com.leanplum.utils.SharedPreferencesUtil;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

class LeanplumLocalPushHelper {
    LeanplumLocalPushHelper() {
    }

    private static void cancelAlarm(Context context, String str) {
        try {
            Intent intent = LeanplumLocalPushListenerService.getIntent(context);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, str.hashCode(), intent, BuildUtil.createIntentFlags(134217728));
            if (alarmManager != null && broadcast != null) {
                alarmManager.cancel(broadcast);
            }
        } catch (Throwable unused) {
        }
    }

    static boolean cancelLocalPush(@NonNull String str) {
        try {
            Context context = Leanplum.getContext();
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.Defaults.MESSAGING_PREF_NAME, 0);
            boolean z10 = true;
            String format2 = String.format(Constants.Defaults.LOCAL_NOTIFICATION_KEY, new Object[]{str});
            long j10 = sharedPreferences.getLong(format2, 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(format2);
            SharedPreferencesUtil.commitChanges(edit);
            cancelAlarm(context, str);
            if (j10 <= Clock.getInstance().currentTimeMillis()) {
                z10 = false;
            }
            if (z10) {
                Log.i("Cancelled notification", new Object[0]);
            }
            return z10;
        } catch (Throwable th2) {
            Log.exception(th2);
            return false;
        }
    }

    private static boolean scheduleAlarm(ActionContext actionContext, String str, long j10) {
        ActionContext actionContext2 = actionContext;
        String str2 = str;
        long j11 = j10;
        try {
            Context context = Leanplum.getContext();
            Intent intent = LeanplumLocalPushListenerService.getIntent(context);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.Defaults.MESSAGING_PREF_NAME, 0);
            long j12 = sharedPreferences.getLong(String.format(Constants.Defaults.LOCAL_NOTIFICATION_KEY, new Object[]{str2}), 0);
            if (j12 > 0 && j12 > System.currentTimeMillis()) {
                int i10 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                if (i10 < 0) {
                    return false;
                }
                if (i10 >= 0) {
                    alarmManager.cancel(PendingIntent.getBroadcast(context, str.hashCode(), intent, BuildUtil.createIntentFlags(134217728)));
                }
            }
            Map map = (Map) actionContext2.objectNamed("Advanced options.Data");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    intent.putExtra(str3, (Serializable) map.get(str3));
                }
            }
            intent.putExtra(Constants.Keys.PUSH_OCCURRENCE_ID, UUID.randomUUID().toString());
            String stringNamed = actionContext2.stringNamed(Constants.Values.DEFAULT_PUSH_ACTION);
            Boolean bool = Boolean.TRUE;
            boolean equals = bool.equals(actionContext2.objectNamed("Advanced options.Mute inside app"));
            if (stringNamed != null) {
                if (equals) {
                    intent.putExtra(Constants.Keys.PUSH_MESSAGE_ID_MUTE_WITH_ACTION, str2);
                } else {
                    intent.putExtra(Constants.Keys.PUSH_MESSAGE_ID_NO_MUTE_WITH_ACTION, str2);
                }
            } else if (equals) {
                intent.putExtra(Constants.Keys.PUSH_MESSAGE_ID_MUTE, str2);
            } else {
                intent.putExtra(Constants.Keys.PUSH_MESSAGE_ID_NO_MUTE, str2);
            }
            String stringNamed2 = actionContext2.stringNamed(MessageTemplateConstants.Args.MESSAGE);
            if (stringNamed2 == null) {
                stringNamed2 = Constants.Values.DEFAULT_PUSH_MESSAGE;
            }
            intent.putExtra(Constants.Keys.PUSH_MESSAGE_TEXT, stringNamed2);
            String stringNamed3 = actionContext2.stringNamed("Android options.Collapse key");
            if (stringNamed3 != null) {
                intent.putExtra("collapseKey", stringNamed3);
            }
            if (bool.equals(actionContext2.objectNamed("Android options.Delay while idle"))) {
                intent.putExtra("delayWhileIdle", true);
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, str.hashCode(), intent, BuildUtil.createIntentFlags(134217728));
            if (Util.isXiaomiDevice()) {
                alarmManager.setExact(0, j11, broadcast);
            } else {
                alarmManager.set(0, j11, broadcast);
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(String.format(Constants.Defaults.LOCAL_NOTIFICATION_KEY, new Object[]{str2}), j11);
            SharedPreferencesUtil.commitChanges(edit);
            Log.i("Scheduling local notification.", new Object[0]);
            return true;
        } catch (Throwable th2) {
            Log.exception(th2);
            return false;
        }
    }

    static boolean scheduleLocalPush(@NonNull ActionContext actionContext) {
        Object obj;
        try {
            String messageId = actionContext.getMessageId();
            if (actionContext.isPreview()) {
                obj = Double.valueOf(5.0d);
            } else {
                Map map = (Map) CollectionUtil.uncheckedCast(VarCache.getMessageDiffs().get(messageId));
                if (map == null) {
                    Log.e("Could not find message options for ID " + messageId, new Object[0]);
                    return false;
                }
                obj = map.get("countdown");
            }
            if (obj instanceof Number) {
                return scheduleAlarm(actionContext, messageId, Clock.getInstance().currentTimeMillis() + (((Number) obj).longValue() * 1000));
            }
            Log.e("Invalid notification countdown: " + obj, new Object[0]);
            return false;
        } catch (Throwable th2) {
            Log.exception(th2);
            return false;
        }
    }
}
