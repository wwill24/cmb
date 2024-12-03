package com.leanplum;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.j0;
import androidx.core.app.p;
import com.leanplum.internal.Constants;
import com.leanplum.internal.JsonConverter;
import com.leanplum.internal.Log;
import com.leanplum.utils.BitmapUtil;
import com.leanplum.utils.BuildUtil;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

class LeanplumNotificationHelper {
    private static final String LEANPLUM_DEFAULT_PUSH_ICON = "leanplum_default_push_icon";

    LeanplumNotificationHelper() {
    }

    public static boolean areNotificationsEnabled(Context context, Bundle bundle) {
        if (!j0.b(context).a()) {
            return false;
        }
        if (!BuildUtil.isNotificationChannelSupported(context)) {
            return true;
        }
        String resolveChannelId = resolveChannelId(context, bundle);
        if (TextUtils.isEmpty(resolveChannelId) || !isChannelEnabled(context, resolveChannelId)) {
            return false;
        }
        return true;
    }

    @TargetApi(16)
    private static boolean canCreateIconDrawable(Context context) {
        try {
            if (AdaptiveIconDrawable.createFromStream(context.getResources().openRawResource(context.getApplicationInfo().icon), "applicationInfo.icon") != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    static Bitmap getBigPictureBitmap(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bitmap scaledBitmap = BitmapUtil.getScaledBitmap(context, str);
        if (scaledBitmap != null) {
            return scaledBitmap;
        }
        Log.i("Failed to download image for push notification: %s", str);
        return scaledBitmap;
    }

    @TargetApi(16)
    static Notification.BigPictureStyle getBigPictureStyle(Bundle bundle, Bitmap bitmap, String str, String str2) {
        if (bundle == null || bitmap == null) {
            return null;
        }
        return new Notification.BigPictureStyle().bigPicture(bitmap).setBigContentTitle(str).setSummaryText(str2);
    }

    static p.e getDefaultCompatNotificationBuilder(Context context, boolean z10) {
        if (!z10) {
            return new p.e(context);
        }
        String defaultNotificationChannelId = LeanplumNotificationChannel.getDefaultNotificationChannelId(context);
        if (!TextUtils.isEmpty(defaultNotificationChannelId)) {
            return new p.e(context, defaultNotificationChannelId);
        }
        Log.e("Failed to post notification, there are no notification channels configured.", new Object[0]);
        return null;
    }

    @TargetApi(26)
    private static Notification.Builder getDefaultNotificationBuilder(Context context, boolean z10) {
        if (!z10) {
            return new Notification.Builder(context);
        }
        String defaultNotificationChannelId = LeanplumNotificationChannel.getDefaultNotificationChannelId(context);
        if (!TextUtils.isEmpty(defaultNotificationChannelId)) {
            return new Notification.Builder(context, defaultNotificationChannelId);
        }
        Log.e("Failed to post notification, there are no notification channels configured.", new Object[0]);
        return null;
    }

    static int getDefaultPushNotificationIconResourceId(Context context) {
        try {
            return context.getResources().getIdentifier(LEANPLUM_DEFAULT_PUSH_ICON, "drawable", context.getPackageName());
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static Notification.Builder getNotificationBuilder(Context context, Bundle bundle) {
        if (!BuildUtil.isNotificationChannelSupported(context)) {
            return new Notification.Builder(context);
        }
        try {
            String string = bundle.getString(Constants.Keys.PUSH_NOTIFICATION_CHANNEL);
            if (TextUtils.isEmpty(string)) {
                return getDefaultNotificationBuilder(context, true);
            }
            String createNotificationChannel = LeanplumNotificationChannel.createNotificationChannel(context, JsonConverter.fromJson(string));
            if (!TextUtils.isEmpty(createNotificationChannel)) {
                return new Notification.Builder(context, createNotificationChannel);
            }
            Log.e("Failed to post notification to specified channel.", new Object[0]);
            return null;
        } catch (Exception unused) {
            Log.e("Failed to post notification to specified channel.", new Object[0]);
            return null;
        }
    }

    static p.e getNotificationCompatBuilder(Context context, Bundle bundle) {
        if (!BuildUtil.isNotificationChannelSupported(context)) {
            return new p.e(context);
        }
        try {
            String string = bundle.getString(Constants.Keys.PUSH_NOTIFICATION_CHANNEL);
            if (TextUtils.isEmpty(string)) {
                return getDefaultCompatNotificationBuilder(context, true);
            }
            String createNotificationChannel = LeanplumNotificationChannel.createNotificationChannel(context, JsonConverter.fromJson(string));
            if (!TextUtils.isEmpty(createNotificationChannel)) {
                return new p.e(context, createNotificationChannel);
            }
            Log.e("Failed to post notification to specified channel.", new Object[0]);
            return null;
        } catch (Exception unused) {
            Log.e("Failed to post notification to specified channel.", new Object[0]);
            return null;
        }
    }

    static boolean isApplicationIconValid(Context context) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return canCreateIconDrawable(context);
    }

    private static boolean isChannelEnabled(Context context, String str) {
        NotificationChannel c10 = j0.b(context).c(str);
        if (c10 == null || c10.getImportance() <= 0) {
            return false;
        }
        return true;
    }

    private static String resolveChannelId(Context context, Bundle bundle) {
        String string = bundle.getString(Constants.Keys.PUSH_NOTIFICATION_CHANNEL);
        if (!TextUtils.isEmpty(string)) {
            String str = (String) JsonConverter.fromJson(string).get("id");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        String defaultNotificationChannelId = LeanplumNotificationChannel.getDefaultNotificationChannelId(context);
        if (!TextUtils.isEmpty(defaultNotificationChannelId)) {
            return defaultNotificationChannelId;
        }
        return null;
    }

    @TargetApi(21)
    static void scheduleJobService(Context context, Class cls, int i10) {
        if (context != null) {
            ComponentName componentName = new ComponentName(context, cls);
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler != null) {
                jobScheduler.schedule(new JobInfo.Builder(verifyJobId(jobScheduler.getAllPendingJobs(), i10), componentName).setMinimumLatency(10).build());
            }
        }
    }

    static void setModifiedBigPictureStyle(Notification.Builder builder, Notification.Style style) {
        if (builder != null && style != null) {
            builder.setStyle(style);
        }
    }

    @TargetApi(21)
    private static int verifyJobId(List<JobInfo> list, int i10) {
        if (list == null || list.isEmpty()) {
            return i10;
        }
        TreeSet treeSet = new TreeSet();
        for (JobInfo id2 : list) {
            treeSet.add(Integer.valueOf(id2.getId()));
        }
        if (!treeSet.contains(Integer.valueOf(i10))) {
            return i10;
        }
        if (((Integer) treeSet.first()).intValue() > Integer.MIN_VALUE) {
            return ((Integer) treeSet.first()).intValue() - 1;
        }
        if (((Integer) treeSet.last()).intValue() < Integer.MIN_VALUE) {
            return ((Integer) treeSet.last()).intValue() + 1;
        }
        while (treeSet.contains(Integer.valueOf(i10))) {
            i10 = new Random().nextInt();
        }
        return i10;
    }

    static Notification.Builder getNotificationBuilder(Context context, Bundle bundle, PendingIntent pendingIntent, String str, String str2, int i10) {
        Notification.Builder notificationBuilder = getNotificationBuilder(context, bundle);
        if (notificationBuilder == null) {
            return null;
        }
        if (i10 == 0) {
            notificationBuilder.setSmallIcon(context.getApplicationInfo().icon);
        } else {
            notificationBuilder.setSmallIcon(i10);
        }
        notificationBuilder.setContentTitle(str).setContentText(str2);
        notificationBuilder.setStyle(new Notification.BigTextStyle().bigText(str2));
        if (!BuildUtil.isNotificationChannelSupported(context)) {
            notificationBuilder.setPriority(2);
        }
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setContentIntent(pendingIntent);
        return notificationBuilder;
    }

    static p.e getNotificationCompatBuilder(Context context, Bundle bundle, PendingIntent pendingIntent, String str, String str2, Bitmap bitmap, int i10) {
        p.e notificationCompatBuilder;
        if (bundle == null || (notificationCompatBuilder = getNotificationCompatBuilder(context, bundle)) == null) {
            return null;
        }
        if (i10 == 0) {
            notificationCompatBuilder.x(context.getApplicationInfo().icon);
        } else {
            notificationCompatBuilder.x(i10);
        }
        notificationCompatBuilder.m(str).z(new p.c().h(str2)).l(str2);
        if (bitmap != null) {
            notificationCompatBuilder.z(new p.b().i(bitmap).j(str).k(str2));
        }
        if (!BuildUtil.isNotificationChannelSupported(context)) {
            notificationCompatBuilder.v(2);
        }
        notificationCompatBuilder.f(true);
        notificationCompatBuilder.k(pendingIntent);
        return notificationCompatBuilder;
    }
}
