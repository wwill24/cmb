package kotlinx.coroutines;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.i;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u001a \u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a.\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002\"\u0018\u0010\u000e\u001a\u00020\b*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u0010\u001a\u00020\b*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"T", "Lkotlinx/coroutines/u0;", "", "mode", "", "a", "Lkotlin/coroutines/c;", "delegate", "", "undispatched", "d", "e", "b", "(I)Z", "isCancellableMode", "c", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class v0 {
    public static final <T> void a(u0<? super T> u0Var, int i10) {
        boolean z10;
        c<? super T> c10 = u0Var.c();
        if (i10 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || !(c10 instanceof i) || b(i10) != b(u0Var.f32728c)) {
            d(u0Var, c10, z10);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((i) c10).f32535d;
        CoroutineContext context = c10.getContext();
        if (coroutineDispatcher.O(context)) {
            coroutineDispatcher.E(context, u0Var);
        } else {
            e(u0Var);
        }
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final <T> void d(u0<? super T> u0Var, c<? super T> cVar, boolean z10) {
        Object obj;
        x2<?> x2Var;
        Object h10 = u0Var.h();
        Throwable e10 = u0Var.e(h10);
        if (e10 != null) {
            Result.a aVar = Result.f32010a;
            obj = g.a(e10);
        } else {
            Result.a aVar2 = Result.f32010a;
            obj = u0Var.f(h10);
        }
        Object b10 = Result.b(obj);
        if (z10) {
            i iVar = (i) cVar;
            c<T> cVar2 = iVar.f32536e;
            Object obj2 = iVar.f32538g;
            CoroutineContext context = cVar2.getContext();
            Object c10 = ThreadContextKt.c(context, obj2);
            if (c10 != ThreadContextKt.f32507a) {
                x2Var = CoroutineContextKt.g(cVar2, context, c10);
            } else {
                x2Var = null;
            }
            try {
                iVar.f32536e.resumeWith(b10);
                Unit unit = Unit.f32013a;
            } finally {
                if (x2Var == null || x2Var.j1()) {
                    ThreadContextKt.a(context, c10);
                }
            }
        } else {
            cVar.resumeWith(b10);
        }
    }

    private static final void e(u0<?> u0Var) {
        d1 b10 = q2.f32598a.b();
        if (b10.B0()) {
            b10.i0(u0Var);
            return;
        }
        b10.q0(true);
        try {
            d(u0Var, u0Var.c(), true);
            do {
            } while (b10.I0());
        } catch (Throwable th2) {
            b10.Y(true);
            throw th2;
        }
        b10.Y(true);
    }
}
