package com.leanplum.migration;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
final class MigrationManager$fetchState$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function1 $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MigrationManager$fetchState$1(Function1 function1) {
        super(1);
        this.$callback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f32013a;
    }

    public final void invoke(boolean z10) {
        this.$callback.invoke(MigrationManager.getState());
    }
}
