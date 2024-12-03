package com.leanplum;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.leanplum.internal.CollectionUtil;
import com.leanplum.internal.Constants;
import com.leanplum.internal.JsonConverter;
import com.leanplum.internal.Log;
import com.leanplum.utils.BuildUtil;
import com.leanplum.utils.SharedPreferencesUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.a;

@TargetApi(26)
class LeanplumNotificationChannel {

    @TargetApi(26)
    private static class NotificationChannelData {
        boolean bypassDnd = false;
        String description;
        boolean enableLights = false;
        boolean enableVibration = false;
        String groupId;

        /* renamed from: id  reason: collision with root package name */
        String f22181id;
        int importance = 3;
        int lightColor = 0;
        int lockscreenVisibility = 1;
        String name;
        boolean showBadge = false;
        long[] vibrationPattern = null;

        NotificationChannelData(Map<String, Object> map) {
            this.f22181id = (String) map.get("id");
            this.name = (String) map.get("name");
            this.description = (String) map.get("description");
            this.groupId = (String) map.get("groupId");
            this.importance = ((Integer) CollectionUtil.getOrDefault(map, "importance", Integer.valueOf(this.importance))).intValue();
            this.enableLights = ((Boolean) CollectionUtil.getOrDefault(map, "enable_lights", Boolean.valueOf(this.enableLights))).booleanValue();
            this.lightColor = ((Integer) CollectionUtil.getOrDefault(map, "light_color", Integer.valueOf(this.lightColor))).intValue();
            this.enableVibration = ((Boolean) CollectionUtil.getOrDefault(map, "enable_vibration", Boolean.valueOf(this.enableVibration))).booleanValue();
            this.lockscreenVisibility = ((Integer) CollectionUtil.getOrDefault(map, "lockscreen_visibility", Integer.valueOf(this.lockscreenVisibility))).intValue();
            this.bypassDnd = ((Boolean) CollectionUtil.getOrDefault(map, "bypass_dnd", Boolean.valueOf(this.bypassDnd))).booleanValue();
            this.showBadge = ((Boolean) CollectionUtil.getOrDefault(map, "show_badge", Boolean.valueOf(this.showBadge))).booleanValue();
            try {
                List list = (List) CollectionUtil.uncheckedCast(CollectionUtil.getOrDefault(map, "vibration_pattern", null));
                if (list != null) {
                    this.vibrationPattern = new long[list.size()];
                    Iterator it = list.iterator();
                    for (int i10 = 0; i10 < this.vibrationPattern.length; i10++) {
                        Number number = (Number) it.next();
                        if (number != null) {
                            this.vibrationPattern[i10] = number.longValue();
                        }
                    }
                }
            } catch (Exception unused) {
                Log.d("Failed to parse vibration pattern.", new Object[0]);
            }
            int i11 = this.importance;
            if (i11 < 0 && i11 > 5) {
                this.importance = 3;
            }
            int i12 = this.lockscreenVisibility;
            if (i12 < -1 && i12 > 1) {
                this.lockscreenVisibility = 1;
            }
        }
    }

    @TargetApi(26)
    private static class NotificationGroupData {

        /* renamed from: id  reason: collision with root package name */
        String f22182id;
        String name;

        NotificationGroupData(Map<String, Object> map) {
            this.f22182id = (String) map.get("id");
            this.name = (String) map.get("name");
        }
    }

    LeanplumNotificationChannel() {
    }

    static void configureChannels(Context context, a aVar, a aVar2, String str) {
        configureNotificationGroups(context, aVar);
        configureNotificationChannels(context, aVar2);
        configureDefaultNotificationChannel(context, str);
    }

