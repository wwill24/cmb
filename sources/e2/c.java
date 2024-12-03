package e2;

import f2.h;
import g2.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0018B\u0017\b\u0000\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b'\u0010(J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0010J\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0018\u0010\u0005\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010!R.\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Le2/c;", "T", "Ld2/a;", "Le2/c$a;", "callback", "currentValue", "", "h", "(Le2/c$a;Ljava/lang/Object;)V", "Lg2/u;", "workSpec", "", "b", "value", "c", "(Ljava/lang/Object;)Z", "", "workSpecs", "e", "f", "", "workSpecId", "d", "newValue", "a", "(Ljava/lang/Object;)V", "Lf2/h;", "Lf2/h;", "tracker", "", "Ljava/util/List;", "matchingWorkSpecs", "matchingWorkSpecIds", "Ljava/lang/Object;", "Le2/c$a;", "getCallback", "()Le2/c$a;", "g", "(Le2/c$a;)V", "<init>", "(Lf2/h;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class c<T> implements d2.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final h<T> f14564a;

    /* renamed from: b  reason: collision with root package name */
    private final List<u> f14565b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f14566c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private T f14567d;

    /* renamed from: e  reason: collision with root package name */
    private a f14568e;

    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¨\u0006\b"}, d2 = {"Le2/c$a;", "", "", "Lg2/u;", "workSpecs", "", "b", "c", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public interface a {
        void b(List<u> list);

        void c(List<u> list);
    }

    public c(h<T> hVar) {
        j.g(hVar, "tracker");
        this.f14564a = hVar;
    }

    private final void h(a aVar, T t10) {
        if (!this.f14565b.isEmpty() && aVar != null) {
            if (t10 == null || c(t10)) {
                aVar.c(this.f14565b);
            } else {
                aVar.b(this.f14565b);
            }
        }
    }

    public void a(T t10) {
        this.f14567d = t10;
        h(this.f14568e, t10);
    }

    public abstract boolean b(u uVar);

    public abstract boolean c(T t10);

    public final boolean d(String str) {
        j.g(str, "workSpecId");
        T t10 = this.f14567d;
        if (t10 == null || !c(t10) || !this.f14566c.contains(str)) {
            return false;
        }
        return true;
    }

    public final void e(Iterable<u> iterable) {
        j.g(iterable, "workSpecs");
        this.f14565b.clear();
        this.f14566c.clear();
        List<u> list = this.f14565b;
        for (u next : iterable) {
            if (b(next)) {
                list.add(next);
            }
        }
        List<u> list2 = this.f14565b;
        List<String> list3 = this.f14566c;
        for (u uVar : list2) {
            list3.add(uVar.f15077a);
        }
        if (this.f14565b.isEmpty()) {
            this.f14564a.f(this);
        } else {
            this.f14564a.c(this);
        }
        h(this.f14568e, this.f14567d);
    }

    public final void f() {
        if (!this.f14565b.isEmpty()) {
            this.f14565b.clear();
            this.f14564a.f(this);
        }
    }

    public final void g(a aVar) {
        if (this.f14568e != aVar) {
            this.f14568e = aVar;
            h(aVar, this.f14567d);
        }
    }
}
