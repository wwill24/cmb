package com.squareup.workflow1;

import com.squareup.workflow1.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001at\u0010\t\u001a\u001e0\bR\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\u001a\u0001\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003*\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2(\u0010\u0010\u001a$\u0012\u001a\u0012\u00180\rR\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f\u001a\u0001\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003*\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00122(\u0010\u0010\u001a$\u0012\u001a\u0012\u00180\rR\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¨\u0006\u0014"}, d2 = {"PropsT", "StateT", "OutputT", "RenderingT", "Lcom/squareup/workflow1/a;", "baseContext", "Lcom/squareup/workflow1/h;", "workflow", "Lcom/squareup/workflow1/h$a;", "a", "", "name", "Lkotlin/Function1;", "Lcom/squareup/workflow1/l$c;", "Lcom/squareup/workflow1/l;", "", "update", "b", "Lkotlin/Function0;", "c", "wf1-workflow-core"}, k = 5, mv = {1, 6, 0}, xs = "com/squareup/workflow1/Workflows")
final /* synthetic */ class Workflows__StatefulWorkflowKt {

    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001J\"\u0010\u0004\u001a\u00020\u0003*\u00180\u0002R\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/squareup/workflow1/Workflows__StatefulWorkflowKt$a", "Lcom/squareup/workflow1/l;", "Lcom/squareup/workflow1/l$c;", "", "a", "", "toString", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
    public static final class a extends l<PropsT, StateT, OutputT> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Function1<l<? super PropsT, StateT, ? extends OutputT>.c, Unit> f23076c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Function0<String> f23077d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ h<PropsT, StateT, OutputT, RenderingT> f23078e;

        a(Function1<? super l<? super PropsT, StateT, ? extends OutputT>.c, Unit> function1, Function0<String> function0, h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT> hVar) {
            this.f23076c = function1;
            this.f23077d = function0;
            this.f23078e = hVar;
        }

        public void a(l<? super PropsT, StateT, ? extends OutputT>.c cVar) {
            j.g(cVar, "<this>");
            this.f23076c.invoke(cVar);
        }

        public String toString() {
            return "action(" + this.f23077d.invoke() + ")-" + this.f23078e;
        }
    }

    public static final <PropsT, StateT, OutputT, RenderingT> h<PropsT, StateT, OutputT, RenderingT>.defpackage.a a(a<? extends PropsT, StateT, ? super OutputT> aVar, h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT> hVar) {
        h<PropsT, StateT, OutputT, RenderingT>.defpackage.a aVar2;
        j.g(aVar, "baseContext");
        j.g(hVar, "workflow");
        if (aVar instanceof h.a) {
            aVar2 = (h.a) aVar;
        } else {
            aVar2 = null;
        }
        if (aVar2 == null) {
            return new h.a(hVar, aVar);
        }
        return aVar2;
    }

    public static final <PropsT, StateT, OutputT, RenderingT> l<PropsT, StateT, OutputT> b(h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT> hVar, String str, Function1<? super l<? super PropsT, StateT, ? extends OutputT>.c, Unit> function1) {
        j.g(hVar, "<this>");
        j.g(str, "name");
        j.g(function1, DiscoverItems.Item.UPDATE_ACTION);
        return o.c(hVar, new Workflows__StatefulWorkflowKt$action$1(str), function1);
    }

    public static final <PropsT, StateT, OutputT, RenderingT> l<PropsT, StateT, OutputT> c(h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT> hVar, Function0<String> function0, Function1<? super l<? super PropsT, StateT, ? extends OutputT>.c, Unit> function1) {
        j.g(hVar, "<this>");
        j.g(function0, "name");
        j.g(function1, DiscoverItems.Item.UPDATE_ACTION);
        return new a(function1, function0, hVar);
    }

    public static /* synthetic */ l d(h hVar, String str, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return o.b(hVar, str, function1);
    }
}
