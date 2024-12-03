package operations.logic.equals;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class Equals$evaluateLogic$1 extends Lambda implements Function2<Integer, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final Equals$evaluateLogic$1 f33489a = new Equals$evaluateLogic$1();

    Equals$evaluateLogic$1() {
        super(2);
    }

    public final Boolean a(int i10, int i11) {
        return Boolean.valueOf(i10 == i11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a(((Number) obj).intValue(), ((Number) obj2).intValue());
    }
}
