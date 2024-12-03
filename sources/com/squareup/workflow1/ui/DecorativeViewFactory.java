package com.squareup.workflow1.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import pk.o;
import wk.c;

@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0001\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012$\u0010\u0018\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u00150\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012B\b\u0002\u0010\"\u001a<\u0012\u0004\u0012\u00020\f\u0012 \u0012\u001e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u0014j\b\u0012\u0004\u0012\u00028\u0001`\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0004\b#\u0010$B{\b\u0016\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012B\b\u0002\u0010\"\u001a<\u0012\u0004\u0012\u00020\f\u0012 \u0012\u001e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u0014j\b\u0012\u0004\u0012\u00028\u0001`\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0004\b#\u0010&J1\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R2\u0010\u0018\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u00150\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRN\u0010\"\u001a<\u0012\u0004\u0012\u00020\f\u0012 \u0012\u001e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u0014j\b\u0012\u0004\u0012\u00028\u0001`\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/squareup/workflow1/ui/DecorativeViewFactory;", "", "OuterT", "InnerT", "Lcom/squareup/workflow1/ui/r;", "initialRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Landroid/content/Context;", "contextForNewView", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "a", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Landroid/content/Context;Landroid/view/ViewGroup;)Landroid/view/View;", "Lwk/c;", "Lwk/c;", "getType", "()Lwk/c;", "type", "Lkotlin/Function2;", "Lkotlin/Pair;", "b", "Lkotlin/jvm/functions/Function2;", "map", "Lcom/squareup/workflow1/ui/u;", "c", "Lcom/squareup/workflow1/ui/u;", "viewStarter", "Lkotlin/Function4;", "", "Lcom/squareup/workflow1/ui/ViewShowRendering;", "d", "Lpk/o;", "doShowRendering", "<init>", "(Lwk/c;Lkotlin/jvm/functions/Function2;Lcom/squareup/workflow1/ui/u;Lpk/o;)V", "Lkotlin/Function1;", "(Lwk/c;Lkotlin/jvm/functions/Function1;Lcom/squareup/workflow1/ui/u;Lpk/o;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class DecorativeViewFactory<OuterT, InnerT> implements r<OuterT> {

    /* renamed from: a  reason: collision with root package name */
    private final c<OuterT> f23163a;

    /* renamed from: b  reason: collision with root package name */
    private final Function2<OuterT, p, Pair<InnerT, p>> f23164b;

    /* renamed from: c  reason: collision with root package name */
    private final u f23165c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final o<View, Function2<? super InnerT, ? super p, Unit>, OuterT, p, Unit> f23166d;

    public DecorativeViewFactory(c<OuterT> cVar, Function2<? super OuterT, ? super p, ? extends Pair<? extends InnerT, p>> function2, u uVar, o<? super View, ? super Function2<? super InnerT, ? super p, Unit>, ? super OuterT, ? super p, Unit> oVar) {
        j.g(cVar, "type");
        j.g(function2, "map");
        j.g(oVar, "doShowRendering");
        this.f23163a = cVar;
        this.f23164b = function2;
        this.f23165c = uVar;
        this.f23166d = oVar;
    }

    public View a(OuterT outert, p pVar, Context context, ViewGroup viewGroup) {
        j.g(outert, "initialRendering");
        j.g(pVar, "initialViewEnvironment");
        j.g(context, "contextForNewView");
        Pair invoke = this.f23164b.invoke(outert, pVar);
        Object a10 = invoke.a();
        p pVar2 = (p) invoke.b();
        View c10 = ViewRegistryKt.c((s) pVar2.a(s.f23293a), a10, pVar2, context, viewGroup, this.f23165c);
        Function2 d10 = t.d(c10);
        j.d(d10);
        t.a(c10, outert, pVar2, new DecorativeViewFactory$buildView$1$1(this, c10, d10));
        return c10;
    }

    public c<OuterT> getType() {
        return this.f23163a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DecorativeViewFactory(c cVar, final Function1 function1, u uVar, o oVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, function1, (i10 & 4) != 0 ? null : uVar, (i10 & 8) != 0 ? new o<View, Function2<? super InnerT, ? super p, ? extends Unit>, OuterT, p, Unit>() {
            public final void a(View view, Function2<? super InnerT, ? super p, Unit> function2, OuterT outert, p pVar) {
                j.g(view, "$noName_0");
                j.g(function2, "innerShowRendering");
                j.g(outert, "outerRendering");
                j.g(pVar, "viewEnvironment");
                function2.invoke(function1.invoke(outert), pVar);
            }

            public /* bridge */ /* synthetic */ Object g(Object obj, Object obj2, Object obj3, Object obj4) {
                a((View) obj, (Function2) obj2, obj3, (p) obj4);
                return Unit.f32013a;
            }
        } : oVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DecorativeViewFactory(c<OuterT> cVar, final Function1<? super OuterT, ? extends InnerT> function1, u uVar, o<? super View, ? super Function2<? super InnerT, ? super p, Unit>, ? super OuterT, ? super p, Unit> oVar) {
        this(cVar, new Function2<OuterT, p, Pair<? extends InnerT, ? extends p>>() {
            /* renamed from: a */
            public final Pair<InnerT, p> invoke(OuterT outert, p pVar) {
                j.g(outert, "outer");
                j.g(pVar, "viewEnvironment");
                return new Pair<>(function1.invoke(outert), pVar);
            }
        }, uVar, oVar);
        j.g(cVar, "type");
        j.g(function1, "map");
        j.g(oVar, "doShowRendering");
    }
}
