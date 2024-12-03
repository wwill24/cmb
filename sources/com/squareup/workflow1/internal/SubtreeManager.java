package com.squareup.workflow1.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.workflow1.TreeSnapshot;
import com.squareup.workflow1.internal.d;
import com.squareup.workflow1.internal.e;
import com.squareup.workflow1.k;
import com.squareup.workflow1.l;
import com.squareup.workflow1.m;
import com.squareup.workflow1.n;
import com.squareup.workflow1.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.selects.a;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004Bo\u0012\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d\u0012\u0006\u0010&\u001a\u00020#\u0012&\u0010)\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010'0\r\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u00100\u001a\u00020-\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000101¢\u0006\u0004\b7\u00108J\u0001\u0010\u0011\u001a \u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\b2\u0006\u0010\n\u001a\u00028\u00032\u0006\u0010\f\u001a\u00020\u000b2$\u0010\u000f\u001a \u0012\u0004\u0012\u00028\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0014\u001a\u00020\u0013Jq\u0010\u0016\u001a\u00028\u0005\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\b2\u0006\u0010\u0015\u001a\u00028\u00032\u0006\u0010\f\u001a\u00020\u000b2$\u0010\u000f\u001a \u0012\u0004\u0012\u00028\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u001c\u001a\u00020\u0013\"\u0004\b\u0003\u0010\u00182\u0014\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u001a0\u0019J\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dR$\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R4\u0010)\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010'0\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010(R\u0016\u0010,\u001a\u0004\u0018\u00010*8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0004\u0018\u0001018\u0002X\u0004¢\u0006\u0006\n\u0004\b \u00102R0\u00106\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u00105¨\u00069"}, d2 = {"Lcom/squareup/workflow1/internal/SubtreeManager;", "PropsT", "StateT", "OutputT", "Lcom/squareup/workflow1/internal/e$a;", "ChildPropsT", "ChildOutputT", "ChildRenderingT", "Lcom/squareup/workflow1/k;", "child", "initialProps", "", "key", "Lkotlin/Function1;", "Lcom/squareup/workflow1/l;", "handler", "Lcom/squareup/workflow1/internal/g;", "d", "(Lcom/squareup/workflow1/k;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/squareup/workflow1/internal/g;", "", "c", "props", "a", "(Lcom/squareup/workflow1/k;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/selects/a;", "Lcom/squareup/workflow1/n;", "selector", "g", "", "Lcom/squareup/workflow1/internal/h;", "Lcom/squareup/workflow1/TreeSnapshot;", "f", "Ljava/util/Map;", "snapshotCache", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "contextForChildren", "", "Lkotlin/jvm/functions/Function1;", "emitActionToParent", "Lcom/squareup/workflow1/m$c;", "Lcom/squareup/workflow1/m$c;", "workflowSession", "Lcom/squareup/workflow1/m;", "e", "Lcom/squareup/workflow1/m;", "interceptor", "Lcom/squareup/workflow1/internal/c;", "Lcom/squareup/workflow1/internal/c;", "idCounter", "Lcom/squareup/workflow1/internal/a;", "Lcom/squareup/workflow1/internal/a;", "children", "<init>", "(Ljava/util/Map;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;Lcom/squareup/workflow1/m$c;Lcom/squareup/workflow1/m;Lcom/squareup/workflow1/internal/c;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class SubtreeManager<PropsT, StateT, OutputT> implements e.a<PropsT, StateT, OutputT> {

    /* renamed from: a  reason: collision with root package name */
    private Map<h, TreeSnapshot> f23095a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext f23096b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<l<? super PropsT, StateT, ? extends OutputT>, Object> f23097c;

    /* renamed from: d  reason: collision with root package name */
    private final m.c f23098d;

    /* renamed from: e  reason: collision with root package name */
    private final m f23099e;

    /* renamed from: f  reason: collision with root package name */
    private final c f23100f;

    /* renamed from: g  reason: collision with root package name */
    private a<g<?, ?, ?, ?, ?>> f23101g = new a<>();

    public SubtreeManager(Map<h, TreeSnapshot> map, CoroutineContext coroutineContext, Function1<? super l<? super PropsT, StateT, ? extends OutputT>, ? extends Object> function1, m.c cVar, m mVar, c cVar2) {
        j.g(coroutineContext, "contextForChildren");
        j.g(function1, "emitActionToParent");
        j.g(mVar, "interceptor");
        this.f23095a = map;
        this.f23096b = coroutineContext;
        this.f23097c = function1;
        this.f23098d = cVar;
        this.f23099e = mVar;
        this.f23100f = cVar2;
    }

    private final <ChildPropsT, ChildOutputT, ChildRenderingT> g<ChildPropsT, ChildOutputT, PropsT, StateT, OutputT> d(k<? super ChildPropsT, ? extends ChildOutputT, ? extends ChildRenderingT> kVar, ChildPropsT childpropst, String str, Function1<? super ChildOutputT, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1) {
        TreeSnapshot treeSnapshot;
        h a10 = i.a(kVar, str);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Map<h, TreeSnapshot> map = this.f23095a;
        if (map == null) {
            treeSnapshot = null;
        } else {
            treeSnapshot = map.get(a10);
        }
        T gVar = new g(kVar, function1, new WorkflowNode(a10, kVar.b(), childpropst, treeSnapshot, this.f23096b, new SubtreeManager$createChildNode$workflowNode$1(ref$ObjectRef, this), this.f23098d, this.f23099e, this.f23100f));
        ref$ObjectRef.element = gVar;
        return gVar;
    }

    /* access modifiers changed from: private */
    public static final <ChildOutputT, PropsT, StateT, OutputT, ChildPropsT> Object e(Ref$ObjectRef<g<ChildPropsT, ChildOutputT, PropsT, StateT, OutputT>> ref$ObjectRef, SubtreeManager<PropsT, StateT, OutputT> subtreeManager, ChildOutputT childoutputt) {
        g gVar;
        T t10 = ref$ObjectRef.element;
        if (t10 == null) {
            j.y(NodeElement.ELEMENT);
            gVar = null;
        } else {
            gVar = (g) t10;
        }
        return subtreeManager.f23097c.invoke(gVar.c(childoutputt));
    }

    public <ChildPropsT, ChildOutputT, ChildRenderingT> ChildRenderingT a(k<? super ChildPropsT, ? extends ChildOutputT, ? extends ChildRenderingT> kVar, ChildPropsT childpropst, String str, Function1<? super ChildOutputT, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1) {
        j.g(kVar, "child");
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(function1, "handler");
        d.a b10 = this.f23101g.f23120b.b();
        while (b10 != null) {
            if (!((g) b10).h(kVar, str)) {
                b10 = b10.a();
            } else {
                throw new IllegalArgumentException(("Expected keys to be unique for " + o.j(kVar) + ": key=\"" + str + '\"').toString());
            }
        }
        a<g<?, ?, ?, ?, ?>> aVar = this.f23101g;
        d a10 = aVar.f23119a;
        d.a b11 = a10.b();
        g<ChildPropsT, ChildOutputT, PropsT, StateT, OutputT> gVar = null;
        d.a aVar2 = null;
        while (true) {
            if (b11 == null) {
                break;
            } else if (((g) b11).h(kVar, str)) {
                if (aVar2 == null) {
                    a10.e(b11.a());
                } else {
                    aVar2.b(b11.a());
                }
                if (j.b(a10.c(), b11)) {
                    a10.f(aVar2);
                }
                b11.b(null);
                gVar = b11;
            } else {
                aVar2 = b11;
                b11 = b11.a();
            }
        }
        if (gVar == null) {
            gVar = d(kVar, childpropst, str, function1);
        }
        aVar.f23120b.d(gVar);
        g gVar2 = gVar;
        gVar2.j(function1);
        return gVar2.i(kVar.b(), childpropst);
    }

    public final void c() {
        a<g<?, ?, ?, ?, ?>> aVar = this.f23101g;
        for (d.a b10 = aVar.f23119a.b(); b10 != null; b10 = b10.a()) {
            WorkflowNode.e(((g) b10).g(), (CancellationException) null, 1, (Object) null);
        }
        d a10 = aVar.f23119a;
        aVar.f23119a = aVar.f23120b;
        aVar.f23120b = a10;
        aVar.f23120b.a();
        this.f23095a = null;
    }

    public final Map<h, TreeSnapshot> f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (d.a b10 = this.f23101g.f23119a.b(); b10 != null; b10 = b10.a()) {
            g gVar = (g) b10;
            linkedHashMap.put(gVar.d(), gVar.g().o(gVar.f().b()));
        }
        return linkedHashMap;
    }

    public final <T> void g(a<? super n<? extends T>> aVar) {
        j.g(aVar, "selector");
        for (d.a b10 = this.f23101g.f23119a.b(); b10 != null; b10 = b10.a()) {
            ((g) b10).g().p(aVar);
        }
    }
}
