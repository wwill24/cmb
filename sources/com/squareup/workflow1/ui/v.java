package com.squareup.workflow1.ui;

import android.view.View;
import com.squareup.workflow1.ui.WorkflowViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\"$\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u00008@X\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"6\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00018@@@X\u000e¢\u0006\u0012\u0012\u0004\b\u000b\u0010\u0005\u001a\u0004\b\b\u0010\u0003\"\u0004\b\t\u0010\n\"\"\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00008@X\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u000e\u0010\u000f\"\"\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0012*\u00020\u00008@X\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroid/view/View;", "Lcom/squareup/workflow1/ui/WorkflowViewState;", "d", "(Landroid/view/View;)Lcom/squareup/workflow1/ui/WorkflowViewState;", "getWorkflowViewStateOrNull$annotations", "(Landroid/view/View;)V", "workflowViewStateOrNull", "value", "a", "e", "(Landroid/view/View;Lcom/squareup/workflow1/ui/WorkflowViewState;)V", "getWorkflowViewState$annotations", "workflowViewState", "Lcom/squareup/workflow1/ui/WorkflowViewState$New;", "b", "(Landroid/view/View;)Lcom/squareup/workflow1/ui/WorkflowViewState$New;", "getWorkflowViewStateAsNew$annotations", "workflowViewStateAsNew", "Lcom/squareup/workflow1/ui/WorkflowViewState$a;", "c", "(Landroid/view/View;)Lcom/squareup/workflow1/ui/WorkflowViewState$a;", "getWorkflowViewStateAsStarted$annotations", "workflowViewStateAsStarted", "wf1-core-android"}, k = 2, mv = {1, 6, 0})
public final class v {
    public static final WorkflowViewState<?> a(View view) {
        j.g(view, "<this>");
        WorkflowViewState<?> d10 = d(view);
        if (d10 != null) {
            return d10;
        }
        throw new IllegalStateException(("Expected " + view + " to have been built by a ViewFactory. Perhaps the factory did not call View.bindShowRendering.").toString());
    }

    public static final WorkflowViewState.New<?> b(View view) {
        WorkflowViewState.New<?> newR;
        j.g(view, "<this>");
        WorkflowViewState<?> a10 = a(view);
        if (a10 instanceof WorkflowViewState.New) {
            newR = (WorkflowViewState.New) a10;
        } else {
            newR = null;
        }
        if (newR != null) {
            return newR;
        }
        throw new IllegalStateException(("Expected " + view + " to be un-started, but View.start() has been called").toString());
    }

    public static final WorkflowViewState.a<?> c(View view) {
        WorkflowViewState.a<?> aVar;
        j.g(view, "<this>");
        WorkflowViewState<?> a10 = a(view);
        if (a10 instanceof WorkflowViewState.a) {
            aVar = (WorkflowViewState.a) a10;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Expected " + view + " to have been started, but View.start() has not been called").toString());
    }

    public static final WorkflowViewState<?> d(View view) {
        j.g(view, "<this>");
        Object tag = view.getTag(i.workflow_ui_view_state);
        if (tag instanceof WorkflowViewState) {
            return (WorkflowViewState) tag;
        }
        return null;
    }

    public static final void e(View view, WorkflowViewState<?> workflowViewState) {
        j.g(view, "<this>");
        j.g(workflowViewState, "value");
        view.setTag(i.workflow_ui_view_state, workflowViewState);
    }
}
