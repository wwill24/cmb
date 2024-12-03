package com.mparticle;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.mparticle.internal.Logger;
import com.mparticle.messaging.MPMessagingAPI;
import com.mparticle.messaging.ProviderCloudMessage;

public class a0 {

    /* renamed from: b  reason: collision with root package name */
    private static PowerManager.WakeLock f22261b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f22262c = MPService.class;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f22263a;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                Class.forName("android.os.AsyncTask");
            } catch (ClassNotFoundException e10) {
                e10.printStackTrace();
            }
        }
    }

    class b extends AsyncTask<ProviderCloudMessage, Void, Notification> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProviderCloudMessage f22265a;

        b(ProviderCloudMessage providerCloudMessage) {
            this.f22265a = providerCloudMessage;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Notification doInBackground(ProviderCloudMessage... providerCloudMessageArr) {
            return this.f22265a.buildNotification(a0.this.f22263a, System.currentTimeMillis());
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Notification notification) {
            super.onPostExecute(notification);
            if (notification != null) {
                NotificationManager notificationManager = (NotificationManager) a0.this.f22263a.getSystemService("notification");
                if (Build.VERSION.SDK_INT >= 26) {
                    a0.this.a(notificationManager);
                }
                notificationManager.cancel(this.f22265a.getId());
                notificationManager.notify(this.f22265a.getId(), notification);
            }
        }
    }

    public a0(Context context) {
        new Handler(Looper.getMainLooper()).post(new a());
        this.f22263a = context;
    }

    private void b(ProviderCloudMessage providerCloudMessage) {
        if (!providerCloudMessage.getDisplayed() && com.mparticle.internal.b.h(this.f22263a).booleanValue()) {
            new b(providerCloudMessage).execute(new ProviderCloudMessage[]{providerCloudMessage});
        }
        String appState = MParticle.getAppState();
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.logNotification(providerCloudMessage, false, appState);
        }
    }

    private void c(Intent intent) {
        ProviderCloudMessage providerCloudMessage = (ProviderCloudMessage) intent.getParcelableExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA);
        ((NotificationManager) this.f22263a.getSystemService("notification")).cancel(providerCloudMessage.getId());
        MParticle.start(MParticleOptions.builder(this.f22263a.getApplicationContext()).buildForInternalRestart());
        Intent intent2 = new Intent(MPMessagingAPI.BROADCAST_NOTIFICATION_TAPPED);
        intent2.putExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA, providerCloudMessage);
        n1.a.b(this.f22263a).d(intent2);
        e(intent2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(Intent intent) {
        try {
            MParticle instance = MParticle.getInstance();
            if (instance != null) {
                ProviderCloudMessage createMessage = ProviderCloudMessage.createMessage(intent, com.mparticle.internal.b.e(this.f22263a));
                createMessage.setDisplayed(instance.Internal().c().onMessageReceived(this.f22263a.getApplicationContext(), intent));
                a(createMessage);
            }
        } catch (Exception e10) {
            Logger.warning("FCM parsing error: " + e10);
        }
    }

    public void e(Intent intent) {
        try {
            String action = intent.getAction();
            Logger.info("MPService", "Handling action: " + action);
            if (!action.equals("com.google.android.c2dm.intent.REGISTRATION")) {
                if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                    a(intent);
                } else if (action.startsWith("com.mparticle.push.notification_tapped")) {
                    c(intent);
                } else if (action.equals(MPMessagingAPI.BROADCAST_NOTIFICATION_TAPPED)) {
                    b(intent);
                } else if (action.equals(MPMessagingAPI.BROADCAST_NOTIFICATION_RECEIVED)) {
                    b((ProviderCloudMessage) intent.getParcelableExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA));
                }
            }
            synchronized (f22262c) {
                PowerManager.WakeLock wakeLock = f22261b;
                if (wakeLock != null && wakeLock.isHeld()) {
                    f22261b.release();
                }
            }
        } catch (Throwable th2) {
            synchronized (f22262c) {
                PowerManager.WakeLock wakeLock2 = f22261b;
                if (wakeLock2 != null && wakeLock2.isHeld()) {
                    f22261b.release();
                }
                throw th2;
            }
        }
    }

    public static void a(Context context, Intent intent) {
        synchronized (f22262c) {
            if (f22261b == null) {
                f22261b = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "mParticle:wakeLock");
            }
        }
        f22261b.acquire();
        intent.setClass(context, MPService.class);
        try {
            context.startService(intent);
        } catch (IllegalStateException unused) {
            new a0(context).e(intent);
        }
    }

    private void b(Intent intent) {
        PendingIntent pendingIntent;
        ProviderCloudMessage providerCloudMessage = (ProviderCloudMessage) intent.getParcelableExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA);
        Intent defaultOpenIntent = providerCloudMessage.getDefaultOpenIntent(this.f22263a, providerCloudMessage);
        defaultOpenIntent.addFlags(268435456);
        defaultOpenIntent.addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 31) {
            pendingIntent = PendingIntent.getActivity(this.f22263a, 0, defaultOpenIntent, 33554432);
        } else {
            pendingIntent = PendingIntent.getActivity(this.f22263a, 0, defaultOpenIntent, 134217728);
        }
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
            }
        }
    }

    private void a(Intent intent) {
        try {
            y0 y0Var = new y0(this, intent);
            MParticle instance = MParticle.getInstance();
            if (instance != null) {
                instance.Internal().c().a((p) y0Var);
            } else {
                MParticle.start(MParticleOptions.builder(this.f22263a).configuration(new q(y0Var)).buildForInternalRestart());
            }
        } catch (Exception e10) {
            Logger.warning("FCM parsing error: " + e10);
        }
    }

    private void a(ProviderCloudMessage providerCloudMessage) {
        Intent intent = new Intent(MPMessagingAPI.BROADCAST_NOTIFICATION_RECEIVED);
        intent.putExtra(MPMessagingAPI.CLOUD_MESSAGE_EXTRA, providerCloudMessage);
        n1.a.b(this.f22263a).d(intent);
        e(intent);
    }

    /* access modifiers changed from: private */
    public void a(NotificationManager notificationManager) {
        notificationManager.createNotificationChannel(new NotificationChannel("com.mparticle.default", "Notifications", 3));
    }
}
