package com.squareup.workflow1.ui.modal;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.mparticle.kits.ReportingMessage;
import com.squareup.workflow1.ui.modal.ModalContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0000\u0007\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"com/squareup/workflow1/ui/modal/ModalContainer$update$2$1$2", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "com/squareup/workflow1/ui/modal/ModalContainer$update$2$1$2$dismissOnDestroy$1", "a", "Lcom/squareup/workflow1/ui/modal/ModalContainer$update$2$1$2$dismissOnDestroy$1;", "()Lcom/squareup/workflow1/ui/modal/ModalContainer$update$2$1$2$dismissOnDestroy$1;", "dismissOnDestroy", "Landroidx/lifecycle/Lifecycle;", "b", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "setLifecycle", "(Landroidx/lifecycle/Lifecycle;)V", "lifecycle", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
public final class ModalContainer$update$2$1$2 implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ModalContainer$update$2$1$2$dismissOnDestroy$1 f23274a;

    /* renamed from: b  reason: collision with root package name */
    private Lifecycle f23275b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ModalContainer.a<ModalRenderingT> f23276c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ ModalContainer<ModalRenderingT> f23277d;

    ModalContainer$update$2$1$2(ModalContainer.a<ModalRenderingT> aVar, ModalContainer<ModalRenderingT> modalContainer) {
        this.f23276c = aVar;
        this.f23277d = modalContainer;
        this.f23274a = new ModalContainer$update$2$1$2$dismissOnDestroy$1(aVar);
    }

    public final ModalContainer$update$2$1$2$dismissOnDestroy$1 a() {
        return this.f23274a;
    }

    public void onViewAttachedToWindow(View view) {
        j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
        Lifecycle lifecycle = this.f23277d.getParentLifecycleOwner().getLifecycle();
        lifecycle.a(a());
        this.f23275b = lifecycle;
    }

    public void onViewDetachedFromWindow(View view) {
        j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
        Lifecycle lifecycle = this.f23275b;
        if (lifecycle != null) {
            lifecycle.d(this.f23274a);
        }
        this.f23275b = null;
    }
}
