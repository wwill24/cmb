package d6;

import com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent;
import com.jakewharton.rxrelay2.c;
import qj.q;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<FragmentLifecycleEvent> f14464a;

    /* renamed from: b  reason: collision with root package name */
    private final c<FragmentLifecycleEvent> f14465b;

    public b() {
        com.jakewharton.rxrelay2.b<FragmentLifecycleEvent> C0 = com.jakewharton.rxrelay2.b.C0();
        this.f14464a = C0;
        this.f14465b = C0.A0();
    }

    public q<FragmentLifecycleEvent> a() {
        return this.f14465b.P();
    }

    public FragmentLifecycleEvent b() {
        return this.f14464a.E0();
    }

    public void c(FragmentLifecycleEvent fragmentLifecycleEvent) {
        this.f14464a.accept(fragmentLifecycleEvent);
    }
}
