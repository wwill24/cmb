package io.sentry.cache;

import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.clientreport.DiscardReason;
import io.sentry.l0;
import io.sentry.n3;
import io.sentry.util.l;
import io.sentry.w2;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

abstract class b {

    /* renamed from: e  reason: collision with root package name */
    protected static final Charset f31160e = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    protected final SentryOptions f31161a;

    /* renamed from: b  reason: collision with root package name */
    protected final l0 f31162b;

    /* renamed from: c  reason: collision with root package name */
    protected final File f31163c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31164d;

    b(SentryOptions sentryOptions, String str, int i10) {
        l.c(str, "Directory is required.");
        this.f31161a = (SentryOptions) l.c(sentryOptions, "SentryOptions is required.");
        this.f31162b = sentryOptions.getSerializer();
        this.f31163c = new File(str);
        this.f31164d = i10;
    }

    private w2 d(w2 w2Var, n3 n3Var) {
        ArrayList arrayList = new ArrayList();
        for (n3 add : w2Var.c()) {
            arrayList.add(add);
        }
        arrayList.add(n3Var);
        return new w2(w2Var.b(), arrayList);
    }

    private Session f(w2 w2Var) {
        for (n3 next : w2Var.c()) {
            if (i(next)) {
                return q(next);
            }
        }
        return null;
    }

    private boolean i(n3 n3Var) {
        if (n3Var == null) {
            return false;
        }
        return n3Var.x().b().equals(SentryItemType.Session);
    }

    private boolean j(w2 w2Var) {
        return w2Var.c().iterator().hasNext();
    }

    private boolean m(Session session) {
        if (session.k().equals(Session.State.Ok) && session.i() != null) {
            return true;
        }
        return false;
    }

    private void o(File file, File[] fileArr) {
        Boolean f10;
        Session q10;
        w2 p10 = p(file);
        if (p10 != null && j(p10)) {
            this.f31161a.getClientReportRecorder().b(DiscardReason.CACHE_OVERFLOW, p10);
            Session f11 = f(p10);
            if (f11 != null && m(f11) && (f10 = f11.f()) != null && f10.booleanValue()) {
                for (File file2 : fileArr) {
                    w2 p11 = p(file2);
                    if (p11 != null && j(p11)) {
                        n3 n3Var = null;
                        Iterator<n3> it = p11.c().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            n3 next = it.next();
                            if (i(next) && (q10 = q(next)) != null && m(q10)) {
                                Boolean f12 = q10.f();
                                if (f12 != null && f12.booleanValue()) {
                                    this.f31161a.getLogger().c(SentryLevel.ERROR, "Session %s has 2 times the init flag.", f11.i());
                                    return;
                                } else if (f11.i() != null && f11.i().equals(q10.i())) {
                                    q10.l();
                                    try {
                                        n3Var = n3.u(this.f31162b, q10);
                                        it.remove();
                                        break;
                                    } catch (IOException e10) {
                                        this.f31161a.getLogger().a(SentryLevel.ERROR, e10, "Failed to create new envelope item for the session %s", f11.i());
                                    }
                                }
                            }
                        }
                        if (n3Var != null) {
                            w2 d10 = d(p11, n3Var);
                            long lastModified = file2.lastModified();
                            if (!file2.delete()) {
                                this.f31161a.getLogger().c(SentryLevel.WARNING, "File can't be deleted: %s", file2.getAbsolutePath());
                            }
                            s(d10, file2, lastModified);
                            return;
                        }
                    }
                }
            }
        }
    }

    private w2 p(File file) {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            w2 d10 = this.f31162b.d(bufferedInputStream);
            bufferedInputStream.close();
            return d10;
        } catch (IOException e10) {
            this.f31161a.getLogger().b(SentryLevel.ERROR, "Failed to deserialize the envelope.", e10);
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private Session q(n3 n3Var) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(n3Var.w()), f31160e));
            Session session = (Session) this.f31162b.c(bufferedReader, Session.class);
            bufferedReader.close();
            return session;
        } catch (Throwable th2) {
            this.f31161a.getLogger().b(SentryLevel.ERROR, "Failed to deserialize the session.", th2);
            return null;
        }
        throw th;
    }

    private void s(w2 w2Var, File file, long j10) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            this.f31162b.b(w2Var, fileOutputStream);
            file.setLastModified(j10);
            fileOutputStream.close();
            return;
        } catch (Throwable th2) {
            this.f31161a.getLogger().b(SentryLevel.ERROR, "Failed to serialize the new envelope to the disk.", th2);
            return;
        }
        throw th;
    }

    private void t(File[] fileArr) {
        if (fileArr.length > 1) {
            Arrays.sort(fileArr, new a());
        }
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        if (this.f31163c.isDirectory() && this.f31163c.canWrite() && this.f31163c.canRead()) {
            return true;
        }
        this.f31161a.getLogger().c(SentryLevel.ERROR, "The directory for caching files is inaccessible.: %s", this.f31163c.getAbsolutePath());
        return false;
    }

    /* access modifiers changed from: protected */
    public void r(File[] fileArr) {
        int length = fileArr.length;
        if (length >= this.f31164d) {
            this.f31161a.getLogger().c(SentryLevel.WARNING, "Cache folder if full (respecting maxSize). Rotating files", new Object[0]);
            int i10 = (length - this.f31164d) + 1;
            t(fileArr);
            File[] fileArr2 = (File[]) Arrays.copyOfRange(fileArr, i10, length);
            for (int i11 = 0; i11 < i10; i11++) {
                File file = fileArr[i11];
                o(file, fileArr2);
                if (!file.delete()) {
                    this.f31161a.getLogger().c(SentryLevel.WARNING, "File can't be deleted: %s", file.getAbsolutePath());
                }
            }
        }
    }
}
