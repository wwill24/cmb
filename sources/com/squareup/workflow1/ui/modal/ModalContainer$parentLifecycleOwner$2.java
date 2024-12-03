package com.squareup.workflow1.ui.modal;

import com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "ModalRenderingT", "Lcom/squareup/workflow1/ui/androidx/WorkflowLifecycleOwner;", "a", "()Lcom/squareup/workflow1/ui/androidx/WorkflowLifecycleOwner;"}, k = 3, mv = {1, 6, 0})
final class ModalContainer$parentLifecycleOwner$2 extends Lambda implements Function0<WorkflowLifecycleOwner> {
    final /* synthetic */ ModalContainer<ModalRenderingT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalContainer$parentLifecycleOwner$2(ModalContainer<ModalRenderingT> modalContainer) {
        super(0);
        this.this$0 = modalContainer;
    }

    /* renamed from: a */
    public final WorkflowLifecycleOwner invoke() {
        WorkflowLifecycleOwner c10 = WorkflowLifecycleOwner.f23206o.c(this.this$0);
        if (c10 != null) {
            return c10;
        }
        throw new IllegalStateException(j.p("Expected to find either a ViewTreeLifecycleOwner in the view tree, or for the context to be a LifecycleOwner, in ", this.this$0).toString());
    }
}
