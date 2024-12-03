package ia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.match_prefs.g;
import com.coffeemeetsbagel.match_prefs.h;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f40931a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f40932b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f40933c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbRadioGroup f40934d;

    private b(@NonNull ConstraintLayout constraintLayout, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull CmbRadioGroup cmbRadioGroup) {
        this.f40931a = constraintLayout;
        this.f40932b = cmbTextView;
        this.f40933c = cmbTextView2;
        this.f40934d = cmbRadioGroup;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = g.instruction;
        CmbTextView cmbTextView = (CmbTextView) z1.b.a(view, i10);
        if (cmbTextView != null) {
            i10 = g.title;
            CmbTextView cmbTextView2 = (CmbTextView) z1.b.a(view, i10);
            if (cmbTextView2 != null) {
                i10 = g.vertical_list_content_container;
                CmbRadioGroup cmbRadioGroup = (CmbRadioGroup) z1.b.a(view, i10);
                if (cmbRadioGroup != null) {
                    return new b((ConstraintLayout) view, cmbTextView, cmbTextView2, cmbRadioGroup);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.match_pref_details_multiple_choice, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f40931a;
    }
}
