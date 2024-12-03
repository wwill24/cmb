package di;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¨\u0006\u0005"}, d2 = {"", "T", "", "Ldi/b;", "a", "wf1-container-common"}, k = 2, mv = {1, 6, 0})
public final class c {
    public static final <T> b<T> a(List<? extends T> list) {
        j.g(list, "<this>");
        if (!list.isEmpty()) {
            return new b<>(CollectionsKt___CollectionsKt.N(list), list.subList(1, list.size()));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
