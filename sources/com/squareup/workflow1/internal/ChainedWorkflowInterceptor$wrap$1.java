package com.squareup.workflow1.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.workflow1.k;
import com.squareup.workflow1.l;
import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.TlsProceed;
import pk.o;

@Metadata(bv = {}, d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001JH\u0010\u0007\u001a\u00020\u00052\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00022$\u0010\u0006\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016JÇ\u0001\u0010\u0012\u001a\u00028\u0005\"\u0004\b\u0003\u0010\b\"\u0004\b\u0004\u0010\t\"\u0004\b\u0005\u0010\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000b2\u0006\u0010\r\u001a\u00028\u00032\u0006\u0010\u000f\u001a\u00020\u000e2$\u0010\u0010\u001a \u0012\u0004\u0012\u00028\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00020\u00042T\u0010\u0006\u001aP\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000b\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\u000e\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00020\u0004\u0012\u0004\u0012\u00028\u00050\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013Jh\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u0016\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00042.\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0004\u0012\u0004\u0012\u00020\u00050\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R/\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00018\u0006¢\u0006\u0012\n\u0004\b\u0012\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"com/squareup/workflow1/internal/ChainedWorkflowInterceptor$wrap$1", "Lcom/squareup/workflow1/m$b;", "Lcom/squareup/workflow1/l;", "action", "Lkotlin/Function1;", "", "proceed", "c", "CP", "CO", "CR", "Lcom/squareup/workflow1/k;", "child", "childProps", "", "key", "handler", "Lkotlin/Function4;", "a", "(Lcom/squareup/workflow1/k;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lpk/o;)Ljava/lang/Object;", "Lkotlin/coroutines/c;", "", "sideEffect", "Lkotlin/Function2;", "b", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Lcom/squareup/workflow1/m$b;", "getOuter", "()Lcom/squareup/workflow1/m$b;", "getOuter$annotations", "()V", "outer", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class ChainedWorkflowInterceptor$wrap$1 implements m.b<P, S, O> {

    /* renamed from: a  reason: collision with root package name */
    private final m.b<P, S, O> f23092a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m.b<P, S, O> f23093b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m.b<P, S, O> f23094c;

    ChainedWorkflowInterceptor$wrap$1(m.b<P, S, O> bVar, m.b<P, S, O> bVar2) {
        this.f23093b = bVar;
        this.f23094c = bVar2;
        j.d(bVar);
        this.f23092a = bVar;
    }

    public <CP, CO, CR> CR a(k<? super CP, ? extends CO, ? extends CR> kVar, CP cp, String str, Function1<? super CO, ? extends l<? super P, S, ? extends O>> function1, o<? super k<? super CP, ? extends CO, ? extends CR>, ? super CP, ? super String, ? super Function1<? super CO, ? extends l<? super P, S, ? extends O>>, ? extends CR> oVar) {
        j.g(kVar, "child");
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(function1, "handler");
        j.g(oVar, TlsProceed.ELEMENT);
        return this.f23092a.a(kVar, cp, str, function1, new ChainedWorkflowInterceptor$wrap$1$onRenderChild$1(this.f23094c, oVar));
    }

    public void b(String str, Function1<? super c<? super Unit>, ? extends Object> function1, Function2<? super String, ? super Function1<? super c<? super Unit>, ? extends Object>, Unit> function2) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(function1, "sideEffect");
        j.g(function2, TlsProceed.ELEMENT);
        this.f23092a.b(str, function1, new ChainedWorkflowInterceptor$wrap$1$onRunningSideEffect$1(this.f23094c, function2));
    }

    public void c(l<? super P, S, ? extends O> lVar, Function1<? super l<? super P, S, ? extends O>, Unit> function1) {
        j.g(lVar, "action");
        j.g(function1, TlsProceed.ELEMENT);
        this.f23092a.c(lVar, new ChainedWorkflowInterceptor$wrap$1$onActionSent$1(this.f23094c, function1));
    }
}
