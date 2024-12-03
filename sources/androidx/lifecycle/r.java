package androidx.lifecycle;

import androidx.annotation.NonNull;
import j.b;
import java.util.Iterator;
import java.util.Map;

public class r<T> extends t<T> {

    /* renamed from: l  reason: collision with root package name */
    private b<LiveData<?>, a<?>> f6063l = new b<>();

    private static class a<V> implements u<V> {

        /* renamed from: a  reason: collision with root package name */
        final LiveData<V> f6064a;

        /* renamed from: b  reason: collision with root package name */
        final u<? super V> f6065b;

        /* renamed from: c  reason: collision with root package name */
        int f6066c = -1;

        a(LiveData<V> liveData, u<? super V> uVar) {
            this.f6064a = liveData;
            this.f6065b = uVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f6064a.j(this);
        }

        public void b(V v10) {
            if (this.f6066c != this.f6064a.g()) {
                this.f6066c = this.f6064a.g();
                this.f6065b.b(v10);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f6064a.n(this);
        }
    }

    public r() {
    }

    /* access modifiers changed from: protected */
    public void k() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f6063l.iterator();
        while (it.hasNext()) {
            ((a) it.next().getValue()).a();
        }
    }

    /* access modifiers changed from: protected */
    public void l() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f6063l.iterator();
        while (it.hasNext()) {
            ((a) it.next().getValue()).c();
        }
    }

    public <S> void p(@NonNull LiveData<S> liveData, @NonNull u<? super S> uVar) {
        if (liveData != null) {
            a aVar = new a(liveData, uVar);
            a j10 = this.f6063l.j(liveData, aVar);
            if (j10 != null && j10.f6065b != uVar) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            } else if (j10 == null && h()) {
                aVar.a();
            }
        } else {
            throw new NullPointerException("source cannot be null");
        }
    }

    public <S> void q(@NonNull LiveData<S> liveData) {
        a m10 = this.f6063l.m(liveData);
        if (m10 != null) {
            m10.c();
        }
    }

    public r(T t10) {
        super(t10);
    }
}
