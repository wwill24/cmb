package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.b;
import qj.q;
import qj.u;

public final class k<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final T[] f30463a;

    static final class a<T> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30464a;

        /* renamed from: b  reason: collision with root package name */
        final T[] f30465b;

        /* renamed from: c  reason: collision with root package name */
        int f30466c;

        /* renamed from: d  reason: collision with root package name */
        boolean f30467d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f30468e;

        a(u<? super T> uVar, T[] tArr) {
            this.f30464a = uVar;
            this.f30465b = tArr;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T[] tArr = this.f30465b;
            int length = tArr.length;
            for (int i10 = 0; i10 < length && !c(); i10++) {
                T t10 = tArr[i10];
                if (t10 == null) {
                    u<? super T> uVar = this.f30464a;
                    uVar.onError(new NullPointerException("The element at index " + i10 + " is null"));
                    return;
                }
                this.f30464a.d(t10);
            }
            if (!c()) {
                this.f30464a.onComplete();
            }
        }

        public int b(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f30467d = true;
            return 1;
        }

        public boolean c() {
            return this.f30468e;
        }

        public void clear() {
            this.f30466c = this.f30465b.length;
        }

        public void dispose() {
            this.f30468e = true;
        }

        public boolean isEmpty() {
            return this.f30466c == this.f30465b.length;
        }

        public T poll() {
            int i10 = this.f30466c;
            T[] tArr = this.f30465b;
            if (i10 == tArr.length) {
                return null;
            }
            this.f30466c = i10 + 1;
            return xj.b.e(tArr[i10], "The array element is null");
        }
    }

    public k(T[] tArr) {
        this.f30463a = tArr;
    }

    public void l0(u<? super T> uVar) {
        a aVar = new a(uVar, this.f30463a);
        uVar.a(aVar);
        if (!aVar.f30467d) {
            aVar.a();
        }
    }
}
