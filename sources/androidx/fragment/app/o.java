package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class o {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f5869a = new CopyOnWriteArrayList<>();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f5870b;

    private static final class a {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final FragmentManager.k f5871a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f5872b;

        a(@NonNull FragmentManager.k kVar, boolean z10) {
            this.f5871a = kVar;
            this.f5872b = z10;
        }
    }

    o(@NonNull FragmentManager fragmentManager) {
        this.f5870b = fragmentManager;
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull Fragment fragment, Bundle bundle, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().a(fragment, bundle, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentActivityCreated(this.f5870b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull Fragment fragment, boolean z10) {
        Context f10 = this.f5870b.w0().f();
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().b(fragment, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentAttached(this.f5870b, fragment, f10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull Fragment fragment, Bundle bundle, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().c(fragment, bundle, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentCreated(this.f5870b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull Fragment fragment, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().d(fragment, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentDestroyed(this.f5870b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull Fragment fragment, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().e(fragment, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentDetached(this.f5870b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(@NonNull Fragment fragment, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().f(fragment, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentPaused(this.f5870b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull Fragment fragment, boolean z10) {
        Context f10 = this.f5870b.w0().f();
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().g(fragment, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentPreAttached(this.f5870b, fragment, f10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull Fragment fragment, Bundle bundle, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().h(fragment, bundle, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentPreCreated(this.f5870b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull Fragment fragment, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().i(fragment, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentResumed(this.f5870b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j(@NonNull Fragment fragment, @NonNull Bundle bundle, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().j(fragment, bundle, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentSaveInstanceState(this.f5870b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(@NonNull Fragment fragment, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().k(fragment, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentStarted(this.f5870b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(@NonNull Fragment fragment, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().l(fragment, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentStopped(this.f5870b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(@NonNull Fragment fragment, @NonNull View view, Bundle bundle, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentViewCreated(this.f5870b, fragment, view, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n(@NonNull Fragment fragment, boolean z10) {
        Fragment z02 = this.f5870b.z0();
        if (z02 != null) {
            z02.getParentFragmentManager().y0().n(fragment, true);
        }
        Iterator<a> it = this.f5869a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f5872b) {
                next.f5871a.onFragmentViewDestroyed(this.f5870b, fragment);
            }
        }
    }

    public void o(@NonNull FragmentManager.k kVar, boolean z10) {
        this.f5869a.add(new a(kVar, z10));
    }

    public void p(@NonNull FragmentManager.k kVar) {
        synchronized (this.f5869a) {
            int i10 = 0;
            int size = this.f5869a.size();
            while (true) {
                if (i10 >= size) {
                    break;
                } else if (this.f5869a.get(i10).f5871a == kVar) {
                    this.f5869a.remove(i10);
                    break;
                } else {
                    i10++;
                }
            }
        }
    }
}
