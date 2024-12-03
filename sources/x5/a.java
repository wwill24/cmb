package x5;

import com.jakewharton.rxrelay2.b;
import java.util.ArrayList;
import java.util.List;
import qj.q;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private List<b> f18556a;

    /* renamed from: b  reason: collision with root package name */
    private b<List<b>> f18557b;

    public a() {
        ArrayList arrayList = new ArrayList();
        this.f18556a = arrayList;
        this.f18557b = b.D0(arrayList);
    }

    public q<List<b>> a() {
        return this.f18557b.P().d0(1).C0();
    }

    public b b(int i10) {
        for (b next : this.f18556a) {
            if (next.c() == i10) {
                return next;
            }
        }
        return null;
    }

    public void c(List<b> list) {
        this.f18556a.clear();
        this.f18556a.addAll(list);
        d();
    }

    public void d() {
        this.f18557b.accept(this.f18556a);
    }
}
