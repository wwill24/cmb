package d6;

import com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent;
import com.jakewharton.rxrelay2.b;
import com.jakewharton.rxrelay2.c;
import qj.q;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final b<ActivityLifecycleEvent> f14462a;

    /* renamed from: b  reason: collision with root package name */
    private final c<ActivityLifecycleEvent> f14463b;

    public a() {
        b<ActivityLifecycleEvent> C0 = b.C0();
        this.f14462a = C0;
        this.f14463b = C0.A0();
    }

    public q<ActivityLifecycleEvent> a() {
        return this.f14463b.P();
    }

    public ActivityLifecycleEvent b() {
        return this.f14462a.E0();
    }

    public void c(ActivityLifecycleEvent activityLifecycleEvent) {
        this.f14462a.accept(activityLifecycleEvent);
    }
}
