package com.squareup.workflow1.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import pk.o;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B=\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R4\u0010\u0016\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u000b0\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/squareup/workflow1/ui/c;", "", "RenderingT", "Lcom/squareup/workflow1/ui/r;", "initialRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Landroid/content/Context;", "contextForNewView", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "a", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Landroid/content/Context;Landroid/view/ViewGroup;)Landroid/view/View;", "Lwk/c;", "Lwk/c;", "getType", "()Lwk/c;", "type", "Lkotlin/Function4;", "b", "Lpk/o;", "viewConstructor", "<init>", "(Lwk/c;Lpk/o;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class c<RenderingT> implements r<RenderingT> {

    /* renamed from: a  reason: collision with root package name */
    private final wk.c<RenderingT> f23234a;

    /* renamed from: b  reason: collision with root package name */
    private final o<RenderingT, p, Context, ViewGroup, View> f23235b;

    public c(wk.c<RenderingT> cVar, o<? super RenderingT, ? super p, ? super Context, ? super ViewGroup, ? extends View> oVar) {
        j.g(cVar, "type");
        j.g(oVar, "viewConstructor");
        this.f23234a = cVar;
        this.f23235b = oVar;
    }

    public View a(RenderingT renderingt, p pVar, Context context, ViewGroup viewGroup) {
        j.g(renderingt, "initialRendering");
        j.g(pVar, "initialViewEnvironment");
        j.g(context, "contextForNewView");
        return this.f23235b.g(renderingt, pVar, context, viewGroup);
    }

    public wk.c<RenderingT> getType() {
        return this.f23234a;
    }
}
