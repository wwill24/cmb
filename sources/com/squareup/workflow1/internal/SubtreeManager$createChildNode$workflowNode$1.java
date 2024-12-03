package com.squareup.workflow1.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class SubtreeManager$createChildNode$workflowNode$1 extends FunctionReferenceImpl implements Function1<ChildOutputT, Object> {
    final /* synthetic */ Ref$ObjectRef<g<ChildPropsT, ChildOutputT, PropsT, StateT, OutputT>> $node;
    final /* synthetic */ SubtreeManager<PropsT, StateT, OutputT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubtreeManager$createChildNode$workflowNode$1(Ref$ObjectRef<g<ChildPropsT, ChildOutputT, PropsT, StateT, OutputT>> ref$ObjectRef, SubtreeManager<PropsT, StateT, OutputT> subtreeManager) {
        super(1, j.a.class, "acceptChildOutput", "createChildNode$acceptChildOutput(Lkotlin/jvm/internal/Ref$ObjectRef;Lcom/squareup/workflow1/internal/SubtreeManager;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        this.$node = ref$ObjectRef;
        this.this$0 = subtreeManager;
    }

    public final Object invoke(ChildOutputT childoutputt) {
        return SubtreeManager.e(this.$node, this.this$0, childoutputt);
    }
}