    static void configureDefaultNotificationChannel(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    storeDefaultNotificationChannel(context, str);
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    static void configureNotificationChannels(Context context, a aVar) {
        if (context != null && aVar != null) {
            try {
                List<HashMap<String, Object>> retrieveNotificationChannels = retrieveNotificationChannels(context);
                List<HashMap> listFromJson = JsonConverter.listFromJson(aVar);
                if (!(retrieveNotificationChannels == null || listFromJson == null)) {
                    retrieveNotificationChannels.removeAll(listFromJson);
                    for (HashMap next : retrieveNotificationChannels) {
                        if (next != null) {
                            deleteNotificationChannel(context, (String) next.get("id"));
                        }
                    }
                }
                storeNotificationChannels(context, listFromJson);
                if (listFromJson != null) {
                    for (HashMap hashMap : listFromJson) {
                        if (hashMap != null) {
                            createNotificationChannel(context, hashMap);
                        }
                    }
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    static void configureNotificationGroups(Context context, a aVar) {
        if (context != null && aVar != null) {
            try {
                List<HashMap<String, Object>> retrieveNotificationGroups = retrieveNotificationGroups(context);
                List<HashMap> listFromJson = JsonConverter.listFromJson(aVar);
                if (!(retrieveNotificationGroups == null || listFromJson == null)) {
                    retrieveNotificationGroups.removeAll(listFromJson);
                    for (HashMap next : retrieveNotificationGroups) {
                        if (next != null) {
                            deleteNotificationGroup(context, (String) next.get("id"));
                        }
                    }
                }
                storeNotificationGroups(context, listFromJson);
                if (listFromJson != null) {
                    for (HashMap hashMap : listFromJson) {
                        if (hashMap != null) {
                            createNotificationGroup(context, hashMap);
                        }
                    }
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    static String createNotificationChannel(Context context, Map<String, Object> map) {
        Map<String, Object> map2 = map;
        if (!(context == null || map2 == null)) {
            try {
                NotificationChannelData notificationChannelData = new NotificationChannelData(map2);
                createNotificationChannel(context, notificationChannelData.f22181id, notificationChannelData.name, notificationChannelData.importance, notificationChannelData.description, notificationChannelData.groupId, notificationChannelData.enableLights, notificationChannelData.lightColor, notificationChannelData.enableVibration, notificationChannelData.vibrationPattern, notificationChannelData.lockscreenVisibility, notificationChannelData.bypassDnd, notificationChannelData.showBadge);
                return notificationChannelData.f22181id;
            } catch (Exception unused) {
                Log.e("Failed to create notification channel.", new Object[0]);
            }
        }
        return null;
    }

    private static String createNotificationGroup(Context context, Map<String, Object> map) {
        if (context == null || map == null) {
            return null;
        }
        NotificationGroupData notificationGroupData = new NotificationGroupData(map);
        createNotificationGroup(context, notificationGroupData.f22182id, notificationGroupData.name);
        return notificationGroupData.f22182id;
    }

    private static void deleteNotificationChannel(Context context, String str) {
        if (context != null && BuildUtil.isNotificationChannelSupported(context)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager == null) {
                    Log.e("Notification manager is null", new Object[0]);
                } else {
                    notificationManager.deleteNotificationChannel(str);
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    private static void deleteNotificationGroup(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str) && BuildUtil.isNotificationChannelSupported(context)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager == null) {
                    Log.e("Notification manager is null", new Object[0]);
                } else {
                    notificationManager.deleteNotificationChannelGroup(str);
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    static String getDefaultNotificationChannelId(Context context) {
        if (BuildUtil.isNotificationChannelSupported(context)) {
            return retrieveDefaultNotificationChannel(context);
        }
        return null;
    }

    static List<NotificationChannel> getNotificationChannels(Context context) {
        if (!BuildUtil.isNotificationChannelSupported(context)) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            return notificationManager.getNotificationChannels();
        }
        Log.e("Notification manager is null", new Object[0]);
        return null;
    }

    static List<NotificationChannelGroup> getNotificationGroups(Context context) {
        if (!BuildUtil.isNotificationChannelSupported(context)) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            return notificationManager.getNotificationChannelGroups();
        }
        Log.e("Cannot get Notification Channel Groups, notificationManager is null.", new Object[0]);
        return null;
    }

    private static String retrieveDefaultNotificationChannel(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0).getString(Constants.Defaults.DEFAULT_NOTIFICATION_CHANNEL_KEY, (String) null);
        } catch (Exception unused) {
            Log.e("Failed to convert default notification channels json.", new Object[0]);
            return null;
        }
    }

    private static List<HashMap<String, Object>> retrieveNotificationChannels(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String string = context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0).getString(Constants.Defaults.NOTIFICATION_CHANNELS_KEY, (String) null);
            if (string == null) {
                return null;
            }
            return JsonConverter.listFromJson(new a(string));
        } catch (Exception unused) {
            Log.e("Failed to convert notification channels json.", new Object[0]);
            return null;
        }
    }

    private static List<HashMap<String, Object>> retrieveNotificationGroups(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String string = context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0).getString(Constants.Defaults.NOTIFICATION_GROUPS_KEY, (String) null);
            if (string == null) {
                return null;
            }
            return JsonConverter.listFromJson(new a(string));
        } catch (Exception unused) {
            Log.e("Failed to convert notification channels json.", new Object[0]);
            return null;
        }
    }

    private static void storeDefaultNotificationChannel(Context context, String str) {
        if (context != null && str != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0).edit();
            edit.putString(Constants.Defaults.DEFAULT_NOTIFICATION_CHANNEL_KEY, str);
            SharedPreferencesUtil.commitChanges(edit);
        }
    }

    private static void storeNotificationChannels(Context context, List<HashMap<String, Object>> list) {
        if (context != null && list != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0).edit();
            edit.putString(Constants.Defaults.NOTIFICATION_CHANNELS_KEY, new a((Collection<?>) list).toString());
            SharedPreferencesUtil.commitChanges(edit);
        }
    }

    private static void storeNotificationGroups(Context context, List<HashMap<String, Object>> list) {
        if (context != null && list != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0).edit();
            edit.putString(Constants.Defaults.NOTIFICATION_GROUPS_KEY, new a((Collection<?>) list).toString());
            SharedPreferencesUtil.commitChanges(edit);
        }
    }

    private static void createNotificationGroup(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && BuildUtil.isNotificationChannelSupported(context)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager == null) {
                    Log.e("Notification manager is null", new Object[0]);
                } else {
                    notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(str, str2));
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    private static void createNotificationChannel(Context context, String str, String str2, int i10, String str3, String str4, boolean z10, int i11, boolean z11, long[] jArr, int i12, boolean z12, boolean z13) {
        if (context != null && !TextUtils.isEmpty(str) && BuildUtil.isNotificationChannelSupported(context)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                if (notificationManager == null) {
                    Log.e("Notification manager is null", new Object[0]);
                    return;
                }
                NotificationChannel notificationChannel = new NotificationChannel(str, str2, i10);
                if (!TextUtils.isEmpty(str3)) {
                    notificationChannel.setDescription(str3);
                }
                if (z10) {
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(i11);
                }
                if (z11) {
                    notificationChannel.enableVibration(true);
                    if (!(jArr == null || jArr.length == 0)) {
                        notificationChannel.setVibrationPattern(jArr);
                    }
                }
                if (!TextUtils.isEmpty(str4)) {
                    notificationChannel.setGroup(str4);
                }
                notificationChannel.setLockscreenVisibility(i12);
                notificationChannel.setBypassDnd(z12);
                notificationChannel.setShowBadge(z13);
                notificationManager.createNotificationChannel(notificationChannel);
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }
}
