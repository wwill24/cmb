package com.squareup.workflow1.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ViewLaunchWhenAttachedKt$launchWhenAttached$launch$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AttachedScope $attachedScope;
    final /* synthetic */ Function2<k0, c<? super Unit>, Object> $block;
    final /* synthetic */ CoroutineContext $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewLaunchWhenAttachedKt$launchWhenAttached$launch$1(AttachedScope attachedScope, CoroutineContext coroutineContext, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2) {
        super(0);
        this.$attachedScope = attachedScope;
        this.$context = coroutineContext;
        this.$block = function2;
    }

    public final void invoke() {
        h.c(this.$attachedScope.b(), this.$context, CoroutineStart.UNDISPATCHED, this.$block);
    }
}
