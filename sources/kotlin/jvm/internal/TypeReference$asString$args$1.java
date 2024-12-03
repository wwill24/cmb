package kotlin.jvm.internal;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KTypeProjection;

final class TypeReference$asString$args$1 extends Lambda implements Function1<KTypeProjection, CharSequence> {
    final /* synthetic */ TypeReference this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeReference$asString$args$1(TypeReference typeReference) {
        super(1);
        this.this$0 = typeReference;
    }

    /* renamed from: a */
    public final CharSequence invoke(KTypeProjection kTypeProjection) {
        j.g(kTypeProjection, "it");
        return this.this$0.e(kTypeProjection);
    }
}
