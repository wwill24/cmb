package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.j;
import qk.a;

final class g<T> extends h<T> implements Iterator<T>, c<Unit>, a {

    /* renamed from: a  reason: collision with root package name */
    private int f32187a;

    /* renamed from: b  reason: collision with root package name */
    private T f32188b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<? extends T> f32189c;

    /* renamed from: d  reason: collision with root package name */
    private c<? super Unit> f32190d;

    private final Throwable g() {
        int i10 = this.f32187a;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f32187a);
    }

    private final T h() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public Object c(T t10, c<? super Unit> cVar) {
        this.f32188b = t10;
        this.f32187a = 3;
        this.f32190d = cVar;
        Object d10 = b.d();
        if (d10 == b.d()) {
            f.c(cVar);
        }
        if (d10 == b.d()) {
            return d10;
        }
        return Unit.f32013a;
    }

    public Object e(Iterator<? extends T> it, c<? super Unit> cVar) {
        if (!it.hasNext()) {
            return Unit.f32013a;
        }
        this.f32189c = it;
        this.f32187a = 2;
        this.f32190d = cVar;
        Object d10 = b.d();
        if (d10 == b.d()) {
            f.c(cVar);
        }
        if (d10 == b.d()) {
            return d10;
        }
        return Unit.f32013a;
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f32070a;
    }

    public boolean hasNext() {
        while (true) {
            int i10 = this.f32187a;
            if (i10 != 0) {
                if (i10 == 1) {
                    Iterator<? extends T> it = this.f32189c;
                    j.d(it);
                    if (it.hasNext()) {
                        this.f32187a = 2;
                        return true;
                    }
                    this.f32189c = null;
                } else if (i10 == 2 || i10 == 3) {
                    return true;
                } else {
                    if (i10 == 4) {
                        return false;
                    }
                    throw g();
                }
            }
            this.f32187a = 5;
            c<? super Unit> cVar = this.f32190d;
            j.d(cVar);
            this.f32190d = null;
            Result.a aVar = Result.f32010a;
            cVar.resumeWith(Result.b(Unit.f32013a));
        }
    }

    public final void j(c<? super Unit> cVar) {
        this.f32190d = cVar;
    }

    public T next() {
        int i10 = this.f32187a;
        if (i10 == 0 || i10 == 1) {
            return h();
        }
        if (i10 == 2) {
            this.f32187a = 1;
            Iterator<? extends T> it = this.f32189c;
            j.d(it);
            return it.next();
        } else if (i10 == 3) {
            this.f32187a = 0;
            T t10 = this.f32188b;
            this.f32188b = null;
            return t10;
        } else {
            throw g();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void resumeWith(Object obj) {
        gk.g.b(obj);
        this.f32187a = 4;
    }
}
