package com.squareup.workflow1.ui;

import android.view.View;
import com.squareup.workflow1.ui.WorkflowViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u001aQ\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00028\u0000`\bH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\f\u0010\f\u001a\u00020\u0007*\u00020\u0002H\u0007\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0000H\u0007\u001a-\u0010\u0011\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a6\u0010\u0013\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u0007\" \u0010\u0018\u001a\u0004\u0018\u00010\u0004*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\"F\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0019*\u00020\u00022\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00198@@@X\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e*6\b\u0007\u0010!\u001a\u0004\b\u0000\u0010\u0001\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\""}, d2 = {"", "RenderingT", "Landroid/view/View;", "initialRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Lkotlin/Function2;", "", "Lcom/squareup/workflow1/ui/ViewShowRendering;", "showRendering", "a", "(Landroid/view/View;Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Lkotlin/jvm/functions/Function2;)V", "h", "rendering", "", "b", "viewEnvironment", "g", "(Landroid/view/View;Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;)V", "d", "c", "(Landroid/view/View;)Lcom/squareup/workflow1/ui/p;", "getEnvironment$annotations", "(Landroid/view/View;)V", "environment", "Lkotlin/Function1;", "value", "e", "(Landroid/view/View;)Lkotlin/jvm/functions/Function1;", "f", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "getStarter$annotations", "starter", "ViewShowRendering", "wf1-core-android"}, k = 2, mv = {1, 6, 0})
public final class t {
    public static final <RenderingT> void a(View view, RenderingT renderingt, p pVar, Function2<? super RenderingT, ? super p, Unit> function2) {
        WorkflowViewState.New newR;
        j.g(view, "<this>");
        j.g(renderingt, "initialRendering");
        j.g(pVar, "initialViewEnvironment");
        j.g(function2, "showRendering");
        if (v.d(view) instanceof WorkflowViewState.New) {
            newR = new WorkflowViewState.New(renderingt, pVar, function2, e(view));
        } else {
            newR = new WorkflowViewState.New(renderingt, pVar, function2, (Function1) null, 8, (DefaultConstructorMarker) null);
        }
        v.e(view, newR);
    }

    public static final boolean b(View view, Object obj) {
        Object obj2;
        j.g(view, "<this>");
        j.g(obj, "rendering");
        WorkflowViewState<?> d10 = v.d(view);
        Object obj3 = null;
        if (d10 == null) {
            obj2 = null;
        } else {
            obj2 = d10.c();
        }
        if (obj2 != null) {
            obj3 = obj2;
        }
        if (obj3 != null && e.a(obj3, obj)) {
            return true;
        }
        return false;
    }

    public static final p c(View view) {
        j.g(view, "<this>");
        WorkflowViewState<?> d10 = v.d(view);
        if (d10 == null) {
            return null;
        }
        return d10.a();
    }

    public static final <RenderingT> Function2<RenderingT, p, Unit> d(View view) {
        j.g(view, "<this>");
        WorkflowViewState<?> d10 = v.d(view);
        if (d10 == null) {
            return null;
        }
        return d10.b();
    }

    public static final Function1<View, Unit> e(View view) {
        j.g(view, "<this>");
        return v.b(view).g();
    }

    public static final void f(View view, Function1<? super View, Unit> function1) {
        j.g(view, "<this>");
        j.g(function1, "value");
        v.e(view, WorkflowViewState.New.e(v.b(view), (Object) null, (p) null, (Function2) null, function1, 7, (Object) null));
    }

    public static final <RenderingT> void g(View view, RenderingT renderingt, p pVar) {
        j.g(view, "<this>");
        j.g(renderingt, "rendering");
        j.g(pVar, "viewEnvironment");
        WorkflowViewState.a<?> c10 = v.c(view);
        if (e.a(c10.c(), renderingt)) {
            v.e(view, new WorkflowViewState.a(renderingt, pVar, c10.b()));
            c10.b().invoke(renderingt, pVar);
            return;
        }
        throw new IllegalStateException(("Expected " + view + " to be able to show rendering " + renderingt + ", but that did not match previous rendering " + c10.c() + ". Consider using WorkflowViewStub to display arbitrary types.").toString());
    }

    public static final void h(View view) {
        j.g(view, "<this>");
        WorkflowViewState.New<?> b10 = v.b(view);
        v.e(view, new WorkflowViewState.a(b10.c(), b10.a(), b10.b()));
        b10.g().invoke(view);
    }
}
