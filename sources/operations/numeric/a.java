package operations.numeric;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public interface a {

    /* renamed from: operations.numeric.a$a  reason: collision with other inner class name */
    public static final class C0386a {
        public static Double a(a aVar, Object obj, Function1<? super List<Double>, Double> function1) {
            List<Double> list;
            List list2;
            Integer num;
            Integer num2;
            List K;
            j.g(function1, "operation");
            if (obj != null) {
                list = p004do.a.b(obj);
            } else {
                list = null;
            }
            if (list != null) {
                list2 = CollectionsKt___CollectionsKt.K(list);
            } else {
                list2 = null;
            }
            if (list2 != null) {
                num = Integer.valueOf(list2.size());
            } else {
                num = null;
            }
            if (list != null) {
                num2 = Integer.valueOf(list.size());
            } else {
                num2 = null;
            }
            if (!j.b(num, num2) || list == null || (K = CollectionsKt___CollectionsKt.K(list)) == null) {
                return null;
            }
            return function1.invoke(K);
        }
    }
}
