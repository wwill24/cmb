package io.sentry;

import io.sentry.hints.e;
import io.sentry.hints.g;
import io.sentry.util.i;
import io.sentry.util.l;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class s extends l implements f0 {

    /* renamed from: c  reason: collision with root package name */
    private final g0 f31618c;

    /* renamed from: d  reason: collision with root package name */
    private final l0 f31619d;

    /* renamed from: e  reason: collision with root package name */
    private final h0 f31620e;

    public s(g0 g0Var, l0 l0Var, h0 h0Var, long j10) {
        super(h0Var, j10);
        this.f31618c = (g0) l.c(g0Var, "Hub is required.");
        this.f31619d = (l0) l.c(l0Var, "Serializer is required.");
        this.f31620e = (h0) l.c(h0Var, "Logger is required.");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(e eVar) {
        if (!eVar.d()) {
            this.f31620e.c(SentryLevel.WARNING, "Timed out waiting for envelope submission.", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(Throwable th2, File file, g gVar) {
        gVar.c(false);
        this.f31620e.a(SentryLevel.INFO, th2, "File '%s' won't retry.", file.getAbsolutePath());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(File file, g gVar) {
        if (!gVar.a()) {
            m(file, "after trying to capture it");
            this.f31620e.c(SentryLevel.DEBUG, "Deleted file %s.", file.getAbsolutePath());
            return;
        }
        this.f31620e.c(SentryLevel.INFO, "File not deleted since retry was marked. %s.", file.getAbsolutePath());
    }

    private void m(File file, String str) {
        try {
            if (!file.delete()) {
                this.f31620e.c(SentryLevel.ERROR, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
            }
        } catch (Throwable th2) {
            this.f31620e.a(SentryLevel.ERROR, th2, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        }
    }

    public void a(String str, w wVar) {
        l.c(str, "Path is required.");
        f(new File(str), wVar);
    }

    /* access modifiers changed from: protected */
    public boolean c(String str) {
        return str.endsWith(".envelope");
    }

    public /* bridge */ /* synthetic */ void e(File file) {
        super.e(file);
    }

    /* access modifiers changed from: protected */
    public void f(File file, w wVar) {
        q qVar;
        h0 h0Var;
        BufferedInputStream bufferedInputStream;
        Class<g> cls = g.class;
        if (!file.isFile()) {
            this.f31620e.c(SentryLevel.DEBUG, "'%s' is not a file.", file.getAbsolutePath());
            return;
        } else if (!c(file.getName())) {
            this.f31620e.c(SentryLevel.DEBUG, "File '%s' doesn't match extension expected.", file.getAbsolutePath());
            return;
        } else if (!file.getParentFile().canWrite()) {
            this.f31620e.c(SentryLevel.WARNING, "File '%s' cannot be deleted so it will not be processed.", file.getAbsolutePath());
            return;
        } else {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                w2 d10 = this.f31619d.d(bufferedInputStream);
                if (d10 == null) {
                    this.f31620e.c(SentryLevel.ERROR, "Failed to deserialize cached envelope %s", file.getAbsolutePath());
                } else {
                    this.f31618c.r(d10, wVar);
                }
                i.p(wVar, e.class, this.f31620e, new p(this));
                bufferedInputStream.close();
                h0Var = this.f31620e;
                qVar = new q(this, file);
            } catch (FileNotFoundException e10) {
                this.f31620e.a(SentryLevel.ERROR, e10, "File '%s' cannot be found.", file.getAbsolutePath());
                h0Var = this.f31620e;
                qVar = new q(this, file);
            } catch (IOException e11) {
                this.f31620e.a(SentryLevel.ERROR, e11, "I/O on file '%s' failed.", file.getAbsolutePath());
                h0Var = this.f31620e;
                qVar = new q(this, file);
            } catch (Throwable th2) {
                try {
                    this.f31620e.a(SentryLevel.ERROR, th2, "Failed to capture cached envelope %s", file.getAbsolutePath());
                    i.p(wVar, cls, this.f31620e, new r(this, th2, file));
                    h0Var = this.f31620e;
                    qVar = new q(this, file);
                } catch (Throwable th3) {
                    i.p(wVar, cls, this.f31620e, new q(this, file));
                    throw th3;
                }
            }
            i.p(wVar, cls, h0Var, qVar);
            return;
        }
        throw th;
    }
}
