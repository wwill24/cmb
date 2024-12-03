package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.h;
import java.util.List;

public abstract class q<T, VH extends RecyclerView.d0> extends RecyclerView.Adapter<VH> {

    /* renamed from: d  reason: collision with root package name */
    final d<T> f6703d;

    /* renamed from: e  reason: collision with root package name */
    private final d.b<T> f6704e;

    class a implements d.b<T> {
        a() {
        }

        public void a(@NonNull List<T> list, @NonNull List<T> list2) {
            q.this.I(list, list2);
        }
    }

    protected q(@NonNull h.f<T> fVar) {
        a aVar = new a();
        this.f6704e = aVar;
        d<T> dVar = new d<>(new b(this), new c.a(fVar).a());
        this.f6703d = dVar;
        dVar.a(aVar);
    }

    @NonNull
    public List<T> G() {
        return this.f6703d.b();
    }

    /* access modifiers changed from: protected */
    public T H(int i10) {
        return this.f6703d.b().get(i10);
    }

    public void I(@NonNull List<T> list, @NonNull List<T> list2) {
    }

    public void J(List<T> list) {
        this.f6703d.e(list);
    }

    public void K(List<T> list, Runnable runnable) {
        this.f6703d.f(list, runnable);
    }

    public int g() {
        return this.f6703d.b().size();
    }
}
