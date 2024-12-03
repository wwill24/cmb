package com.squareup.workflow1.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import wk.c;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B9\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0013\u0012\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/squareup/workflow1/ui/LayoutRunnerViewFactory;", "", "RenderingT", "Lcom/squareup/workflow1/ui/r;", "initialRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Landroid/content/Context;", "contextForNewView", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "a", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Landroid/content/Context;Landroid/view/ViewGroup;)Landroid/view/View;", "Lwk/c;", "Lwk/c;", "getType", "()Lwk/c;", "type", "", "b", "I", "layoutId", "Lkotlin/Function1;", "Lcom/squareup/workflow1/ui/f;", "c", "Lkotlin/jvm/functions/Function1;", "runnerConstructor", "<init>", "(Lwk/c;ILkotlin/jvm/functions/Function1;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class LayoutRunnerViewFactory<RenderingT> implements r<RenderingT> {

    /* renamed from: a  reason: collision with root package name */
    private final c<RenderingT> f23171a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23172b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<View, f<RenderingT>> f23173c;

    public LayoutRunnerViewFactory(c<RenderingT> cVar, int i10, Function1<? super View, ? extends f<RenderingT>> function1) {
        j.g(cVar, "type");
        j.g(function1, "runnerConstructor");
        this.f23171a = cVar;
        this.f23172b = i10;
        this.f23173c = function1;
    }

    public View a(RenderingT renderingt, p pVar, Context context, ViewGroup viewGroup) {
        j.g(renderingt, "initialRendering");
        j.g(pVar, "initialViewEnvironment");
        j.g(context, "contextForNewView");
        View inflate = g.a(context, viewGroup).inflate(this.f23172b, viewGroup, false);
        Function1<View, f<RenderingT>> function1 = this.f23173c;
        j.f(inflate, "view");
        t.a(inflate, renderingt, pVar, new LayoutRunnerViewFactory$buildView$1$1(function1.invoke(inflate)));
        j.f(inflate, "contextForNewView.viewBi…onment)\n        }\n      }");
        return inflate;
    }

    public c<RenderingT> getType() {
        return this.f23171a;
    }
}
