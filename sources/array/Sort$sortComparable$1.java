package array;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class Sort$sortComparable$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ List<Comparable<Object>> $this_sortComparable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Sort$sortComparable$1(List<Comparable<Object>> list) {
        super(0);
        this.$this_sortComparable = list;
    }

    public final Object invoke() {
        return CollectionsKt___CollectionsKt.o0(this.$this_sortComparable);
    }
}
