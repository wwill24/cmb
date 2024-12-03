package b6;

import android.view.MenuItem;
import b6.i;
import b6.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class q<C extends j, I extends i> {

    /* renamed from: a  reason: collision with root package name */
    private final List<q> f7871a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final C f7872b;

    /* renamed from: c  reason: collision with root package name */
    private final I f7873c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7874d;

    public q(C c10, I i10) {
        this.f7872b = c10;
        this.f7873c = i10;
        c10.l1(i10);
        i10.E1(this);
    }

    /* access modifiers changed from: protected */
    public void a(q<?, ?> qVar) {
        this.f7871a.add(qVar);
        qVar.c();
    }

    /* access modifiers changed from: protected */
    public void b(q qVar) {
        this.f7871a.remove(qVar);
        qVar.d();
    }

    public void c() {
        if (!this.f7874d) {
            this.f7874d = true;
        }
        j();
        this.f7873c.z1();
    }

    public void d() {
        this.f7873c.A1();
        k();
        Iterator<q> it = this.f7871a.iterator();
        while (it.hasNext()) {
            it.remove();
            it.next().d();
        }
    }

    public C e() {
        return this.f7872b;
    }

    public I f() {
        return this.f7873c;
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        if (g()) {
            return true;
        }
        for (q h10 : this.f7871a) {
            if (h10.h()) {
                return true;
            }
        }
        return false;
    }

    public boolean i(MenuItem menuItem) {
        for (q i10 : this.f7871a) {
            if (i10.i(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public void k() {
    }
}
