package ri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.workflow1.ui.WorkflowViewStub;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f33797a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final WorkflowViewStub f33798b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FloatingActionButton f33799c;

    private a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull WorkflowViewStub workflowViewStub, @NonNull FloatingActionButton floatingActionButton) {
        this.f33797a = coordinatorLayout;
        this.f33798b = workflowViewStub;
        this.f33799c = floatingActionButton;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = qi.a.child_stub;
        WorkflowViewStub workflowViewStub = (WorkflowViewStub) b.a(view, i10);
        if (workflowViewStub != null) {
            i10 = qi.a.floating_action_button;
            FloatingActionButton floatingActionButton = (FloatingActionButton) b.a(view, i10);
            if (floatingActionButton != null) {
                return new a((CoordinatorLayout) view, workflowViewStub, floatingActionButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(qi.b.pi2_sandbox_overlay, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f33797a;
    }
}
