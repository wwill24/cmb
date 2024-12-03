package io.sentry.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.d;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.util.l;
import io.sentry.util.p;
import io.sentry.w;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class SystemEventsBreadcrumbsIntegration implements Integration, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30897a;

    /* renamed from: b  reason: collision with root package name */
    a f30898b;

    /* renamed from: c  reason: collision with root package name */
    private SentryAndroidOptions f30899c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f30900d;

    static final class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final g0 f30901a;

        /* renamed from: b  reason: collision with root package name */
        private final h0 f30902b;

        a(g0 g0Var, h0 h0Var) {
            this.f30901a = g0Var;
            this.f30902b = h0Var;
        }

        public void onReceive(Context context, Intent intent) {
            d dVar = new d();
            dVar.p("system");
            dVar.l("device.event");
            String action = intent.getAction();
            String c10 = p.c(action);
            if (c10 != null) {
                dVar.m("action", c10);
            }
            Bundle extras = intent.getExtras();
            HashMap hashMap = new HashMap();
            if (extras != null && !extras.isEmpty()) {
                for (String next : extras.keySet()) {
                    try {
                        Object obj = extras.get(next);
                        if (obj != null) {
                            hashMap.put(next, obj.toString());
                        }
                    } catch (Throwable th2) {
                        this.f30902b.a(SentryLevel.ERROR, th2, "%s key of the %s action threw an error.", next, action);
                    }
                }
                dVar.m("extras", hashMap);
            }
            dVar.n(SentryLevel.INFO);
            w wVar = new w();
            wVar.i("android:intent", intent);
            this.f30901a.t(dVar, wVar);
        }
    }

    public SystemEventsBreadcrumbsIntegration(Context context) {
        this(context, e());
    }

    private static List<String> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.appwidget.action.APPWIDGET_DELETED");
        arrayList.add("android.appwidget.action.APPWIDGET_DISABLED");
        arrayList.add("android.appwidget.action.APPWIDGET_ENABLED");
        arrayList.add("android.appwidget.action.APPWIDGET_HOST_RESTORED");
        arrayList.add("android.appwidget.action.APPWIDGET_RESTORED");
        arrayList.add("android.appwidget.action.APPWIDGET_UPDATE");
        arrayList.add("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS");
        arrayList.add("android.intent.action.ACTION_POWER_CONNECTED");
        arrayList.add("android.intent.action.ACTION_POWER_DISCONNECTED");
        arrayList.add("android.intent.action.ACTION_SHUTDOWN");
        arrayList.add("android.intent.action.AIRPLANE_MODE");
        arrayList.add("android.intent.action.BATTERY_LOW");
        arrayList.add("android.intent.action.BATTERY_OKAY");
        arrayList.add("android.intent.action.BOOT_COMPLETED");
        arrayList.add("android.intent.action.CAMERA_BUTTON");
        arrayList.add("android.intent.action.CONFIGURATION_CHANGED");
        arrayList.add("android.intent.action.CONTENT_CHANGED");
        arrayList.add("android.intent.action.DATE_CHANGED");
        arrayList.add("android.intent.action.DEVICE_STORAGE_LOW");
        arrayList.add("android.intent.action.DEVICE_STORAGE_OK");
        arrayList.add("android.intent.action.DOCK_EVENT");
        arrayList.add("android.intent.action.DREAMING_STARTED");
        arrayList.add("android.intent.action.DREAMING_STOPPED");
        arrayList.add("android.intent.action.INPUT_METHOD_CHANGED");
        arrayList.add("android.intent.action.LOCALE_CHANGED");
        arrayList.add("android.intent.action.REBOOT");
        arrayList.add("android.intent.action.SCREEN_OFF");
        arrayList.add("android.intent.action.SCREEN_ON");
        arrayList.add("android.intent.action.TIMEZONE_CHANGED");
        arrayList.add("android.intent.action.TIME_SET");
        arrayList.add("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        arrayList.add("android.os.action.POWER_SAVE_MODE_CHANGED");
        arrayList.add("android.intent.action.APP_ERROR");
        arrayList.add("android.intent.action.BUG_REPORT");
        arrayList.add("android.intent.action.MEDIA_BAD_REMOVAL");
        arrayList.add("android.intent.action.MEDIA_MOUNTED");
        arrayList.add("android.intent.action.MEDIA_UNMOUNTABLE");
        arrayList.add("android.intent.action.MEDIA_UNMOUNTED");
        return arrayList;
    }

    public void a(g0 g0Var, SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions;
        l.c(g0Var, "Hub is required");
        if (sentryOptions instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        } else {
            sentryAndroidOptions = null;
        }
        SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f30899c = sentryAndroidOptions2;
        sentryAndroidOptions2.getLogger().c(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.f30899c.isEnableSystemEventBreadcrumbs()));
        if (this.f30899c.isEnableSystemEventBreadcrumbs()) {
            this.f30898b = new a(g0Var, this.f30899c.getLogger());
            IntentFilter intentFilter = new IntentFilter();
            for (String addAction : this.f30900d) {
                intentFilter.addAction(addAction);
            }
            try {
                this.f30897a.registerReceiver(this.f30898b, intentFilter);
                this.f30899c.getLogger().c(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration installed.", new Object[0]);
                c();
            } catch (Throwable th2) {
                this.f30899c.setEnableSystemEventBreadcrumbs(false);
                this.f30899c.getLogger().b(SentryLevel.ERROR, "Failed to initialize SystemEventsBreadcrumbsIntegration.", th2);
            }
        }
    }

    public void close() throws IOException {
        a aVar = this.f30898b;
        if (aVar != null) {
            this.f30897a.unregisterReceiver(aVar);
            this.f30898b = null;
            SentryAndroidOptions sentryAndroidOptions = this.f30899c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration remove.", new Object[0]);
            }
        }
    }

    public SystemEventsBreadcrumbsIntegration(Context context, List<String> list) {
        this.f30897a = (Context) l.c(context, "Context is required");
        this.f30900d = (List) l.c(list, "Actions list is required");
    }
}
