package p8;

import java.util.function.BinaryOperator;

public final /* synthetic */ class g implements BinaryOperator {
    public final Object apply(Object obj, Object obj2) {
        return Integer.valueOf(Integer.sum(((Integer) obj).intValue(), ((Integer) obj2).intValue()));
    }
}
