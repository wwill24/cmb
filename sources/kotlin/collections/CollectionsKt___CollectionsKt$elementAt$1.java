package kotlin.collections;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class CollectionsKt___CollectionsKt$elementAt$1 extends Lambda implements Function1<Integer, T> {
    final /* synthetic */ int $index;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionsKt___CollectionsKt$elementAt$1(int i10) {
        super(1);
        this.$index = i10;
    }

    public final T a(int i10) {
        throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.$index + '.');
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a(((Number) obj).intValue());
    }
}
