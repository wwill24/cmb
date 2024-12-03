package m3;

import f4.k;
import java.util.Queue;
import m3.l;

abstract class c<T extends l> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f16285a = k.e(20);

    c() {
    }

    /* access modifiers changed from: package-private */
    public abstract T a();

    /* access modifiers changed from: package-private */
    public T b() {
        T t10 = (l) this.f16285a.poll();
        if (t10 == null) {
            return a();
        }
        return t10;
    }

    public void c(T t10) {
        if (this.f16285a.size() < 20) {
            this.f16285a.offer(t10);
        }
    }
}
