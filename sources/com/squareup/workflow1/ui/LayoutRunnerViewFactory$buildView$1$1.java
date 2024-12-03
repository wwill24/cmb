package com.squareup.workflow1.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "RenderingT", "rendering", "Lcom/squareup/workflow1/ui/p;", "environment", "", "a", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;)V"}, k = 3, mv = {1, 6, 0})
final class LayoutRunnerViewFactory$buildView$1$1 extends Lambda implements Function2<RenderingT, p, Unit> {
    final /* synthetic */ f<RenderingT> $runner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutRunnerViewFactory$buildView$1$1(f<RenderingT> fVar) {
        super(2);
        this.$runner = fVar;
    }

    public final void a(RenderingT renderingt, p pVar) {
        j.g(renderingt, "rendering");
        j.g(pVar, "environment");
        this.$runner.a(renderingt, pVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a(obj, (p) obj2);
        return Unit.f32013a;
    }
}
