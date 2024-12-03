package kd;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import fk.a;
import gd.b;
import gd.d;

public final class g implements b<SchedulerConfig> {

    /* renamed from: a  reason: collision with root package name */
    private final a<od.a> f41089a;

    public g(a<od.a> aVar) {
        this.f41089a = aVar;
    }

    public static SchedulerConfig a(od.a aVar) {
        return (SchedulerConfig) d.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(a<od.a> aVar) {
        return new g(aVar);
    }

    /* renamed from: c */
    public SchedulerConfig get() {
        return a(this.f41089a.get());
    }
}
