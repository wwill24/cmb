package com.squareup.workflow1.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.workflow1.f;
import com.squareup.workflow1.k;
import com.squareup.workflow1.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u0005:\u0002\u001c\u0015BI\u0012\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001f\u0012\u0006\u0010$\u001a\u00020\"\u0012\u001e\u0010(\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060%¢\u0006\u0004\b/\u00100J\b\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\n\u001a\u00020\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006H\u0016Jq\u0010\u0015\u001a\u00028\u0005\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\f\"\u0004\b\u0005\u0010\r2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000e2\u0006\u0010\u0010\u001a\u00028\u00032\u0006\u0010\u0012\u001a\u00020\u00112$\u0010\u0014\u001a \u0012\u0004\u0012\u00028\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J>\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\"\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0007R&\u0010!\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001f8\bX\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010#R,\u0010(\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R,\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010-\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/squareup/workflow1/internal/e;", "PropsT", "StateT", "OutputT", "Lcom/squareup/workflow1/a;", "Lcom/squareup/workflow1/f;", "Lcom/squareup/workflow1/l;", "", "e", "value", "g", "ChildPropsT", "ChildOutputT", "ChildRenderingT", "Lcom/squareup/workflow1/k;", "child", "props", "", "key", "Lkotlin/Function1;", "handler", "b", "(Lcom/squareup/workflow1/k;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/c;", "", "sideEffect", "a", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "f", "Lcom/squareup/workflow1/internal/e$a;", "Lcom/squareup/workflow1/internal/e$a;", "renderer", "Lcom/squareup/workflow1/internal/e$b;", "Lcom/squareup/workflow1/internal/e$b;", "sideEffectRunner", "Lkotlinx/coroutines/channels/u;", "c", "Lkotlinx/coroutines/channels/u;", "eventActionsChannel", "", "d", "Z", "frozen", "()Lcom/squareup/workflow1/f;", "actionSink", "<init>", "(Lcom/squareup/workflow1/internal/e$a;Lcom/squareup/workflow1/internal/e$b;Lkotlinx/coroutines/channels/u;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class e<PropsT, StateT, OutputT> implements com.squareup.workflow1.a<PropsT, StateT, OutputT>, f<l<? super PropsT, StateT, ? extends OutputT>> {

    /* renamed from: a  reason: collision with root package name */
    private final a<PropsT, StateT, OutputT> f23124a;

    /* renamed from: b  reason: collision with root package name */
    private final b f23125b;

    /* renamed from: c  reason: collision with root package name */
    private final u<l<? super PropsT, StateT, ? extends OutputT>> f23126c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23127d;

    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0004\b\u0005\u0010\u00032\u00020\u0004Jq\u0010\u0010\u001a\u00028\b\"\u0004\b\u0006\u0010\u0005\"\u0004\b\u0007\u0010\u0006\"\u0004\b\b\u0010\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\b2\u0006\u0010\n\u001a\u00028\u00062\u0006\u0010\f\u001a\u00020\u000b2$\u0010\u000f\u001a \u0012\u0004\u0012\u00028\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000e0\rH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/squareup/workflow1/internal/e$a;", "PropsT", "StateT", "OutputT", "", "ChildPropsT", "ChildOutputT", "ChildRenderingT", "Lcom/squareup/workflow1/k;", "child", "props", "", "key", "Lkotlin/Function1;", "Lcom/squareup/workflow1/l;", "handler", "a", "(Lcom/squareup/workflow1/k;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
    public interface a<PropsT, StateT, OutputT> {
        <ChildPropsT, ChildOutputT, ChildRenderingT> ChildRenderingT a(k<? super ChildPropsT, ? extends ChildOutputT, ? extends ChildRenderingT> kVar, ChildPropsT childpropst, String str, Function1<? super ChildOutputT, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1);
    }

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J>\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/squareup/workflow1/internal/e$b;", "", "", "key", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/c;", "", "sideEffect", "a", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
    public interface b {
        void a(String str, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2);
    }

    public e(a<PropsT, StateT, OutputT> aVar, b bVar, u<? super l<? super PropsT, StateT, ? extends OutputT>> uVar) {
        j.g(aVar, "renderer");
        j.g(bVar, "sideEffectRunner");
        j.g(uVar, "eventActionsChannel");
        this.f23124a = aVar;
        this.f23125b = bVar;
        this.f23126c = uVar;
    }

    private final void e() {
        if (!(!this.f23127d)) {
            throw new IllegalStateException("RenderContext cannot be used after render method returns.".toString());
        }
    }

    public void a(String str, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(function2, "sideEffect");
        e();
        this.f23125b.a(str, function2);
    }

    public <ChildPropsT, ChildOutputT, ChildRenderingT> ChildRenderingT b(k<? super ChildPropsT, ? extends ChildOutputT, ? extends ChildRenderingT> kVar, ChildPropsT childpropst, String str, Function1<? super ChildOutputT, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1) {
        j.g(kVar, "child");
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(function1, "handler");
        e();
        return this.f23124a.a(kVar, childpropst, str, function1);
    }

    public f<l<? super PropsT, StateT, ? extends OutputT>> c() {
        return this;
    }

    public final void f() {
        e();
        this.f23127d = true;
    }

    /* renamed from: g */
    public void d(l<? super PropsT, StateT, ? extends OutputT> lVar) {
        j.g(lVar, "value");
        if (this.f23127d) {
            this.f23126c.offer(lVar);
            return;
        }
        throw new UnsupportedOperationException(j.p("Expected sink to not be sent to until after the render pass. Received action: ", lVar));
    }
}
