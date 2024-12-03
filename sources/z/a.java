package z;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import z.b;

public class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f18779a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<T> f18780b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f18781c;

    /* renamed from: d  reason: collision with root package name */
    final b.a<T> f18782d;

    public a(int i10) {
        this(i10, (b.a) null);
    }

    @NonNull
    public T a() {
        T removeLast;
        synchronized (this.f18781c) {
            removeLast = this.f18780b.removeLast();
        }
        return removeLast;
    }

    public void b(@NonNull T t10) {
        Object obj;
        synchronized (this.f18781c) {
            if (this.f18780b.size() >= this.f18779a) {
                obj = a();
            } else {
                obj = null;
            }
            this.f18780b.addFirst(t10);
        }
        b.a<T> aVar = this.f18782d;
        if (aVar != null && obj != null) {
            aVar.a(obj);
        }
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f18781c) {
            isEmpty = this.f18780b.isEmpty();
        }
        return isEmpty;
    }

    public a(int i10, b.a<T> aVar) {
        this.f18781c = new Object();
        this.f18779a = i10;
        this.f18780b = new ArrayDeque<>(i10);
        this.f18782d = aVar;
    }
}
