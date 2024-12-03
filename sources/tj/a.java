package tj;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.f;
import java.util.ArrayList;
import xj.b;

public final class a implements b, wj.a {

    /* renamed from: a  reason: collision with root package name */
    f<b> f33870a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f33871b;

    public boolean a(b bVar) {
        b.e(bVar, "disposable is null");
        if (!this.f33871b) {
            synchronized (this) {
                if (!this.f33871b) {
                    f<b> fVar = this.f33870a;
                    if (fVar == null) {
                        fVar = new f<>();
                        this.f33870a = fVar;
                    }
                    fVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(tj.b r3) {
        /*
            r2 = this;
            java.lang.String r0 = "disposables is null"
            xj.b.e(r3, r0)
            boolean r0 = r2.f33871b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f33871b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            io.reactivex.internal.util.f<tj.b> r0 = r2.f33870a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.e(r3)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r3 = 1
            return r3
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tj.a.b(tj.b):boolean");
    }

    public boolean c() {
        return this.f33871b;
    }

    public boolean d(b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    public void dispose() {
        if (!this.f33871b) {
            synchronized (this) {
                if (!this.f33871b) {
                    this.f33871b = true;
                    f<b> fVar = this.f33870a;
                    this.f33870a = null;
                    f(fVar);
                }
            }
        }
    }

    public void e() {
        if (!this.f33871b) {
            synchronized (this) {
                if (!this.f33871b) {
                    f<b> fVar = this.f33870a;
                    this.f33870a = null;
                    f(fVar);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(f<b> fVar) {
        if (fVar != null) {
            ArrayList arrayList = null;
            for (Object obj : fVar.b()) {
                if (obj instanceof b) {
                    try {
                        ((b) obj).dispose();
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw ExceptionHelper.e((Throwable) arrayList.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) arrayList);
        }
    }
}
