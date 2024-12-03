package io.sentry;

import io.sentry.util.l;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

final class n4 {

    /* renamed from: a  reason: collision with root package name */
    private final Deque<a> f31355a;

    /* renamed from: b  reason: collision with root package name */
    private final h0 f31356b;

    public n4(h0 h0Var, a aVar) {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        this.f31355a = linkedBlockingDeque;
        this.f31356b = (h0) l.c(h0Var, "logger is required");
        linkedBlockingDeque.push((a) l.c(aVar, "rootStackItem is required"));
    }

    /* access modifiers changed from: package-private */
    public a a() {
        return this.f31355a.peek();
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        this.f31355a.push(aVar);
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final SentryOptions f31357a;

        /* renamed from: b  reason: collision with root package name */
        private volatile j0 f31358b;

        /* renamed from: c  reason: collision with root package name */
        private volatile e2 f31359c;

        a(SentryOptions sentryOptions, j0 j0Var, e2 e2Var) {
            this.f31358b = (j0) l.c(j0Var, "ISentryClient is required.");
            this.f31359c = (e2) l.c(e2Var, "Scope is required.");
            this.f31357a = (SentryOptions) l.c(sentryOptions, "Options is required");
        }

        public j0 a() {
            return this.f31358b;
        }

        public SentryOptions b() {
            return this.f31357a;
        }

        public e2 c() {
            return this.f31359c;
        }

        a(a aVar) {
            this.f31357a = aVar.f31357a;
            this.f31358b = aVar.f31358b;
            this.f31359c = new e2(aVar.f31359c);
        }
    }

    public n4(n4 n4Var) {
        this(n4Var.f31356b, new a(n4Var.f31355a.getLast()));
        Iterator<a> descendingIterator = n4Var.f31355a.descendingIterator();
        if (descendingIterator.hasNext()) {
            descendingIterator.next();
        }
        while (descendingIterator.hasNext()) {
            b(new a(descendingIterator.next()));
        }
    }
}
