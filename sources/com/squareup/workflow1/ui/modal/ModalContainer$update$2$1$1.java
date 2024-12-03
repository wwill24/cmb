package com.squareup.workflow1.ui.modal;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "ModalRenderingT", "Landroid/view/View;", "it", "Landroidx/lifecycle/Lifecycle;", "a", "(Landroid/view/View;)Landroidx/lifecycle/Lifecycle;"}, k = 3, mv = {1, 6, 0})
final class ModalContainer$update$2$1$1 extends Lambda implements Function1<View, Lifecycle> {
    final /* synthetic */ ModalContainer<ModalRenderingT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalContainer$update$2$1$1(ModalContainer<ModalRenderingT> modalContainer) {
        super(1);
        this.this$0 = modalContainer;
    }

    /* renamed from: a */
    public final Lifecycle invoke(View view) {
        j.g(view, "it");
        Lifecycle lifecycle = this.this$0.getParentLifecycleOwner().getLifecycle();
        j.f(lifecycle, "parentLifecycleOwner.lifecycle");
        return lifecycle;
    }
}
