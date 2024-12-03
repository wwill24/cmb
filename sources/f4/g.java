package f4;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class g<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f14719a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f14720b;

    /* renamed from: c  reason: collision with root package name */
    private long f14721c;

    /* renamed from: d  reason: collision with root package name */
    private long f14722d;

    public g(long j10) {
        this.f14720b = j10;
        this.f14721c = j10;
    }

    private void f() {
        m(this.f14721c);
    }

    public void b() {
        m(0);
    }

    public synchronized Y g(@NonNull T t10) {
        return this.f14719a.get(t10);
    }

    public synchronized long h() {
        return this.f14721c;
    }

    /* access modifiers changed from: protected */
    public int i(Y y10) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void j(@NonNull T t10, Y y10) {
    }

    public synchronized Y k(@NonNull T t10, Y y10) {
        long i10 = (long) i(y10);
        if (i10 >= this.f14721c) {
            j(t10, y10);
            return null;
        }
        if (y10 != null) {
            this.f14722d += i10;
        }
        Y put = this.f14719a.put(t10, y10);
        if (put != null) {
            this.f14722d -= (long) i(put);
            if (!put.equals(y10)) {
                j(t10, put);
            }
        }
        f();
        return put;
    }

    public synchronized Y l(@NonNull T t10) {
        Y remove;
        remove = this.f14719a.remove(t10);
        if (remove != null) {
            this.f14722d -= (long) i(remove);
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    public synchronized void m(long j10) {
        while (this.f14722d > j10) {
            Iterator<Map.Entry<T, Y>> it = this.f14719a.entrySet().iterator();
            Map.Entry next = it.next();
            Object value = next.getValue();
            this.f14722d -= (long) i(value);
            Object key = next.getKey();
            it.remove();
            j(key, value);
        }
    }
}
