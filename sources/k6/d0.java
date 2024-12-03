package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class d0 implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f15721a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f15722b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15723c;

    private d0(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull CmbTextView cmbTextView) {
        this.f15721a = linearLayout;
        this.f15722b = imageView;
        this.f15723c = cmbTextView;
    }

    @NonNull
    public static d0 a(@NonNull View view) {
        int i10 = R.id.premium_feature_image;
        ImageView imageView = (ImageView) b.a(view, R.id.premium_feature_image);
        if (imageView != null) {
            i10 = R.id.premium_feature_text;
            CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.premium_feature_text);
            if (cmbTextView != null) {
                return new d0((LinearLayout) view, imageView, cmbTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static d0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static d0 d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.premium_feature_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f15721a;
    }
}
