package androidx.activity;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private boolean f353a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f354b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private Function0<Unit> f355c;

    public l(boolean z10) {
        this.f353a = z10;
    }

    public final void a(a aVar) {
        j.g(aVar, "cancellable");
        this.f354b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f353a;
    }

    public final void d() {
        for (a cancel : this.f354b) {
            cancel.cancel();
        }
    }

    public final void e(a aVar) {
        j.g(aVar, "cancellable");
        this.f354b.remove(aVar);
    }

    public final void f(boolean z10) {
        this.f353a = z10;
        Function0<Unit> function0 = this.f355c;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void g(Function0<Unit> function0) {
        this.f355c = function0;
    }
}
