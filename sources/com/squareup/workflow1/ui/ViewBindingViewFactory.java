package com.squareup.workflow1.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import pk.n;
import wk.c;
import z1.a;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005B[\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010\u0012*\u0010\u001b\u001a&\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00028\u00000\u0015j\b\u0012\u0004\u0012\u00028\u0000`\u0018\u0012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d0\u001c¢\u0006\u0004\b!\u0010\"J1\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00108\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R8\u0010\u001b\u001a&\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00028\u00000\u0015j\b\u0012\u0004\u0012\u00028\u0000`\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010 \u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/squareup/workflow1/ui/ViewBindingViewFactory;", "Lz1/a;", "BindingT", "", "RenderingT", "Lcom/squareup/workflow1/ui/r;", "initialRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Landroid/content/Context;", "contextForNewView", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "a", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Landroid/content/Context;Landroid/view/ViewGroup;)Landroid/view/View;", "Lwk/c;", "Lwk/c;", "getType", "()Lwk/c;", "type", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "", "Lcom/squareup/workflow1/ui/ViewBindingInflater;", "b", "Lpk/n;", "bindingInflater", "Lkotlin/Function1;", "Lcom/squareup/workflow1/ui/f;", "c", "Lkotlin/jvm/functions/Function1;", "runnerConstructor", "<init>", "(Lwk/c;Lpk/n;Lkotlin/jvm/functions/Function1;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class ViewBindingViewFactory<BindingT extends a, RenderingT> implements r<RenderingT> {

    /* renamed from: a  reason: collision with root package name */
    private final c<RenderingT> f23180a;

    /* renamed from: b  reason: collision with root package name */
    private final n<LayoutInflater, ViewGroup, Boolean, BindingT> f23181b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<BindingT, f<RenderingT>> f23182c;

    public ViewBindingViewFactory(c<RenderingT> cVar, n<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends BindingT> nVar, Function1<? super BindingT, ? extends f<RenderingT>> function1) {
        j.g(cVar, "type");
        j.g(nVar, "bindingInflater");
        j.g(function1, "runnerConstructor");
        this.f23180a = cVar;
        this.f23181b = nVar;
        this.f23182c = function1;
    }

    public View a(RenderingT renderingt, p pVar, Context context, ViewGroup viewGroup) {
        j.g(renderingt, "initialRendering");
        j.g(pVar, "initialViewEnvironment");
        j.g(context, "contextForNewView");
        n<LayoutInflater, ViewGroup, Boolean, BindingT> nVar = this.f23181b;
        LayoutInflater a10 = g.a(context, viewGroup);
        j.f(a10, "contextForNewView.viewBi…LayoutInflater(container)");
        a aVar = (a) nVar.l(a10, viewGroup, Boolean.FALSE);
        View root = aVar.getRoot();
        j.f(root, "binding.root");
        t.a(root, renderingt, pVar, new ViewBindingViewFactory$buildView$1$1(this.f23182c.invoke(aVar)));
        View root2 = aVar.getRoot();
        j.f(root2, "bindingInflater(contextF…    }\n      }\n      .root");
        return root2;
    }

    public c<RenderingT> getType() {
        return this.f23180a;
    }
}
