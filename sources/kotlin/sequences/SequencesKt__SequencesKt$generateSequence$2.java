package kotlin.sequences;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SequencesKt__SequencesKt$generateSequence$2 extends Lambda implements Function0<T> {
    final /* synthetic */ T $seed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$generateSequence$2(T t10) {
        super(0);
        this.$seed = t10;
    }

    public final T invoke() {
        return this.$seed;
    }
}
