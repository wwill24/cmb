package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.p;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.CommonNotificationBuilder;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.p;

class DisplayNotification {
    private static final int IMAGE_DOWNLOAD_TIMEOUT_SECONDS = 5;
    private final Context context;
    private final ExecutorService networkIoExecutor;
    private final NotificationParams params;

    public DisplayNotification(Context context2, NotificationParams notificationParams, ExecutorService executorService) {
        this.networkIoExecutor = executorService;
        this.context = context2;
        this.params = notificationParams;
    }

    private boolean isAppForeground() {
        if (((KeyguardManager) this.context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!p.f()) {
            SystemClock.sleep(10);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                if (next.importance == 100) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private void showNotification(CommonNotificationBuilder.DisplayNotificationInfo displayNotificationInfo) {
        Log.isLoggable(Constants.TAG, 3);
        ((NotificationManager) this.context.getSystemService("notification")).notify(displayNotificationInfo.tag, displayNotificationInfo.f21091id, displayNotificationInfo.notificationBuilder.b());
    }

    private ImageDownload startImageDownloadInBackground() {
        ImageDownload create = ImageDownload.create(this.params.getString(Constants.MessageNotificationKeys.IMAGE_URL));
        if (create != null) {
            create.start(this.networkIoExecutor);
        }
        return create;
    }

    private void waitForAndApplyImageDownload(p.e eVar, ImageDownload imageDownload) {
        if (imageDownload != null) {
            try {
                Bitmap bitmap = (Bitmap) Tasks.await(imageDownload.getTask(), 5, TimeUnit.SECONDS);
                eVar.q(bitmap);
                eVar.z(new p.b().i(bitmap).h((Bitmap) null));
            } catch (ExecutionException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to download image: ");
                sb2.append(e10.getCause());
            } catch (InterruptedException unused) {
                imageDownload.close();
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                imageDownload.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean handleNotification() {
        if (this.params.getBoolean(Constants.MessageNotificationKeys.NO_UI)) {
            return true;
        }
        if (isAppForeground()) {
            return false;
        }
        ImageDownload startImageDownloadInBackground = startImageDownloadInBackground();
        CommonNotificationBuilder.DisplayNotificationInfo createNotificationInfo = CommonNotificationBuilder.createNotificationInfo(this.context, this.params);
        waitForAndApplyImageDownload(createNotificationInfo.notificationBuilder, startImageDownloadInBackground);
        showNotification(createNotificationInfo);
        return true;
    }
}
