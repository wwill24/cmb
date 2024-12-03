package io.reactivex.internal.operators.single;

import bk.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.a0;
import qj.w;
import qj.y;
import qj.z;
import tj.b;

public final class SingleCreate<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final a0<T> f30513a;

    static final class Emitter<T> extends AtomicReference<b> implements y<T>, b {
        private static final long serialVersionUID = -2467358622224974244L;
        final z<? super T> downstream;

        Emitter(z<? super T> zVar) {
            this.downstream = zVar;
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public boolean d(Throwable th2) {
            b bVar;
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj == disposableHelper || (bVar = (b) getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            try {
                this.downstream.onError(th2);
            } finally {
                if (bVar != null) {
                    bVar.dispose();
                }
            }
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void onError(Throwable th2) {
            if (!d(th2)) {
                a.s(th2);
            }
        }

        public void onSuccess(T t10) {
            b bVar;
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper && (bVar = (b) getAndSet(disposableHelper)) != disposableHelper) {
                if (t10 == null) {
                    try {
                        this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                    } catch (Throwable th2) {
                        if (bVar != null) {
                            bVar.dispose();
                        }
                        throw th2;
                    }
                } else {
                    this.downstream.onSuccess(t10);
                }
                if (bVar != null) {
                    bVar.dispose();
                }
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{Emitter.class.getSimpleName(), super.toString()});
        }
    }

    public SingleCreate(a0<T> a0Var) {
        this.f30513a = a0Var;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        Emitter emitter = new Emitter(zVar);
        zVar.a(emitter);
        try {
            this.f30513a.a(emitter);
        } catch (Throwable th2) {
            uj.a.b(th2);
            emitter.onError(th2);
        }
    }
}
