package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView;
import z1.a;
import z1.b;

public final class s implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f15804a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbEditText f15805b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbEditText f15806c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DelayAutoCompleteTextView f15807d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final DelayAutoCompleteTextView f15808e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f15809f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ProgressBar f15810g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ProgressBar f15811h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f15812j;

    private s(@NonNull ScrollView scrollView, @NonNull CmbEditText cmbEditText, @NonNull CmbEditText cmbEditText2, @NonNull DelayAutoCompleteTextView delayAutoCompleteTextView, @NonNull DelayAutoCompleteTextView delayAutoCompleteTextView2, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull ProgressBar progressBar2, @NonNull CmbTextView cmbTextView) {
        this.f15804a = scrollView;
        this.f15805b = cmbEditText;
        this.f15806c = cmbEditText2;
        this.f15807d = delayAutoCompleteTextView;
        this.f15808e = delayAutoCompleteTextView2;
        this.f15809f = linearLayout;
        this.f15810g = progressBar;
        this.f15811h = progressBar2;
        this.f15812j = cmbTextView;
    }

    @NonNull
    public static s a(@NonNull View view) {
        int i10 = R.id.degree1_text_view;
        CmbEditText cmbEditText = (CmbEditText) b.a(view, R.id.degree1_text_view);
        if (cmbEditText != null) {
            i10 = R.id.degree2_text_view;
            CmbEditText cmbEditText2 = (CmbEditText) b.a(view, R.id.degree2_text_view);
            if (cmbEditText2 != null) {
                i10 = R.id.editText_school1;
                DelayAutoCompleteTextView delayAutoCompleteTextView = (DelayAutoCompleteTextView) b.a(view, R.id.editText_school1);
                if (delayAutoCompleteTextView != null) {
                    i10 = R.id.editText_school2;
                    DelayAutoCompleteTextView delayAutoCompleteTextView2 = (DelayAutoCompleteTextView) b.a(view, R.id.editText_school2);
                    if (delayAutoCompleteTextView2 != null) {
                        i10 = R.id.education_container;
                        LinearLayout linearLayout = (LinearLayout) b.a(view, R.id.education_container);
                        if (linearLayout != null) {
                            i10 = R.id.educationfragment_schools_autocomplete_loading_indicator1;
                            ProgressBar progressBar = (ProgressBar) b.a(view, R.id.educationfragment_schools_autocomplete_loading_indicator1);
                            if (progressBar != null) {
                                i10 = R.id.educationfragment_schools_autocomplete_loading_indicator2;
                                ProgressBar progressBar2 = (ProgressBar) b.a(view, R.id.educationfragment_schools_autocomplete_loading_indicator2);
                                if (progressBar2 != null) {
                                    i10 = R.id.textView_title;
                                    CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.textView_title);
                                    if (cmbTextView != null) {
                                        return new s((ScrollView) view, cmbEditText, cmbEditText2, delayAutoCompleteTextView, delayAutoCompleteTextView2, linearLayout, progressBar, progressBar2, cmbTextView);
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
    public static s c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile_education_dls, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f15804a;
    }
}
