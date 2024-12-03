package kotlin.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;

public final class e {
    public static final <R, T> void a(Function2<? super R, ? super c<? super T>, ? extends Object> function2, R r10, c<? super T> cVar) {
        j.g(function2, "<this>");
        j.g(cVar, "completion");
        c c10 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(function2, r10, cVar));
        Result.a aVar = Result.f32010a;
        c10.resumeWith(Result.b(Unit.f32013a));
    }
}
