package com.squareup.workflow1.ui.modal;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.l;
import com.squareup.workflow1.ui.modal.ModalContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/squareup/workflow1/ui/modal/ModalContainer$update$2$1$2$dismissOnDestroy$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/l;", "owner", "", "onDestroy", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
public final class ModalContainer$update$2$1$2$dismissOnDestroy$1 implements DefaultLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ModalContainer.a<ModalRenderingT> f23278a;

    ModalContainer$update$2$1$2$dismissOnDestroy$1(ModalContainer.a<ModalRenderingT> aVar) {
        this.f23278a = aVar;
    }

    public void onDestroy(l lVar) {
        j.g(lVar, "owner");
        this.f23278a.c();
    }
}
