package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"okio/Pipe$sink$1", "Lokio/Sink;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "flush", "close", "Lokio/Timeout;", "p", "a", "Lokio/Timeout;", "timeout", "okio"}, k = 1, mv = {1, 6, 0})
public final class Pipe$sink$1 implements Sink {

    /* renamed from: a  reason: collision with root package name */
    private final Timeout f33395a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Pipe f33396b;

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r0 = r12.f33396b;
        r1 = r2.p();
        r0 = r0.i().p();
        r3 = r1.h();
        r5 = okio.Timeout.f33429d.a(r0.h(), r1.h());
        r7 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r1.g(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        if (r1.e() == false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0071, code lost:
        r5 = r1.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (r0.e() == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        r1.d(java.lang.Math.min(r1.c(), r0.c()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008d, code lost:
        r1.g(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0094, code lost:
        if (r0.e() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0096, code lost:
        r1.d(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
        r1.g(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a4, code lost:
        if (r0.e() != false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a6, code lost:
        r1.d(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a9, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ae, code lost:
        if (r0.e() == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b0, code lost:
        r1.d(r0.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ba, code lost:
        r1.g(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c1, code lost:
        if (r0.e() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c3, code lost:
        r1.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c7, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        r1.g(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d1, code lost:
        if (r0.e() != false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        r1.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r12 = this;
            okio.Pipe r0 = r12.f33396b
            okio.Buffer r0 = r0.a()
            okio.Pipe r1 = r12.f33396b
            monitor-enter(r0)
            boolean r2 = r1.e()     // Catch:{ all -> 0x00d8 }
            if (r2 == 0) goto L_0x0011
            monitor-exit(r0)
            return
        L_0x0011:
            okio.Sink r2 = r1.c()     // Catch:{ all -> 0x00d8 }
            if (r2 == 0) goto L_0x0018
            goto L_0x0041
        L_0x0018:
            boolean r2 = r1.f()     // Catch:{ all -> 0x00d8 }
            if (r2 == 0) goto L_0x0035
            okio.Buffer r2 = r1.a()     // Catch:{ all -> 0x00d8 }
            long r2 = r2.size()     // Catch:{ all -> 0x00d8 }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "source is closed"
            r1.<init>(r2)     // Catch:{ all -> 0x00d8 }
            throw r1     // Catch:{ all -> 0x00d8 }
        L_0x0035:
            r2 = 1
            r1.g(r2)     // Catch:{ all -> 0x00d8 }
            okio.Buffer r1 = r1.a()     // Catch:{ all -> 0x00d8 }
            r1.notifyAll()     // Catch:{ all -> 0x00d8 }
            r2 = 0
        L_0x0041:
            kotlin.Unit r1 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00d8 }
            monitor-exit(r0)
            if (r2 == 0) goto L_0x00d7
            okio.Pipe r0 = r12.f33396b
            okio.Timeout r1 = r2.p()
            okio.Sink r0 = r0.i()
            okio.Timeout r0 = r0.p()
            long r3 = r1.h()
            okio.Timeout$Companion r5 = okio.Timeout.f33429d
            long r6 = r0.h()
            long r8 = r1.h()
            long r5 = r5.a(r6, r8)
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.g(r5, r7)
            boolean r5 = r1.e()
            if (r5 == 0) goto L_0x00aa
            long r5 = r1.c()
            boolean r8 = r0.e()
            if (r8 == 0) goto L_0x008a
            long r8 = r1.c()
            long r10 = r0.c()
            long r8 = java.lang.Math.min(r8, r10)
            r1.d(r8)
        L_0x008a:
            r2.close()     // Catch:{ all -> 0x009a }
            r1.g(r3, r7)
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x00d7
            r1.d(r5)
            goto L_0x00d7
        L_0x009a:
            r2 = move-exception
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.g(r3, r7)
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x00a9
            r1.d(r5)
        L_0x00a9:
            throw r2
        L_0x00aa:
            boolean r5 = r0.e()
            if (r5 == 0) goto L_0x00b7
            long r5 = r0.c()
            r1.d(r5)
        L_0x00b7:
            r2.close()     // Catch:{ all -> 0x00c7 }
            r1.g(r3, r7)
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x00d7
            r1.a()
            goto L_0x00d7
        L_0x00c7:
            r2 = move-exception
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.g(r3, r5)
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x00d6
            r1.a()
        L_0x00d6:
            throw r2
        L_0x00d7:
            return
        L_0x00d8:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.close():void");
    }

    public void flush() {
        Sink c10;
        Buffer a10 = this.f33396b.a();
        Pipe pipe = this.f33396b;
        synchronized (a10) {
            if (!(!pipe.e())) {
                throw new IllegalStateException("closed".toString());
            } else if (!pipe.b()) {
                c10 = pipe.c();
                if (c10 == null) {
                    if (pipe.f()) {
                        if (pipe.a().size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    c10 = null;
                }
                Unit unit = Unit.f32013a;
            } else {
                throw new IOException("canceled");
            }
        }
        if (c10 != null) {
            Pipe pipe2 = this.f33396b;
            Timeout p10 = c10.p();
            Timeout p11 = pipe2.i().p();
            long h10 = p10.h();
            long a11 = Timeout.f33429d.a(p11.h(), p10.h());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            p10.g(a11, timeUnit);
            if (p10.e()) {
                long c11 = p10.c();
                if (p11.e()) {
                    p10.d(Math.min(p10.c(), p11.c()));
                }
                try {
                    c10.flush();
                    p10.g(h10, timeUnit);
                    if (p11.e()) {
                        p10.d(c11);
                    }
                } catch (Throwable th2) {
                    p10.g(h10, TimeUnit.NANOSECONDS);
                    if (p11.e()) {
                        p10.d(c11);
                    }
                    throw th2;
                }
            } else {
                if (p11.e()) {
                    p10.d(p11.c());
                }
                try {
                    c10.flush();
                    p10.g(h10, timeUnit);
                    if (p11.e()) {
                        p10.a();
                    }
                } catch (Throwable th3) {
                    p10.g(h10, TimeUnit.NANOSECONDS);
                    if (p11.e()) {
                        p10.a();
                    }
                    throw th3;
                }
            }
        }
    }

    public void k0(Buffer buffer, long j10) {
        Sink sink;
        j.g(buffer, "source");
        Buffer a10 = this.f33396b.a();
        Pipe pipe = this.f33396b;
        synchronized (a10) {
            if (!(!pipe.e())) {
                throw new IllegalStateException("closed".toString());
            } else if (!pipe.b()) {
                while (true) {
                    if (j10 <= 0) {
                        sink = null;
                        break;
                    }
                    sink = pipe.c();
                    if (sink != null) {
                        break;
                    } else if (!pipe.f()) {
                        long d10 = pipe.d() - pipe.a().size();
                        if (d10 == 0) {
                            this.f33395a.i(pipe.a());
                            if (pipe.b()) {
                                throw new IOException("canceled");
                            }
                        } else {
                            long min = Math.min(d10, j10);
                            pipe.a().k0(buffer, min);
                            j10 -= min;
                            pipe.a().notifyAll();
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.f32013a;
            } else {
                throw new IOException("canceled");
            }
        }
        if (sink != null) {
            Pipe pipe2 = this.f33396b;
            Timeout p10 = sink.p();
            Timeout p11 = pipe2.i().p();
            long h10 = p10.h();
            long a11 = Timeout.f33429d.a(p11.h(), p10.h());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            p10.g(a11, timeUnit);
            if (p10.e()) {
                long c10 = p10.c();
                if (p11.e()) {
                    p10.d(Math.min(p10.c(), p11.c()));
                }
                try {
                    sink.k0(buffer, j10);
                    p10.g(h10, timeUnit);
                    if (p11.e()) {
                        p10.d(c10);
                    }
                } catch (Throwable th2) {
                    p10.g(h10, TimeUnit.NANOSECONDS);
                    if (p11.e()) {
                        p10.d(c10);
                    }
                    throw th2;
                }
            } else {
                if (p11.e()) {
                    p10.d(p11.c());
                }
                try {
                    sink.k0(buffer, j10);
                    p10.g(h10, timeUnit);
                    if (p11.e()) {
                        p10.a();
                    }
                } catch (Throwable th3) {
                    p10.g(h10, TimeUnit.NANOSECONDS);
                    if (p11.e()) {
                        p10.a();
                    }
                    throw th3;
                }
            }
        }
    }

    public Timeout p() {
        return this.f33395a;
    }
}
