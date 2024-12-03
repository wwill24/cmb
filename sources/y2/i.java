package y2;

import android.graphics.PointF;
import c3.f;
import java.util.ArrayList;
import java.util.List;
import w2.a;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f18615a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f18616b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18617c;

    public i(PointF pointF, boolean z10, List<a> list) {
        this.f18616b = pointF;
        this.f18617c = z10;
        this.f18615a = new ArrayList(list);
    }

    public List<a> a() {
        return this.f18615a;
    }

    public PointF b() {
        return this.f18616b;
    }

    public void c(i iVar, i iVar2, float f10) {
        boolean z10;
        if (this.f18616b == null) {
            this.f18616b = new PointF();
        }
        if (iVar.d() || iVar2.d()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f18617c = z10;
        if (iVar.a().size() != iVar2.a().size()) {
            f.c("Curves must have the same number of control points. Shape 1: " + iVar.a().size() + "\tShape 2: " + iVar2.a().size());
        }
        int min = Math.min(iVar.a().size(), iVar2.a().size());
        if (this.f18615a.size() < min) {
            for (int size = this.f18615a.size(); size < min; size++) {
                this.f18615a.add(new a());
            }
        } else if (this.f18615a.size() > min) {
            for (int size2 = this.f18615a.size() - 1; size2 >= min; size2--) {
                List<a> list = this.f18615a;
                list.remove(list.size() - 1);
            }
        }
        PointF b10 = iVar.b();
        PointF b11 = iVar2.b();
        f(c3.i.i(b10.x, b11.x, f10), c3.i.i(b10.y, b11.y, f10));
        for (int size3 = this.f18615a.size() - 1; size3 >= 0; size3--) {
            a aVar = iVar.a().get(size3);
            a aVar2 = iVar2.a().get(size3);
            PointF a10 = aVar.a();
            PointF b12 = aVar.b();
            PointF c10 = aVar.c();
            PointF a11 = aVar2.a();
            PointF b13 = aVar2.b();
            PointF c11 = aVar2.c();
            this.f18615a.get(size3).d(c3.i.i(a10.x, a11.x, f10), c3.i.i(a10.y, a11.y, f10));
            this.f18615a.get(size3).e(c3.i.i(b12.x, b13.x, f10), c3.i.i(b12.y, b13.y, f10));
            this.f18615a.get(size3).f(c3.i.i(c10.x, c11.x, f10), c3.i.i(c10.y, c11.y, f10));
        }
    }

    public boolean d() {
        return this.f18617c;
    }

    public void e(boolean z10) {
        this.f18617c = z10;
    }

    public void f(float f10, float f11) {
        if (this.f18616b == null) {
            this.f18616b = new PointF();
        }
        this.f18616b.set(f10, f11);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f18615a.size() + "closed=" + this.f18617c + '}';
    }

    public i() {
        this.f18615a = new ArrayList();
    }
}
