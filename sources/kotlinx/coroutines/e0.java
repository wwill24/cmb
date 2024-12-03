package kotlinx.coroutines;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a0\u0010\u000b\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a6\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"T", "Lkotlin/Result;", "Lkotlin/Function1;", "", "", "onCancellation", "", "b", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/n;", "caller", "c", "(Ljava/lang/Object;Lkotlinx/coroutines/n;)Ljava/lang/Object;", "state", "Lkotlin/coroutines/c;", "uCont", "a", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class e0 {
    public static final <T> Object a(Object obj, c<? super T> cVar) {
        if (!(obj instanceof b0)) {
            return Result.b(obj);
        }
        Result.a aVar = Result.f32010a;
        return Result.b(g.a(((b0) obj).f32285a));
    }

    public static final <T> Object b(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable e10 = Result.e(obj);
        if (e10 != null) {
            return new b0(e10, false, 2, (DefaultConstructorMarker) null);
        }
        if (function1 != null) {
            return new c0(obj, function1);
        }
        return obj;
    }

    public static final <T> Object c(Object obj, n<?> nVar) {
        Throwable e10 = Result.e(obj);
        if (e10 == null) {
            return obj;
        }
        return new b0(e10, false, 2, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }
}
