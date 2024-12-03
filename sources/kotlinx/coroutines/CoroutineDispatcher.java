package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.a;
import kotlin.coroutines.b;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.o;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u001c\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\f\u001a\u00060\nj\u0002`\u000bH&J\u001c\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0017J \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0012\u0010\u0014\u001a\u00020\r2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011J\b\u0010\u0016\u001a\u00020\u0015H\u0016¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/a;", "Lkotlin/coroutines/d;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "O", "", "parallelism", "S", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "E", "F", "T", "Lkotlin/coroutines/c;", "continuation", "g", "e", "", "toString", "<init>", "()V", "b", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class CoroutineDispatcher extends a implements d {

    /* renamed from: b  reason: collision with root package name */
    public static final Key f32246b = new Key((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/b;", "Lkotlin/coroutines/d;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class Key extends b<d, CoroutineDispatcher> {
        private Key() {
            super(d.f32074s, AnonymousClass1.f32247a);
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(d.f32074s);
    }

    public abstract void E(CoroutineContext coroutineContext, Runnable runnable);

    public void F(CoroutineContext coroutineContext, Runnable runnable) {
        E(coroutineContext, runnable);
    }

    public boolean O(CoroutineContext coroutineContext) {
        return true;
    }

    public CoroutineDispatcher S(int i10) {
        o.a(i10);
        return new n(this, i10);
    }

    public <E extends CoroutineContext.Element> E c(CoroutineContext.a<E> aVar) {
        return d.a.a(this, aVar);
    }

    public final void e(c<?> cVar) {
        ((i) cVar).s();
    }

    public final <T> c<T> g(c<? super T> cVar) {
        return new i(this, cVar);
    }

    public String toString() {
        return m0.a(this) + '@' + m0.b(this);
    }

    public CoroutineContext u0(CoroutineContext.a<?> aVar) {
        return d.a.b(this, aVar);
    }
}
