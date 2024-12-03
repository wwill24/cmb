package zk;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.j;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001al\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001e\u0010\u0010\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001a\u001c\u0010\u0012\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u000bH\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "", "c", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", "receiver", "", "onCancellation", "d", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/c;Lkotlin/jvm/functions/Function1;)V", "fatalCompletion", "b", "e", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class a {
    private static final void a(c<?> cVar, Throwable th2) {
        Result.a aVar = Result.f32010a;
        cVar.resumeWith(Result.b(g.a(th2)));
        throw th2;
    }

    public static final void b(c<? super Unit> cVar, c<?> cVar2) {
        try {
            c c10 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
            Result.a aVar = Result.f32010a;
            j.c(c10, Result.b(Unit.f32013a), (Function1) null, 2, (Object) null);
        } catch (Throwable th2) {
            a(cVar2, th2);
        }
    }

    public static final <T> void c(Function1<? super c<? super T>, ? extends Object> function1, c<? super T> cVar) {
        try {
            c c10 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(function1, cVar));
            Result.a aVar = Result.f32010a;
            j.c(c10, Result.b(Unit.f32013a), (Function1) null, 2, (Object) null);
        } catch (Throwable th2) {
            a(cVar, th2);
        }
    }

    public static final <R, T> void d(Function2<? super R, ? super c<? super T>, ? extends Object> function2, R r10, c<? super T> cVar, Function1<? super Throwable, Unit> function1) {
        try {
            c c10 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(function2, r10, cVar));
            Result.a aVar = Result.f32010a;
            j.b(c10, Result.b(Unit.f32013a), function1);
        } catch (Throwable th2) {
            a(cVar, th2);
        }
    }

    public static /* synthetic */ void e(Function2 function2, Object obj, c cVar, Function1 function1, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            function1 = null;
        }
        d(function2, obj, cVar, function1);
    }
}
