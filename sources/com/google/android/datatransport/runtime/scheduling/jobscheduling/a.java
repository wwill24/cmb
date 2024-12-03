package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Map;

final class a extends SchedulerConfig {

    /* renamed from: a  reason: collision with root package name */
    private final od.a f38158a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Priority, SchedulerConfig.b> f38159b;

    a(od.a aVar, Map<Priority, SchedulerConfig.b> map) {
        if (aVar != null) {
            this.f38158a = aVar;
            if (map != null) {
                this.f38159b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    /* access modifiers changed from: package-private */
    public od.a e() {
        return this.f38158a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        if (!this.f38158a.equals(schedulerConfig.e()) || !this.f38159b.equals(schedulerConfig.h())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public Map<Priority, SchedulerConfig.b> h() {
        return this.f38159b;
    }

    public int hashCode() {
        return ((this.f38158a.hashCode() ^ 1000003) * 1000003) ^ this.f38159b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f38158a + ", values=" + this.f38159b + "}";
    }
}
