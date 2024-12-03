package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$filterNotNull$1 extends Lambda implements Function1<T, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final SequencesKt___SequencesKt$filterNotNull$1 f32168a = new SequencesKt___SequencesKt$filterNotNull$1();

    SequencesKt___SequencesKt$filterNotNull$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(T t10) {
        return Boolean.valueOf(t10 == null);
    }
}
