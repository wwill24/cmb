package com.squareup.workflow1.ui.androidx;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.l;
import ci.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/squareup/workflow1/ui/androidx/WorkflowLifecycleOwner;", "Landroidx/lifecycle/l;", "", "P", "o", "Companion", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public interface WorkflowLifecycleOwner extends l {

    /* renamed from: o  reason: collision with root package name */
    public static final Companion f23206o = Companion.f23207a;

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/squareup/workflow1/ui/androidx/WorkflowLifecycleOwner$Companion;", "", "Landroid/view/View;", "view", "Landroidx/lifecycle/Lifecycle;", "b", "Lkotlin/Function1;", "findParentLifecycle", "", "d", "Lcom/squareup/workflow1/ui/androidx/WorkflowLifecycleOwner;", "c", "<init>", "()V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f23207a = new Companion();

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Lifecycle b(View view) {
            View view2;
            l a10;
            ViewParent parent = view.getParent();
            Lifecycle lifecycle = null;
            if (parent instanceof View) {
                view2 = (View) parent;
            } else {
                view2 = null;
            }
            if (!(view2 == null || (a10 = b.f19008a.a(view2)) == null)) {
                lifecycle = a10.getLifecycle();
            }
            if (lifecycle != null) {
                return lifecycle;
            }
            throw new IllegalStateException(("Expected parent or context of " + view + " to have or be a ViewTreeLifecycleOwner").toString());
        }

        public static /* synthetic */ void e(Companion companion, View view, Function1 function1, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                function1 = WorkflowLifecycleOwner$Companion$installOn$1.f23208a;
            }
            companion.d(view, function1);
        }

        public final WorkflowLifecycleOwner c(View view) {
            j.g(view, "view");
            l a10 = ViewTreeLifecycleOwner.a(view);
            if (a10 instanceof WorkflowLifecycleOwner) {
                return (WorkflowLifecycleOwner) a10;
            }
            return null;
        }

        public final void d(View view, Function1<? super View, ? extends Lifecycle> function1) {
            j.g(view, "view");
            j.g(function1, "findParentLifecycle");
            RealWorkflowLifecycleOwner realWorkflowLifecycleOwner = new RealWorkflowLifecycleOwner(function1, false, 2, (DefaultConstructorMarker) null);
            ViewTreeLifecycleOwner.b(view, realWorkflowLifecycleOwner);
            view.addOnAttachStateChangeListener(realWorkflowLifecycleOwner);
        }
    }

    void P();
}
