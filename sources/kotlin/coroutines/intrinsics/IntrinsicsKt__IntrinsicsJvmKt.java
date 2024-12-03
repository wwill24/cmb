package kotlin.coroutines.intrinsics;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;

class IntrinsicsKt__IntrinsicsJvmKt {
    public static <T> c<Unit> a(Function1<? super c<? super T>, ? extends Object> function1, c<? super T> cVar) {
        j.g(function1, "<this>");
        j.g(cVar, "completion");
        c<? super T> a10 = f.a(cVar);
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(a10);
        }
        CoroutineContext context = a10.getContext();
        if (context == EmptyCoroutineContext.f32070a) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(a10, function1);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2(a10, context, function1);
    }

    public static <R, T> c<Unit> b(Function2<? super R, ? super c<? super T>, ? extends Object> function2, R r10, c<? super T> cVar) {
        j.g(function2, "<this>");
        j.g(cVar, "completion");
        c<? super T> a10 = f.a(cVar);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r10, a10);
        }
        CoroutineContext context = a10.getContext();
        if (context == EmptyCoroutineContext.f32070a) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(a10, function2, r10);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(a10, context, function2, r10);
    }

    public static <T> c<T> c(c<? super T> cVar) {
        c<Object> intercepted;
        j.g(cVar, "<this>");
        ContinuationImpl continuationImpl = cVar instanceof ContinuationImpl ? (ContinuationImpl) cVar : null;
        return (continuationImpl == null || (intercepted = continuationImpl.intercepted()) == null) ? cVar : intercepted;
    }
}
