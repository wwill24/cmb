package d2;

import b2.f;
import e2.a;
import e2.b;
import e2.c;
import e2.d;
import e2.g;
import e2.h;
import f2.n;
import g2.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0001\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013¢\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001a\u0010\u001eJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0016J\u0016\u0010\u000f\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0016R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u001e\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018¨\u0006\u001f"}, d2 = {"Ld2/e;", "Ld2/d;", "Le2/c$a;", "", "Lg2/u;", "workSpecs", "", "a", "reset", "", "workSpecId", "", "d", "", "b", "c", "Ld2/c;", "Ld2/c;", "callback", "", "Le2/c;", "[Le2/c;", "constraintControllers", "", "Ljava/lang/Object;", "lock", "<init>", "(Ld2/c;[Le2/c;)V", "Lf2/n;", "trackers", "(Lf2/n;Ld2/c;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class e implements d, c.a {

    /* renamed from: a  reason: collision with root package name */
    private final c f14401a;

    /* renamed from: b  reason: collision with root package name */
    private final c<?>[] f14402b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f14403c;

    public e(c cVar, c<?>[] cVarArr) {
        j.g(cVarArr, "constraintControllers");
        this.f14401a = cVar;
        this.f14402b = cVarArr;
        this.f14403c = new Object();
    }

    public void a(Iterable<u> iterable) {
        j.g(iterable, "workSpecs");
        synchronized (this.f14403c) {
            for (c<?> g10 : this.f14402b) {
                g10.g((c.a) null);
            }
            for (c<?> e10 : this.f14402b) {
                e10.e(iterable);
            }
            for (c<?> g11 : this.f14402b) {
                g11.g(this);
            }
            Unit unit = Unit.f32013a;
        }
    }

    public void b(List<u> list) {
        j.g(list, "workSpecs");
        synchronized (this.f14403c) {
            ArrayList<u> arrayList = new ArrayList<>();
            for (T next : list) {
                if (d(((u) next).f15077a)) {
                    arrayList.add(next);
                }
            }
            for (u uVar : arrayList) {
                f e10 = f.e();
                String a10 = f.f14404a;
                e10.a(a10, "Constraints met for " + uVar);
            }
            c cVar = this.f14401a;
            if (cVar != null) {
                cVar.f(arrayList);
                Unit unit = Unit.f32013a;
            }
        }
    }

    public void c(List<u> list) {
        j.g(list, "workSpecs");
        synchronized (this.f14403c) {
            c cVar = this.f14401a;
            if (cVar != null) {
                cVar.b(list);
                Unit unit = Unit.f32013a;
            }
        }
    }

    public final boolean d(String str) {
        boolean z10;
        c<?> cVar;
        j.g(str, "workSpecId");
        synchronized (this.f14403c) {
            c<?>[] cVarArr = this.f14402b;
            int length = cVarArr.length;
            z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    cVar = null;
                    break;
                }
                cVar = cVarArr[i10];
                if (cVar.d(str)) {
                    break;
                }
                i10++;
            }
            if (cVar != null) {
                f.e().a(f.f14404a, "Work " + str + " constrained by " + cVar.getClass().getSimpleName());
            }
            if (cVar == null) {
                z10 = true;
            }
        }
        return z10;
    }

    public void reset() {
        synchronized (this.f14403c) {
            for (c<?> f10 : this.f14402b) {
                f10.f();
            }
            Unit unit = Unit.f32013a;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e(n nVar, c cVar) {
        this(cVar, (c<?>[]) new c[]{new a(nVar.a()), new b(nVar.b()), new h(nVar.d()), new d(nVar.c()), new g(nVar.c()), new e2.f(nVar.c()), new e2.e(nVar.c())});
        j.g(nVar, "trackers");
    }
}
