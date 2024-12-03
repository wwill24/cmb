package operations.numeric;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class Addition$evaluateLogic$1 extends Lambda implements Function1<List<? extends Double>, Double> {

    /* renamed from: a  reason: collision with root package name */
    public static final Addition$evaluateLogic$1 f33497a = new Addition$evaluateLogic$1();

    Addition$evaluateLogic$1() {
        super(1);
    }

    /* renamed from: a */
    public final Double invoke(List<Double> list) {
        j.g(list, "it");
        return Double.valueOf(CollectionsKt___CollectionsKt.r0(list));
    }
}
