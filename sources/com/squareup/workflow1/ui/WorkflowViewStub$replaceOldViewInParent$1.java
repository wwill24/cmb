package com.squareup.workflow1.ui;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "newView", "", "a", "(Landroid/view/ViewGroup;Landroid/view/View;)V"}, k = 3, mv = {1, 6, 0})
final class WorkflowViewStub$replaceOldViewInParent$1 extends Lambda implements Function2<ViewGroup, View, Unit> {
    final /* synthetic */ WorkflowViewStub this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkflowViewStub$replaceOldViewInParent$1(WorkflowViewStub workflowViewStub) {
        super(2);
        this.this$0 = workflowViewStub;
    }

    public final void a(ViewGroup viewGroup, View view) {
        Unit unit;
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        j.g(view, "newView");
        int indexOfChild = viewGroup.indexOfChild(this.this$0.getActual());
        viewGroup.removeView(this.this$0.getActual());
        ViewGroup.LayoutParams layoutParams = this.this$0.getActual().getLayoutParams();
        if (layoutParams == null) {
            unit = null;
        } else {
            viewGroup.addView(view, indexOfChild, layoutParams);
            unit = Unit.f32013a;
        }
        if (unit == null) {
            viewGroup.addView(view, indexOfChild);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((ViewGroup) obj, (View) obj2);
        return Unit.f32013a;
    }
}
