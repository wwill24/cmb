package com.squareup.workflow1.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0})
final class AttachedScope$attachedJob$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ AttachedScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AttachedScope$attachedJob$1$1(AttachedScope attachedScope) {
        super(1);
        this.this$0 = attachedScope;
    }

    public final void a(Throwable th2) {
        this.this$0.f23154a.clear();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
