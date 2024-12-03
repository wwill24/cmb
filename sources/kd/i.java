package kd;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import fk.a;
import gd.b;
import ld.u;
import md.d;

public final class i implements b<u> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f41090a;

    /* renamed from: b  reason: collision with root package name */
    private final a<d> f41091b;

    /* renamed from: c  reason: collision with root package name */
    private final a<SchedulerConfig> f41092c;

    /* renamed from: d  reason: collision with root package name */
    private final a<od.a> f41093d;

    public i(a<Context> aVar, a<d> aVar2, a<SchedulerConfig> aVar3, a<od.a> aVar4) {
        this.f41090a = aVar;
        this.f41091b = aVar2;
        this.f41092c = aVar3;
        this.f41093d = aVar4;
    }

    public static i a(a<Context> aVar, a<d> aVar2, a<SchedulerConfig> aVar3, a<od.a> aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static u c(Context context, d dVar, SchedulerConfig schedulerConfig, od.a aVar) {
        return (u) gd.d.c(h.a(context, dVar, schedulerConfig, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b */
    public u get() {
        return c(this.f41090a.get(), this.f41091b.get(), this.f41092c.get(), this.f41093d.get());
    }
}
