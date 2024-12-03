package operations.numeric.compare;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class GreaterThan$evaluateLogic$1 extends Lambda implements Function2<Integer, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final GreaterThan$evaluateLogic$1 f33505a = new GreaterThan$evaluateLogic$1();

    GreaterThan$evaluateLogic$1() {
        super(2);
    }

    public final Boolean a(int i10, int i11) {
        return Boolean.valueOf(i10 > i11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a(((Number) obj).intValue(), ((Number) obj2).intValue());
    }
}
