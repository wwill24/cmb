package com.squareup.workflow1;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u0005B;\u0012\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001f¢\u0006\u0004\b%\u0010&J\"\u0010\t\u001a\u00020\b2\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006H\u0016Jq\u0010\u0014\u001a\u00028\u0005\"\u0004\b\u0003\u0010\n\"\u0004\b\u0004\u0010\u000b\"\u0004\b\u0005\u0010\f2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r2\u0006\u0010\u000f\u001a\u00028\u00032\u0006\u0010\u0011\u001a\u00020\u00102$\u0010\u0013\u001a \u0012\u0004\u0012\u00028\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J>\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\"\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR&\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001dR&\u0010!\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010 R,\u0010$\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/squareup/workflow1/InterceptedRenderContext;", "P", "S", "O", "Lcom/squareup/workflow1/a;", "Lcom/squareup/workflow1/f;", "Lcom/squareup/workflow1/l;", "value", "", "f", "ChildPropsT", "ChildOutputT", "ChildRenderingT", "Lcom/squareup/workflow1/k;", "child", "props", "", "key", "Lkotlin/Function1;", "handler", "b", "(Lcom/squareup/workflow1/k;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/c;", "", "sideEffect", "a", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Lcom/squareup/workflow1/a;", "baseRenderContext", "Lcom/squareup/workflow1/m$b;", "Lcom/squareup/workflow1/m$b;", "interceptor", "c", "()Lcom/squareup/workflow1/f;", "actionSink", "<init>", "(Lcom/squareup/workflow1/a;Lcom/squareup/workflow1/m$b;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
final class InterceptedRenderContext<P, S, O> implements a<P, S, O>, f<l<? super P, S, ? extends O>> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a<P, S, O> f23052a;

    /* renamed from: b  reason: collision with root package name */
    private final m.b<P, S, O> f23053b;

    public InterceptedRenderContext(a<? extends P, S, ? super O> aVar, m.b<P, S, O> bVar) {
        j.g(aVar, "baseRenderContext");
        j.g(bVar, "interceptor");
        this.f23052a = aVar;
        this.f23053b = bVar;
    }

    public void a(String str, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(function2, "sideEffect");
        this.f23053b.b(str, new InterceptedRenderContext$runningSideEffect$withScopeReceiver$1(function2, this, (c<? super InterceptedRenderContext$runningSideEffect$withScopeReceiver$1>) null), new InterceptedRenderContext$runningSideEffect$1(this));
    }

    public <ChildPropsT, ChildOutputT, ChildRenderingT> ChildRenderingT b(k<? super ChildPropsT, ? extends ChildOutputT, ? extends ChildRenderingT> kVar, ChildPropsT childpropst, String str, Function1<? super ChildOutputT, ? extends l<? super P, S, ? extends O>> function1) {
        j.g(kVar, "child");
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(function1, "handler");
        return this.f23053b.a(kVar, childpropst, str, function1, new InterceptedRenderContext$renderChild$1(this));
    }

    public f<l<? super P, S, ? extends O>> c() {
        return this;
    }

    /* renamed from: f */
    public void d(l<? super P, S, ? extends O> lVar) {
        j.g(lVar, "value");
        this.f23053b.c(lVar, new InterceptedRenderContext$send$1(this));
    }
}
