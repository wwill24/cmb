package io.sentry;

import io.sentry.hints.e;
import io.sentry.hints.f;
import io.sentry.hints.g;
import io.sentry.protocol.v;
import io.sentry.util.b;
import io.sentry.util.i;
import io.sentry.util.k;
import io.sentry.util.l;
import io.sentry.util.o;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;
import org.jivesoftware.smack.packet.Session;

@ApiStatus.Internal
public final class w1 extends l implements f0 {

    /* renamed from: g  reason: collision with root package name */
    private static final Charset f31777g = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private final g0 f31778c;

    /* renamed from: d  reason: collision with root package name */
    private final e0 f31779d;

    /* renamed from: e  reason: collision with root package name */
    private final l0 f31780e;

    /* renamed from: f  reason: collision with root package name */
    private final h0 f31781f;

    public w1(g0 g0Var, e0 e0Var, l0 l0Var, h0 h0Var, long j10) {
        super(h0Var, j10);
        this.f31778c = (g0) l.c(g0Var, "Hub is required.");
        this.f31779d = (e0) l.c(e0Var, "Envelope reader is required.");
        this.f31780e = (l0) l.c(l0Var, "Serializer is required.");
        this.f31781f = (h0) l.c(h0Var, "Logger is required.");
    }

    private r4 i(p4 p4Var) {
        String a10;
        if (!(p4Var == null || (a10 = p4Var.a()) == null)) {
            try {
                Double valueOf = Double.valueOf(Double.parseDouble(a10));
                if (o.e(valueOf, false)) {
                    return new r4(Boolean.TRUE, valueOf);
                }
                this.f31781f.c(SentryLevel.ERROR, "Invalid sample rate parsed from TraceContext: %s", a10);
            } catch (Exception unused) {
                this.f31781f.c(SentryLevel.ERROR, "Unable to parse sample rate from TraceContext: %s", a10);
            }
        }
        return new r4(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(File file, g gVar) {
        if (!gVar.a()) {
            try {
                if (!file.delete()) {
                    this.f31781f.c(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
                }
            } catch (RuntimeException e10) {
                this.f31781f.a(SentryLevel.ERROR, e10, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
    }

    private void l(n3 n3Var, int i10) {
        this.f31781f.c(SentryLevel.ERROR, "Item %d of type %s returned null by the parser.", Integer.valueOf(i10), n3Var.x().b());
    }

    private void m(int i10) {
        this.f31781f.c(SentryLevel.DEBUG, "Item %d is being captured.", Integer.valueOf(i10));
    }

    private void n(io.sentry.protocol.o oVar) {
        this.f31781f.c(SentryLevel.WARNING, "Timed out waiting for event id submission: %s", oVar);
    }

    private void o(w2 w2Var, io.sentry.protocol.o oVar, int i10) {
        this.f31781f.c(SentryLevel.ERROR, "Item %d of has a different event id (%s) to the envelope header (%s)", Integer.valueOf(i10), w2Var.b().a(), oVar);
    }

    private void p(w2 w2Var, w wVar) throws IOException {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        this.f31781f.c(SentryLevel.DEBUG, "Processing Envelope with %d item(s)", Integer.valueOf(b.d(w2Var.c())));
        int i10 = 0;
        for (n3 next : w2Var.c()) {
            i10++;
            if (next.x() == null) {
                this.f31781f.c(SentryLevel.ERROR, "Item %d has no header", Integer.valueOf(i10));
            } else {
                if (SentryItemType.Event.equals(next.x().b())) {
                    try {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(next.w()), f31777g));
                        p3 p3Var = (p3) this.f31780e.c(bufferedReader2, p3.class);
                        if (p3Var == null) {
                            l(next, i10);
                        } else {
                            if (p3Var.L() != null) {
                                i.q(wVar, p3Var.L().e());
                            }
                            if (w2Var.b().a() == null || w2Var.b().a().equals(p3Var.G())) {
                                this.f31778c.x(p3Var, wVar);
                                m(i10);
                                if (!q(wVar)) {
                                    n(p3Var.G());
                                    bufferedReader2.close();
                                    return;
                                }
                            } else {
                                o(w2Var, p3Var.G(), i10);
                                bufferedReader2.close();
                            }
                        }
                        bufferedReader2.close();
                    } catch (Throwable th2) {
                        this.f31781f.b(SentryLevel.ERROR, "Item failed to process.", th2);
                    }
                } else if (SentryItemType.Transaction.equals(next.x().b())) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(next.w()), f31777g));
                        v vVar = (v) this.f31780e.c(bufferedReader, v.class);
                        if (vVar == null) {
                            l(next, i10);
                        } else if (w2Var.b().a() == null || w2Var.b().a().equals(vVar.G())) {
                            p4 c10 = w2Var.b().c();
                            if (vVar.C().e() != null) {
                                vVar.C().e().l(i(c10));
                            }
                            this.f31778c.s(vVar, c10, wVar);
                            m(i10);
                            if (!q(wVar)) {
                                n(vVar.G());
                                bufferedReader.close();
                                return;
                            }
                        } else {
                            o(w2Var, vVar.G(), i10);
                            bufferedReader.close();
                        }
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        this.f31781f.b(SentryLevel.ERROR, "Item failed to process.", th3);
                    }
                } else {
                    this.f31778c.r(new w2(w2Var.b().a(), w2Var.b().b(), next), wVar);
                    this.f31781f.c(SentryLevel.DEBUG, "%s item %d is being captured.", next.x().b().getItemType(), Integer.valueOf(i10));
                    if (!q(wVar)) {
                        this.f31781f.c(SentryLevel.WARNING, "Timed out waiting for item type submission: %s", next.x().b().getItemType());
                        return;
                    }
                }
                Object f10 = i.f(wVar);
                if (!(f10 instanceof io.sentry.hints.l) || ((io.sentry.hints.l) f10).e()) {
                    i.n(wVar, f.class, new v1());
                } else {
                    this.f31781f.c(SentryLevel.WARNING, "Envelope had a failed capture at item %d. No more items will be sent.", Integer.valueOf(i10));
                    return;
                }
            }
        }
        return;
        throw th;
        throw th;
    }

