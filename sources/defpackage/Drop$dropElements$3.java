package defpackage;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: Drop$dropElements$3  reason: default package */
final class Drop$dropElements$3 extends Lambda implements Function0<Object> {
    final /* synthetic */ int $count;
    final /* synthetic */ Object $this_dropElements;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Drop$dropElements$3(Object obj, int i10) {
        super(0);
        this.$this_dropElements = obj;
        this.$count = i10;
    }

    public final Object invoke() {
        return CollectionsKt___CollectionsKt.G((Iterable) this.$this_dropElements, this.$count);
    }
}
