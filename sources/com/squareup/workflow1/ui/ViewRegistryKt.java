package com.squareup.workflow1.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0004\u001a\u00020\u00032\u001a\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000\"\u0006\u0012\u0002\b\u00030\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\b\u0010\u0006\u001a\u00020\u0003H\u0007\u001a+\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\b*\u00020\u0007*\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001aM\u0010\u0016\u001a\u00020\u0015\"\b\b\u0000\u0010\b*\u00020\u0007*\u00020\u00032\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"", "Lcom/squareup/workflow1/ui/r;", "bindings", "Lcom/squareup/workflow1/ui/s;", "b", "([Lcom/squareup/workflow1/ui/r;)Lcom/squareup/workflow1/ui/s;", "a", "", "RenderingT", "rendering", "e", "(Lcom/squareup/workflow1/ui/s;Ljava/lang/Object;)Lcom/squareup/workflow1/ui/r;", "initialRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Landroid/content/Context;", "contextForNewView", "Landroid/view/ViewGroup;", "container", "Lcom/squareup/workflow1/ui/u;", "viewStarter", "Landroid/view/View;", "c", "(Lcom/squareup/workflow1/ui/s;Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Landroid/content/Context;Landroid/view/ViewGroup;Lcom/squareup/workflow1/ui/u;)Landroid/view/View;", "wf1-core-android"}, k = 2, mv = {1, 6, 0})
public final class ViewRegistryKt {
    public static final s a() {
        return new o((r<?>[]) new r[0]);
    }

    public static final s b(r<?>... rVarArr) {
        j.g(rVarArr, "bindings");
        return new o((r<?>[]) (r[]) Arrays.copyOf(rVarArr, rVarArr.length));
    }

    public static final <RenderingT> View c(s sVar, RenderingT renderingt, p pVar, Context context, ViewGroup viewGroup, u uVar) {
        j.g(sVar, "<this>");
        j.g(renderingt, "initialRendering");
        j.g(pVar, "initialViewEnvironment");
        j.g(context, "contextForNewView");
        View a10 = e(sVar, renderingt).a(renderingt, pVar, context, viewGroup);
        if (v.d(a10) != null) {
            if (uVar != null) {
                t.f(a10, new ViewRegistryKt$buildView$1$2$1(uVar, t.e(a10)));
            }
            return a10;
        }
        throw new IllegalStateException(("View.bindShowRendering should have been called for " + a10 + ", typically by the " + r.class.getName() + " that created it.").toString());
    }

    public static /* synthetic */ View d(s sVar, Object obj, p pVar, Context context, ViewGroup viewGroup, u uVar, int i10, Object obj2) {
        return c(sVar, obj, pVar, context, (i10 & 8) != 0 ? null : viewGroup, (i10 & 16) != 0 ? null : uVar);
    }

    public static final <RenderingT> r<RenderingT> e(s sVar, RenderingT renderingt) {
        a aVar;
        h hVar;
        r<RenderingT> rVar;
        j.g(sVar, "<this>");
        j.g(renderingt, "rendering");
        r<RenderingT> a10 = sVar.a(l.b(renderingt.getClass()));
        if (a10 == null) {
            if (renderingt instanceof a) {
                aVar = (a) renderingt;
            } else {
                aVar = null;
            }
            if (aVar == null) {
                a10 = null;
            } else {
                a10 = aVar.a();
            }
            if (!(a10 instanceof r)) {
                a10 = null;
            }
            if (a10 == null) {
                if (renderingt instanceof h) {
                    hVar = (h) renderingt;
                } else {
                    hVar = null;
                }
                if (hVar == null) {
                    rVar = null;
                } else {
                    rVar = NamedViewFactory.f23174b;
                }
                if (a10 == null) {
                    throw new IllegalArgumentException("A " + l.b(r.class).d() + " should have been registered to display " + l.b(renderingt.getClass()).d() + " instances, or that class should implement " + l.b(a.class).getSimpleName() + '<' + l.b(renderingt.getClass()).getSimpleName() + ">.");
                }
            }
        }
        return a10;
    }
}
