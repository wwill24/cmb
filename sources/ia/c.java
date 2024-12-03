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
import z1.b;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f40935a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f40936b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbRadioGroup f40937c;

    private c(@NonNull ConstraintLayout constraintLayout, @NonNull CmbTextView cmbTextView, @NonNull CmbRadioGroup cmbRadioGroup) {
        this.f40935a = constraintLayout;
        this.f40936b = cmbTextView;
        this.f40937c = cmbRadioGroup;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = g.title;
        CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
        if (cmbTextView != null) {
            i10 = g.vertical_list_content_container;
            CmbRadioGroup cmbRadioGroup = (CmbRadioGroup) b.a(view, i10);
            if (cmbRadioGroup != null) {
                return new c((ConstraintLayout) view, cmbTextView, cmbRadioGroup);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.match_pref_details_single_choice, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f40935a;
    }
}
