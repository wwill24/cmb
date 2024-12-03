package y9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.instant_like.c0;
import com.coffeemeetsbagel.instant_like.d0;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f18769a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbButton f18770b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f18771c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f18772d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f18773e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbTextView f18774f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final AppCompatImageView f18775g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayoutCompat f18776h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f18777j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final CmbEditText f18778k;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull CmbButton cmbButton, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull CmbTextView cmbTextView5, @NonNull CmbEditText cmbEditText) {
        this.f18769a = constraintLayout;
        this.f18770b = cmbButton;
        this.f18771c = cmbTextView;
        this.f18772d = cmbTextView2;
        this.f18773e = cmbTextView3;
        this.f18774f = cmbTextView4;
        this.f18775g = appCompatImageView;
        this.f18776h = linearLayoutCompat;
        this.f18777j = cmbTextView5;
        this.f18778k = cmbEditText;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = c0.cta_primary;
        CmbButton cmbButton = (CmbButton) b.a(view, i10);
        if (cmbButton != null) {
            i10 = c0.cta_secondary;
            CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
            if (cmbTextView != null) {
                i10 = c0.description;
                CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
                if (cmbTextView2 != null) {
                    i10 = c0.grant_count;
                    CmbTextView cmbTextView3 = (CmbTextView) b.a(view, i10);
                    if (cmbTextView3 != null) {
                        i10 = c0.header;
                        CmbTextView cmbTextView4 = (CmbTextView) b.a(view, i10);
                        if (cmbTextView4 != null) {
                            i10 = c0.icon;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
                            if (appCompatImageView != null) {
                                i10 = c0.input;
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) b.a(view, i10);
                                if (linearLayoutCompat != null) {
                                    i10 = c0.input_character_left;
                                    CmbTextView cmbTextView5 = (CmbTextView) b.a(view, i10);
                                    if (cmbTextView5 != null) {
                                        i10 = c0.input_text;
                                        CmbEditText cmbEditText = (CmbEditText) b.a(view, i10);
                                        if (cmbEditText != null) {
                                            return new a((ConstraintLayout) view, cmbButton, cmbTextView, cmbTextView2, cmbTextView3, cmbTextView4, appCompatImageView, linearLayoutCompat, cmbTextView5, cmbEditText);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(d0.instant_like_bottom_sheet, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f18769a;
    }
}
