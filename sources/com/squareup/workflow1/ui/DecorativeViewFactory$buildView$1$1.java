package com.squareup.workflow1.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "OuterT", "InnerT", "rendering", "Lcom/squareup/workflow1/ui/p;", "env", "", "a", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;)V"}, k = 3, mv = {1, 6, 0})
final class DecorativeViewFactory$buildView$1$1 extends Lambda implements Function2<OuterT, p, Unit> {
    final /* synthetic */ Function2<InnerT, p, Unit> $innerShowRendering;
    final /* synthetic */ View $view;
    final /* synthetic */ DecorativeViewFactory<OuterT, InnerT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DecorativeViewFactory$buildView$1$1(DecorativeViewFactory<OuterT, InnerT> decorativeViewFactory, View view, Function2<? super InnerT, ? super p, Unit> function2) {
        super(2);
        this.this$0 = decorativeViewFactory;
        this.$view = view;
        this.$innerShowRendering = function2;
    }

    public final void a(OuterT outert, p pVar) {
        j.g(outert, "rendering");
        j.g(pVar, "env");
        this.this$0.f23166d.g(this.$view, this.$innerShowRendering, outert, pVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a(obj, (p) obj2);
        return Unit.f32013a;
    }
}
