package io.sentry;

import io.sentry.protocol.s;
import io.sentry.protocol.t;
import io.sentry.protocol.u;
import io.sentry.util.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class a4 {

    /* renamed from: a  reason: collision with root package name */
    private final z3 f30826a;

    /* renamed from: b  reason: collision with root package name */
    private final SentryOptions f30827b;

    public a4(z3 z3Var, SentryOptions sentryOptions) {
        this.f30826a = (z3) l.c(z3Var, "The SentryStackTraceFactory is required.");
        this.f30827b = (SentryOptions) l.c(sentryOptions, "The SentryOptions is required");
    }

    private u d(boolean z10, StackTraceElement[] stackTraceElementArr, Thread thread) {
        u uVar = new u();
        uVar.r(thread.getName());
        uVar.s(Integer.valueOf(thread.getPriority()));
        uVar.p(Long.valueOf(thread.getId()));
        uVar.o(Boolean.valueOf(thread.isDaemon()));
        uVar.u(thread.getState().name());
        uVar.m(Boolean.valueOf(z10));
        List<s> a10 = this.f30826a.a(stackTraceElementArr);
        if (this.f30827b.isAttachStacktrace() && a10 != null && !a10.isEmpty()) {
            t tVar = new t(a10);
            tVar.d(Boolean.TRUE);
            uVar.t(tVar);
        }
        return uVar;
    }

    /* access modifiers changed from: package-private */
    public List<u> a() {
        HashMap hashMap = new HashMap();
        Thread currentThread = Thread.currentThread();
        hashMap.put(currentThread, currentThread.getStackTrace());
        return c(hashMap, (List<Long>) null, false);
    }

    /* access modifiers changed from: package-private */
    public List<u> b(List<Long> list, boolean z10) {
        return c(Thread.getAllStackTraces(), list, z10);
    }

    /* access modifiers changed from: package-private */
    public List<u> c(Map<Thread, StackTraceElement[]> map, List<Long> list, boolean z10) {
        boolean z11;
        Thread currentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(currentThread)) {
            map.put(currentThread, currentThread.getStackTrace());
        }
        for (Map.Entry next : map.entrySet()) {
            Thread thread = (Thread) next.getKey();
            if ((thread != currentThread || z10) && (list == null || !list.contains(Long.valueOf(thread.getId())))) {
                z11 = false;
            } else {
                z11 = true;
            }
            arrayList.add(d(z11, (StackTraceElement[]) next.getValue(), (Thread) next.getKey()));
        }
        return arrayList;
    }
}
