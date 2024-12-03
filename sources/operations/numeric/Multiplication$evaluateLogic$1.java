package operations.numeric;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class Multiplication$evaluateLogic$1 extends Lambda implements Function1<List<? extends Double>, Double> {

    /* renamed from: a  reason: collision with root package name */
    public static final Multiplication$evaluateLogic$1 f33503a = new Multiplication$evaluateLogic$1();

    Multiplication$evaluateLogic$1() {
        super(1);
    }

    /* renamed from: a */
    public final Double invoke(List<Double> list) {
        j.g(list, "it");
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = Double.valueOf(((Number) next).doubleValue() * ((Number) it.next()).doubleValue());
            }
            return (Double) next;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}
