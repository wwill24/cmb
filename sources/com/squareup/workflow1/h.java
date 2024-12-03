package com.squareup.workflow1;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\t\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJC\u0010\u0014\u001a\u00028\u00032\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\"\u0010\u0013\u001a\u001e0\u0012R\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00028\u0001H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000¨\u0006\u001c"}, d2 = {"Lcom/squareup/workflow1/h;", "PropsT", "StateT", "OutputT", "RenderingT", "Lcom/squareup/workflow1/k;", "props", "Lcom/squareup/workflow1/Snapshot;", "snapshot", "d", "(Ljava/lang/Object;Lcom/squareup/workflow1/Snapshot;)Ljava/lang/Object;", "old", "new", "state", "e", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "renderProps", "renderState", "Lcom/squareup/workflow1/h$a;", "context", "f", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/squareup/workflow1/h$a;)Ljava/lang/Object;", "g", "(Ljava/lang/Object;)Lcom/squareup/workflow1/Snapshot;", "b", "<init>", "()V", "a", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
public abstract class h<PropsT, StateT, OutputT, RenderingT> implements k<PropsT, OutputT, RenderingT> {

    @Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001B#\b\u0000\u0012\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001¢\u0006\u0004\b\u001c\u0010\u001dJt\u0010\r\u001a\u00028\u0006\"\u0004\b\u0004\u0010\u0002\"\u0004\b\u0005\u0010\u0003\"\u0004\b\u0006\u0010\u00042\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u00052\u0006\u0010\u0007\u001a\u00028\u00042\b\b\u0002\u0010\t\u001a\u00020\b2$\u0010\f\u001a \u0012\u0004\u0012\u00028\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b0\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u0015\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R,\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b0\u00178\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/squareup/workflow1/h$a;", "Lcom/squareup/workflow1/a;", "ChildPropsT", "ChildOutputT", "ChildRenderingT", "Lcom/squareup/workflow1/k;", "child", "props", "", "key", "Lkotlin/Function1;", "Lcom/squareup/workflow1/l;", "handler", "b", "(Lcom/squareup/workflow1/k;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/c;", "", "", "sideEffect", "a", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Lcom/squareup/workflow1/f;", "c", "()Lcom/squareup/workflow1/f;", "actionSink", "baseContext", "<init>", "(Lcom/squareup/workflow1/h;Lcom/squareup/workflow1/a;)V", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
    public final class a implements a<PropsT, StateT, OutputT> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ a<PropsT, StateT, OutputT> f23087a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h<PropsT, StateT, OutputT, RenderingT> f23088b;

        public a(h hVar, a<? extends PropsT, StateT, ? super OutputT> aVar) {
            j.g(hVar, "this$0");
            j.g(aVar, "baseContext");
            this.f23088b = hVar;
            this.f23087a = aVar;
        }

        public void a(String str, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2) {
            j.g(str, SDKConstants.PARAM_KEY);
            j.g(function2, "sideEffect");
            this.f23087a.a(str, function2);
        }

        public <ChildPropsT, ChildOutputT, ChildRenderingT> ChildRenderingT b(k<? super ChildPropsT, ? extends ChildOutputT, ? extends ChildRenderingT> kVar, ChildPropsT childpropst, String str, Function1<? super ChildOutputT, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1) {
            j.g(kVar, "child");
            j.g(str, SDKConstants.PARAM_KEY);
            j.g(function1, "handler");
            return this.f23087a.b(kVar, childpropst, str, function1);
        }

        public f<l<? super PropsT, StateT, ? extends OutputT>> c() {
            return this.f23087a.c();
        }
    }

    public final h<PropsT, StateT, OutputT, RenderingT> b() {
        return this;
    }

    public abstract StateT d(PropsT propst, Snapshot snapshot);

    public StateT e(PropsT propst, PropsT propst2, StateT statet) {
        return statet;
    }

    public abstract RenderingT f(PropsT propst, StateT statet, h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT>.defpackage.a aVar);

    public abstract Snapshot g(StateT statet);
}
