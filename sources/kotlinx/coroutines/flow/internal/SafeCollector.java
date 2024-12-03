package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.v1;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b-\u0010.J'\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0018\u001a\u00020\t2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u001b\u0010\u001b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\f8\u0000X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0000X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010 R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/c;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlin/coroutines/c;", "", "uCont", "value", "", "j", "(Lkotlin/coroutines/c;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "currentContext", "previousContext", "i", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/internal/f;", "exception", "k", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "Lkotlin/Result;", "result", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "collector", "Lkotlinx/coroutines/flow/c;", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "", "collectContextSize", "I", "lastEmissionContext", "completion", "Lkotlin/coroutines/c;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class SafeCollector<T> extends ContinuationImpl implements c<T> {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final c<T> collector;
    private kotlin.coroutines.c<? super Unit> completion;
    private CoroutineContext lastEmissionContext;

    public SafeCollector(c<? super T> cVar, CoroutineContext coroutineContext) {
        super(j.f32461a, EmptyCoroutineContext.f32070a);
        this.collector = cVar;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.v0(0, SafeCollector$collectContextSize$1.f32448a)).intValue();
    }

    private final void i(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t10) {
        if (coroutineContext2 instanceof f) {
            k((f) coroutineContext2, t10);
        }
        SafeCollector_commonKt.a(this, coroutineContext);
    }

    private final Object j(kotlin.coroutines.c<? super Unit> cVar, T t10) {
        CoroutineContext context = cVar.getContext();
        v1.i(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            i(context, coroutineContext, t10);
            this.lastEmissionContext = context;
        }
        this.completion = cVar;
        Object l10 = SafeCollectorKt.f32449a.l(this.collector, t10, this);
        if (!j.b(l10, b.d())) {
            this.completion = null;
        }
        return l10;
    }

    private final void k(f fVar, Object obj) {
        throw new IllegalStateException(StringsKt__IndentKt.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + fVar.f32459a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    public Object c(T t10, kotlin.coroutines.c<? super Unit> cVar) {
        try {
            Object j10 = j(cVar, t10);
            if (j10 == b.d()) {
                f.c(cVar);
            }
            if (j10 == b.d()) {
                return j10;
            }
            return Unit.f32013a;
        } catch (Throwable th2) {
            this.lastEmissionContext = new f(th2, cVar.getContext());
            throw th2;
        }
    }

    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<? super Unit> cVar = this.completion;
        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) cVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        return coroutineContext == null ? EmptyCoroutineContext.f32070a : coroutineContext;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public Object invokeSuspend(Object obj) {
        Throwable e10 = Result.e(obj);
        if (e10 != null) {
            this.lastEmissionContext = new f(e10, getContext());
        }
        kotlin.coroutines.c<? super Unit> cVar = this.completion;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        return b.d();
    }

    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
