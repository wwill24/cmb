package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.a;
import qj.c;
import qj.d;
import qj.e;
import tj.b;

public final class CompletableCreate extends a {

    /* renamed from: a  reason: collision with root package name */
    final e f30103a;

    static final class Emitter extends AtomicReference<b> implements c, b {
        private static final long serialVersionUID = -2467358622224974244L;
        final d downstream;

        Emitter(d dVar) {
            this.downstream = dVar;
        }

        public boolean a(Throwable th2) {
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

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            b bVar;
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper && (bVar = (b) getAndSet(disposableHelper)) != disposableHelper) {
                try {
                    this.downstream.onComplete();
                } finally {
                    if (bVar != null) {
                        bVar.dispose();
                    }
                }
            }
        }

        public void onError(Throwable th2) {
            if (!a(th2)) {
                bk.a.s(th2);
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{Emitter.class.getSimpleName(), super.toString()});
        }
    }

    public CompletableCreate(e eVar) {
        this.f30103a = eVar;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        Emitter emitter = new Emitter(dVar);
        dVar.a(emitter);
        try {
            this.f30103a.a(emitter);
        } catch (Throwable th2) {
            uj.a.b(th2);
            emitter.onError(th2);
        }
    }
}
