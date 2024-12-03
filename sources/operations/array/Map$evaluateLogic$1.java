package operations.array;

import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import ol.a;

/* synthetic */ class Map$evaluateLogic$1 extends FunctionReferenceImpl implements Function2<a, f, List<? extends Object>> {
    Map$evaluateLogic$1(Object obj) {
        super(2, obj, Map.class, "mapOrEmptyList", "mapOrEmptyList(Loperations/array/ArrayOperationInputData;LLogicEvaluator;)Ljava/util/List;", 0);
    }

    /* renamed from: c */
    public final List<Object> invoke(a aVar, f fVar) {
        j.g(aVar, "p0");
        j.g(fVar, "p1");
        return ((Map) this.receiver).h(aVar, fVar);
    }
}
