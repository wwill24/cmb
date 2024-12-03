package com.squareup.workflow1;

import com.squareup.workflow1.l;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a^\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032(\u0010\t\u001a$\u0012\u001a\u0012\u00180\u0006R\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u001ab\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2(\u0010\t\u001a$\u0012\u001a\u0012\u00180\u0006R\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u001aY\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00100\u000f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"PropsT", "StateT", "OutputT", "", "name", "Lkotlin/Function1;", "Lcom/squareup/workflow1/l$c;", "Lcom/squareup/workflow1/l;", "", "apply", "a", "Lkotlin/Function0;", "b", "props", "state", "Lkotlin/Pair;", "Lcom/squareup/workflow1/n;", "d", "(Lcom/squareup/workflow1/l;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "wf1-workflow-core"}, k = 5, mv = {1, 6, 0}, xs = "com/squareup/workflow1/Workflows")
final /* synthetic */ class Workflows__WorkflowActionKt {

    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001J\"\u0010\u0004\u001a\u00020\u0003*\u00180\u0002R\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/squareup/workflow1/Workflows__WorkflowActionKt$a", "Lcom/squareup/workflow1/l;", "Lcom/squareup/workflow1/l$c;", "", "a", "", "toString", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
    public static final class a extends l<PropsT, StateT, OutputT> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Function1<l<? super PropsT, StateT, ? extends OutputT>.c, Unit> f23079c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Function0<String> f23080d;

        a(Function1<? super l<? super PropsT, StateT, ? extends OutputT>.c, Unit> function1, Function0<String> function0) {
            this.f23079c = function1;
            this.f23080d = function0;
        }

        public void a(l<? super PropsT, StateT, ? extends OutputT>.c cVar) {
            j.g(cVar, "<this>");
            this.f23079c.invoke(cVar);
        }

        public String toString() {
            return "WorkflowAction(" + this.f23080d.invoke() + ")@" + hashCode();
        }
    }

    public static final <PropsT, StateT, OutputT> l<PropsT, StateT, OutputT> a(String str, Function1<? super l<? super PropsT, StateT, ? extends OutputT>.c, Unit> function1) {
        j.g(str, "name");
        j.g(function1, "apply");
        return o.e(new Workflows__WorkflowActionKt$action$1(str), function1);
    }

    public static final <PropsT, StateT, OutputT> l<PropsT, StateT, OutputT> b(Function0<String> function0, Function1<? super l<? super PropsT, StateT, ? extends OutputT>.c, Unit> function1) {
        j.g(function0, "name");
        j.g(function1, "apply");
        return new a(function1, function0);
    }

    public static /* synthetic */ l c(String str, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return o.d(str, function1);
    }

    public static final <PropsT, StateT, OutputT> Pair<StateT, n<OutputT>> d(l<? super PropsT, StateT, ? extends OutputT> lVar, PropsT propst, StateT statet) {
        j.g(lVar, "<this>");
        l.c cVar = new l.c(lVar, propst, statet);
        lVar.a(cVar);
        return new Pair<>(cVar.c(), cVar.a());
    }
}
