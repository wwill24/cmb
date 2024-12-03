package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.withpersona.sdk2.inquiry.steps.ui.g;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;
import z1.b;

public final class d implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f24844a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Guideline f24845b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Guideline f24846c;

    private d(@NonNull ConstraintLayout constraintLayout, @NonNull Guideline guideline, @NonNull Guideline guideline2) {
        this.f24844a = constraintLayout;
        this.f24845b = guideline;
        this.f24846c = guideline2;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i10 = g.left_guideline;
        Guideline guideline = (Guideline) b.a(view, i10);
        if (guideline != null) {
            i10 = g.right_guideline;
            Guideline guideline2 = (Guideline) b.a(view, i10);
            if (guideline2 != null) {
                return new d((ConstraintLayout) view, guideline, guideline2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static d c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static d d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_clickable_stack, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f24844a;
    }
}
