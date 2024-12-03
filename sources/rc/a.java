package rc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffemeetsbagel.hide_report.y;
import com.coffemeetsbagel.hide_report.z;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f41815a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f41816b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f41817c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f41818d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f41819e;

    private a(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull Toolbar toolbar, @NonNull CmbTextView cmbTextView) {
        this.f41815a = linearLayout;
        this.f41816b = imageView;
        this.f41817c = frameLayout;
        this.f41818d = toolbar;
        this.f41819e = cmbTextView;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = y.cta_back;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = y.hide_report_content;
            FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
            if (frameLayout != null) {
                i10 = y.toolbar;
                Toolbar toolbar = (Toolbar) b.a(view, i10);
                if (toolbar != null) {
                    i10 = y.toolbar_title;
                    CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
                    if (cmbTextView != null) {
                        return new a((LinearLayout) view, imageView, frameLayout, toolbar, cmbTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(z.hide_report_main, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f41815a;
    }
}
