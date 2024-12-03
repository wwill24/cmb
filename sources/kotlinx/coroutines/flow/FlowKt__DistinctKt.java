package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001aY\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u001c\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\n\"*\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0002X\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u000b\u0012\u0004\b\f\u0010\r\"0\u0010\u0011\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\f\n\u0004\b\t\u0010\u000f\u0012\u0004\b\u0010\u0010\r¨\u0006\u0012"}, d2 = {"T", "Lkotlinx/coroutines/flow/b;", "a", "Lkotlin/Function1;", "", "keySelector", "Lkotlin/Function2;", "", "areEquivalent", "b", "(Lkotlinx/coroutines/flow/b;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/b;", "Lkotlin/jvm/functions/Function1;", "getDefaultKeySelector$annotations$FlowKt__DistinctKt", "()V", "defaultKeySelector", "Lkotlin/jvm/functions/Function2;", "getDefaultAreEquivalent$annotations$FlowKt__DistinctKt", "defaultAreEquivalent", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__DistinctKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Function1<Object, Object> f32364a = FlowKt__DistinctKt$defaultKeySelector$1.f32367a;

    /* renamed from: b  reason: collision with root package name */
    private static final Function2<Object, Object, Boolean> f32365b = FlowKt__DistinctKt$defaultAreEquivalent$1.f32366a;

    public static final <T> b<T> a(b<? extends T> bVar) {
        if (bVar instanceof r) {
            return bVar;
        }
        return b(bVar, f32364a, f32365b);
    }

    private static final <T> b<T> b(b<? extends T> bVar, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        if (bVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) bVar;
            if (distinctFlowImpl.f32358b == function1 && distinctFlowImpl.f32359c == function2) {
                return bVar;
            }
        }
        return new DistinctFlowImpl(bVar, function1, function2);
    }
}
