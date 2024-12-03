package ub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.store.n0;
import com.coffeemeetsbagel.store.o0;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f41958a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f41959b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f41960c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f41961d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f41962e;

    private b(@NonNull LinearLayout linearLayout, @NonNull CmbTextView cmbTextView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull Toolbar toolbar) {
        this.f41958a = linearLayout;
        this.f41959b = cmbTextView;
        this.f41960c = imageView;
        this.f41961d = frameLayout;
        this.f41962e = toolbar;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = n0.cancel_button;
        CmbTextView cmbTextView = (CmbTextView) z1.b.a(view, i10);
        if (cmbTextView != null) {
            i10 = n0.cta_back;
            ImageView imageView = (ImageView) z1.b.a(view, i10);
            if (imageView != null) {
                i10 = n0.premium_upsell_content;
                FrameLayout frameLayout = (FrameLayout) z1.b.a(view, i10);
                if (frameLayout != null) {
                    i10 = n0.toolbar;
                    Toolbar toolbar = (Toolbar) z1.b.a(view, i10);
                    if (toolbar != null) {
                        return new b((LinearLayout) view, cmbTextView, imageView, frameLayout, toolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(o0.premium_upsell, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f41958a;
    }
}
