package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.c;
import pk.n;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements n<c<? super Object>, Object, kotlin.coroutines.c<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final SafeCollectorKt$emitFun$1 f32450a = new SafeCollectorKt$emitFun$1();

    SafeCollectorKt$emitFun$1() {
        super(3, c.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* renamed from: c */
    public final Object l(c<Object> cVar, Object obj, kotlin.coroutines.c<? super Unit> cVar2) {
        return cVar.c(obj, cVar2);
    }
}
