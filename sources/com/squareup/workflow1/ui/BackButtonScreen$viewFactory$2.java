package com.squareup.workflow1.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import pk.o;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\f\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00020\u0000`\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u000b\u001a\u00020\u0005H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "W", "Landroid/view/View;", "view", "Lkotlin/Function2;", "Lcom/squareup/workflow1/ui/p;", "", "Lcom/squareup/workflow1/ui/ViewShowRendering;", "innerShowRendering", "Lcom/squareup/workflow1/ui/BackButtonScreen;", "outerRendering", "viewEnvironment", "a", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;Lcom/squareup/workflow1/ui/BackButtonScreen;Lcom/squareup/workflow1/ui/p;)V"}, k = 3, mv = {1, 6, 0})
final class BackButtonScreen$viewFactory$2 extends Lambda implements o<View, Function2<? super Object, ? super p, ? extends Unit>, BackButtonScreen<?>, p, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final BackButtonScreen$viewFactory$2 f23162a = new BackButtonScreen$viewFactory$2();

    BackButtonScreen$viewFactory$2() {
        super(4);
    }

    public final void a(View view, Function2<Object, ? super p, Unit> function2, BackButtonScreen<?> backButtonScreen, p pVar) {
        j.g(view, "view");
        j.g(function2, "innerShowRendering");
        j.g(backButtonScreen, "outerRendering");
        j.g(pVar, "viewEnvironment");
        if (!backButtonScreen.c()) {
            b.c(view, backButtonScreen.b());
        }
        function2.invoke(backButtonScreen.d(), pVar);
        if (backButtonScreen.c()) {
            b.c(view, backButtonScreen.b());
        }
    }

    public /* bridge */ /* synthetic */ Object g(Object obj, Object obj2, Object obj3, Object obj4) {
        a((View) obj, (Function2) obj2, (BackButtonScreen) obj3, (p) obj4);
        return Unit.f32013a;
    }
}
