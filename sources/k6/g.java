package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class g implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15741a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f15742b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f15743c;

    private g(@NonNull ConstraintLayout constraintLayout, @NonNull CmbTextView cmbTextView, @NonNull RecyclerView recyclerView) {
        this.f15741a = constraintLayout;
        this.f15742b = cmbTextView;
        this.f15743c = recyclerView;
    }

    @NonNull
    public static g a(@NonNull View view) {
        int i10 = R.id.reason_list_section_title;
        CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.reason_list_section_title);
        if (cmbTextView != null) {
            i10 = R.id.reasons_list;
            RecyclerView recyclerView = (RecyclerView) b.a(view, R.id.reasons_list);
            if (recyclerView != null) {
                return new g((ConstraintLayout) view, cmbTextView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static g c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.deactivate_comp, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15741a;
    }
}
