package kotlinx.coroutines.reactive;

import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.b;
import rn.a;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\"\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\n¨\u0006\f"}, d2 = {"", "T", "Lrn/a;", "Lkotlinx/coroutines/flow/b;", "a", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "b", "", "Lkotlinx/coroutines/reactive/b;", "[Lkotlinx/coroutines/reactive/b;", "contextInjectors", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 6, 0})
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final b[] f32609a;

    static {
        Class<b> cls = b.class;
        Object[] array2 = SequencesKt___SequencesKt.t(SequencesKt__SequencesKt.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator())).toArray(new b[0]);
        if (array2 != null) {
            f32609a = (b[]) array2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final <T> b<T> a(a<T> aVar) {
        return new PublisherAsFlow(aVar, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (DefaultConstructorMarker) null);
    }

    public static final <T> a<T> b(a<T> aVar, CoroutineContext coroutineContext) {
        for (b a10 : f32609a) {
            aVar = a10.a(aVar, coroutineContext);
        }
        return aVar;
    }
}
