package wj;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import uj.a;

public final class b implements tj.b, a {

    /* renamed from: a  reason: collision with root package name */
    List<tj.b> f33957a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f33958b;

    public boolean a(tj.b bVar) {
        xj.b.e(bVar, "d is null");
        if (!this.f33958b) {
            synchronized (this) {
                if (!this.f33958b) {
                    List list = this.f33957a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f33957a = list;
                    }
                    list.add(bVar);
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
            java.lang.String r0 = "Disposable item is null"
            xj.b.e(r3, r0)
            boolean r0 = r2.f33958b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f33958b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<tj.b> r0 = r2.f33957a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: wj.b.b(tj.b):boolean");
    }

    public boolean c() {
        return this.f33958b;
    }

    public boolean d(tj.b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    public void dispose() {
        if (!this.f33958b) {
            synchronized (this) {
                if (!this.f33958b) {
                    this.f33958b = true;
                    List<tj.b> list = this.f33957a;
                    this.f33957a = null;
                    e(list);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(List<tj.b> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (tj.b dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th2) {
                    a.b(th2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
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
