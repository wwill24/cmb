package io.sentry;

import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.clientreport.DiscardReason;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.hints.d;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.o;
import io.sentry.protocol.v;
import io.sentry.transport.p;
import io.sentry.util.i;
import io.sentry.util.l;
import java.io.Closeable;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

public final class s2 implements j0 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f31622a;

    /* renamed from: b  reason: collision with root package name */
    private final SentryOptions f31623b;

    /* renamed from: c  reason: collision with root package name */
    private final p f31624c;

    /* renamed from: d  reason: collision with root package name */
    private final SecureRandom f31625d;

    /* renamed from: e  reason: collision with root package name */
    private final b f31626e = new b();

    private static final class b implements Comparator<d> {
        private b() {
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.j().compareTo(dVar2.j());
        }
    }

    s2(SentryOptions sentryOptions) {
        SecureRandom secureRandom = null;
        this.f31623b = (SentryOptions) l.c(sentryOptions, "SentryOptions is required.");
        this.f31622a = true;
        p0 transportFactory = sentryOptions.getTransportFactory();
        if (transportFactory instanceof s1) {
            transportFactory = new a();
            sentryOptions.setTransportFactory(transportFactory);
        }
        this.f31624c = transportFactory.a(sentryOptions, new c2(sentryOptions).a());
        this.f31625d = sentryOptions.getSampleRate() != null ? new SecureRandom() : secureRandom;
    }

    private void f(e2 e2Var, w wVar) {
        if (e2Var != null) {
            wVar.a(e2Var.f());
        }
    }

    private <T extends p2> T g(T t10, e2 e2Var) {
        if (e2Var != null) {
            if (t10.K() == null) {
                t10.Z(e2Var.m());
            }
            if (t10.Q() == null) {
                t10.e0(e2Var.s());
            }
            if (t10.N() == null) {
                t10.d0(new HashMap(e2Var.p()));
            } else {
                for (Map.Entry next : e2Var.p().entrySet()) {
                    if (!t10.N().containsKey(next.getKey())) {
                        t10.N().put((String) next.getKey(), (String) next.getValue());
                    }
                }
            }
            if (t10.B() == null) {
                t10.R(new ArrayList(e2Var.g()));
            } else {
                w(t10, e2Var.g());
            }
            if (t10.H() == null) {
                t10.W(new HashMap(e2Var.j()));
            } else {
                for (Map.Entry next2 : e2Var.j().entrySet()) {
                    if (!t10.H().containsKey(next2.getKey())) {
                        t10.H().put((String) next2.getKey(), next2.getValue());
                    }
                }
            }
            Contexts C = t10.C();
            for (Map.Entry entry : new Contexts(e2Var.h()).entrySet()) {
                if (!C.containsKey(entry.getKey())) {
                    C.put((String) entry.getKey(), entry.getValue());
                }
            }
        }
        return t10;
    }

    private p3 h(p3 p3Var, e2 e2Var, w wVar) {
        if (e2Var == null) {
            return p3Var;
        }
        g(p3Var, e2Var);
        if (p3Var.s0() == null) {
            p3Var.A0(e2Var.r());
        }
        if (p3Var.p0() == null) {
            p3Var.w0(e2Var.k());
        }
        if (e2Var.l() != null) {
            p3Var.x0(e2Var.l());
        }
        m0 o10 = e2Var.o();
        if (p3Var.C().e() == null && o10 != null) {
            p3Var.C().n(o10.m());
        }
        return q(p3Var, wVar, e2Var.i());
    }

    private w2 i(p2 p2Var, List<b> list, Session session, p4 p4Var, z1 z1Var) throws IOException, SentryEnvelopeException {
        o oVar;
        ArrayList arrayList = new ArrayList();
        if (p2Var != null) {
            arrayList.add(n3.s(this.f31623b.getSerializer(), p2Var));
            oVar = p2Var.G();
        } else {
            oVar = null;
        }
        if (session != null) {
            arrayList.add(n3.u(this.f31623b.getSerializer(), session));
        }
        if (z1Var != null) {
            arrayList.add(n3.t(z1Var, this.f31623b.getMaxTraceFileSize(), this.f31623b.getSerializer()));
            if (oVar == null) {
                oVar = new o(z1Var.A());
            }
        }
        if (list != null) {
            for (b q10 : list) {
                arrayList.add(n3.q(this.f31623b.getSerializer(), this.f31623b.getLogger(), q10, this.f31623b.getMaxAttachmentSize()));
            }
        }
        if (!arrayList.isEmpty()) {
            return new w2(new x2(oVar, this.f31623b.getSdkVersion(), p4Var), arrayList);
        }
        return null;
    }

    private p3 j(p3 p3Var, w wVar) {
        SentryOptions.b beforeSend = this.f31623b.getBeforeSend();
        if (beforeSend == null) {
            return p3Var;
        }
        try {
            return beforeSend.a(p3Var, wVar);
        } catch (Throwable th2) {
            this.f31623b.getLogger().b(SentryLevel.ERROR, "The BeforeSend callback threw an exception. It will be added as breadcrumb and continue.", th2);
            return null;
        }
    }

    private v k(v vVar, w wVar) {
        SentryOptions.c beforeSendTransaction = this.f31623b.getBeforeSendTransaction();
        if (beforeSendTransaction == null) {
            return vVar;
        }
        try {
            return beforeSendTransaction.a(vVar, wVar);
        } catch (Throwable th2) {
            this.f31623b.getLogger().b(SentryLevel.ERROR, "The BeforeSendTransaction callback threw an exception. It will be added as breadcrumb and continue.", th2);
            return null;
        }
    }

    private List<b> l(List<b> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (b next : list) {
            if (next.i()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private List<b> m(w wVar) {
        List<b> e10 = wVar.e();
        b f10 = wVar.f();
        if (f10 != null) {
            e10.add(f10);
        }
        b g10 = wVar.g();
        if (g10 != null) {
            e10.add(g10);
        }
        return e10;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void n(Session session) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(p3 p3Var, w wVar, Session session) {
        Session.State state;
        String str;
        boolean z10 = false;
        if (session != null) {
            String str2 = null;
            if (p3Var.t0()) {
                state = Session.State.Crashed;
            } else {
                state = null;
            }
            if (Session.State.Crashed == state || p3Var.u0()) {
                z10 = true;
            }
            if (p3Var.K() == null || p3Var.K().k() == null || !p3Var.K().k().containsKey("user-agent")) {
                str = null;
            } else {
                str = p3Var.K().k().get("user-agent");
            }
            Object f10 = i.f(wVar);
            if (f10 instanceof io.sentry.hints.a) {
                str2 = ((io.sentry.hints.a) f10).b();
                state = Session.State.Abnormal;
            }
            if (session.o(state, str, z10, str2) && i.g(wVar, d.class)) {
                session.c();
                return;
            }
            return;
        }
        this.f31623b.getLogger().c(SentryLevel.INFO, "Session is null on scope.withSession", new Object[0]);
    }

    private p3 q(p3 p3Var, w wVar, List<t> list) {
        Iterator<t> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            t next = it.next();
            try {
                p3Var = next.a(p3Var, wVar);
                continue;
            } catch (Throwable th2) {
                this.f31623b.getLogger().a(SentryLevel.ERROR, th2, "An exception occurred while processing event by processor: %s", next.getClass().getName());
                continue;
            }
            if (p3Var == null) {
                this.f31623b.getLogger().c(SentryLevel.DEBUG, "Event was dropped by a processor: %s", next.getClass().getName());
                this.f31623b.getClientReportRecorder().a(DiscardReason.EVENT_PROCESSOR, DataCategory.Error);
                break;
            }
        }
        return p3Var;
    }

    private v s(v vVar, w wVar, List<t> list) {
        Iterator<t> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            t next = it.next();
            try {
                vVar = next.b(vVar, wVar);
                continue;
            } catch (Throwable th2) {
                this.f31623b.getLogger().a(SentryLevel.ERROR, th2, "An exception occurred while processing transaction by processor: %s", next.getClass().getName());
                continue;
            }
            if (vVar == null) {
                this.f31623b.getLogger().c(SentryLevel.DEBUG, "Transaction was dropped by a processor: %s", next.getClass().getName());
                this.f31623b.getClientReportRecorder().a(DiscardReason.EVENT_PROCESSOR, DataCategory.Transaction);
                break;
            }
        }
        return vVar;
    }

    private boolean t() {
        if (this.f31623b.getSampleRate() == null || this.f31625d == null || this.f31623b.getSampleRate().doubleValue() >= this.f31625d.nextDouble()) {
            return true;
        }
        return false;
    }

    private boolean u(p2 p2Var, w wVar) {
        if (i.s(wVar)) {
            return true;
        }
        this.f31623b.getLogger().c(SentryLevel.DEBUG, "Event was cached so not applying scope: %s", p2Var.G());
        return false;
    }

    private boolean v(Session session, Session session2) {
        boolean z10;
        boolean z11;
        if (session2 == null) {
            return false;
        }
        if (session == null) {
            return true;
        }
        Session.State k10 = session2.k();
        Session.State state = Session.State.Crashed;
        if (k10 != state || session.k() == state) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return true;
        }
        if (session2.e() <= 0 || session.e() > 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    private void w(p2 p2Var, Collection<d> collection) {
        List<d> B = p2Var.B();
        if (B != null && !collection.isEmpty()) {
            B.addAll(collection);
            Collections.sort(B, this.f31626e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0124 A[Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0126 A[Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0129 A[Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0139 A[Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.protocol.o a(io.sentry.p3 r13, io.sentry.e2 r14, io.sentry.w r15) {
        /*
            r12 = this;
            java.lang.String r0 = "SentryEvent is required."
            io.sentry.util.l.c(r13, r0)
            if (r15 != 0) goto L_0x000c
            io.sentry.w r15 = new io.sentry.w
            r15.<init>()
        L_0x000c:
            boolean r0 = r12.u(r13, r15)
            if (r0 == 0) goto L_0x0015
            r12.f(r14, r15)
        L_0x0015:
            io.sentry.SentryOptions r0 = r12.f31623b
            io.sentry.h0 r0 = r0.getLogger()
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            io.sentry.protocol.o r4 = r13.G()
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "Capturing event: %s"
            r0.c(r1, r4, r3)
            java.lang.Throwable r0 = r13.O()
            if (r0 == 0) goto L_0x005d
            io.sentry.SentryOptions r3 = r12.f31623b
            boolean r3 = r3.containsIgnoredExceptionForType(r0)
            if (r3 == 0) goto L_0x005d
            io.sentry.SentryOptions r13 = r12.f31623b
            io.sentry.h0 r13 = r13.getLogger()
            java.lang.Object[] r14 = new java.lang.Object[r2]
            java.lang.Class r15 = r0.getClass()
            r14[r5] = r15
            java.lang.String r15 = "Event was dropped as the exception %s is ignored"
            r13.c(r1, r15, r14)
            io.sentry.SentryOptions r13 = r12.f31623b
            io.sentry.clientreport.f r13 = r13.getClientReportRecorder()
            io.sentry.clientreport.DiscardReason r14 = io.sentry.clientreport.DiscardReason.EVENT_PROCESSOR
            io.sentry.DataCategory r15 = io.sentry.DataCategory.Error
            r13.a(r14, r15)
            io.sentry.protocol.o r13 = io.sentry.protocol.o.f31517b
            return r13
        L_0x005d:
            boolean r0 = r12.u(r13, r15)
            if (r0 == 0) goto L_0x0079
            io.sentry.p3 r13 = r12.h(r13, r14, r15)
            if (r13 != 0) goto L_0x0079
            io.sentry.SentryOptions r13 = r12.f31623b
            io.sentry.h0 r13 = r13.getLogger()
            java.lang.Object[] r14 = new java.lang.Object[r5]
            java.lang.String r15 = "Event was dropped by applyScope"
            r13.c(r1, r15, r14)
            io.sentry.protocol.o r13 = io.sentry.protocol.o.f31517b
            return r13
        L_0x0079:
            io.sentry.SentryOptions r0 = r12.f31623b
            java.util.List r0 = r0.getEventProcessors()
            io.sentry.p3 r13 = r12.q(r13, r15, r0)
            if (r13 == 0) goto L_0x00a5
            io.sentry.p3 r13 = r12.j(r13, r15)
            if (r13 != 0) goto L_0x00a5
            io.sentry.SentryOptions r0 = r12.f31623b
            io.sentry.h0 r0 = r0.getLogger()
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r4 = "Event was dropped by beforeSend"
            r0.c(r1, r4, r3)
            io.sentry.SentryOptions r0 = r12.f31623b
            io.sentry.clientreport.f r0 = r0.getClientReportRecorder()
            io.sentry.clientreport.DiscardReason r3 = io.sentry.clientreport.DiscardReason.BEFORE_SEND
            io.sentry.DataCategory r4 = io.sentry.DataCategory.Error
            r0.a(r3, r4)
        L_0x00a5:
            if (r13 != 0) goto L_0x00aa
            io.sentry.protocol.o r13 = io.sentry.protocol.o.f31517b
            return r13
        L_0x00aa:
            r0 = 0
            if (r14 == 0) goto L_0x00b7
            io.sentry.q2 r3 = new io.sentry.q2
            r3.<init>()
            io.sentry.Session r3 = r14.x(r3)
            goto L_0x00b8
        L_0x00b7:
            r3 = r0
        L_0x00b8:
            io.sentry.Session r9 = r12.x(r13, r15, r14)
            boolean r4 = r12.t()
            if (r4 != 0) goto L_0x00e4
            io.sentry.SentryOptions r4 = r12.f31623b
            io.sentry.h0 r4 = r4.getLogger()
            java.lang.Object[] r6 = new java.lang.Object[r2]
            io.sentry.protocol.o r13 = r13.G()
            r6[r5] = r13
            java.lang.String r13 = "Event %s was dropped due to sampling decision."
            r4.c(r1, r13, r6)
            io.sentry.SentryOptions r13 = r12.f31623b
            io.sentry.clientreport.f r13 = r13.getClientReportRecorder()
            io.sentry.clientreport.DiscardReason r4 = io.sentry.clientreport.DiscardReason.SAMPLE_RATE
            io.sentry.DataCategory r6 = io.sentry.DataCategory.Error
            r13.a(r4, r6)
            r7 = r0
            goto L_0x00e5
        L_0x00e4:
            r7 = r13
        L_0x00e5:
            boolean r13 = r12.v(r3, r9)
            if (r7 != 0) goto L_0x00fd
            if (r13 != 0) goto L_0x00fd
            io.sentry.SentryOptions r13 = r12.f31623b
            io.sentry.h0 r13 = r13.getLogger()
            java.lang.Object[] r14 = new java.lang.Object[r5]
            java.lang.String r15 = "Not sending session update for dropped event as it did not cause the session health to change."
            r13.c(r1, r15, r14)
            io.sentry.protocol.o r13 = io.sentry.protocol.o.f31517b
            return r13
        L_0x00fd:
            io.sentry.protocol.o r13 = io.sentry.protocol.o.f31517b
            if (r7 == 0) goto L_0x010b
            io.sentry.protocol.o r1 = r7.G()
            if (r1 == 0) goto L_0x010b
            io.sentry.protocol.o r13 = r7.G()
        L_0x010b:
            if (r14 == 0) goto L_0x0121
            io.sentry.n0 r1 = r14.q()     // Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }
            if (r1 == 0) goto L_0x0121
            io.sentry.n0 r14 = r14.q()     // Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }
            io.sentry.p4 r14 = r14.f()     // Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }
            r10 = r14
            goto L_0x0122
        L_0x011d:
            r14 = move-exception
            goto L_0x013f
        L_0x011f:
            r14 = move-exception
            goto L_0x013f
        L_0x0121:
            r10 = r0
        L_0x0122:
            if (r7 == 0) goto L_0x0126
            r14 = r2
            goto L_0x0127
        L_0x0126:
            r14 = r5
        L_0x0127:
            if (r14 == 0) goto L_0x012d
            java.util.List r0 = r12.m(r15)     // Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }
        L_0x012d:
            r8 = r0
            r11 = 0
            r6 = r12
            io.sentry.w2 r14 = r6.i(r7, r8, r9, r10, r11)     // Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }
            r15.b()     // Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }
            if (r14 == 0) goto L_0x0152
            io.sentry.transport.p r0 = r12.f31624c     // Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }
            r0.R(r14, r15)     // Catch:{ IOException -> 0x011f, SentryEnvelopeException -> 0x011d }
            goto L_0x0152
        L_0x013f:
            io.sentry.SentryOptions r15 = r12.f31623b
            io.sentry.h0 r15 = r15.getLogger()
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r1[r5] = r13
            java.lang.String r13 = "Capturing event %s failed."
            r15.a(r0, r14, r13, r1)
            io.sentry.protocol.o r13 = io.sentry.protocol.o.f31517b
        L_0x0152:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.s2.a(io.sentry.p3, io.sentry.e2, io.sentry.w):io.sentry.protocol.o");
    }

    @ApiStatus.Internal
    public void b(Session session, w wVar) {
        l.c(session, "Session is required.");
        if (session.g() == null || session.g().isEmpty()) {
            this.f31623b.getLogger().c(SentryLevel.WARNING, "Sessions can't be captured without setting a release.", new Object[0]);
            return;
        }
        try {
            r(w2.a(this.f31623b.getSerializer(), session, this.f31623b.getSdkVersion()), wVar);
        } catch (IOException e10) {
            this.f31623b.getLogger().b(SentryLevel.ERROR, "Failed to capture session.", e10);
        }
    }

    public o c(v vVar, p4 p4Var, e2 e2Var, w wVar, z1 z1Var) {
        w wVar2;
        o oVar;
        v vVar2 = vVar;
        e2 e2Var2 = e2Var;
        l.c(vVar, "Transaction is required.");
        if (wVar == null) {
            wVar2 = new w();
        } else {
            wVar2 = wVar;
        }
        if (u(vVar, wVar2)) {
            f(e2Var2, wVar2);
        }
        h0 logger = this.f31623b.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "Capturing transaction: %s", vVar.G());
        o oVar2 = o.f31517b;
        if (vVar.G() != null) {
            oVar = vVar.G();
        } else {
            oVar = oVar2;
        }
        if (u(vVar, wVar2)) {
            vVar2 = (v) g(vVar, e2Var2);
            if (!(vVar2 == null || e2Var2 == null)) {
                vVar2 = s(vVar2, wVar2, e2Var.i());
            }
            if (vVar2 == null) {
                this.f31623b.getLogger().c(sentryLevel, "Transaction was dropped by applyScope", new Object[0]);
            }
        }
        if (vVar2 != null) {
            vVar2 = s(vVar2, wVar2, this.f31623b.getEventProcessors());
        }
        if (vVar2 == null) {
            this.f31623b.getLogger().c(sentryLevel, "Transaction was dropped by Event processors.", new Object[0]);
            return oVar2;
        }
        v k10 = k(vVar2, wVar2);
        if (k10 == null) {
            this.f31623b.getLogger().c(sentryLevel, "Transaction was dropped by beforeSendTransaction.", new Object[0]);
            this.f31623b.getClientReportRecorder().a(DiscardReason.BEFORE_SEND, DataCategory.Transaction);
            return oVar2;
        }
        try {
            w2 i10 = i(k10, l(m(wVar2)), (Session) null, p4Var, z1Var);
            wVar2.b();
            if (i10 == null) {
                return oVar2;
            }
            this.f31624c.R(i10, wVar2);
            return oVar;
        } catch (SentryEnvelopeException | IOException e10) {
            this.f31623b.getLogger().a(SentryLevel.WARNING, e10, "Capturing transaction %s failed.", oVar);
            return o.f31517b;
        }
    }

    public void close() {
        this.f31623b.getLogger().c(SentryLevel.INFO, "Closing SentryClient.", new Object[0]);
        try {
            o(this.f31623b.getShutdownTimeoutMillis());
            this.f31624c.close();
        } catch (IOException e10) {
            this.f31623b.getLogger().b(SentryLevel.WARNING, "Failed to close the connection to the Sentry Server.", e10);
        }
        for (t next : this.f31623b.getEventProcessors()) {
            if (next instanceof Closeable) {
                try {
                    ((Closeable) next).close();
                } catch (IOException e11) {
                    this.f31623b.getLogger().c(SentryLevel.WARNING, "Failed to close the event processor {}.", next, e11);
                }
            }
        }
        this.f31622a = false;
    }

    public void o(long j10) {
        this.f31624c.o(j10);
    }

    @ApiStatus.Internal
    public o r(w2 w2Var, w wVar) {
        l.c(w2Var, "SentryEnvelope is required.");
        if (wVar == null) {
            wVar = new w();
        }
        try {
            wVar.b();
            this.f31624c.R(w2Var, wVar);
            o a10 = w2Var.b().a();
            if (a10 != null) {
                return a10;
            }
            return o.f31517b;
        } catch (IOException e10) {
            this.f31623b.getLogger().b(SentryLevel.ERROR, "Failed to capture envelope.", e10);
            return o.f31517b;
        }
    }

    /* access modifiers changed from: package-private */
    public Session x(p3 p3Var, w wVar, e2 e2Var) {
        if (i.s(wVar)) {
            if (e2Var != null) {
                return e2Var.x(new r2(this, p3Var, wVar));
            }
            this.f31623b.getLogger().c(SentryLevel.INFO, "Scope is null on client.captureEvent", new Object[0]);
        }
        return null;
    }
}
