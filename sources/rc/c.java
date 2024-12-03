package rc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffemeetsbagel.hide_report.y;
import com.coffemeetsbagel.hide_report.z;
import z1.a;
import z1.b;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f41826a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbButton f41827b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f41828c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f41829d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f41830e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final NestedScrollView f41831f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final RecyclerView f41832g;

    private c(@NonNull ConstraintLayout constraintLayout, @NonNull CmbButton cmbButton, @NonNull FrameLayout frameLayout, @NonNull CmbTextView cmbTextView, @NonNull LinearLayout linearLayout, @NonNull NestedScrollView nestedScrollView, @NonNull RecyclerView recyclerView) {
        this.f41826a = constraintLayout;
        this.f41827b = cmbButton;
        this.f41828c = frameLayout;
        this.f41829d = cmbTextView;
        this.f41830e = linearLayout;
        this.f41831f = nestedScrollView;
        this.f41832g = recyclerView;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = y.cta_primary;
        CmbButton cmbButton = (CmbButton) b.a(view, i10);
        if (cmbButton != null) {
            i10 = y.footer_container;
            FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
            if (frameLayout != null) {
                i10 = y.header;
                CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
                if (cmbTextView != null) {
                    i10 = y.hide_disclaimer;
                    LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                    if (linearLayout != null) {
                        i10 = y.list_container;
                        NestedScrollView nestedScrollView = (NestedScrollView) b.a(view, i10);
                        if (nestedScrollView != null) {
                            i10 = y.reason_list;
                            RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
                            if (recyclerView != null) {
                                return new c((ConstraintLayout) view, cmbButton, frameLayout, cmbTextView, linearLayout, nestedScrollView, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(z.hide_report_reason_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f41826a;
    }
}
