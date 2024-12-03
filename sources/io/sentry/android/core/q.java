package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import io.sentry.SentryLevel;
import io.sentry.d0;
import io.sentry.e;
import io.sentry.h0;
import io.sentry.util.d;
import io.sentry.util.l;
import io.sentry.x1;
import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class q implements d0 {

    /* renamed from: a  reason: collision with root package name */
    private long f31089a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f31090b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f31091c = 1;

    /* renamed from: d  reason: collision with root package name */
    private long f31092d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final long f31093e = 1000000000;

    /* renamed from: f  reason: collision with root package name */
    private double f31094f = (1.0E9d / ((double) 1));

    /* renamed from: g  reason: collision with root package name */
    private final File f31095g = new File("/proc/self/stat");

    /* renamed from: h  reason: collision with root package name */
    private final h0 f31096h;

    /* renamed from: i  reason: collision with root package name */
    private final i0 f31097i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31098j = false;

    public q(h0 h0Var, i0 i0Var) {
        this.f31096h = (h0) l.c(h0Var, "Logger is required.");
        this.f31097i = (i0) l.c(i0Var, "BuildInfoProvider is required.");
    }

    private long c() {
        String str;
        try {
            str = d.b(this.f31095g);
        } catch (IOException e10) {
            this.f31098j = false;
            this.f31096h.b(SentryLevel.WARNING, "Unable to read /proc/self/stat file. Disabling cpu collection.", e10);
            str = null;
        }
        if (str != null) {
            String[] split = str.trim().split("[\n\t\r ]");
            try {
                long parseLong = Long.parseLong(split[13]);
                long parseLong2 = Long.parseLong(split[14]);
                return (long) (((double) (parseLong + parseLong2 + Long.parseLong(split[15]) + Long.parseLong(split[16]))) * this.f31094f);
            } catch (NumberFormatException e11) {
                this.f31096h.b(SentryLevel.ERROR, "Error parsing /proc/self/stat file.", e11);
            }
        }
        return 0;
    }

    @SuppressLint({"NewApi"})
    public void a() {
        if (this.f31097i.d() < 21) {
            this.f31098j = false;
            return;
        }
        this.f31098j = true;
        this.f31091c = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.f31092d = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
        this.f31094f = 1.0E9d / ((double) this.f31091c);
        this.f31090b = c();
    }

    @SuppressLint({"NewApi"})
    public void b(x1 x1Var) {
        if (this.f31097i.d() >= 21 && this.f31098j) {
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long j10 = elapsedRealtimeNanos - this.f31089a;
            this.f31089a = elapsedRealtimeNanos;
            long c10 = c();
            this.f31090b = c10;
            x1Var.a(new e(System.currentTimeMillis(), ((((double) (c10 - this.f31090b)) / ((double) j10)) / ((double) this.f31092d)) * 100.0d));
        }
    }
}
