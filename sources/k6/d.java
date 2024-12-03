package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class d implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f15717a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f15718b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15719c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f15720d;

    private d(@NonNull LinearLayout linearLayout, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3) {
        this.f15717a = linearLayout;
        this.f15718b = cmbTextView;
        this.f15719c = cmbTextView2;
        this.f15720d = cmbTextView3;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i10 = R.id.clickable_text_help;
        CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.clickable_text_help);
        if (cmbTextView != null) {
            i10 = R.id.textView_imperial;
            CmbTextView cmbTextView2 = (CmbTextView) b.a(view, R.id.textView_imperial);
            if (cmbTextView2 != null) {
                i10 = R.id.textView_metric;
                CmbTextView cmbTextView3 = (CmbTextView) b.a(view, R.id.textView_metric);
                if (cmbTextView3 != null) {
                    return new d((LinearLayout) view, cmbTextView, cmbTextView2, cmbTextView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static d c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static d d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_settings_v2, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f15717a;
    }
}
