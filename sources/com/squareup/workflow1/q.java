package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a{\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00060\u00052$\u0010\t\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00060\bH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a[\u0010\u000e\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u00052\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"T", "PropsT", "StateT", "OutputT", "Lkotlinx/coroutines/flow/b;", "Lcom/squareup/workflow1/f;", "Lcom/squareup/workflow1/l;", "actionSink", "Lkotlin/Function1;", "handler", "", "a", "(Lkotlinx/coroutines/flow/b;Lcom/squareup/workflow1/f;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/c;)Ljava/lang/Object;", "action", "b", "(Lcom/squareup/workflow1/f;Lcom/squareup/workflow1/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "wf1-workflow-core"}, k = 5, mv = {1, 6, 0}, xs = "com/squareup/workflow1/Workflows")
final /* synthetic */ class q {

    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"com/squareup/workflow1/q$a", "Lkotlinx/coroutines/flow/c;", "value", "", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f23148a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function1 f23149b;

        public a(f fVar, Function1 function1) {
            this.f23148a = fVar;
            this.f23149b = function1;
        }

        public Object c(T t10, kotlin.coroutines.c<? super Unit> cVar) {
            Object m10 = o.m(this.f23148a, (l) this.f23149b.invoke(t10), cVar);
            if (m10 == b.d()) {
                return m10;
            }
            return Unit.f32013a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u0006\u001a\u00020\u0005*\u00180\u0004R\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001H\u0016¨\u0006\u0007"}, d2 = {"com/squareup/workflow1/q$b", "Lcom/squareup/workflow1/l;", "", "toString", "Lcom/squareup/workflow1/l$c;", "", "a", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
    public static final class b extends l<PropsT, StateT, OutputT> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<PropsT, StateT, OutputT> f23150c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ n<Unit> f23151d;

        b(l<? super PropsT, StateT, ? extends OutputT> lVar, n<? super Unit> nVar) {
            this.f23150c = lVar;
            this.f23151d = nVar;
        }

        public void a(l<? super PropsT, StateT, ? extends OutputT>.c cVar) {
            j.g(cVar, "<this>");
            if (this.f23151d.a()) {
                this.f23150c.a(cVar);
                n<Unit> nVar = this.f23151d;
                Result.a aVar = Result.f32010a;
                nVar.resumeWith(Result.b(Unit.f32013a));
            }
        }

        public String toString() {
            return "sendAndAwaitApplication(" + this.f23150c + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final <T, PropsT, StateT, OutputT> Object a(kotlinx.coroutines.flow.b<? extends T> bVar, f<? super l<? super PropsT, StateT, ? extends OutputT>> fVar, Function1<? super T, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1, kotlin.coroutines.c<? super Unit> cVar) {
        Object a10 = bVar.a(new a(fVar, function1), cVar);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }

    public static final <PropsT, StateT, OutputT> Object b(f<? super l<? super PropsT, StateT, ? extends OutputT>> fVar, l<? super PropsT, StateT, ? extends OutputT> lVar, kotlin.coroutines.c<? super Unit> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.y();
        fVar.d(new b(lVar, oVar));
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        if (v10 == b.d()) {
            return v10;
        }
        return Unit.f32013a;
    }
}
