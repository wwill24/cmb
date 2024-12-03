package n3;

import f4.j;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f16388a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f16389b = new b();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f16390a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f16391b;

        a() {
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f16392a = new ArrayDeque();

        b() {
        }

        /* access modifiers changed from: package-private */
        public a a() {
            a poll;
            synchronized (this.f16392a) {
                poll = this.f16392a.poll();
            }
            if (poll == null) {
                return new a();
            }
            return poll;
        }

        /* access modifiers changed from: package-private */
        public void b(a aVar) {
            synchronized (this.f16392a) {
                if (this.f16392a.size() < 10) {
                    this.f16392a.offer(aVar);
                }
            }
        }
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f16388a.get(str);
            if (aVar == null) {
                aVar = this.f16389b.a();
                this.f16388a.put(str, aVar);
            }
            aVar.f16391b++;
        }
        aVar.f16390a.lock();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) j.d(this.f16388a.get(str));
            int i10 = aVar.f16391b;
            if (i10 >= 1) {
                int i11 = i10 - 1;
                aVar.f16391b = i11;
                if (i11 == 0) {
                    a remove = this.f16388a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f16389b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f16391b);
            }
        }
        aVar.f16390a.unlock();
    }
}
