package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f4869a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<a0> f4870b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<a0, a> f4871c = new HashMap();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f4872a;

        /* renamed from: b  reason: collision with root package name */
        private i f4873b;

        a(@NonNull Lifecycle lifecycle, @NonNull i iVar) {
            this.f4872a = lifecycle;
            this.f4873b = iVar;
            lifecycle.a(iVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f4872a.d(this.f4873b);
            this.f4873b = null;
        }
    }

    public l(@NonNull Runnable runnable) {
        this.f4869a = runnable;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(a0 a0Var, androidx.lifecycle.l lVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(a0Var);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Lifecycle.State state, a0 a0Var, androidx.lifecycle.l lVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.d(state)) {
            c(a0Var);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            l(a0Var);
        } else if (event == Lifecycle.Event.b(state)) {
            this.f4870b.remove(a0Var);
            this.f4869a.run();
        }
    }

    public void c(@NonNull a0 a0Var) {
        this.f4870b.add(a0Var);
        this.f4869a.run();
    }

    public void d(@NonNull a0 a0Var, @NonNull androidx.lifecycle.l lVar) {
        c(a0Var);
        Lifecycle lifecycle = lVar.getLifecycle();
        a remove = this.f4871c.remove(a0Var);
        if (remove != null) {
            remove.a();
        }
        this.f4871c.put(a0Var, new a(lifecycle, new j(this, a0Var)));
    }

    @SuppressLint({"LambdaLast"})
    public void e(@NonNull a0 a0Var, @NonNull androidx.lifecycle.l lVar, @NonNull Lifecycle.State state) {
        Lifecycle lifecycle = lVar.getLifecycle();
        a remove = this.f4871c.remove(a0Var);
        if (remove != null) {
            remove.a();
        }
        this.f4871c.put(a0Var, new a(lifecycle, new k(this, state, a0Var)));
    }

    public void h(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        Iterator<a0> it = this.f4870b.iterator();
        while (it.hasNext()) {
            it.next().d(menu, menuInflater);
        }
    }

    public void i(@NonNull Menu menu) {
        Iterator<a0> it = this.f4870b.iterator();
        while (it.hasNext()) {
            it.next().a(menu);
        }
    }

    public boolean j(@NonNull MenuItem menuItem) {
        Iterator<a0> it = this.f4870b.iterator();
        while (it.hasNext()) {
            if (it.next().c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(@NonNull Menu menu) {
        Iterator<a0> it = this.f4870b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public void l(@NonNull a0 a0Var) {
        this.f4870b.remove(a0Var);
        a remove = this.f4871c.remove(a0Var);
        if (remove != null) {
            remove.a();
        }
        this.f4869a.run();
    }
}
