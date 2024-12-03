package kotlin.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.j;

final class CombinedContext$writeReplace$1 extends Lambda implements Function2<Unit, CoroutineContext.Element, Unit> {
    final /* synthetic */ CoroutineContext[] $elements;
    final /* synthetic */ Ref$IntRef $index;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombinedContext$writeReplace$1(CoroutineContext[] coroutineContextArr, Ref$IntRef ref$IntRef) {
        super(2);
        this.$elements = coroutineContextArr;
        this.$index = ref$IntRef;
    }

    public final void a(Unit unit, CoroutineContext.Element element) {
        j.g(unit, "<anonymous parameter 0>");
        j.g(element, "element");
        CoroutineContext[] coroutineContextArr = this.$elements;
        Ref$IntRef ref$IntRef = this.$index;
        int i10 = ref$IntRef.element;
        ref$IntRef.element = i10 + 1;
        coroutineContextArr[i10] = element;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((Unit) obj, (CoroutineContext.Element) obj2);
        return Unit.f32013a;
    }
}
