package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u00002\u00020\u0004Js\u0010\u0010\u001a\u00028\u0005\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\b2\u0006\u0010\n\u001a\u00028\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b2$\u0010\u000f\u001a \u0012\u0004\u0012\u00028\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e0\rH&¢\u0006\u0004\b\u0010\u0010\u0011J>\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0012H&ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R,\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e0\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/squareup/workflow1/a;", "PropsT", "StateT", "OutputT", "", "ChildPropsT", "ChildOutputT", "ChildRenderingT", "Lcom/squareup/workflow1/k;", "child", "props", "", "key", "Lkotlin/Function1;", "Lcom/squareup/workflow1/l;", "handler", "b", "(Lcom/squareup/workflow1/k;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/c;", "", "sideEffect", "a", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Lcom/squareup/workflow1/f;", "c", "()Lcom/squareup/workflow1/f;", "actionSink", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
public interface a<PropsT, StateT, OutputT> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: com.squareup.workflow1.a$a  reason: collision with other inner class name */
    public static final class C0266a {
        public static /* synthetic */ Object a(a aVar, k kVar, Object obj, String str, Function1 function1, int i10, Object obj2) {
            if (obj2 == null) {
                if ((i10 & 4) != 0) {
                    str = "";
                }
                return aVar.b(kVar, obj, str, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderChild");
        }
    }

    void a(String str, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2);

    <ChildPropsT, ChildOutputT, ChildRenderingT> ChildRenderingT b(k<? super ChildPropsT, ? extends ChildOutputT, ? extends ChildRenderingT> kVar, ChildPropsT childpropst, String str, Function1<? super ChildOutputT, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1);

    f<l<? super PropsT, StateT, ? extends OutputT>> c();
}
