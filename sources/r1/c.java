package r1;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.Recreator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f17246d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final d f17247a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.savedstate.a f17248b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17249c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a(d dVar) {
            j.g(dVar, "owner");
            return new c(dVar, (DefaultConstructorMarker) null);
        }
    }

    private c(d dVar) {
        this.f17247a = dVar;
        this.f17248b = new androidx.savedstate.a();
    }

    public /* synthetic */ c(d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar);
    }

    public static final c a(d dVar) {
        return f17246d.a(dVar);
    }

    public final androidx.savedstate.a b() {
        return this.f17248b;
    }

    public final void c() {
        boolean z10;
        Lifecycle lifecycle = this.f17247a.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.INITIALIZED) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            lifecycle.a(new Recreator(this.f17247a));
            this.f17248b.e(lifecycle);
            this.f17249c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    public final void d(Bundle bundle) {
        if (!this.f17249c) {
            c();
        }
        Lifecycle lifecycle = this.f17247a.getLifecycle();
        if (!lifecycle.b().b(Lifecycle.State.STARTED)) {
            this.f17248b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        j.g(bundle, "outBundle");
        this.f17248b.g(bundle);
    }
}
