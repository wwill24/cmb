package rc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffemeetsbagel.hide_report.y;
import com.coffemeetsbagel.hide_report.z;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f41820a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbButton f41821b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f41822c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f41823d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f41824e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbEditText f41825f;

    private b(@NonNull ConstraintLayout constraintLayout, @NonNull CmbButton cmbButton, @NonNull ImageView imageView, @NonNull CmbTextView cmbTextView, @NonNull ConstraintLayout constraintLayout2, @NonNull CmbEditText cmbEditText) {
        this.f41820a = constraintLayout;
        this.f41821b = cmbButton;
        this.f41822c = imageView;
        this.f41823d = cmbTextView;
        this.f41824e = constraintLayout2;
        this.f41825f = cmbEditText;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = y.cta_primary;
        CmbButton cmbButton = (CmbButton) z1.b.a(view, i10);
        if (cmbButton != null) {
            i10 = y.explanation_icon;
            ImageView imageView = (ImageView) z1.b.a(view, i10);
            if (imageView != null) {
                i10 = y.explanation_text;
                CmbTextView cmbTextView = (CmbTextView) z1.b.a(view, i10);
                if (cmbTextView != null) {
                    i10 = y.footer_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) z1.b.a(view, i10);
                    if (constraintLayout != null) {
                        i10 = y.reason_details_text;
                        CmbEditText cmbEditText = (CmbEditText) z1.b.a(view, i10);
                        if (cmbEditText != null) {
                            return new b((ConstraintLayout) view, cmbButton, imageView, cmbTextView, constraintLayout, cmbEditText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(z.hide_report_reason_details, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f41820a;
    }
}
