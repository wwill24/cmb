package io.sentry.android.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.d;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.util.l;
import io.sentry.w;
import java.io.Closeable;
import java.io.IOException;

public final class TempSensorBreadcrumbsIntegration implements Integration, Closeable, SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30903a;

    /* renamed from: b  reason: collision with root package name */
    private g0 f30904b;

    /* renamed from: c  reason: collision with root package name */
    private SentryAndroidOptions f30905c;

    /* renamed from: d  reason: collision with root package name */
    SensorManager f30906d;

    public TempSensorBreadcrumbsIntegration(Context context) {
        this.f30903a = (Context) l.c(context, "Context is required");
    }

    public void a(g0 g0Var, SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions;
        this.f30904b = (g0) l.c(g0Var, "Hub is required");
        if (sentryOptions instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        } else {
            sentryAndroidOptions = null;
        }
        SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f30905c = sentryAndroidOptions2;
        h0 logger = sentryAndroidOptions2.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "enableSystemEventsBreadcrumbs enabled: %s", Boolean.valueOf(this.f30905c.isEnableSystemEventBreadcrumbs()));
        if (this.f30905c.isEnableSystemEventBreadcrumbs()) {
            try {
                SensorManager sensorManager = (SensorManager) this.f30903a.getSystemService("sensor");
                this.f30906d = sensorManager;
                if (sensorManager != null) {
                    Sensor defaultSensor = sensorManager.getDefaultSensor(13);
                    if (defaultSensor != null) {
                        this.f30906d.registerListener(this, defaultSensor, 3);
                        sentryOptions.getLogger().c(sentryLevel, "TempSensorBreadcrumbsIntegration installed.", new Object[0]);
                        c();
                        return;
                    }
                    this.f30905c.getLogger().c(SentryLevel.INFO, "TYPE_AMBIENT_TEMPERATURE is not available.", new Object[0]);
                    return;
                }
                this.f30905c.getLogger().c(SentryLevel.INFO, "SENSOR_SERVICE is not available.", new Object[0]);
            } catch (Throwable th2) {
                sentryOptions.getLogger().a(SentryLevel.ERROR, th2, "Failed to init. the SENSOR_SERVICE.", new Object[0]);
            }
        }
    }

    public void close() throws IOException {
        SensorManager sensorManager = this.f30906d;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.f30906d = null;
            SentryAndroidOptions sentryAndroidOptions = this.f30905c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "TempSensorBreadcrumbsIntegration removed.", new Object[0]);
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length != 0 && fArr[0] != 0.0f && this.f30904b != null) {
            d dVar = new d();
            dVar.p("system");
            dVar.l("device.event");
            dVar.m("action", "TYPE_AMBIENT_TEMPERATURE");
            dVar.m("accuracy", Integer.valueOf(sensorEvent.accuracy));
            dVar.m("timestamp", Long.valueOf(sensorEvent.timestamp));
            dVar.n(SentryLevel.INFO);
            dVar.m("degree", Float.valueOf(sensorEvent.values[0]));
            w wVar = new w();
            wVar.i("android:sensorEvent", sensorEvent);
            this.f30904b.t(dVar, wVar);
        }
    }
}
