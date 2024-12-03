package wa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f42101a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbButton f42102b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbEditText f42103c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ScrollView f42104d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f42105e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f42106f;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull CmbButton cmbButton, @NonNull CmbEditText cmbEditText, @NonNull ScrollView scrollView, @NonNull CmbTextView cmbTextView, @NonNull Toolbar toolbar) {
        this.f42101a = constraintLayout;
        this.f42102b = cmbButton;
        this.f42103c = cmbEditText;
        this.f42104d = scrollView;
        this.f42105e = cmbTextView;
        this.f42106f = toolbar;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = va.a.done_button;
        CmbButton cmbButton = (CmbButton) b.a(view, i10);
        if (cmbButton != null) {
            i10 = va.a.input;
            CmbEditText cmbEditText = (CmbEditText) b.a(view, i10);
            if (cmbEditText != null) {
                i10 = va.a.scroll_view_container;
                ScrollView scrollView = (ScrollView) b.a(view, i10);
                if (scrollView != null) {
                    i10 = va.a.subject;
                    CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
                    if (cmbTextView != null) {
                        i10 = va.a.toolbar;
                        Toolbar toolbar = (Toolbar) b.a(view, i10);
                        if (toolbar != null) {
                            return new a((ConstraintLayout) view, cmbButton, cmbEditText, scrollView, cmbTextView, toolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(va.b.prompt_edit, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f42101a;
    }
}
