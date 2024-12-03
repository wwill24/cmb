package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

final class b extends SchedulerConfig.b {

    /* renamed from: a  reason: collision with root package name */
    private final long f38160a;

    /* renamed from: b  reason: collision with root package name */
    private final long f38161b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<SchedulerConfig.Flag> f38162c;

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.b$b  reason: collision with other inner class name */
    static final class C0479b extends SchedulerConfig.b.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f38163a;

        /* renamed from: b  reason: collision with root package name */
        private Long f38164b;

        /* renamed from: c  reason: collision with root package name */
        private Set<SchedulerConfig.Flag> f38165c;

        C0479b() {
        }

        public SchedulerConfig.b a() {
            String str = "";
            if (this.f38163a == null) {
                str = str + " delta";
            }
            if (this.f38164b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f38165c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new b(this.f38163a.longValue(), this.f38164b.longValue(), this.f38165c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public SchedulerConfig.b.a b(long j10) {
            this.f38163a = Long.valueOf(j10);
            return this;
        }

        public SchedulerConfig.b.a c(Set<SchedulerConfig.Flag> set) {
            if (set != null) {
                this.f38165c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        public SchedulerConfig.b.a d(long j10) {
            this.f38164b = Long.valueOf(j10);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.f38160a;
    }

    /* access modifiers changed from: package-private */
    public Set<SchedulerConfig.Flag> c() {
        return this.f38162c;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.f38161b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.b)) {
            return false;
        }
        SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
        if (this.f38160a == bVar.b() && this.f38161b == bVar.d() && this.f38162c.equals(bVar.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f38160a;
        long j11 = this.f38161b;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f38162c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f38160a + ", maxAllowedDelay=" + this.f38161b + ", flags=" + this.f38162c + "}";
    }

    private b(long j10, long j11, Set<SchedulerConfig.Flag> set) {
        this.f38160a = j10;
        this.f38161b = j11;
        this.f38162c = set;
    }
}
