package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.mparticle.kits.AppsFlyerKit;
import io.sentry.SentryLevel;
import io.sentry.h0;
import io.sentry.util.l;
import java.util.Arrays;
import java.util.List;

final class v0 {
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0262, code lost:
        if (r3.isEmpty() != false) goto L_0x0264;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(android.content.Context r10, io.sentry.android.core.SentryAndroidOptions r11, io.sentry.android.core.i0 r12) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "io.sentry.traces.trace-propagation-targets"
            java.lang.String r2 = "The application context is required."
            io.sentry.util.l.c(r10, r2)
            java.lang.String r2 = "The options object is required."
            io.sentry.util.l.c(r11, r2)
            io.sentry.h0 r2 = r11.getLogger()     // Catch:{ all -> 0x02fd }
            android.os.Bundle r10 = b(r10, r2, r12)     // Catch:{ all -> 0x02fd }
            io.sentry.h0 r12 = r11.getLogger()     // Catch:{ all -> 0x02fd }
            r2 = 0
            if (r10 == 0) goto L_0x02ef
            java.lang.String r3 = "io.sentry.debug"
            boolean r4 = r11.isDebug()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r4)     // Catch:{ all -> 0x02fd }
            r11.setDebug(r3)     // Catch:{ all -> 0x02fd }
            boolean r3 = r11.isDebug()     // Catch:{ all -> 0x02fd }
            if (r3 == 0) goto L_0x0051
            java.lang.String r3 = "io.sentry.debug.level"
            io.sentry.SentryLevel r4 = r11.getDiagnosticLevel()     // Catch:{ all -> 0x02fd }
            java.lang.String r4 = r4.name()     // Catch:{ all -> 0x02fd }
            java.util.Locale r5 = java.util.Locale.ROOT     // Catch:{ all -> 0x02fd }
            java.lang.String r4 = r4.toLowerCase(r5)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = i(r10, r12, r3, r4)     // Catch:{ all -> 0x02fd }
            if (r3 == 0) goto L_0x0051
            java.lang.String r3 = r3.toUpperCase(r5)     // Catch:{ all -> 0x02fd }
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.valueOf(r3)     // Catch:{ all -> 0x02fd }
            r11.setDiagnosticLevel(r3)     // Catch:{ all -> 0x02fd }
        L_0x0051:
            java.lang.String r3 = "io.sentry.anr.enable"
            boolean r4 = r11.isAnrEnabled()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r4)     // Catch:{ all -> 0x02fd }
            r11.setAnrEnabled(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.session-tracking.enable"
            boolean r4 = r11.isEnableAutoSessionTracking()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r4)     // Catch:{ all -> 0x02fd }
            java.lang.String r4 = "io.sentry.auto-session-tracking.enable"
            boolean r3 = d(r10, r12, r4, r3)     // Catch:{ all -> 0x02fd }
            r11.setEnableAutoSessionTracking(r3)     // Catch:{ all -> 0x02fd }
            java.lang.Double r3 = r11.getSampleRate()     // Catch:{ all -> 0x02fd }
            r4 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            if (r3 != 0) goto L_0x008a
            java.lang.String r3 = "io.sentry.sample-rate"
            java.lang.Double r3 = f(r10, r12, r3)     // Catch:{ all -> 0x02fd }
            double r6 = r3.doubleValue()     // Catch:{ all -> 0x02fd }
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x008a
            r11.setSampleRate(r3)     // Catch:{ all -> 0x02fd }
        L_0x008a:
            java.lang.String r3 = "io.sentry.anr.report-debug"
            boolean r6 = r11.isAnrReportInDebug()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setAnrReportInDebug(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.anr.timeout-interval-millis"
            long r6 = r11.getAnrTimeoutIntervalMillis()     // Catch:{ all -> 0x02fd }
            long r6 = h(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setAnrTimeoutIntervalMillis(r6)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.dsn"
            java.lang.String r6 = r11.getDsn()     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = i(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            if (r3 != 0) goto L_0x00be
            io.sentry.h0 r6 = r11.getLogger()     // Catch:{ all -> 0x02fd }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.FATAL     // Catch:{ all -> 0x02fd }
            java.lang.String r8 = "DSN is required. Use empty string to disable SDK."
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x02fd }
            r6.c(r7, r8, r9)     // Catch:{ all -> 0x02fd }
            goto L_0x00d1
        L_0x00be:
            boolean r6 = r3.isEmpty()     // Catch:{ all -> 0x02fd }
            if (r6 == 0) goto L_0x00d1
            io.sentry.h0 r6 = r11.getLogger()     // Catch:{ all -> 0x02fd }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x02fd }
            java.lang.String r8 = "DSN is empty, disabling sentry-android"
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x02fd }
            r6.c(r7, r8, r9)     // Catch:{ all -> 0x02fd }
        L_0x00d1:
            r11.setDsn(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.ndk.enable"
            boolean r6 = r11.isEnableNdk()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableNdk(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.ndk.scope-sync.enable"
            boolean r6 = r11.isEnableScopeSync()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableScopeSync(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.release"
            java.lang.String r6 = r11.getRelease()     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = i(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setRelease(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.environment"
            java.lang.String r6 = r11.getEnvironment()     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = i(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnvironment(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.session-tracking.timeout-interval-millis"
            long r6 = r11.getSessionTrackingIntervalMillis()     // Catch:{ all -> 0x02fd }
            long r6 = h(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setSessionTrackingIntervalMillis(r6)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.breadcrumbs.activity-lifecycle"
            boolean r6 = r11.isEnableActivityLifecycleBreadcrumbs()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableActivityLifecycleBreadcrumbs(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.breadcrumbs.app-lifecycle"
            boolean r6 = r11.isEnableAppLifecycleBreadcrumbs()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableAppLifecycleBreadcrumbs(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.breadcrumbs.system-events"
            boolean r6 = r11.isEnableSystemEventBreadcrumbs()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableSystemEventBreadcrumbs(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.breadcrumbs.app-components"
            boolean r6 = r11.isEnableAppComponentBreadcrumbs()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableAppComponentBreadcrumbs(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.breadcrumbs.user-interaction"
            boolean r6 = r11.isEnableUserInteractionBreadcrumbs()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableUserInteractionBreadcrumbs(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.breadcrumbs.network-events"
            boolean r6 = r11.isEnableNetworkEventBreadcrumbs()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableNetworkEventBreadcrumbs(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.uncaught-exception-handler.enable"
            boolean r6 = r11.isEnableUncaughtExceptionHandler()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableUncaughtExceptionHandler(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.attach-threads"
            boolean r6 = r11.isAttachThreads()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setAttachThreads(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.attach-screenshot"
            boolean r6 = r11.isAttachScreenshot()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setAttachScreenshot(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.attach-view-hierarchy"
            boolean r6 = r11.isAttachViewHierarchy()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setAttachViewHierarchy(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.send-client-reports"
            boolean r6 = r11.isSendClientReports()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setSendClientReports(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.additional-context"
            boolean r6 = r11.isCollectAdditionalContext()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setCollectAdditionalContext(r3)     // Catch:{ all -> 0x02fd }
            java.lang.Boolean r3 = r11.getEnableTracing()     // Catch:{ all -> 0x02fd }
            if (r3 != 0) goto L_0x01c1
            java.lang.String r3 = "io.sentry.traces.enable"
            r6 = 0
            java.lang.Boolean r3 = e(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableTracing(r3)     // Catch:{ all -> 0x02fd }
        L_0x01c1:
            java.lang.Double r3 = r11.getTracesSampleRate()     // Catch:{ all -> 0x02fd }
            if (r3 != 0) goto L_0x01d8
            java.lang.String r3 = "io.sentry.traces.sample-rate"
            java.lang.Double r3 = f(r10, r12, r3)     // Catch:{ all -> 0x02fd }
            double r6 = r3.doubleValue()     // Catch:{ all -> 0x02fd }
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x01d8
            r11.setTracesSampleRate(r3)     // Catch:{ all -> 0x02fd }
        L_0x01d8:
            java.lang.String r3 = "io.sentry.traces.trace-sampling"
            boolean r6 = r11.isTraceSampling()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setTraceSampling(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.traces.activity.enable"
            boolean r6 = r11.isEnableAutoActivityLifecycleTracing()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableAutoActivityLifecycleTracing(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.traces.activity.auto-finish.enable"
            boolean r6 = r11.isEnableActivityLifecycleTracingAutoFinish()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setEnableActivityLifecycleTracingAutoFinish(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.traces.profiling.enable"
            boolean r6 = r11.isProfilingEnabled()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r6)     // Catch:{ all -> 0x02fd }
            r11.setProfilingEnabled(r3)     // Catch:{ all -> 0x02fd }
            java.lang.Double r3 = r11.getProfilesSampleRate()     // Catch:{ all -> 0x02fd }
            if (r3 != 0) goto L_0x0223
            java.lang.String r3 = "io.sentry.traces.profiling.sample-rate"
            java.lang.Double r3 = f(r10, r12, r3)     // Catch:{ all -> 0x02fd }
            double r6 = r3.doubleValue()     // Catch:{ all -> 0x02fd }
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0223
            r11.setProfilesSampleRate(r3)     // Catch:{ all -> 0x02fd }
        L_0x0223:
            java.lang.String r3 = "io.sentry.traces.user-interaction.enable"
            boolean r4 = r11.isEnableUserInteractionTracing()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r4)     // Catch:{ all -> 0x02fd }
            r11.setEnableUserInteractionTracing(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.traces.time-to-full-display.enable"
            boolean r4 = r11.isEnableTimeToFullDisplayTracing()     // Catch:{ all -> 0x02fd }
            boolean r3 = d(r10, r12, r3, r4)     // Catch:{ all -> 0x02fd }
            r11.setEnableTimeToFullDisplayTracing(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "io.sentry.traces.idle-timeout"
            r4 = -1
            long r6 = h(r10, r12, r3, r4)     // Catch:{ all -> 0x02fd }
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0250
            java.lang.Long r3 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x02fd }
            r11.setIdleTimeout(r3)     // Catch:{ all -> 0x02fd }
        L_0x0250:
            java.util.List r3 = g(r10, r12, r1)     // Catch:{ all -> 0x02fd }
            boolean r4 = r10.containsKey(r1)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = "io.sentry.traces.tracing-origins"
            if (r4 != 0) goto L_0x0268
            if (r3 == 0) goto L_0x0264
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x02fd }
            if (r4 == 0) goto L_0x0268
        L_0x0264:
            java.util.List r3 = g(r10, r12, r5)     // Catch:{ all -> 0x02fd }
        L_0x0268:
            boolean r1 = r10.containsKey(r1)     // Catch:{ all -> 0x02fd }
            if (r1 != 0) goto L_0x0274
            boolean r1 = r10.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r1 == 0) goto L_0x027e
        L_0x0274:
            if (r3 != 0) goto L_0x027e
            java.util.List r1 = java.util.Collections.emptyList()     // Catch:{ all -> 0x02fd }
            r11.setTracePropagationTargets(r1)     // Catch:{ all -> 0x02fd }
            goto L_0x0283
        L_0x027e:
            if (r3 == 0) goto L_0x0283
            r11.setTracePropagationTargets(r3)     // Catch:{ all -> 0x02fd }
        L_0x0283:
            java.lang.String r1 = "io.sentry.traces.frames-tracking"
            r3 = 1
            boolean r1 = d(r10, r12, r1, r3)     // Catch:{ all -> 0x02fd }
            r11.setEnableFramesTracking(r1)     // Catch:{ all -> 0x02fd }
            java.lang.String r1 = "io.sentry.proguard-uuid"
            java.lang.String r3 = r11.getProguardUuid()     // Catch:{ all -> 0x02fd }
            java.lang.String r1 = i(r10, r12, r1, r3)     // Catch:{ all -> 0x02fd }
            r11.setProguardUuid(r1)     // Catch:{ all -> 0x02fd }
            io.sentry.protocol.m r1 = r11.getSdkVersion()     // Catch:{ all -> 0x02fd }
            if (r1 != 0) goto L_0x02a5
            io.sentry.protocol.m r1 = new io.sentry.protocol.m     // Catch:{ all -> 0x02fd }
            r1.<init>(r0, r0)     // Catch:{ all -> 0x02fd }
        L_0x02a5:
            java.lang.String r0 = "io.sentry.sdk.name"
            java.lang.String r3 = r1.e()     // Catch:{ all -> 0x02fd }
            java.lang.String r0 = j(r10, r12, r0, r3)     // Catch:{ all -> 0x02fd }
            r1.h(r0)     // Catch:{ all -> 0x02fd }
            java.lang.String r0 = "io.sentry.sdk.version"
            java.lang.String r3 = r1.g()     // Catch:{ all -> 0x02fd }
            java.lang.String r0 = j(r10, r12, r0, r3)     // Catch:{ all -> 0x02fd }
            r1.j(r0)     // Catch:{ all -> 0x02fd }
            r11.setSdkVersion(r1)     // Catch:{ all -> 0x02fd }
            java.lang.String r0 = "io.sentry.send-default-pii"
            boolean r1 = r11.isSendDefaultPii()     // Catch:{ all -> 0x02fd }
            boolean r0 = d(r10, r12, r0, r1)     // Catch:{ all -> 0x02fd }
            r11.setSendDefaultPii(r0)     // Catch:{ all -> 0x02fd }
            java.lang.String r0 = "io.sentry.gradle-plugin-integrations"
            java.util.List r10 = g(r10, r12, r0)     // Catch:{ all -> 0x02fd }
            if (r10 == 0) goto L_0x02ef
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x02fd }
        L_0x02db:
            boolean r12 = r10.hasNext()     // Catch:{ all -> 0x02fd }
            if (r12 == 0) goto L_0x02ef
            java.lang.Object r12 = r10.next()     // Catch:{ all -> 0x02fd }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x02fd }
            io.sentry.u3 r0 = io.sentry.u3.c()     // Catch:{ all -> 0x02fd }
            r0.a(r12)     // Catch:{ all -> 0x02fd }
            goto L_0x02db
        L_0x02ef:
            io.sentry.h0 r10 = r11.getLogger()     // Catch:{ all -> 0x02fd }
            io.sentry.SentryLevel r12 = io.sentry.SentryLevel.INFO     // Catch:{ all -> 0x02fd }
            java.lang.String r0 = "Retrieving configuration from AndroidManifest.xml"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x02fd }
            r10.c(r12, r0, r1)     // Catch:{ all -> 0x02fd }
            goto L_0x0309
        L_0x02fd:
            r10 = move-exception
            io.sentry.h0 r11 = r11.getLogger()
            io.sentry.SentryLevel r12 = io.sentry.SentryLevel.ERROR
            java.lang.String r0 = "Failed to read configuration from android manifest metadata."
            r11.b(r12, r0, r10)
        L_0x0309:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.v0.a(android.content.Context, io.sentry.android.core.SentryAndroidOptions, io.sentry.android.core.i0):void");
    }

    private static Bundle b(Context context, h0 h0Var, i0 i0Var) throws PackageManager.NameNotFoundException {
        if (i0Var == null) {
            i0Var = new i0(h0Var);
        }
        return j0.a(context, 128, i0Var).metaData;
    }

    static boolean c(Context context, h0 h0Var) {
        l.c(context, "The application context is required.");
        boolean z10 = true;
        try {
            Bundle b10 = b(context, h0Var, (i0) null);
            if (b10 != null) {
                z10 = d(b10, h0Var, "io.sentry.auto-init", true);
            }
            h0Var.c(SentryLevel.INFO, "Retrieving auto-init from AndroidManifest.xml", new Object[0]);
        } catch (Throwable th2) {
            h0Var.b(SentryLevel.ERROR, "Failed to read auto-init from android manifest metadata.", th2);
        }
        return z10;
    }

    private static boolean d(Bundle bundle, h0 h0Var, String str, boolean z10) {
        boolean z11 = bundle.getBoolean(str, z10);
        h0Var.c(SentryLevel.DEBUG, "%s read: %s", str, Boolean.valueOf(z11));
        return z11;
    }

    private static Boolean e(Bundle bundle, h0 h0Var, String str, Boolean bool) {
        boolean z10;
        if (bundle.getSerializable(str) != null) {
            if (bool == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            boolean z11 = bundle.getBoolean(str, z10);
            h0Var.c(SentryLevel.DEBUG, "%s read: %s", str, Boolean.valueOf(z11));
            return Boolean.valueOf(z11);
        }
        h0Var.c(SentryLevel.DEBUG, "%s used default %s", str, bool);
        return bool;
    }

    private static Double f(Bundle bundle, h0 h0Var, String str) {
        Double valueOf = Double.valueOf(Float.valueOf(bundle.getFloat(str, -1.0f)).doubleValue());
        h0Var.c(SentryLevel.DEBUG, "%s read: %s", str, valueOf);
        return valueOf;
    }

    private static List<String> g(Bundle bundle, h0 h0Var, String str) {
        String string = bundle.getString(str);
        h0Var.c(SentryLevel.DEBUG, "%s read: %s", str, string);
        if (string != null) {
            return Arrays.asList(string.split(AppsFlyerKit.COMMA, -1));
        }
        return null;
    }

    private static long h(Bundle bundle, h0 h0Var, String str, long j10) {
        long j11 = (long) bundle.getInt(str, (int) j10);
        h0Var.c(SentryLevel.DEBUG, "%s read: %s", str, Long.valueOf(j11));
        return j11;
    }

    private static String i(Bundle bundle, h0 h0Var, String str, String str2) {
        String string = bundle.getString(str, str2);
        h0Var.c(SentryLevel.DEBUG, "%s read: %s", str, string);
        return string;
    }

    private static String j(Bundle bundle, h0 h0Var, String str, String str2) {
        String string = bundle.getString(str, str2);
        h0Var.c(SentryLevel.DEBUG, "%s read: %s", str, string);
        return string;
    }
}
