package com.squareup.workflow1.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "RenderingT", "Landroid/view/View;", "newView", "", "a", "(Landroid/view/View;)V"}, k = 3, mv = {1, 6, 0})
final class ViewRegistryKt$buildView$1$2$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Function1<View, Unit> $doStart;
    final /* synthetic */ u $givenStarter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewRegistryKt$buildView$1$2$1(u uVar, Function1<? super View, Unit> function1) {
        super(1);
        this.$givenStarter = uVar;
        this.$doStart = function1;
    }

    public final void a(final View view) {
        j.g(view, "newView");
        u uVar = this.$givenStarter;
        final Function1<View, Unit> function1 = this.$doStart;
        uVar.a(view, new Function0<Unit>() {
            public final void invoke() {
                function1.invoke(view);
            }
        });
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((View) obj);
        return Unit.f32013a;
    }
}
