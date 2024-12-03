package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.a;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.t;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0001\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108DX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148@X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/b0;", "T", "Lkotlinx/coroutines/a;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "state", "", "e1", "Lkotlin/coroutines/c;", "c", "Lkotlin/coroutines/c;", "uCont", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "", "z0", "()Z", "isScopedCoroutine", "Lkotlinx/coroutines/s1;", "i1", "()Lkotlinx/coroutines/s1;", "parent", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class b0<T> extends a<T> implements c {

    /* renamed from: c  reason: collision with root package name */
    public final kotlin.coroutines.c<T> f32519c;

    public b0(CoroutineContext coroutineContext, kotlin.coroutines.c<? super T> cVar) {
        super(coroutineContext, true, true);
        this.f32519c = cVar;
    }

    /* access modifiers changed from: protected */
    public void T(Object obj) {
        j.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.f32519c), e0.a(obj, this.f32519c), (Function1) null, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void e1(Object obj) {
        kotlin.coroutines.c<T> cVar = this.f32519c;
        cVar.resumeWith(e0.a(obj, cVar));
    }

    public final c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f32519c;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    public final s1 i1() {
        t p02 = p0();
        if (p02 != null) {
            return p02.getParent();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean z0() {
        return true;
    }
}
