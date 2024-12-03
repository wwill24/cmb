package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import io.sentry.SentryLevel;
import io.sentry.android.core.cache.a;
import io.sentry.android.core.internal.util.b;
import io.sentry.android.core.internal.util.p;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.compose.gestures.ComposeGestureTargetLocator;
import io.sentry.h0;
import io.sentry.i;
import io.sentry.k2;
import io.sentry.l2;
import io.sentry.transport.r;
import io.sentry.util.l;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

final class w {
    private static String c(Context context, h0 h0Var) {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(context.getAssets().open("sentry-debug-meta.properties"));
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            String property = properties.getProperty("io.sentry.ProguardUuids");
            h0Var.c(SentryLevel.DEBUG, "Proguard UUID found: %s", property);
            bufferedInputStream.close();
            return property;
        } catch (FileNotFoundException unused) {
            h0Var.c(SentryLevel.INFO, "sentry-debug-meta.properties file was not found.", new Object[0]);
            return null;
        } catch (IOException e10) {
            h0Var.b(SentryLevel.ERROR, "Error getting Proguard UUIDs.", e10);
            return null;
        } catch (RuntimeException e11) {
            h0Var.b(SentryLevel.ERROR, "sentry-debug-meta.properties file is malformed.", e11);
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static String d(PackageInfo packageInfo, String str) {
        return packageInfo.packageName + "@" + packageInfo.versionName + "+" + str;
    }

    private static void e(Context context, SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.setCacheDirPath(new File(context.getCacheDir(), "sentry").getAbsolutePath());
    }

    static void f(SentryAndroidOptions sentryAndroidOptions, Context context, i0 i0Var, t0 t0Var, boolean z10, boolean z11) {
        boolean z12;
        if (sentryAndroidOptions.getCacheDirPath() != null && (sentryAndroidOptions.getEnvelopeDiskCache() instanceof r)) {
            sentryAndroidOptions.setEnvelopeDiskCache(new a(sentryAndroidOptions));
        }
        g gVar = new g(t0Var, sentryAndroidOptions);
        g(context, sentryAndroidOptions, i0Var, t0Var, gVar, z10, z11);
        sentryAndroidOptions.addEventProcessor(new n0(context, i0Var, sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new y0(sentryAndroidOptions, gVar));
        sentryAndroidOptions.addEventProcessor(new z0(sentryAndroidOptions, i0Var));
        sentryAndroidOptions.addEventProcessor(new f1(sentryAndroidOptions));
        sentryAndroidOptions.setTransportGate(new c0(context, sentryAndroidOptions.getLogger()));
        sentryAndroidOptions.setTransactionProfiler(new b0(context, sentryAndroidOptions, i0Var, new p(context, sentryAndroidOptions, i0Var)));
        sentryAndroidOptions.setModulesLoader(new io.sentry.android.core.internal.modules.a(context, sentryAndroidOptions.getLogger()));
        boolean b10 = t0Var.b("androidx.core.view.ScrollingView", sentryAndroidOptions);
        if (sentryAndroidOptions.getGestureTargetLocators().isEmpty()) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(new io.sentry.android.core.internal.gestures.a(b10));
            if (!t0Var.b("androidx.compose.ui.node.Owner", sentryAndroidOptions) || !t0Var.b("io.sentry.compose.gestures.ComposeGestureTargetLocator", sentryAndroidOptions)) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                arrayList.add(new ComposeGestureTargetLocator());
            }
            sentryAndroidOptions.setGestureTargetLocators(arrayList);
        }
        sentryAndroidOptions.setMainThreadChecker(b.e());
        if (sentryAndroidOptions.getCollectors().isEmpty()) {
            sentryAndroidOptions.addCollector(new t());
            sentryAndroidOptions.addCollector(new q(sentryAndroidOptions.getLogger(), i0Var));
        }
        sentryAndroidOptions.setTransactionPerformanceCollector(new i(sentryAndroidOptions));
    }

    private static void g(Context context, SentryAndroidOptions sentryAndroidOptions, i0 i0Var, t0 t0Var, g gVar, boolean z10, boolean z11) {
        Class<?> cls;
        boolean H = a.H(sentryAndroidOptions);
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new k2(new u(sentryAndroidOptions)), H));
        if (h(i0Var)) {
            cls = t0Var.c("io.sentry.android.ndk.SentryNdk", sentryAndroidOptions.getLogger());
        } else {
            cls = null;
        }
        sentryAndroidOptions.addIntegration(new NdkIntegration(cls));
        sentryAndroidOptions.addIntegration(EnvelopeFileObserverIntegration.e());
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new l2(new v(sentryAndroidOptions)), H));
        sentryAndroidOptions.addIntegration(new AppLifecycleIntegration());
        sentryAndroidOptions.addIntegration(new AnrIntegration(context));
        if (context instanceof Application) {
            Application application = (Application) context;
            sentryAndroidOptions.addIntegration(new ActivityLifecycleIntegration(application, i0Var, gVar));
            sentryAndroidOptions.addIntegration(new CurrentActivityIntegration(application));
            sentryAndroidOptions.addIntegration(new UserInteractionIntegration(application, t0Var));
            if (z10) {
                sentryAndroidOptions.addIntegration(new FragmentLifecycleIntegration(application, true, true));
            }
        } else {
            sentryAndroidOptions.getLogger().c(SentryLevel.WARNING, "ActivityLifecycle, FragmentLifecycle and UserInteraction Integrations need an Application class to be installed.", new Object[0]);
        }
        if (z11) {
            sentryAndroidOptions.addIntegration(new SentryTimberIntegration());
        }
        sentryAndroidOptions.addIntegration(new AppComponentsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new SystemEventsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new NetworkBreadcrumbsIntegration(context, i0Var, sentryAndroidOptions.getLogger()));
        sentryAndroidOptions.addIntegration(new TempSensorBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new PhoneStateBreadcrumbsIntegration(context));
    }

    private static boolean h(i0 i0Var) {
        return i0Var.d() >= 16;
    }

    static void k(SentryAndroidOptions sentryAndroidOptions, Context context, h0 h0Var, i0 i0Var) {
        l.c(context, "The context is required.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        l.c(sentryAndroidOptions, "The options object is required.");
        l.c(h0Var, "The ILogger object is required.");
        sentryAndroidOptions.setLogger(h0Var);
        sentryAndroidOptions.setDateProvider(new e1());
        v0.a(context, sentryAndroidOptions, i0Var);
        e(context, sentryAndroidOptions);
        l(sentryAndroidOptions, context, i0Var);
    }

    private static void l(SentryAndroidOptions sentryAndroidOptions, Context context, i0 i0Var) {
        PackageInfo c10 = j0.c(context, sentryAndroidOptions.getLogger(), i0Var);
        if (c10 != null) {
            if (sentryAndroidOptions.getRelease() == null) {
                sentryAndroidOptions.setRelease(d(c10, j0.d(c10, i0Var)));
            }
            String str = c10.packageName;
            if (str != null && !str.startsWith("android.")) {
                sentryAndroidOptions.addInAppInclude(str);
            }
        }
        if (sentryAndroidOptions.getDistinctId() == null) {
            try {
                sentryAndroidOptions.setDistinctId(r0.a(context));
            } catch (RuntimeException e10) {
                sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Could not generate distinct Id.", e10);
            }
        }
        if (sentryAndroidOptions.getProguardUuid() == null) {
            sentryAndroidOptions.setProguardUuid(c(context, sentryAndroidOptions.getLogger()));
        }
    }
}
