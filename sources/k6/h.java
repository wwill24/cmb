package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class h implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f15744a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f15745b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15746c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f15747d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f15748e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbTextView f15749f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CmbTextView f15750g;

    private h(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4, @NonNull CmbTextView cmbTextView5) {
        this.f15744a = frameLayout;
        this.f15745b = imageView;
        this.f15746c = cmbTextView;
        this.f15747d = cmbTextView2;
        this.f15748e = cmbTextView3;
        this.f15749f = cmbTextView4;
        this.f15750g = cmbTextView5;
    }

    @NonNull
    public static h a(@NonNull View view) {
        int i10 = R.id.image;
        ImageView imageView = (ImageView) b.a(view, R.id.image);
        if (imageView != null) {
            i10 = R.id.primary_button;
            CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.primary_button);
            if (cmbTextView != null) {
                i10 = R.id.secondary_button;
                CmbTextView cmbTextView2 = (CmbTextView) b.a(view, R.id.secondary_button);
                if (cmbTextView2 != null) {
                    i10 = R.id.send_flowers_description;
                    CmbTextView cmbTextView3 = (CmbTextView) b.a(view, R.id.send_flowers_description);
                    if (cmbTextView3 != null) {
                        i10 = R.id.send_flowers_title;
                        CmbTextView cmbTextView4 = (CmbTextView) b.a(view, R.id.send_flowers_title);
                        if (cmbTextView4 != null) {
                            i10 = R.id.subscription_cta;
                            CmbTextView cmbTextView5 = (CmbTextView) b.a(view, R.id.subscription_cta);
                            if (cmbTextView5 != null) {
                                return new h((FrameLayout) view, imageView, cmbTextView, cmbTextView2, cmbTextView3, cmbTextView4, cmbTextView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static h c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static h d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_send_flowers, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f15744a;
    }
}
