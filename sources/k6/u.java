package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class u implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f15817a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbEditText f15818b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbEditText f15819c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f15820d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f15821e;

    private u(@NonNull ScrollView scrollView, @NonNull CmbEditText cmbEditText, @NonNull CmbEditText cmbEditText2, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2) {
        this.f15817a = scrollView;
        this.f15818b = cmbEditText;
        this.f15819c = cmbEditText2;
        this.f15820d = cmbTextView;
        this.f15821e = cmbTextView2;
    }

    @NonNull
    public static u a(@NonNull View view) {
        int i10 = R.id.editText_employer;
        CmbEditText cmbEditText = (CmbEditText) b.a(view, R.id.editText_employer);
        if (cmbEditText != null) {
            i10 = R.id.editText_occupation;
            CmbEditText cmbEditText2 = (CmbEditText) b.a(view, R.id.editText_occupation);
            if (cmbEditText2 != null) {
                i10 = R.id.textView_title_company;
                CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.textView_title_company);
                if (cmbTextView != null) {
                    i10 = R.id.textView_title_occupation;
                    CmbTextView cmbTextView2 = (CmbTextView) b.a(view, R.id.textView_title_occupation);
                    if (cmbTextView2 != null) {
                        return new u((ScrollView) view, cmbEditText, cmbEditText2, cmbTextView, cmbTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static u c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile_occupation_dls, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f15817a;
    }
}
