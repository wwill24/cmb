package s5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import q5.l;
import q5.m;
import z1.a;
import z1.b;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f17486a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f17487b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f17488c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final AppCompatImageView f17489d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f17490e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbTextView f17491f;

    private c(@NonNull FrameLayout frameLayout, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull AppCompatImageView appCompatImageView, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4) {
        this.f17486a = frameLayout;
        this.f17487b = cmbTextView;
        this.f17488c = cmbTextView2;
        this.f17489d = appCompatImageView;
        this.f17490e = cmbTextView3;
        this.f17491f = cmbTextView4;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = l.dialog_stacked_buttons_text;
        CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
        if (cmbTextView != null) {
            i10 = l.dialog_stacked_buttons_title;
            CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
            if (cmbTextView2 != null) {
                i10 = l.image;
                AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
                if (appCompatImageView != null) {
                    i10 = l.primary_button;
                    CmbTextView cmbTextView3 = (CmbTextView) b.a(view, i10);
                    if (cmbTextView3 != null) {
                        i10 = l.secondary_button;
                        CmbTextView cmbTextView4 = (CmbTextView) b.a(view, i10);
                        if (cmbTextView4 != null) {
                            return new c((FrameLayout) view, cmbTextView, cmbTextView2, appCompatImageView, cmbTextView3, cmbTextView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(m.dialog_primary_secondary_vertical, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f17486a;
    }
}
