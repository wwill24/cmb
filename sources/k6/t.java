package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class t implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f15813a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f15814b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15815c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f15816d;

    private t(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2) {
        this.f15813a = scrollView;
        this.f15814b = linearLayout;
        this.f15815c = cmbTextView;
        this.f15816d = cmbTextView2;
    }

    @NonNull
    public static t a(@NonNull View view) {
        int i10 = R.id.fragment_my_profile_disclaimer_list_holder;
        LinearLayout linearLayout = (LinearLayout) b.a(view, R.id.fragment_my_profile_disclaimer_list_holder);
        if (linearLayout != null) {
            i10 = R.id.fragment_my_profile_disclaimer_textview;
            CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.fragment_my_profile_disclaimer_textview);
            if (cmbTextView != null) {
                i10 = R.id.textView_title;
                CmbTextView cmbTextView2 = (CmbTextView) b.a(view, R.id.textView_title);
                if (cmbTextView2 != null) {
                    return new t((ScrollView) view, linearLayout, cmbTextView, cmbTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static t c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile_list_dls, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f15813a;
    }
}
