package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.g;
import io.sentry.protocol.n;
import io.sentry.protocol.s;
import io.sentry.protocol.t;
import io.sentry.util.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

final class q3 {

    /* renamed from: a  reason: collision with root package name */
    private final z3 f31601a;

    public q3(z3 z3Var) {
        this.f31601a = (z3) l.c(z3Var, "The SentryStackTraceFactory is required.");
    }

    private n b(Throwable th2, g gVar, Thread thread, boolean z10) {
        String str;
        Package packageR = th2.getClass().getPackage();
        String name = th2.getClass().getName();
        n nVar = new n();
        String message = th2.getMessage();
        if (packageR != null) {
            name = name.replace(packageR.getName() + ".", "");
        }
        if (packageR != null) {
            str = packageR.getName();
        } else {
            str = null;
        }
        List<s> a10 = this.f31601a.a(th2.getStackTrace());
        if (a10 != null && !a10.isEmpty()) {
            t tVar = new t(a10);
            if (z10) {
                tVar.d(Boolean.TRUE);
            }
            nVar.k(tVar);
        }
        if (thread != null) {
            nVar.l(Long.valueOf(thread.getId()));
        }
        nVar.m(name);
        nVar.i(gVar);
        nVar.j(str);
        nVar.o(message);
        return nVar;
    }

    private List<n> d(Deque<n> deque) {
        return new ArrayList(deque);
    }

    /* access modifiers changed from: package-private */
    public Deque<n> a(Throwable th2) {
        Thread thread;
        boolean z10;
        g gVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (th2 != null && hashSet.add(th2)) {
            if (th2 instanceof ExceptionMechanismException) {
                ExceptionMechanismException exceptionMechanismException = (ExceptionMechanismException) th2;
                gVar = exceptionMechanismException.a();
                Throwable c10 = exceptionMechanismException.c();
                thread = exceptionMechanismException.b();
                Throwable th3 = c10;
                z10 = exceptionMechanismException.d();
                th2 = th3;
            } else {
                thread = Thread.currentThread();
                z10 = false;
                gVar = null;
            }
            arrayDeque.addFirst(b(th2, gVar, thread, z10));
            th2 = th2.getCause();
        }
        return arrayDeque;
    }

    /* access modifiers changed from: package-private */
    public List<n> c(Throwable th2) {
        return d(a(th2));
    }
}