    private boolean q(w wVar) {
        Object f10 = i.f(wVar);
        if (f10 instanceof e) {
            return ((e) f10).d();
        }
        k.a(e.class, f10, this.f31781f);
        return true;
    }

    public void a(String str, w wVar) {
        l.c(str, "Path is required.");
        f(new File(str), wVar);
    }

    /* access modifiers changed from: protected */
    public boolean c(String str) {
        if (str == null || str.startsWith(Session.ELEMENT) || str.startsWith("startup_crash")) {
            return false;
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void e(File file) {
        super.e(file);
    }

    /* access modifiers changed from: protected */
    public void f(File file, w wVar) {
        u1 u1Var;
        h0 h0Var;
        BufferedInputStream bufferedInputStream;
        Class<g> cls = g.class;
        l.c(file, "File is required.");
        if (!c(file.getName())) {
            this.f31781f.c(SentryLevel.DEBUG, "File '%s' should be ignored.", file.getAbsolutePath());
            return;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            w2 a10 = this.f31779d.a(bufferedInputStream);
            if (a10 == null) {
                this.f31781f.c(SentryLevel.ERROR, "Stream from path %s resulted in a null envelope.", file.getAbsolutePath());
            } else {
                p(a10, wVar);
                this.f31781f.c(SentryLevel.DEBUG, "File '%s' is done.", file.getAbsolutePath());
            }
            bufferedInputStream.close();
            h0Var = this.f31781f;
            u1Var = new u1(this, file);
        } catch (IOException e10) {
            try {
                this.f31781f.b(SentryLevel.ERROR, "Error processing envelope.", e10);
                h0Var = this.f31781f;
                u1Var = new u1(this, file);
            } catch (Throwable th2) {
                i.p(wVar, cls, this.f31781f, new u1(this, file));
                throw th2;
            }
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
        i.p(wVar, cls, h0Var, u1Var);
        return;
        throw th;
    }
}
