package com.squareup.workflow1.ui.androidx;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.l;
import androidx.savedstate.a;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import r1.d;

@Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/squareup/workflow1/ui/androidx/WorkflowSavedStateRegistryAggregator$lifecycleObserver$1", "Landroidx/lifecycle/i;", "Landroidx/lifecycle/l;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "e", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class WorkflowSavedStateRegistryAggregator$lifecycleObserver$1 implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WorkflowSavedStateRegistryAggregator f23214a;

    WorkflowSavedStateRegistryAggregator$lifecycleObserver$1(WorkflowSavedStateRegistryAggregator workflowSavedStateRegistryAggregator) {
        this.f23214a = workflowSavedStateRegistryAggregator;
    }

    public void e(l lVar, Lifecycle.Event event) {
        boolean z10;
        j.g(lVar, "source");
        j.g(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalStateException(j.p("Expected to receive ON_CREATE event before anything else, but got ", event).toString());
        } else if (!this.f23214a.i()) {
            lVar.getLifecycle().d(this);
            WorkflowSavedStateRegistryAggregator workflowSavedStateRegistryAggregator = this.f23214a;
            d c10 = workflowSavedStateRegistryAggregator.f23210b;
            j.d(c10);
            a savedStateRegistry = c10.getSavedStateRegistry();
            String b10 = this.f23214a.f23211c;
            j.d(b10);
            workflowSavedStateRegistryAggregator.k(savedStateRegistry.b(b10));
        } else {
            throw new IllegalStateException("Expected not to be observing lifecycle after restoration.".toString());
        }
    }
}
