package t2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import c3.j;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import java.util.ArrayList;
import java.util.List;
import u2.a;
import u2.p;
import w2.e;
import x2.l;
import y2.c;
import y2.k;

public class d implements e, m, a.b, e {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f17667a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f17668b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f17669c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f17670d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f17671e;

    /* renamed from: f  reason: collision with root package name */
    private final String f17672f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f17673g;

    /* renamed from: h  reason: collision with root package name */
    private final List<c> f17674h;

    /* renamed from: i  reason: collision with root package name */
    private final LottieDrawable f17675i;

    /* renamed from: j  reason: collision with root package name */
    private List<m> f17676j;

    /* renamed from: k  reason: collision with root package name */
    private p f17677k;

    public d(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, k kVar, h hVar) {
        this(lottieDrawable, aVar, kVar.c(), kVar.d(), g(lottieDrawable, hVar, aVar, kVar.b()), i(kVar.b()));
    }

    private static List<c> g(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar, List<c> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            c a10 = list.get(i10).a(lottieDrawable, hVar, aVar);
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    static l i(List<c> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof l) {
                return (l) cVar;
            }
        }
        return null;
    }

    private boolean m() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f17674h.size(); i11++) {
            if ((this.f17674h.get(i11) instanceof e) && (i10 = i10 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.f17675i.invalidateSelf();
    }

    public void b(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f17674h.size());
        arrayList.addAll(list);
        for (int size = this.f17674h.size() - 1; size >= 0; size--) {
            c cVar = this.f17674h.get(size);
            cVar.b(arrayList, this.f17674h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    public <T> void c(T t10, d3.c<T> cVar) {
        p pVar = this.f17677k;
        if (pVar != null) {
            pVar.c(t10, cVar);
        }
    }

    public void e(w2.d dVar, int i10, List<w2.d> list, w2.d dVar2) {
        if (dVar.g(getName(), i10) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i10)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i10)) {
                int e10 = i10 + dVar.e(getName(), i10);
                for (int i11 = 0; i11 < this.f17674h.size(); i11++) {
                    c cVar = this.f17674h.get(i11);
                    if (cVar instanceof e) {
                        ((e) cVar).e(dVar, e10, list, dVar2);
                    }
                }
            }
        }
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f17669c.set(matrix);
        p pVar = this.f17677k;
        if (pVar != null) {
            this.f17669c.preConcat(pVar.f());
        }
        this.f17671e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f17674h.size() - 1; size >= 0; size--) {
            c cVar = this.f17674h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).f(this.f17671e, this.f17669c, z10);
                rectF.union(this.f17671e);
            }
        }
    }

    public String getName() {
        return this.f17672f;
    }

    public Path getPath() {
        this.f17669c.reset();
        p pVar = this.f17677k;
        if (pVar != null) {
            this.f17669c.set(pVar.f());
        }
        this.f17670d.reset();
        if (this.f17673g) {
            return this.f17670d;
        }
        for (int size = this.f17674h.size() - 1; size >= 0; size--) {
            c cVar = this.f17674h.get(size);
            if (cVar instanceof m) {
                this.f17670d.addPath(((m) cVar).getPath(), this.f17669c);
            }
        }
        return this.f17670d;
    }

    public void h(Canvas canvas, Matrix matrix, int i10) {
        boolean z10;
        int i11;
        if (!this.f17673g) {
            this.f17669c.set(matrix);
            p pVar = this.f17677k;
            if (pVar != null) {
                this.f17669c.preConcat(pVar.f());
                if (this.f17677k.h() == null) {
                    i11 = 100;
                } else {
                    i11 = this.f17677k.h().h().intValue();
                }
                i10 = (int) ((((((float) i11) / 100.0f) * ((float) i10)) / 255.0f) * 255.0f);
            }
            if (!this.f17675i.b0() || !m() || i10 == 255) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                this.f17668b.set(0.0f, 0.0f, 0.0f, 0.0f);
                f(this.f17668b, this.f17669c, true);
                this.f17667a.setAlpha(i10);
                j.m(canvas, this.f17668b, this.f17667a);
            }
            if (z10) {
                i10 = 255;
            }
            for (int size = this.f17674h.size() - 1; size >= 0; size--) {
                c cVar = this.f17674h.get(size);
                if (cVar instanceof e) {
                    ((e) cVar).h(canvas, this.f17669c, i10);
                }
            }
            if (z10) {
                canvas.restore();
            }
        }
    }

    public List<c> j() {
        return this.f17674h;
    }

    /* access modifiers changed from: package-private */
    public List<m> k() {
        if (this.f17676j == null) {
            this.f17676j = new ArrayList();
            for (int i10 = 0; i10 < this.f17674h.size(); i10++) {
                c cVar = this.f17674h.get(i10);
                if (cVar instanceof m) {
                    this.f17676j.add((m) cVar);
                }
            }
        }
        return this.f17676j;
    }

    /* access modifiers changed from: package-private */
    public Matrix l() {
        p pVar = this.f17677k;
        if (pVar != null) {
            return pVar.f();
        }
        this.f17669c.reset();
        return this.f17669c;
    }

    d(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, String str, boolean z10, List<c> list, l lVar) {
        this.f17667a = new s2.a();
        this.f17668b = new RectF();
        this.f17669c = new Matrix();
        this.f17670d = new Path();
        this.f17671e = new RectF();
        this.f17672f = str;
        this.f17675i = lottieDrawable;
        this.f17673g = z10;
        this.f17674h = list;
        if (lVar != null) {
            p b10 = lVar.b();
            this.f17677k = b10;
            b10.a(aVar);
            this.f17677k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).g(list.listIterator(list.size()));
        }
    }
}
