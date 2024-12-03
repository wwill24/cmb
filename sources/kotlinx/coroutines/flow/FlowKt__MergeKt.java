package kotlinx.coroutines.flow;

import com.google.android.gms.common.api.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.g0;
import pk.n;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\u001a9\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0004\"\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a`\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u000220\b\u0001\u0010\u000e\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aT\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00022$\b\u0001\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\" \u0010\u001a\u001a\u00020\u00148\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u001c\u001a\u00020\u001b8\u0006XT¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\u001e\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"T", "", "Lkotlinx/coroutines/flow/b;", "b", "", "flows", "c", "([Lkotlinx/coroutines/flow/b;)Lkotlinx/coroutines/flow/b;", "R", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/c;", "Lkotlin/coroutines/c;", "", "", "transform", "d", "(Lkotlinx/coroutines/flow/b;Lpk/n;)Lkotlinx/coroutines/flow/b;", "Lkotlin/Function2;", "a", "(Lkotlinx/coroutines/flow/b;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/b;", "", "I", "getDEFAULT_CONCURRENCY", "()I", "getDEFAULT_CONCURRENCY$annotations", "()V", "DEFAULT_CONCURRENCY", "", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "Ljava/lang/String;", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f32393a = g0.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, a.e.API_PRIORITY_OTHER);

    public static final <T, R> b<R> a(b<? extends T> bVar, Function2<? super T, ? super c<? super R>, ? extends Object> function2) {
        return d.I(bVar, new FlowKt__MergeKt$mapLatest$1(function2, (c<? super FlowKt__MergeKt$mapLatest$1>) null));
    }

    public static final <T> b<T> b(Iterable<? extends b<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (DefaultConstructorMarker) null);
    }

    public static final <T> b<T> c(b<? extends T>... bVarArr) {
        return d.B(l.q(bVarArr));
    }

    public static final <T, R> b<R> d(b<? extends T> bVar, n<? super c<? super R>, ? super T, ? super c<? super Unit>, ? extends Object> nVar) {
        return new ChannelFlowTransformLatest(nVar, bVar, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (DefaultConstructorMarker) null);
    }
}
