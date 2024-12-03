package s5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import q5.l;
import q5.m;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f17481a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f17482b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final AppCompatImageView f17483c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f17484d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f17485e;

    private b(@NonNull ConstraintLayout constraintLayout, @NonNull CmbTextView cmbTextView, @NonNull AppCompatImageView appCompatImageView, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3) {
        this.f17481a = constraintLayout;
        this.f17482b = cmbTextView;
        this.f17483c = appCompatImageView;
        this.f17484d = cmbTextView2;
        this.f17485e = cmbTextView3;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = l.description;
        CmbTextView cmbTextView = (CmbTextView) z1.b.a(view, i10);
        if (cmbTextView != null) {
            i10 = l.image_holder;
            AppCompatImageView appCompatImageView = (AppCompatImageView) z1.b.a(view, i10);
            if (appCompatImageView != null) {
                i10 = l.primary_button;
                CmbTextView cmbTextView2 = (CmbTextView) z1.b.a(view, i10);
                if (cmbTextView2 != null) {
                    i10 = l.title;
                    CmbTextView cmbTextView3 = (CmbTextView) z1.b.a(view, i10);
                    if (cmbTextView3 != null) {
                        return new b((ConstraintLayout) view, cmbTextView, appCompatImageView, cmbTextView2, cmbTextView3);
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
        View inflate = layoutInflater.inflate(m.dialog_fullscreen_single_button, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f17481a;
    }
}
