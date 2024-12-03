package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class SchedulerConfig {

    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private od.a f38156a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Priority, b> f38157b = new HashMap();

        public a a(Priority priority, b bVar) {
            this.f38157b.put(priority, bVar);
            return this;
        }

        public SchedulerConfig b() {
            if (this.f38156a == null) {
                throw new NullPointerException("missing required property: clock");
            } else if (this.f38157b.keySet().size() >= Priority.values().length) {
                Map<Priority, b> map = this.f38157b;
                this.f38157b = new HashMap();
                return SchedulerConfig.d(this.f38156a, map);
            } else {
                throw new IllegalStateException("Not all priorities have been configured");
            }
        }

        public a c(od.a aVar) {
            this.f38156a = aVar;
            return this;
        }
    }

    public static abstract class b {

        public static abstract class a {
            public abstract b a();

            public abstract a b(long j10);

            public abstract a c(Set<Flag> set);

            public abstract a d(long j10);
        }

        public static a a() {
            return new b.C0479b().c(Collections.emptySet());
        }

        /* access modifiers changed from: package-private */
        public abstract long b();

        /* access modifiers changed from: package-private */
        public abstract Set<Flag> c();

        /* access modifiers changed from: package-private */
        public abstract long d();
    }

    private long a(int i10, long j10) {
        long j11;
        int i11 = i10 - 1;
        if (j10 > 1) {
            j11 = j10;
        } else {
            j11 = 2;
        }
        return (long) (Math.pow(3.0d, (double) i11) * ((double) j10) * Math.max(1.0d, Math.log(10000.0d) / Math.log((double) (j11 * ((long) i11)))));
    }

    public static a b() {
        return new a();
    }

    static SchedulerConfig d(od.a aVar, Map<Priority, b> map) {
        return new a(aVar, map);
    }

    public static SchedulerConfig f(od.a aVar) {
        return b().a(Priority.DEFAULT, b.a().b(30000).d(86400000).a()).a(Priority.HIGHEST, b.a().b(1000).d(86400000).a()).a(Priority.VERY_LOW, b.a().b(86400000).d(86400000).c(i(Flag.DEVICE_IDLE)).a()).c(aVar).b();
    }

    private static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    private void j(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j10, int i10) {
        builder.setMinimumLatency(g(priority, j10, i10));
        j(builder, h().get(priority).c());
        return builder;
    }

    /* access modifiers changed from: package-private */
    public abstract od.a e();

    public long g(Priority priority, long j10, int i10) {
        long a10 = j10 - e().a();
        b bVar = h().get(priority);
        return Math.min(Math.max(a(i10, bVar.b()), a10), bVar.d());
    }

    /* access modifiers changed from: package-private */
    public abstract Map<Priority, b> h();
}
